/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.db;

import resto.exception.RestoDbException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import resto.outils.Outils;
import resto.persistance.dto.AlimentDto;
import resto.persistance.dto.ComposantDto;
import resto.persistance.dto.IngredientDto;
import resto.persistance.dto.ListeRecetteDto;
import resto.persistance.dto.RecetteDto;
import resto.seldto.ListeRecetteSel;

/**
 * Classe d'accès au gestionnaire de persistance pour les Liste de recette
 */
public class ListeRecetteDB {

    public static ListeRecetteDto getListeRecette(int id) throws RestoDbException {
        if (id <= 0) {
            throw new RestoDbException("Instanciation de Liste de recette impossible");
        }
        ListeRecetteSel sel = new ListeRecetteSel(id, 0);
        return rechCollection(sel);

    }

    public static ListeRecetteDto getListeRecette(ListeRecetteSel sel) throws RestoDbException {
        return rechCollection(sel);

    }

    public static List<ListeRecetteDto> getListeRecetteWiRct(ListeRecetteSel sel) throws RestoDbException {
        return rechCollectionWithRct(sel);

    }

    public static ListeRecetteDto rechCollection(ListeRecetteSel sel) throws RestoDbException {
        ArrayList<ComposantDto> al = new ArrayList<ComposantDto>();
        try {
            String query = "Select lstRct, lstRctQte  FROM LISTERECETTE where lstId= ? ";
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement stmt;

            stmt = connexion.prepareStatement(query);

            int i = 1;
            if (sel.getId() != 0) {
                stmt.setInt(i, sel.getId());
                i++;
            }

            java.sql.ResultSet rs = stmt.executeQuery();
            //java.sql.ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                al.add(new ComposantDto(RecetteDB.getRecette(rs.getInt("lstRct")), rs.getInt("lstRctQte")));
            }
        } catch (java.sql.SQLException eSQL) {
            throw new RestoDbException("Instanciation de Liste de recette impossible:\rSQLException: " + eSQL.getMessage());
        }

        return new ListeRecetteDto(sel.getId(), 0, al);
    }

    public static List<ListeRecetteDto> rechCollectionWithRct(ListeRecetteSel sel) throws RestoDbException {
        ArrayList<ListeRecetteDto> al = new ArrayList<ListeRecetteDto>();
        try {
            String query = "Select lstId,lstNo,lstRct, lstRctQte FROM LISTERECETTE where lstRct= ? ";
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement stmt;

            stmt = connexion.prepareStatement(query);
            stmt.setInt(1, sel.getRctId());
            java.sql.ResultSet rs = stmt.executeQuery();
            //java.sql.ResultSet rs = stmt.executeQuery(query
            while (rs.next()) {
                al.add(new ListeRecetteDto(rs.getInt("lstId"), rs.getInt("lstNo"), null));
            }
        } catch (java.sql.SQLException eSQL) {
            throw new RestoDbException("Instanciation de Liste de recette impossible:\rSQLException: " + eSQL.getMessage());
        }

        return al;
    }

    public static int insertDb(ListeRecetteDto lst) throws RestoDbException {
        try {
            int num = SequenceDB.getNumSuivant(SequenceDB.LISTERECETTE);
            int numLigne = SequenceDB.getNumSuivant(SequenceDB.NUMLIGNE);
            java.sql.Connection connexion = DBManager.getConnection();
            for (ComposantDto ing : lst.getComposants()) {

                java.sql.PreparedStatement insert;
                insert =
                        connexion.prepareStatement("Insert into LISTERECETTE (lstId,lstNo, lstRct,lstRctQte) values(?, ?, ?, ?)");
                insert.setInt(1, num);
                insert.setInt(2, numLigne);
                insert.setInt(3, ing.getId().getId());
                insert.setInt(4, ing.getQte());

                insert.execute();
                numLigne = SequenceDB.getNumSuivant(SequenceDB.NUMLIGNE);
            }
            SequenceDB.reset(SequenceDB.NUMLIGNE);
            return num;
        } catch (RestoDbException | SQLException ex) {
            throw new RestoDbException("Liste ingrédient: ajout impossible\r" + ex.getMessage());
        }

    }

    public static int insertCompoDb(ListeRecetteDto lst, ComposantDto ing) throws RestoDbException {
        try {
            int num = lst.getId();
            int numLigne = getLastLigne(new ListeRecetteSel(lst.getId(), 0)) + 2;
            java.sql.Connection connexion = DBManager.getConnection();

            java.sql.PreparedStatement insert;
            insert =
                    connexion.prepareStatement("Insert into LISTERECETTE (lstId,lstNo, lstRct,lstRctQte) values(?, ?, ?, ?)");
            insert.setInt(1, num);
            insert.setInt(2, numLigne);
            insert.setInt(3, ing.getId().getId());
            insert.setInt(4, ing.getQte());
            insert.execute();
            return num;
        } catch (RestoDbException | SQLException ex) {
            throw new RestoDbException("Liste ingrédient: ajout impossible\r" + ex.getMessage());
        }
    }

    public static void updateDb(ListeRecetteDto lst) throws RestoDbException {
        try {
            java.sql.Connection connexion = DBManager.getConnection();
            for (ComposantDto ing : lst.getComposants()) {
                java.sql.PreparedStatement update;
                update = connexion.prepareStatement("Update LISTERECETTE set "
                        + " lstRctQte=?"
                        + " where lstId= ? AND lstRct = ?");
                update.setInt(1, ing.getQte());
                update.setInt(2, lst.getId());
                update.setInt(3, ing.getId().getId());
                int a = update.executeUpdate();
            }
        } catch (Exception ex) {
            throw new RestoDbException("Liste ingrédient, modification impossible:\n" + ex.getMessage());
        }

    }

    private static int getNumLigne(ListeRecetteSel sel) throws RestoDbException {
        ArrayList<ListeRecetteDto> al = new ArrayList<ListeRecetteDto>();
        try {
            String query = "Select lstId,lstNo  FROM LISTERECETTE where lstRct= ? and lstId=? ";
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement stmt;

            stmt = connexion.prepareStatement(query);

            stmt.setInt(1, sel.getRctId());
            stmt.setInt(2, sel.getId());

            java.sql.ResultSet rs = stmt.executeQuery();
            //java.sql.ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                al.add(new ListeRecetteDto(rs.getInt("lstId"), rs.getInt("lstNo"), null));
            }
        } catch (RestoDbException | SQLException eSQL) {
            throw new RestoDbException("Instanciation de Liste de recette impossible:\rSQLException: " + eSQL.getMessage());
        }
        if (!al.isEmpty()) {
            return al.get(0).getNumLigne();
        } else {
            return -1;
        }
    }

    public static int updateCompoDb(ListeRecetteDto lst, ComposantDto ing) throws RestoDbException {
        try {
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement update;
            update = connexion.prepareStatement("Update LISTERECETTE set "
                    + " lstRctQte=?,lstRct = ?"
                    + " where lstId= ? AND lstNo = ?");
            update.setInt(1, ing.getQte());
            update.setInt(2, ing.getId().getId());
            update.setInt(3, lst.getId());
            update.setInt(4, getNumLigne(new ListeRecetteSel(lst.getId(), 0, ing.getId().getId())));
            return update.executeUpdate();
        } catch (RestoDbException | SQLException ex) {
            throw new RestoDbException("Liste ingrédient, modification impossible:\n" + ex.getMessage());
        }

    }

    public static int deleteCompoDb(ListeRecetteDto lst, ComposantDto ing) throws RestoDbException {
        try {
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement update;
            update = connexion.prepareStatement("Delete from LISTERECETTE "
                    + " where lstId= ? AND lstNo = ?");
            update.setInt(1, lst.getId());
            update.setInt(2, getNumLigne(new ListeRecetteSel(lst.getId(), 0, ing.getId().getId())));
            return update.executeUpdate();
        } catch (RestoDbException | SQLException ex) {
            throw new RestoDbException("Liste ingrédient, suppression impossible:\n" + ex.getMessage());
        }

    }

    public static void deleteDb(int id) throws RestoDbException {
        try {
            java.sql.Statement stmt = DBManager.getConnection().createStatement();
            stmt.execute("Delete from LISTERECETTE where lstId=" + id);
        } catch (Exception ex) {
            throw new RestoDbException("Categorie: suppression impossible\n" + ex.getMessage());
        }
    }

    public static Double getPrix(ListeRecetteSel sel) throws RestoDbException {
        Double sum = 0.0;
        try {
            String query = "Select lstRct, lstRctQte  FROM LISTERECETTE  where lstId= ? ";
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement stmt;

            stmt = connexion.prepareStatement(query);

            stmt.setInt(1, sel.getId());
            java.sql.ResultSet rs = stmt.executeQuery();
            //java.sql.ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ComposantDto ing = new ComposantDto(RecetteDB.getRecette(rs.getInt("lstRct")), rs.getInt("lstRctQte"));
                sum += ing.getPrix();
            }
        } catch (RestoDbException | SQLException eSQL) {
            throw new RestoDbException("Mise a jour de Liste de recette impossible:\rSQLException: " + eSQL.getMessage());
        }
        return sum;
    }

    private static int getLastLigne(ListeRecetteSel sel) throws RestoDbException {
        try {
            return rechCollection(sel).getListRecette().size();
        } catch (RestoDbException ex) {
            throw new RestoDbException("Mise a jour de Liste de recette impossible.");
        }
    }

    public static List<IngredientDto> getIngredients(HashMap<Integer, Double> map) throws RestoDbException {

        ArrayList<IngredientDto> liste = new ArrayList<>();
        AlimentDto elem;
        for (Integer id : map.keySet()) {
            try {
                elem = AlimentDB.getAliment(id);
                liste.add(new IngredientDto(elem, map.get(id).intValue(), Outils.stand(elem.getUnit())));
            } catch (RestoDbException ex) {
                throw new RestoDbException("instanciation de Liste d'ingrédients impossible.");
            }

        }

        return liste;
    }

    public static void majDB(RecetteDto rec) throws RestoDbException {
        try {
            for (ListeRecetteDto list : ListeRecetteDB.rechCollectionWithRct(new ListeRecetteSel(0, 0, rec.getId()))) {
                CommandeDB.majCommandeListe(list, ListeRecetteDB.getPrix(new ListeRecetteSel(list.getId(), 0, 0)));
            }
        } catch (RestoDbException ex) {
            throw new RestoDbException("instanciation de Liste d'ingrédients impossible.");
        }
    }
}
