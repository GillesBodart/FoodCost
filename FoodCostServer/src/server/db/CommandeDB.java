/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.db;

import common.dto.CommandeDto;
import common.dto.ListeRecetteDto;
import common.dto.RecetteDto;
import common.exception.RestoDTOException;
import common.exception.RestoDbException;
import common.seldto.CommandeSel;
import common.seldto.ListeRecetteSel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Classe d'accès au gestionnaire de persistance pour les Catégories
 */
public class CommandeDB {

    public static List<CommandeDto> getAllCommande() throws RestoDbException {
        try {
            return rechCollection(new CommandeSel(0));
        } catch (RestoDTOException ex) {
            throw new RestoDbException("Instanciation de commande impossible: " + ex.getMessage());
        }
    }

    public static CommandeDto getCommande(int id) throws RestoDbException {
        try {
            CommandeSel sel = new CommandeSel(id);
            Collection<CommandeDto> rec = rechCollection(sel);
            if (rec.size() == 0) {
                return null;
            } else {
                return rec.iterator().next();
            }
        } catch (RestoDTOException ex) {
            throw new RestoDbException("Instanciation de commande impossible: " + ex.getMessage());
        }

    }

    public static Collection<CommandeDto> getCommande(CommandeSel sel) throws RestoDbException {
        return rechCollection(sel);

    }

    public static CommandeDto getCommande(String nom) throws RestoDbException {
        try {
            CommandeSel sel = new CommandeSel(0, nom, null, 0.0, 0);
            Collection<CommandeDto> rec = rechCollection(sel);
            if (rec.size() == 0) {
                return null;
            } else {
                return rec.iterator().next();
            }
        } catch (RestoDTOException ex) {
            throw new RestoDbException("Instanciation de commande impossible: " + ex.getMessage());
        }

    }

    public static List<CommandeDto> rechCollection(CommandeSel sel) throws RestoDbException {
        ArrayList<CommandeDto> al = new ArrayList<CommandeDto>();
        try {

            String query = "Select comId, comNom, comLstRec, comPrix  FROM COMMANDE ";
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement stmt;
            String where = "";
            if (sel.getId() != 0) {
                where = where + " comId = ? ";
            }
            if (sel.getLibelle() != null && !sel.getLibelle().equals("")) {
                if (!where.equals("")) {
                    where = where + " AND ";
                }
                where = where + " comNom like ? ";
            }
            if (where.length() != 0) {
                where = " where " + where;
                query = query + where;
            }
            query = query + " order by comNom";

            stmt = connexion.prepareStatement(query);

            int i = 1;
            if (sel.getId() != 0) {
                stmt.setInt(i, sel.getId());
                i++;
            }

            if (sel.getLibelle() != null && !sel.getLibelle().equals("")) {
                stmt.setString(i, "%" + sel.getLibelle() + "%");
                i++;
            }


            java.sql.ResultSet rs = stmt.executeQuery();
            //java.sql.ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                al.add(new CommandeDto(rs.getInt("comId"), rs.getString("comNom"), ListeRecetteDB.getListeRecetteInt(rs.getInt("comLstRec")), rs.getDouble("comPrix")));

            }

        } catch (java.sql.SQLException eSQL) {
            throw new RestoDbException("Instanciation de commande impossible:\rSQLException: " + eSQL.getMessage());
        } catch (Exception ex) {
            System.out.println("hum" + ex.getMessage());
        }

        return al;
    }

    public static int insertDb(CommandeDto rec) throws RestoDbException {
        try {
            int num = SequenceDB.getNumSuivant(SequenceDB.RECETTE);
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement insert;
            insert =
                    connexion.prepareStatement("Insert into Commande(comId,comNom,comLstRec,comPrix) values(?, ?, ?, ?)");
            insert.setInt(1, num);
            insert.setString(2, rec.getLibelle());
            insert.setInt(3, rec.getListeRecettes().getId());
            insert.setDouble(4, rec.getRecPrix());
            insert.execute();
            return num;
        } catch (RestoDbException | SQLException ex) {
            throw new RestoDbException("Commande: ajout impossible\r" + ex.getMessage());
        }

    }

    public static void updateDb(CommandeDto rec) throws RestoDbException {
        try {
            java.sql.Connection connexion = DBManager.getConnection();

            java.sql.PreparedStatement update;
            update = connexion.prepareStatement("Update COMMANDE set "
                    + " comNom=?,comPrix=? "
                    + " where comId= ?");
            update.setInt(3, rec.getId());
            update.setString(1, rec.getLibelle());
            ListeRecetteDB.updateDb(rec.getListeRecettes());
            rec.setRecPrix(ListeRecetteDB.getPrix(new ListeRecetteSel(rec.getListeRecettes().getId(), 0)));
            update.setDouble(2, rec.getRecPrix());
            int a = update.executeUpdate();
        } catch (RestoDbException | SQLException ex) {
            throw new RestoDbException("Commande, modification impossible:\n" + ex.getMessage());
        }


    }

    public static void deleteDb(CommandeDto rec) throws RestoDbException {
        try {
            java.sql.Statement stmt = DBManager.getConnection().createStatement();
            stmt.execute("Delete from commande where comId=" + rec.getId());
            ListeRecetteDB.deleteDb(rec.getListeRecettes().getId());
        } catch (Exception ex) {
            throw new RestoDbException("Commande: suppression impossible\n" + ex.getMessage());
        }
    }

    public static void majCommandeListe(ListeRecetteDto list, Double prix) throws RestoDbException {
        try {
            java.sql.Connection connexion = DBManager.getConnection();

            java.sql.PreparedStatement update;
            update = connexion.prepareStatement("Update commande set "
                    + "comPrix=?"
                    + " where comLstRec = ?");

            update.setDouble(1, prix);
            update.setInt(2, list.getId());
            int a = update.executeUpdate();
        } catch (Exception ex) {
            throw new RestoDbException("Commande, modification impossible:\n" + ex.getMessage());
        }

    }

    public static void majDB(RecetteDto rct) throws RestoDbException {
        for (ListeRecetteDto list : ListeRecetteDB.getListeRecetteWiRct(new ListeRecetteSel(0, 0, rct.getId()))) {
            majCommandeListe(list, ListeRecetteDB.getPrix(new ListeRecetteSel(list.getId(), 0, 0)));
        }
    }
}
