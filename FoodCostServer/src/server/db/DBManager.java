/*
 * DBManager.java
 */
package server.db;

import common.exception.RestoDbException;
import common.tools.CommonTool;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.apache.derby.tools.ij;


/**
 * Offre les outils de connexion et de gestion de transaction.
 */
public class DBManager {

    private static Properties prop = new Properties();
    private static final String encoding = "UTF-8";
    private static final String CONFIG_FILE = "config.properties";
    private static Connection connection;
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String[] TABLES = {"ALIMENT", "CATEGORIE", "SOUSCATEGORIE", "RECETTE", "LISTEINGREDIENT", "LISTERECETTE", "COMMANDE", "SEQUENCES"};
    private static final String DB_SCRIPT = "RestoDb.sql";
    private static String persistenceUN = "FoodcostPU";
    //private static MesParametresDeConnexion dbChoisie;

    /**
     * Retourne la connexion établie ou à défaut, l'établit
     *
     * @return la connexion établie.
     */
    public static Connection getConnection() throws RestoDbException {

        if (connection == null) {

            try {
                prop.load(new FileInputStream(CONFIG_FILE));
                connection = DriverManager.getConnection("jdbc:derby:" + prop.getProperty("database"), prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
            } catch (IOException | SQLException ex) {
                throw new RestoDbException("Connexion impossible: " + ex.getMessage());
            }
        }
        return connection;
    }

    /**
     * débute une transaction
     */
    public static void startTransaction() throws RestoDbException {
        try {

            getConnection().setAutoCommit(false);
        } catch (SQLException ex) {
            throw new RestoDbException("Impossible de démarrer une transaction: " + ex.getMessage());
        }
    }

    /**
     * débute une transaction en spécifiant son niveau d'isolation Attention,
     * ceci n'est pas implémenté sous Access! (cette notion sera abordée
     * ultérieurement dans le cours de bd)
     */
    public static void startTransaction(int isolationLevel) throws RestoDbException {
        try {
            getConnection().setAutoCommit(false);

            int isol = 0;
            switch (isolationLevel) {
                case 0:
                    isol = java.sql.Connection.TRANSACTION_READ_UNCOMMITTED;
                    break;
                case 1:
                    isol = java.sql.Connection.TRANSACTION_READ_COMMITTED;
                    break;
                case 2:
                    isol = java.sql.Connection.TRANSACTION_REPEATABLE_READ;
                    break;
                case 3:
                    isol = java.sql.Connection.TRANSACTION_SERIALIZABLE;
                    break;
                default:
                    throw new RestoDbException("Degré d'isolation inexistant!");
            }


            getConnection().setTransactionIsolation(isolationLevel);
        } catch (SQLException ex) {
            throw new RestoDbException("Impossible de démarrer une transaction: " + ex.getMessage());
        }
    }

    /**
     * valide la transaction courante
     */
    public static void valideTransaction() throws RestoDbException {
        try {
            getConnection().commit();
            getConnection().setAutoCommit(true);
        } catch (SQLException ex) {
            throw new RestoDbException("Impossible de valider la transaction: " + ex.getMessage());
        }
    }

    /**
     * annule la transaction courante
     */
    public static void annuleTransaction() throws RestoDbException {
        try {
            getConnection().rollback();
            getConnection().setAutoCommit(true);
        } catch (SQLException ex) {
            throw new RestoDbException("Impossible d'annuler la transaction: " + ex.getMessage());
        }
    }

    private static boolean createDB() {
        boolean ok = false;
        String dbName = prop.getProperty("database");
        if (dbName.trim().isEmpty()) {
            dbName = "DB_" + System.nanoTime();
            prop.setProperty("database", dbName);
        }
        String url = "jdbc:derby:" + dbName + ";create=true";
        Connection con = null;
        URL scriptURL = DBManager.class.getResource(DB_SCRIPT);

        try {

            Class.forName(DRIVER);
            con = DriverManager.getConnection(url);
            ij.runScript(con, scriptURL.openStream(), encoding, System.out, encoding);
            ok = checkDB();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            ok = false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
            }
        }
        return ok;
    }

    public static boolean checkDB() {
        boolean exist = false;
        String dbName = prop.getProperty("database");

        if (dbName.trim().isEmpty()) {

            dbName = "DB_" + System.nanoTime();
            prop.setProperty("database", dbName);
        }
        String url = "jdbc:derby:" + dbName + ";create=true";
        Connection con = null;

        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(url);
            LinkedList<String> matchTables = new LinkedList<>();
            ResultSet rsTables = con.getMetaData().getTables(null, null, null, new String[]{"TABLE"});
            String tNames;
            while (rsTables.next()) {
                tNames = rsTables.getString("TABLE_NAME");
                matchTables.add(tNames.toUpperCase());
            }

            List<String> managedTable = Arrays.asList(TABLES);
            exist = matchTables.containsAll(managedTable);
        } catch (ClassNotFoundException | SQLException ex) {
            exist = false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
            }
        }

        return exist;

    }

    public static void loadConfigFile(String CONFIG_FILE) {
        prop = new Properties();
        prop.setProperty("database", "DB_" + System.nanoTime());
        prop.setProperty("dbuser", "app");
        prop.setProperty("dbpassword", "app");
        try {
            prop.load(new FileInputStream(CONFIG_FILE));
        } catch (Exception ex) {
            Logger.getLogger(CommonTool.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void saveConfigFile(String CONFIG_FILE) {
        try {
            prop.store(new FileOutputStream(CONFIG_FILE), "");
        } catch (Exception ex) {
            Logger.getLogger(CommonTool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void openAction() {
        try {
            String dbProp = prop.getProperty("database");
            File currentDBDir = new File(dbProp);
            JFileChooser chooser;
            if (currentDBDir.exists()) {
                chooser = new JFileChooser(currentDBDir.getParentFile());
            } else {
                chooser = new JFileChooser();
            }
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setSelectedFile(currentDBDir);
            chooser.setDialogTitle("Select a db directory");
            chooser.setDialogType(JFileChooser.OPEN_DIALOG);
            chooser.setMultiSelectionEnabled(false);
            int value = chooser.showDialog(null, "Select");
            if (value == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                String absolutePath = selectedFile.getAbsolutePath();
                if (selectedFile.listFiles().length == 0) {
                    selectedFile.delete();
                }
                if (!dbProp.equals(absolutePath)) {
                    prop.setProperty("database", absolutePath);
                    loadDataBase();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(CommonTool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadDataBase() {

        boolean dbExist = DBManager.checkDB();
        if (!dbExist) {
            dbExist = DBManager.createDB();
        }
        if (!dbExist) {
            DBManager.initController();
        }
    }

    private static void initController() {
        HashMap ctlProp = new HashMap();
        String URL = "jdbc:derby:" + prop.getProperty("database") + ";create=true";
        ctlProp.put("javax.persistence.jdbc.url", URL);
        ctlProp.put("javax.persistence.jdbc.password", prop.getProperty("dbpassword"));
        ctlProp.put("javax.persistence.jdbc.user", prop.getProperty("dbuser"));
        ctlProp.put("javax.persistence.jdbc.driver", DRIVER);
    }

    public static void logout() {
        String url = "jdbc:derby:" + prop.getProperty("database") + ";shutdown=true";
        try {
            DriverManager.getConnection(url);
            Thread.sleep(5000);
        } catch (SQLException | InterruptedException e) {
        }
    }
}
