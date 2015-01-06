/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.db;

import resto.exception.RestoDbException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import resto.outils.Outils;
import resto.persistance.dto.IngredientDto;
import resto.persistance.dto.ListeAlimentDto;
import resto.seldto.ListeAlimentSel;

/**
 * Classe d'accès au gestionnaire de persistance pour les Liste d'Aliments
 */
public class ListeAlimentDB {

    public static ListeAlimentDto getListeAliment(int id) throws RestoDbException {
        if (id <= 0) {
            throw new RestoDbException("Instanciation de Liste d'Aliments impossible");
        }
        ListeAlimentSel sel = new ListeAlimentSel(id, 0);
        return rechCollection(sel);

    }

    public static ListeAlimentDto getListeAliment(ListeAlimentSel sel) throws RestoDbException {
        return rechCollection(sel);

    }

    public static List<ListeAlimentDto> getListeAlimentWiAli(ListeAlimentSel sel) throws RestoDbException {
        return rechCollectionWithAli(sel);

    }

    public static ListeAlimentDto rechCollection(ListeAlimentSel sel) throws RestoDbException {
        ArrayList<IngredientDto> al = new ArrayList<IngredientDto>();
        try {
            String query = "Select lstAli, lstAliQte,lstAliQteUnite  FROM LISTEINGREDIENT where lstId= ? ";
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
                al.add(new IngredientDto(AlimentDB.getAliment(rs.getInt("lstAli")), rs.getInt("lstAliQte"), Outils.getQte(rs.getString("lstAliQteUnite"))));
            }
        } catch (java.sql.SQLException eSQL) {
            throw new RestoDbException("Instanciation de Liste d'Aliments impossible:\rSQLException: " + eSQL.getMessage());
        }

        return new ListeAlimentDto(sel.getId(), 0, al);
    }

    public static List<ListeAlimentDto> rechCollectionWithAli(ListeAlimentSel sel) throws RestoDbException {
        ArrayList<ListeAlimentDto> al = new ArrayList<ListeAlimentDto>();
        try {
            String query = "Select lstId,lstNo,lstAli, lstAliQte,lstAliQteUnite  FROM LISTEINGREDIENT where lstAli= ? ";
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement stmt;

            stmt = connexion.prepareStatement(query);
            stmt.setInt(1, sel.getAliId());
            java.sql.ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                al.add(new ListeAlimentDto(rs.getInt("lstId"), rs.getInt("lstNo"), null));
            }
        } catch (java.sql.SQLException eSQL) {
            throw new RestoDbException("Instanciation de Liste d'Aliments impossible:\rSQLException: " + eSQL.getMessage());
        }

        return al;
    }

    public static int insertDb(ListeAlimentDto lst) throws RestoDbException {
        try {
            int num = SequenceDB.getNumSuivant(SequenceDB.LISTEINGREDIENT);
            int numLigne = SequenceDB.getNumSuivant(SequenceDB.NUMLIGNE);
            java.sql.Connection connexion = DBManager.getConnection();
            for (IngredientDto ing : lst.getIngredients()) {

                java.sql.PreparedStatement insert;
                insert =
                        connexion.prepareStatement("Insert into LISTEINGREDIENT (lstId,lstNo, lstAli,lstAliQte,lstAliQteUnite) values(?, ?, ?, ?, ?)");
                insert.setInt(1, num);
                insert.setInt(2, numLigne);
                insert.setInt(3, ing.getId().getId());
                insert.setInt(4, ing.getQte());
                insert.setString(5, ing.getUnit().toString());
                insert.execute();
                numLigne = SequenceDB.getNumSuivant(SequenceDB.NUMLIGNE);
            }
            SequenceDB.reset(SequenceDB.NUMLIGNE);
            return num;
        } catch (RestoDbException | SQLException ex) {
            throw new RestoDbException("Liste ingrédient: ajout impossible\r" + ex.getMessage());
        }

    }

    public static int insertIngrDb(ListeAlimentDto lst, IngredientDto ing) throws RestoDbException {
        try {
            int num = lst.getId();
            int numLigne = getLastLigne(new ListeAlimentSel(lst.getId(), 0)) + 2;
            java.sql.Connection connexion = DBManager.getConnection();

            java.sql.PreparedStatement insert;
            insert =
                    connexion.prepareStatement("Insert into LISTEINGREDIENT (lstId,lstNo, lstAli,lstAliQte,lstAliQteUnite) values(?, ?, ?, ?, ?)");
            insert.setInt(1, num);
            insert.setInt(2, numLigne);
            insert.setInt(3, ing.getId().getId());
            insert.setInt(4, ing.getQte());
            insert.setString(5, ing.getUnit().toString());
            insert.execute();
            return num;
        } catch (RestoDbException | SQLException ex) {
            throw new RestoDbException("Liste ingrédient: ajout impossible\r" + ex.getMessage());
        }
    }

    public static void updateDb(ListeAlimentDto lst) throws RestoDbException {
        try {
            java.sql.Connection connexion = DBManager.getConnection();
            for (IngredientDto ing : lst.getIngredients()) {
                java.sql.PreparedStatement update;
                update = connexion.prepareStatement("Update LISTEINGREDIENT set "
                        + " lstAliQte=?"
                        + " where lstId= ? AND lstAli = ?");
                update.setInt(1, ing.getQte());
                update.setInt(2, lst.getId());
                update.setInt(3, ing.getId().getId());
                int a = update.executeUpdate();
            }
        } catch (Exception ex) {
            throw new RestoDbException("Liste ingrédient, modification impossible:\n" + ex.getMessage());
        }

    }

    private static int getNumLigne(ListeAlimentSel sel) throws RestoDbException {
        ArrayList<ListeAlimentDto> al = new ArrayList<ListeAlimentDto>();
        try {
            String query = "Select lstId,lstNo,lstAli, lstAliQte,lstAliQteUnite  FROM LISTEINGREDIENT where lstAli= ? and lstId=? ";
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement stmt;

            stmt = connexion.prepareStatement(query);

            stmt.setInt(1, sel.getAliId());
            stmt.setInt(2, sel.getId());

            java.sql.ResultSet rs = stmt.executeQuery();
            //java.sql.ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                al.add(new ListeAlimentDto(rs.getInt("lstId"), rs.getInt("lstNo"), null));
            }
        } catch (RestoDbException | SQLException eSQL) {
            throw new RestoDbException("Instanciation de Liste d'Aliments impossible:\rSQLException: " + eSQL.getMessage());
        }
        if (!al.isEmpty()) {
            return al.get(0).getNumLigne();
        } else {
            return -1;
        }
    }

    public static int updateIngreDb(ListeAlimentDto lst, IngredientDto ing) throws RestoDbException {
        try {
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement update;
            update = connexion.prepareStatement("Update LISTEINGREDIENT set "
                    + " lstAliQte=?, lstAliQteUnite = ? ,lstAli = ?"
                    + " where lstId= ? AND lstNo = ?");
            update.setInt(1, ing.getQte());
            update.setString(2, ing.getUnit().toString());
            update.setInt(3, ing.getId().getId());
            update.setInt(4, lst.getId());
            update.setInt(5, getNumLigne(new ListeAlimentSel(lst.getId(), 0, ing.getId().getId())));
            return update.executeUpdate();
        } catch (RestoDbException | SQLException ex) {
            throw new RestoDbException("Liste ingrédient, modification impossible:\n" + ex.getMessage());
        }

    }

    public static int deleteIngreDb(ListeAlimentDto lst, IngredientDto ing) throws RestoDbException {
        try {
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement update;
            update = connexion.prepareStatement("Delete from LISTEINGREDIENT "
                    + " where lstId= ? AND lstNo = ?");
            update.setInt(1, lst.getId());
            update.setInt(2, getNumLigne(new ListeAlimentSel(lst.getId(), 0, ing.getId().getId())));
            return update.executeUpdate();
        } catch (RestoDbException | SQLException ex) {
            throw new RestoDbException("Liste ingrédient, suppression impossible:\n" + ex.getMessage());
        }

    }

    public static void deleteDb(int id) throws RestoDbException {
        try {
            java.sql.Statement stmt = DBManager.getConnection().createStatement();
            stmt.execute("Delete from LISTEINGREDIENT where lstId=" + id);
        } catch (Exception ex) {
            throw new RestoDbException("Categorie: suppression impossible\n" + ex.getMessage());
        }
    }

    public static Double getPrix(ListeAlimentSel sel) throws RestoDbException {
        Double sum = 0.0;
        try {
            String query = "Select lstAli, lstAliQte,lstAliQteUnite  FROM LISTEINGREDIENT  where lstId= ? ";
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement stmt;

            stmt = connexion.prepareStatement(query);

            stmt.setInt(1, sel.getId());
            java.sql.ResultSet rs = stmt.executeQuery();
            //java.sql.ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                IngredientDto ing = new IngredientDto(AlimentDB.getAliment(rs.getInt("lstAli")), rs.getInt("lstAliQte"), Outils.getQte(rs.getString("lstAliQteUnite")));
                sum += ing.getPrix();
            }
        } catch (RestoDbException | SQLException eSQL) {
            throw new RestoDbException("Mise a jour de Liste d'Aliments impossible:\rSQLException: " + eSQL.getMessage());
        }
        return sum;
    }

    private static int getLastLigne(ListeAlimentSel sel) throws RestoDbException {
        try {
            return rechCollection(sel).getListAliment().size();
        } catch (RestoDbException ex) {
            throw new RestoDbException("Mise a jour de Liste d'Aliments impossible:\rSQLException: ");
        }
    }
}
