/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.db;

import java.sql.SQLException;
import resto.persistance.dto.AlimentDto;
import resto.exception.RestoDbException;
import resto.seldto.AlimentSel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import resto.exception.RestoDTOException;
import resto.outils.Outils;
import resto.persistance.dto.SousCategorieDto;
import resto.seldto.SousCategorieSel;

/**
 * Classe d'accès au gestionnaire de persistance pour les Catégories
 */
public class AlimentDB {

    public static List<AlimentDto> getAllAliment() throws RestoDbException {
        return rechCollection(new AlimentSel(0));
    }

    public static Collection<AlimentDto> getAliment(AlimentSel sel) throws RestoDbException {
        if (sel.getSousCategorie() == null || sel.getSousCategorie().getNom().equalsIgnoreCase("")) {
            return rechCollection(sel);
        }
        return rechCollectionWithCategorie(sel);
    }

    public static AlimentDto getAliment(int id) throws RestoDbException {
        AlimentSel sel = new AlimentSel(id);
        Collection<AlimentDto> alli = rechCollection(sel);
        if (alli.isEmpty()) {
            return null;
        } else {
            return alli.iterator().next();
        }

    }

    public static AlimentDto getAliment(String nom) throws RestoDbException {
        AlimentSel sel = new AlimentSel(0, nom);
        Collection<AlimentDto> alli = rechCollection(sel);
        if (alli.isEmpty()) {
            return null;
        } else {
            return alli.iterator().next();
        }

    }

    public static List<AlimentDto> rechCollection(AlimentSel sel) throws RestoDbException {
        ArrayList<AlimentDto> al = new ArrayList<>();
        try {
            String query = "Select aliId, aliNom, aliFou , aliCat, aliPrix,aliUnit  FROM Aliment ";
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement stmt;
            String where = "";
            if (sel.getId() != 0) {
                where = where + " aliId = ? ";
            }
            if (sel.getLibelle() != null && !sel.getLibelle().equals("")) {
                if (!where.equals("")) {
                    where = where + " AND ";
                }
                where = where + " aliNom like ? ";
            }
            if (sel.getFournisseur() != null && !sel.getFournisseur().equals("")) {
                if (!where.equals("")) {
                    where = where + " AND ";
                }
                where = where + " aliFou like ? ";
            }

            if (where.length() != 0) {
                where = " where " + where;
                query = query + where;
            }
            query = query + " order by aliNom";
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
            if (sel.getFournisseur() != null && !sel.getFournisseur().equals("")) {
                stmt.setString(i, "%" + sel.getFournisseur() + "%");
                i++;
            }

            java.sql.ResultSet rs = stmt.executeQuery();
            //java.sql.ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                al.add(new AlimentDto(rs.getInt("aliId"), rs.getString("aliNom"), SousCategorieDB.getSousCategorie(rs.getInt("aliCat")), rs.getDouble("aliPrix"), rs.getString("aliFou"), Outils.getUnite(rs.getString("aliUnit"))));
            }
        } catch (java.sql.SQLException eSQL) {
            throw new RestoDbException("Instanciation d'Aliment impossible:\rSQLException: " + eSQL.getMessage());
        } catch (RestoDTOException ex) {
            throw new RestoDbException("Instanciation d'Aliment impossible: " + ex.getMessage());
        }

        return al;
    }

    public static List<AlimentDto> rechCollectionWithCategorie(AlimentSel sel) throws RestoDbException {
        ArrayList<AlimentDto> al = new ArrayList<>();
        try {
            for (SousCategorieDto cate : SousCategorieDB.getSousCategorie(new SousCategorieSel(0, sel.getSousCategorie().getNom(), null))) {
                String query = "Select aliId, aliNom, aliFou , aliCat, aliPrix, aliUnit  FROM Aliment ";
                java.sql.Connection connexion = DBManager.getConnection();
                java.sql.PreparedStatement stmt;
                String where = "";
                if (sel.getId() != 0) {
                    where = where + " aliId = ? ";
                }
                if (sel.getLibelle() != null && !sel.getLibelle().equals("")) {
                    if (!where.equals("")) {
                        where = where + " AND ";
                    }
                    where = where + " aliNom like ? ";
                }
                if (sel.getFournisseur() != null && !sel.getFournisseur().equals("")) {
                    if (!where.equals("")) {
                        where = where + " AND ";
                    }
                    where = where + " aliFou like ? ";
                }
                if (!where.equals("")) {
                    where = where + " AND ";
                }
                where = where + " aliCat = ? ";


                if (where.length() != 0) {
                    where = " where " + where;
                    query = query + where;
                }
                query = query + " order by aliNom";
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
                if (sel.getFournisseur() != null && !sel.getFournisseur().equals("")) {
                    stmt.setString(i, "%" + sel.getFournisseur() + "%");
                    i++;
                }

                stmt.setInt(i, cate.getId());



                java.sql.ResultSet rs = stmt.executeQuery();
                //java.sql.ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    al.add(new AlimentDto(rs.getInt("aliId"), rs.getString("aliNom"), SousCategorieDB.getSousCategorie(rs.getInt("aliCat")), rs.getDouble("aliPrix"), rs.getString("aliFou"), Outils.getUnite(rs.getString("aliUnit"))));
                }
            }
        } catch (java.sql.SQLException eSQL) {
            throw new RestoDbException("Instanciation d'Aliment impossible:\rSQLException: " + eSQL.getMessage());
        } catch (RestoDTOException ex) {
            throw new RestoDbException("Instanciation d'Aliment impossible: " + ex.getMessage());
        }

        return al;
    }

    public static int insertDb(AlimentDto ali) throws RestoDbException {
        try {
            int num = SequenceDB.getNumSuivant(SequenceDB.ALIMENT);
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement insert;
            insert =
                    connexion.prepareStatement("Insert into Aliment(aliId,aliNom,aliFou,aliCat,aliPrix,aliUnit) values(?, ?, ?, ?, ?, ?)");
            insert.setInt(1, num);
            insert.setString(2, ali.getLibelle());
            insert.setString(3, ali.getFournisseur());
            insert.setInt(4, ali.getCategorie().getId());
            insert.setDouble(5, ali.getAliPrix());
            insert.setString(6, ali.getUnit().toString());
            insert.execute();
            return num;
        } catch (RestoDbException | SQLException ex) {
            throw new RestoDbException("Aliment: ajout impossible\r" + ex.getMessage());
        }

    }

    public static int updateDb(AlimentDto ali) throws RestoDbException {
        try {
            java.sql.Connection connexion = DBManager.getConnection();

            java.sql.PreparedStatement update;
            update = connexion.prepareStatement("Update Aliment set "
                    + " aliNom=?,aliFou=?,aliCat=?,aliPrix=?,aliUnit=? "
                    + " where aliId= ?");
            update.setInt(6, ali.getId());
            update.setString(1, ali.getLibelle());
            update.setString(2, ali.getFournisseur());
            update.setInt(3, ali.getCategorie().getId());
            update.setDouble(4, ali.getAliPrix());
            update.setString(5, ali.getUnit().toString());
            int a = update.executeUpdate();
            
            RecetteDB.majDB(ali);
            return a;
        } catch (RestoDbException | SQLException ex) {
            throw new RestoDbException("Aliment, modification impossible:\n" + ex.getMessage());
        }

    }

    public static void deleteDb(int id) throws RestoDbException {
        try {
            java.sql.Statement stmt = DBManager.getConnection().createStatement();
            stmt.execute("Delete from categorie where aliId=" + id);
        } catch (Exception ex) {
            throw new RestoDbException("Aliment: suppression impossible\n" + ex.getMessage());
        }
    }
}
