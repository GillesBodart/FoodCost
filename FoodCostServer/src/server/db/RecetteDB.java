/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.db;

import resto.persistance.dto.RecetteDto;
import resto.exception.RestoDbException;
import resto.seldto.RecetteSel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import resto.exception.RestoDTOException;
import resto.persistance.dto.AlimentDto;
import resto.persistance.dto.IngredientDto;
import resto.persistance.dto.ListeAlimentDto;
import resto.seldto.ListeAlimentSel;

/**
 * Classe d'accès au gestionnaire de persistance pour les Catégories
 */
public class RecetteDB {

    public static List<RecetteDto> getAllRecette() throws RestoDbException {
        try {
            return rechCollection(new RecetteSel(0));
        } catch (RestoDTOException ex) {
            throw new RestoDbException("Instanciation d'recette impossible: " + ex.getMessage());
        }
    }

    public static RecetteDto getRecette(int id) throws RestoDbException {
        try {
            RecetteSel sel = new RecetteSel(id);
            Collection<RecetteDto> rec = rechCollection(sel);
            if (rec.size() == 0) {
                return null;
            } else {
                return rec.iterator().next();
            }
        } catch (RestoDTOException ex) {
            throw new RestoDbException("Instanciation de recette impossible: " + ex.getMessage());
        }

    }

    public static RecetteDto getRecette(ListeAlimentDto id) throws RestoDbException {
        try {
            RecetteSel sel = (new RecetteSel(0, "", id, 0.0, 0));
            Collection<RecetteDto> rec = rechCollection(sel);
            if (rec.size() == 0) {
                return null;
            } else {
                return rec.iterator().next();
            }
        } catch (RestoDTOException ex) {
            throw new RestoDbException("Instanciation de recette impossible: " + ex.getMessage());
        }

    }

    public static Collection<RecetteDto> getRecette(RecetteSel sel) throws RestoDbException {
        return rechCollection(sel);

    }

    public static RecetteDto getRecette(String nom) throws RestoDbException {
        try {
            RecetteSel sel = new RecetteSel(0, nom, null, 0.0, 0);
            Collection<RecetteDto> rec = rechCollection(sel);
            if (rec.size() == 0) {
                return null;
            } else {
                return rec.iterator().next();
            }
        } catch (RestoDTOException ex) {
            throw new RestoDbException("Instanciation de recette impossible: " + ex.getMessage());
        }

    }

    public static List<RecetteDto> rechCollection(RecetteSel sel) throws RestoDbException {
        ArrayList<RecetteDto> al = new ArrayList<RecetteDto>();
        try {

            String query = "Select recId, recNom, recLstIng, recPrix,recNbCouv  FROM Recette ";
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement stmt;
            String where = "";
            if (sel.getId() != 0) {
                where = where + " recId = ? ";
            }
            if (sel.getLibelle() != null && !sel.getLibelle().equals("")) {
                if (!where.equals("")) {
                    where = where + " AND ";
                }
                where = where + " recNom like ? ";
            }
            if (sel.getNbPers() != null && sel.getNbPers() != 0) {
                if (!where.equals("")) {
                    where = where + " AND ";
                }
                where = where + " recNbCouv = ? ";
            }
            if (sel.getListeAliments() != null && sel.getListeAliments().getId() != 0) {
                if (!where.equals("")) {
                    where = where + " AND ";
                }
                where = where + " recLstIng = ? ";
            }

            if (where.length() != 0) {
                where = " where " + where;
                query = query + where;
            }

            query = query + " order by recNom";

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
            if (sel.getNbPers() != null && sel.getNbPers() != 0) {
                stmt.setInt(i, sel.getNbPers());
                i++;
            }
            if (sel.getListeAliments() != null && sel.getListeAliments().getId() != 0) {
                stmt.setInt(i, sel.getListeAliments().getId());
                i++;
            }

            java.sql.ResultSet rs = stmt.executeQuery();
            //java.sql.ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                al.add(new RecetteDto(rs.getInt("recId"), rs.getString("recNom"), ListeAlimentDB.getListeAliment(rs.getInt("recLstIng")), rs.getDouble("recPrix"), rs.getInt("recNbCouv")));

            }

        } catch (java.sql.SQLException eSQL) {
            throw new RestoDbException("Instanciation de recette impossible:\rSQLException: " + eSQL.getMessage());
        } catch (RestoDTOException ex) {
            throw new RestoDbException("Instanciation de recette impossible: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("hum " + ex.getMessage() + " " + ex.toString());
        }
        return al;
    }

    public static int insertDb(RecetteDto rec) throws RestoDbException {
        try {
            int num = SequenceDB.getNumSuivant(SequenceDB.RECETTE);
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement insert;
            insert =
                    connexion.prepareStatement("Insert into Recette(recId,recNom,recLstIng,recPrix,recNbCouv) values(?, ?, ?, ?, ?)");
            insert.setInt(1, num);
            insert.setString(2, rec.getLibelle());
            insert.setInt(3, rec.getListeAliments().getId());
            insert.setDouble(4, rec.getRecPrix());
            insert.setInt(5, rec.getNbPers());
            insert.execute();
            return num;
        } catch (RestoDbException | SQLException ex) {
            throw new RestoDbException("Recette: ajout impossible\r" + ex.getMessage());
        }

    }

    public static void updateDb(RecetteDto rec) throws RestoDbException {
        try {
            java.sql.Connection connexion = DBManager.getConnection();

            java.sql.PreparedStatement update;
            update = connexion.prepareStatement("Update recette set "
                    + " recNom=?,recPrix=?,recNbCouv=? "
                    + " where recId= ?");
            update.setInt(4, rec.getId());
            update.setString(1, rec.getLibelle());
            ListeAlimentDB.updateDb(rec.getListeAliments());
            rec.setRecPrix(ListeAlimentDB.getPrix(new ListeAlimentSel(rec.getListeAliments().getId(), 0)));
            update.setDouble(2, rec.getRecPrix());
            update.setInt(3, rec.getNbPers());
            CommandeDB.majDB(rec);
            int a = update.executeUpdate();
        } catch (RestoDbException | SQLException ex) {
            throw new RestoDbException("Recette, modification impossible:\n" + ex.getMessage());
        }


    }

    public static void deleteDb(RecetteDto rec) throws RestoDbException {
        try {
            java.sql.Statement stmt = DBManager.getConnection().createStatement();
            stmt.execute("Delete from categorie where recId=" + rec.getId());
            ListeAlimentDB.deleteDb(rec.getListeAliments().getId());
        } catch (Exception ex) {
            throw new RestoDbException("Recette: suppression impossible\n" + ex.getMessage());
        }
    }

    private static void majRecetteListe(ListeAlimentDto list, Double prix) throws RestoDbException {
        try {
            java.sql.Connection connexion = DBManager.getConnection();

            java.sql.PreparedStatement update;
            update = connexion.prepareStatement("Update recette set "
                    + "recPrix=?"
                    + " where recLstIng = ?");

            update.setDouble(1, prix);
            update.setInt(2, list.getId());
            int a = update.executeUpdate();
        } catch (Exception ex) {
            throw new RestoDbException("Recette, modification impossible:\n" + ex.getMessage());
        }




    }

    public static void majDB(AlimentDto ali) {
        try {
            for (ListeAlimentDto list : ListeAlimentDB.getListeAlimentWiAli(new ListeAlimentSel(0, 0, ali.getId()))) {
                majRecetteListe(list, ListeAlimentDB.getPrix(new ListeAlimentSel(list.getId(), 0, 0)));
                CommandeDB.majDB(getRecette(list));
            }
        } catch (RestoDbException ex) {
            Logger.getLogger(RecetteDB.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
