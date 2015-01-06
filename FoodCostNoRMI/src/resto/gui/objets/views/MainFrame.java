/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.gui.objets.views;

import be.esi.alg2.gui.outils.MaJTableInitialisationException;
import javax.swing.JOptionPane;
import resto.gui.criteres.JPCritSelAliment;
import resto.gui.criteres.JPCritSelCategorie;
import resto.gui.criteres.JPCritSelCommande;
import resto.gui.criteres.JPCritSelRecette;
import resto.gui.criteres.JPCritSelSousCategorie;
import resto.gui.objets.dialogs.ajouts.AjoutAliment;
import resto.gui.objets.dialogs.ajouts.AjoutCatégorie;
import resto.gui.objets.dialogs.ajouts.AjoutRecette;
import resto.gui.objets.dialogs.ajouts.AjoutSousCatégorie;
import resto.gui.objets.dialogs.consults.MaCategorie;
import resto.gui.objets.dialogs.consults.MaRecette;
import resto.gui.objets.dialogs.consults.MaSousCategorie;
import resto.gui.objets.dialogs.modif.ModifAliment;
import resto.gui.objets.dialogs.modif.ModifCategorie;
import resto.gui.objets.dialogs.modif.ModifRecette;
import resto.gui.objets.dialogs.modif.ModifSousCategorie;
import resto.gui.objets.dialogs.consults.MonAliment;
import resto.gui.objets.dialogs.ajouts.AjoutCommande;
import resto.gui.objets.dialogs.consults.MaCommande;
import resto.gui.objets.dialogs.modif.ModifCommande;
import resto.gui.recherche.JDRechercheAliment;
import resto.gui.recherche.JDRechercheCategorie;
import resto.gui.recherche.JDRechercheCommande;
import resto.gui.recherche.JDRechercheRecette;
import resto.gui.recherche.JDRechercheSousCategorie;
import resto.gui.table.MaJTableAliment;
import resto.gui.table.MaJTableCategorie;
import resto.gui.table.MaJTableCommande;
import resto.gui.table.MaJTableRecette;
import resto.gui.table.MaJTableSousCategorie;

/**
 *
 * @author Gilles
 */
public class MainFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        // Outils.loadConfigFile(Outils.CONFIG_FILE);
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAR = new javax.swing.JButton();
        jButtonAA = new javax.swing.JButton();
        jButtonCR = new javax.swing.JButton();
        jButtonCA = new javax.swing.JButton();
        jButtonMA = new javax.swing.JButton();
        jButtonMR = new javax.swing.JButton();
        jButtonCC = new javax.swing.JButton();
        jButtonAC = new javax.swing.JButton();
        jButtonMC = new javax.swing.JButton();
        jButtonCSC = new javax.swing.JButton();
        jButtonASC = new javax.swing.JButton();
        jButtonMSC = new javax.swing.JButton();
        jButtonCSC1 = new javax.swing.JButton();
        jButtonASC1 = new javax.swing.JButton();
        jButtonMSC1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonAR.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jButtonAR.setText("Ajouter recette");
        jButtonAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonARActionPerformed(evt);
            }
        });

        jButtonAA.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jButtonAA.setText("Ajouter aliment");
        jButtonAA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAAActionPerformed(evt);
            }
        });

        jButtonCR.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jButtonCR.setText("Consulter recette");
        jButtonCR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCRActionPerformed(evt);
            }
        });

        jButtonCA.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jButtonCA.setText("Consulter aliment");
        jButtonCA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCAActionPerformed(evt);
            }
        });

        jButtonMA.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jButtonMA.setText("Modifier aliment");
        jButtonMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMAActionPerformed(evt);
            }
        });

        jButtonMR.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jButtonMR.setText("Modifier recette");
        jButtonMR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMRActionPerformed(evt);
            }
        });

        jButtonCC.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jButtonCC.setText("Consulter catégories");
        jButtonCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCCActionPerformed(evt);
            }
        });

        jButtonAC.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jButtonAC.setText("Ajouter catégorie");
        jButtonAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonACActionPerformed(evt);
            }
        });

        jButtonMC.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jButtonMC.setText("Modifier catégorie");
        jButtonMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMCActionPerformed(evt);
            }
        });

        jButtonCSC.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jButtonCSC.setText("Consulter sous-catégories");
        jButtonCSC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCSCActionPerformed(evt);
            }
        });

        jButtonASC.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jButtonASC.setText("Ajouter sous-catégorie");
        jButtonASC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonASCActionPerformed(evt);
            }
        });

        jButtonMSC.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jButtonMSC.setText("Modifier sous-catégorie");
        jButtonMSC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMSCActionPerformed(evt);
            }
        });

        jButtonCSC1.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jButtonCSC1.setText("Consulter bons de comande");
        jButtonCSC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCSC1ActionPerformed(evt);
            }
        });

        jButtonASC1.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jButtonASC1.setText("Ajouter bons de comande");
        jButtonASC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonASC1ActionPerformed(evt);
            }
        });

        jButtonMSC1.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jButtonMSC1.setText("Modifier bons de comande");
        jButtonMSC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMSC1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonCA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAA))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonCR, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAR, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jButtonMA)
                            .addComponent(jButtonMR)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAC, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonMC))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCSC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonASC, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonMSC))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCSC1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonASC1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonMSC1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonAA, jButtonAC, jButtonAR, jButtonASC, jButtonASC1, jButtonCA, jButtonCC, jButtonCR, jButtonCSC, jButtonCSC1, jButtonMA, jButtonMC, jButtonMR, jButtonMSC, jButtonMSC1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButtonMA)
                    .addComponent(jButtonAA)
                    .addComponent(jButtonCA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButtonCR, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMR)
                    .addComponent(jButtonAR, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButtonCC, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMC)
                    .addComponent(jButtonAC, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButtonCSC, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMSC)
                    .addComponent(jButtonASC, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButtonCSC1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMSC1)
                    .addComponent(jButtonASC1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonAA, jButtonAC, jButtonAR, jButtonASC, jButtonASC1, jButtonCA, jButtonCC, jButtonCR, jButtonCSC, jButtonCSC1, jButtonMA, jButtonMC, jButtonMR, jButtonMSC, jButtonMSC1});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCAActionPerformed
        try {
            JDRechercheAliment ali = new JDRechercheAliment(null, true, "Consultater un Aliment", new JPCritSelAliment(),
                    new MaJTableAliment());
            ali.setVisible(true);
            if (ali.getObjectSelected() != null) {
                new MonAliment(null, true, ali.getObjectSelected()).setVisible(true);
            }

        } catch (MaJTableInitialisationException ex) {
            JOptionPane.showMessageDialog(null,
                    "Fais un peu attention tu vas tout bousiller " + ex.getMessage(), "Error Massage",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCAActionPerformed

    private void jButtonARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonARActionPerformed
        new AjoutRecette(null, true).setVisible(true);
    }//GEN-LAST:event_jButtonARActionPerformed

    private void jButtonCRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCRActionPerformed
        try {
            JDRechercheRecette rec = new JDRechercheRecette(null, true, "Consulter une recette", new JPCritSelRecette(),
                    new MaJTableRecette());
            rec.setVisible(true);
            if (rec.getObjectSelected() != null) {
                new MaRecette(null, true, rec.getObjectSelected()).setVisible(true);
            }

        } catch (MaJTableInitialisationException ex) {
            JOptionPane.showMessageDialog(null,
                    "Un probleme est survenu je ne sais pas non plus pourquoi " + ex.getMessage(), "Error Massage",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCRActionPerformed

    private void jButtonCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCCActionPerformed
        try {
            JDRechercheCategorie cat = new JDRechercheCategorie(null, true, "Sélection d'une catégorie", new JPCritSelCategorie(),
                    new MaJTableCategorie());
            cat.setVisible(true);
            if (cat.getObjectSelected() != null) {
                new MaCategorie(null, true, cat.getObjectSelected()).setVisible(true);
            }
        } catch (MaJTableInitialisationException ex) {
            JOptionPane.showMessageDialog(null,
                    "Un probleme est survenu je ne sais pas non plus pourquoi " + ex.getMessage(), "Error Massage",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCCActionPerformed

    private void jButtonACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonACActionPerformed
        new AjoutCatégorie(null, true).setVisible(true);
    }//GEN-LAST:event_jButtonACActionPerformed

    private void jButtonCSCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCSCActionPerformed
        try {
            JDRechercheSousCategorie sousCat = new JDRechercheSousCategorie(null, true, "Sélection d'une sous-catégorie", new JPCritSelSousCategorie(),
                    new MaJTableSousCategorie());
            sousCat.setVisible(true);
            if (sousCat.getObjectSelected() != null) {
                new MaSousCategorie(null, true, sousCat.getObjectSelected()).setVisible(true);
            }
        } catch (MaJTableInitialisationException ex) {
            JOptionPane.showMessageDialog(null,
                    "Un probleme est survenu je ne sais pas non plus pourquoi " + ex.getMessage(), "Error Massage",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCSCActionPerformed

    private void jButtonASCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonASCActionPerformed
        new AjoutSousCatégorie(null, true).setVisible(true);
    }//GEN-LAST:event_jButtonASCActionPerformed

    private void jButtonMSCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMSCActionPerformed
        try {
            JDRechercheSousCategorie cat = new JDRechercheSousCategorie(null, true, "Sélection d'une sous-catégorie", new JPCritSelSousCategorie(),
                    new MaJTableSousCategorie());
            cat.setVisible(true);
            if (cat.getObjectSelected() != null) {
                new ModifSousCategorie(null, true, cat.getObjectSelected()).setVisible(true);
            }
        } catch (MaJTableInitialisationException ex) {
            JOptionPane.showMessageDialog(null,
                    "Un probleme est survenu je ne sais pas non plus pourquoi " + ex.getMessage(), "Error Massage",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonMSCActionPerformed

    private void jButtonAAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAAActionPerformed
        new AjoutAliment(null, true).setVisible(true);
    }//GEN-LAST:event_jButtonAAActionPerformed

    private void jButtonMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMAActionPerformed
        try {
            JDRechercheAliment ali = new JDRechercheAliment(null, true, "Sélection d'un aliment", new JPCritSelAliment(),
                    new MaJTableAliment());
            ali.setVisible(true);
            if (ali.getObjectSelected() != null) {
                new ModifAliment(null, true, ali.getObjectSelected()).setVisible(true);
            }
        } catch (MaJTableInitialisationException ex) {
            JOptionPane.showMessageDialog(null,
                    "Un probleme est survenu je ne sais pas non plus pourquoi " + ex.getMessage(), "Error Massage",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonMAActionPerformed

    private void jButtonMCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMCActionPerformed
        try {
            JDRechercheCategorie cat = new JDRechercheCategorie(null, true, "Sélection d'une catégorie", new JPCritSelCategorie(),
                    new MaJTableCategorie());
            cat.setVisible(true);
            if (cat.getObjectSelected() != null) {
                new ModifCategorie(null, true, cat.getObjectSelected()).setVisible(true);
            }
        } catch (MaJTableInitialisationException ex) {
            JOptionPane.showMessageDialog(null,
                    "Un probleme est survenu je ne sais pas non plus pourquoi " + ex.getMessage(), "Error Massage",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonMCActionPerformed

    private void jButtonMRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMRActionPerformed
        try {
            JDRechercheRecette cat = new JDRechercheRecette(null, true, "Sélection d'une recette", new JPCritSelRecette(),
                    new MaJTableRecette());
            cat.setVisible(true);
            if (cat.getObjectSelected() != null) {
                new ModifRecette(null, true, cat.getObjectSelected()).setVisible(true);
            }
        } catch (MaJTableInitialisationException ex) {
            JOptionPane.showMessageDialog(null,
                    "Un probleme est survenu je ne sais pas non plus pourquoi " + ex.getMessage(), "Error Massage",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonMRActionPerformed

    private void jButtonCSC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCSC1ActionPerformed
        try {
            JDRechercheCommande rec = new JDRechercheCommande(null, true, "Consulter une commande", new JPCritSelCommande(),
                    new MaJTableCommande());
            rec.setVisible(true);
            if (rec.getObjectSelected() != null) {
                new MaCommande(null, true, rec.getObjectSelected()).setVisible(true);
            }

        } catch (MaJTableInitialisationException ex) {
            JOptionPane.showMessageDialog(null,
                    "Un probleme est survenu je ne sais pas non plus pourquoi " + ex.getMessage(), "Error Massage",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCSC1ActionPerformed

    private void jButtonASC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonASC1ActionPerformed
        new AjoutCommande(null, true).setVisible(true);
    }//GEN-LAST:event_jButtonASC1ActionPerformed

    private void jButtonMSC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMSC1ActionPerformed
        try {
            JDRechercheCommande cat = new JDRechercheCommande(null, true, "Sélection d'une commande", new JPCritSelCommande(),
                    new MaJTableCommande());
            cat.setVisible(true);
            if (cat.getObjectSelected() != null) {
                new ModifCommande(null, true, cat.getObjectSelected()).setVisible(true);
            }
        } catch (MaJTableInitialisationException ex) {
            JOptionPane.showMessageDialog(null,
                    "Un probleme est survenu je ne sais pas non plus pourquoi \n" + ex.getMessage(), "Error Massage",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonMSC1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAA;
    private javax.swing.JButton jButtonAC;
    private javax.swing.JButton jButtonAR;
    private javax.swing.JButton jButtonASC;
    private javax.swing.JButton jButtonASC1;
    private javax.swing.JButton jButtonCA;
    private javax.swing.JButton jButtonCC;
    private javax.swing.JButton jButtonCR;
    private javax.swing.JButton jButtonCSC;
    private javax.swing.JButton jButtonCSC1;
    private javax.swing.JButton jButtonMA;
    private javax.swing.JButton jButtonMC;
    private javax.swing.JButton jButtonMR;
    private javax.swing.JButton jButtonMSC;
    private javax.swing.JButton jButtonMSC1;
    // End of variables declaration//GEN-END:variables
}
