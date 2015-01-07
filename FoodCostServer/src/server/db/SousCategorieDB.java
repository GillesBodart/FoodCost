/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.db;

import common.dto.SousCategorieDto;
import common.exception.RestoDbException;
import common.seldto.SousCategorieSel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Classe d'accès au gestionnaire de persistance pour les Catégories
 */
public class SousCategorieDB {

    public static List<SousCategorieDto> getAllSousCategorie() throws RestoDbException {
        return rechCollection(new SousCategorieSel(0, ""));
    }

    public static SousCategorieDto getSousCategorie(int id) throws RestoDbException {
        SousCategorieSel sel = new SousCategorieSel(id, "");
        Collection<SousCategorieDto> cate = rechCollection(sel);
        if (cate.isEmpty()) {
            return null;
        } else {
            return cate.iterator().next();
        }
    }

    public static List<SousCategorieDto> getSousCategorie(SousCategorieSel sel) throws RestoDbException {
        return rechCollection(sel);

    }

    public static SousCategorieDto getSousCategorie(String nom) throws RestoDbException {
        SousCategorieSel sel = new SousCategorieSel(nom);
        Collection<SousCategorieDto> cate = rechIdByNom(sel);
        if (cate.isEmpty()) {
            return null;
        } else {
            return cate.iterator().next();
        }
    }

    public static List<SousCategorieDto> rechCollection(SousCategorieSel sel) throws RestoDbException {
        ArrayList<SousCategorieDto> al = new ArrayList<>();
        try {
            String query = "Select sousCatId, sousCatNom, categorie  FROM SousCategorie ";
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement stmt;
            String where = "";
            if (sel.getId() != 0) {
                where = where + " sousCatId = ? ";
            }
            if (sel.getNom() != null && !sel.getNom().equals("")) {
                if (!where.equals("")) {
                    where = where + " AND ";
                }
                where = where + " sousCatNom like ? ";
            }
            if (sel.getCategorie() != null && sel.getCategorie().getId() != 0) {
                if (!where.equals("")) {
                    where = where + " AND ";
                }
                where = where + " categorie = ? ";
            }


            if (where.length() != 0) {
                where = " where " + where;
                query = query + where;
            }
            query = query + " order by sousCatNom";
            stmt = connexion.prepareStatement(query);

            int i = 1;
            if (sel.getId() != 0) {
                stmt.setInt(i, sel.getId());
                i++;
            }

            if (sel.getNom() != null && !sel.getNom().equals("")) {
                stmt.setString(i, "%" + sel.getNom() + "%");
                i++;
            }
            if (sel.getCategorie() != null && sel.getCategorie().getId() != 0) {
                stmt.setInt(i, sel.getCategorie().getId());
                i++;
            }
            java.sql.ResultSet rs = stmt.executeQuery();
            //java.sql.ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                al.add(new SousCategorieDto(rs.getInt("sousCatId"), rs.getString("sousCatNom"), CategorieDB.getCategorie(rs.getInt("categorie"))));
            }
        } catch (java.sql.SQLException eSQL) {
            throw new RestoDbException("Instanciation de Sous-Catégorie impossible:\rSQLException: " + eSQL.getMessage());
        }

        return al;
    }

    public static List<SousCategorieDto> rechIdByNom(SousCategorieSel sel) throws RestoDbException {
        ArrayList<SousCategorieDto> al = new ArrayList<SousCategorieDto>();
        try {
            String query = "Select sousCatId, sousCatNom, categorie  FROM SousCategorie ";
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement stmt;
            String where = "";
            if (sel.getNom() != null && !sel.getNom().equals("")) {
                where = where + " sousCatNom like ? ";
            }
            if (where.length() != 0) {
                where = " where " + where;
                query = query + where;
            }
            stmt = connexion.prepareStatement(query);
            if (sel.getNom() != null && !sel.getNom().equals("")) {
                stmt.setString(1, "%" + sel.getNom() + "%");
            }
            java.sql.ResultSet rs = stmt.executeQuery();
            //java.sql.ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                al.add(new SousCategorieDto(rs.getInt("sousCatId"), rs.getString("sousCatNom"), CategorieDB.getCategorie(rs.getInt("categorie"))));
            }

        } catch (java.sql.SQLException eSQL) {
            throw new RestoDbException("Instanciation de Sous-Catégorie impossible:\rSQLException: " + eSQL.getMessage());
        }

        return al;
    }

    public static int insertDb(SousCategorieDto cat) throws RestoDbException {
        try {
            int num = SequenceDB.getNumSuivant(SequenceDB.SOUSCATEGORIE);
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement insert;
            insert =
                    connexion.prepareStatement("Insert into SousCategorie(sousCatId,sousCatNom,categorie) values(?, ?, ?)");
            insert.setInt(1, num);
            insert.setString(2, cat.getNom());
            insert.setInt(3, cat.getCategorie().getId());
            insert.execute();
            return num;
        } catch (RestoDbException | SQLException ex) {
            throw new RestoDbException("SousCategorie: ajout impossible\r" + ex.getMessage());
        }

    }

    public static int updateDb(SousCategorieDto cat) throws RestoDbException {
        try {
            java.sql.Connection connexion = DBManager.getConnection();

            java.sql.PreparedStatement update;
            update = connexion.prepareStatement("Update SousCategorie set "
                    + " sousCatNom=?, categorie = ?"
                    + " where sousCatId= ?");
            update.setString(1, cat.getNom());
            update.setInt(2, cat.getCategorie().getId());
            update.setInt(3, cat.getId());
             return update.executeUpdate();
        } catch (Exception ex) {
            throw new RestoDbException("Sous-Categorie, modification impossible:\n" + ex.getMessage());
        }

    }

    public static void deleteDb(int id) throws RestoDbException {
        try {
            java.sql.Statement stmt = DBManager.getConnection().createStatement();
            stmt.execute("Delete from SousCategorie where sousCatId=" + id);
        } catch (Exception ex) {
            throw new RestoDbException("Sous-Categorie: suppression impossible\n" + ex.getMessage());
        }
    }
}
