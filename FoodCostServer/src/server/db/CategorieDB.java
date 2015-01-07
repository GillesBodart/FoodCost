/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.db;

import resto.persistance.dto.CategorieDto;
import resto.exception.RestoDbException;
import resto.seldto.CategorieSel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Classe d'accès au gestionnaire de persistance pour les Catégories
 */
public class CategorieDB {

    public static List<CategorieDto> getAllCategorie() throws RestoDbException {
        return rechCollection(new CategorieSel(0));
    }

    public static List<CategorieDto> getCategorie(CategorieSel sel) throws RestoDbException {
        return rechCollection(sel);
    }

    public static CategorieDto getCategorie(int id) throws RestoDbException {
        CategorieSel sel = new CategorieSel(id);
        Collection<CategorieDto> cate = rechCollection(sel);
        if (cate.isEmpty()) {
            return null;
        } else {
            return cate.iterator().next();
        }
    }

    public static CategorieDto getCategorie(String nom) throws RestoDbException {
        CategorieSel sel = new CategorieSel(nom);
        Collection<CategorieDto> cate = rechIdByNom(sel);
        if (cate.isEmpty()) {
            return null;
        } else {
            return cate.iterator().next();
        }
    }

    public static List<CategorieDto> rechCollection(CategorieSel sel) throws RestoDbException {
        ArrayList<CategorieDto> al = new ArrayList<CategorieDto>();
        try {
            String query = "Select catId, catNom  FROM Categorie ";
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement stmt;
            String where = "";
            if (sel.getId() != 0) {
                where = where + " catId = ? ";
            }
            if (sel.getNom() != null && !sel.getNom().equals("")) {
                if (!where.equals("")) {
                    where = where + " AND ";
                }
                where = where + " catNom like ? ";
            }


            if (where.length() != 0) {
                where = " where " + where;
                query = query + where;
            }
            query = query + " order by catNom";
            stmt = connexion.prepareStatement(query);

            int i = 1;
            if (sel.getId() != 0) {
                stmt.setInt(i, sel.getId());
                i++;
            }

            if (sel.getNom() != null && !sel.getNom().equals("")) {
                stmt.setString(i, sel.getNom() + "%");
                i++;
            }
            java.sql.ResultSet rs = stmt.executeQuery();
            //java.sql.ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                al.add(new CategorieDto(rs.getInt("catId"), rs.getString("catNom")));
            }
        } catch (java.sql.SQLException eSQL) {
            throw new RestoDbException("Instanciation de Catégorie impossible:\rSQLException: " + eSQL.getMessage());
        }

        return al;
    }

    public static List<CategorieDto> rechIdByNom(CategorieSel sel) throws RestoDbException {
        ArrayList<CategorieDto> al = new ArrayList<CategorieDto>();
        try {
            String query = "Select catId, catNom  FROM Categorie ";
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement stmt;
            String where = "";
            if (sel.getNom() != null && !sel.getNom().equals("")) {
                where = where + " catNom like ? ";
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
                al.add(new CategorieDto(rs.getInt("catId"), rs.getString("catNom")));
            }

        } catch (java.sql.SQLException eSQL) {
            throw new RestoDbException("Instanciation de Catégorie impossible:\rSQLException: " + eSQL.getMessage());
        }

        return al;
    }

    public static int insertDb(CategorieDto cat) throws RestoDbException {
        try {
            int num = SequenceDB.getNumSuivant(SequenceDB.CATEGORIE);
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement insert;
            insert =
                    connexion.prepareStatement("Insert into Categorie(catId,catNom) values(?, ?)");
            insert.setInt(1, num);
            insert.setString(2, cat.getNom());
            insert.execute();
            return num;
        } catch (RestoDbException | SQLException ex) {
            throw new RestoDbException("Categorie: ajout impossible\r" + ex.getMessage());
        }

    }

    public static int updateDb(CategorieDto cat) throws RestoDbException {
        try {
            java.sql.Connection connexion = DBManager.getConnection();

            java.sql.PreparedStatement update;
            update = connexion.prepareStatement("Update categorie set "
                    + " catNom=?"
                    + " where catId= ?");
            update.setString(1, cat.getNom());
            update.setInt(2, cat.getId());
            int a = update.executeUpdate();
            return a;
        } catch (Exception ex) {
            throw new RestoDbException("Categorie, modification impossible:\n" + ex.getMessage());
        }

    }

    public static void deleteDb(int id) throws RestoDbException {
        try {
            java.sql.Statement stmt = DBManager.getConnection().createStatement();
            stmt.execute("Delete from categorie where catId=" + id);
        } catch (Exception ex) {
            throw new RestoDbException("Categorie: suppression impossible\n" + ex.getMessage());
        }
    }
}
