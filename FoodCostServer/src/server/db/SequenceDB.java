/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.db;

import common.exception.RestoDbException;

/**
 * Classe d'accès au gestionnaire de persistance pour les Séquences
 */
public class SequenceDB {

    static final String ALIMENT = "Aliment", SOUSCATEGORIE = "SousCategorie", RECETTE = "Recette", COMMANDE = "Commande", CATEGORIE = "Categorie", NUMLIGNE = "NumLigne", LISTEINGREDIENT = "ListeIngredient", LISTERECETTE = "ListeRecette";

    static synchronized int getNumSuivant(String sequence) throws RestoDbException {
        try {
            java.sql.Connection connexion = DBManager.getConnection();
            String query = "Update SEQUENCES set valeur= valeur+1 where id='" + sequence + "'";
            java.sql.PreparedStatement update = connexion.prepareStatement(query);
            update.execute();
            java.sql.Statement stmt = connexion.createStatement();
            query = "Select valeur FROM Sequences where id='" + sequence + "'";
            java.sql.ResultSet rs = stmt.executeQuery(query);
            int nvId;
            if (rs.next()) {
                nvId = rs.getInt("valeur");
                return nvId;
            } else {
                throw new RestoDbException("Nouveau n° de séquence inaccessible!");
            }
        } catch (java.sql.SQLException eSQL) {
            throw new RestoDbException("Nouveau n° de séquence inaccessible!\n" + eSQL.getMessage());
        }

    }

    static synchronized void reset(String sequence) throws RestoDbException {
        try {
            java.sql.Connection connexion = DBManager.getConnection();
            String query = "Update SEQUENCES set valeur = 0 where id='" + sequence + "'";
            java.sql.PreparedStatement update = connexion.prepareStatement(query);
            update.execute();

        } catch (java.sql.SQLException eSQL) {
            throw new RestoDbException("Remise à 0 impossible" + eSQL.getMessage());
        }

    }
}
