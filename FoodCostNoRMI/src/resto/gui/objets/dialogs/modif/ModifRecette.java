/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.gui.objets.dialogs.modif;

import javax.swing.ImageIcon;
import resto.gui.objets.dialogs.ajouts.AjoutIngredient;
import javax.swing.JOptionPane;
import resto.business.AdminFacade;
import resto.db.ListeAlimentDB;
import resto.exception.RestoDbException;
import resto.gui.objets.element.JBoutIngre;
import resto.outils.Outils;
import resto.persistance.dto.IngredientDto;
import resto.persistance.dto.ModificationIngreDto;
import resto.persistance.dto.RecetteDto;

/**
 *
 * @author Gilles
 */
public class ModifRecette extends javax.swing.JDialog {

    private RecetteDto rec;
    private IngredientDto lastIng;
    private JBoutIngre lastPanelIngre;
    private double prixTmp;

    /**
     * Creates new form MaRecette
     */
    public ModifRecette(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
setIconImage(new ImageIcon(this.getClass().getResource("/img/Logo.jpg")).getImage());
    }

    public ModifRecette(java.awt.Frame parent, boolean modal, RecetteDto rec) {
        this(parent, modal);
        this.rec = rec;
        this.jTextFieldTitre.setText(rec.getLibelle());
        this.jTextFieldNbPers.setText("" + rec.getNbPers());
        prixTmp = rec.getRecPrix();
        this.jLabelPrix.setText("" + Outils.round(prixTmp, 4));
        this.jLabelPrixPP.setText("" + Outils.round(prixTmp / rec.getNbPers(), 4));
        this.jListeIngredient1.setElmnt(rec.getListeAliments(), true);
        setLocationRelativeTo(null);
        setTitle("Modification de la recette : " + rec.getLibelle());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelPrix = new javax.swing.JLabel();
        jLabelPrixPP = new javax.swing.JLabel();
        jButtonQuitter = new javax.swing.JButton();
        jButtonRaf = new javax.swing.JButton();
        jListeIngredient1 = new resto.gui.objets.element.JListeIngredient();
        jTextFieldTitre = new javax.swing.JTextField();
        jLabelNbPers = new javax.swing.JLabel();
        jTextFieldNbPers = new javax.swing.JTextField();
        jButtonModif = new javax.swing.JButton();
        jButtonAjout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelTitre.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jLabelTitre.setText("Titre :");

        jLabel2.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jLabel2.setText("Prix :");

        jLabel3.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jLabel3.setText("Prix PP:");

        jLabelPrix.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jLabelPrix.setText("0");

        jLabelPrixPP.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jLabelPrixPP.setText("0");

        jButtonQuitter.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jButtonQuitter.setText("Quitter");
        jButtonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitterActionPerformed(evt);
            }
        });

        jButtonRaf.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jButtonRaf.setText("Rafraichir prix");
        jButtonRaf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRafActionPerformed(evt);
            }
        });

        jTextFieldTitre.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jTextFieldTitre.setText("[Titre]");

        jLabelNbPers.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jLabelNbPers.setText("Nb personnes :");

        jTextFieldNbPers.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jTextFieldNbPers.setText("[Pers]");

        jButtonModif.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jButtonModif.setText("Modifier");
        jButtonModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifActionPerformed(evt);
            }
        });

        jButtonAjout.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jButtonAjout.setText("Ajouter ingrédient");
        jButtonAjout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPrix)
                            .addComponent(jLabelPrixPP))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonRaf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButtonModif, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jListeIngredient1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAjout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTitre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelNbPers, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTitre)
                            .addComponent(jTextFieldNbPers, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonModif, jButtonQuitter});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitre)
                    .addComponent(jTextFieldTitre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNbPers)
                    .addComponent(jTextFieldNbPers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jListeIngredient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAjout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRaf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelPrix))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabelPrixPP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonQuitter)
                    .addComponent(jButtonModif))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonQuitter, jButtonRaf});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonQuitterActionPerformed

    private void jButtonRafActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRafActionPerformed
        recalc();
    }//GEN-LAST:event_jButtonRafActionPerformed

    private void jButtonModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifActionPerformed
        try {
            rec.setLibelle(jTextFieldTitre.getText());
            rec.setNbPers(Integer.parseInt(jTextFieldNbPers.getText()));
            int reply = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment modifier cette recette ?", "Veuillez confirmer", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                for (ModificationIngreDto mod : jListeIngredient1.getModif()) {
                    if (mod.getEnded() == 1) {
                        AdminFacade.modifListeAli(rec,mod.getId());
                    }
                    if (mod.getEnded() == 2) {
                        AdminFacade.supprimeIngre(rec,mod.getId());
                    }
                }
                recalc();
                rec.setRecPrix(prixTmp);
                AdminFacade.majDBFromRecette(rec);

                dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Tu vas tout casser !!\n" + ex.getMessage(), "Error Massage",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonModifActionPerformed

    private void jButtonAjoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjoutActionPerformed
        AjoutIngredient aI = new AjoutIngredient(null, true);
        aI.setVisible(true);
        if (aI.getExit() == 0) {
            try {
                lastIng = aI.getIngre();
                lastPanelIngre = new JBoutIngre(lastIng, rec.getListeAliments());
                jListeIngredient1.addElem(lastPanelIngre);
                prixTmp += lastIng.getPrix();
                jLabelPrix.setText("" + Outils.round(prixTmp, 4));
                jLabelPrixPP.setText("" + Outils.round(prixTmp / Integer.parseInt(jTextFieldNbPers.getText()), 4));
                ListeAlimentDB.insertIngrDb(rec.getListeAliments(), lastIng);
            } catch (RestoDbException ex) {
                JOptionPane.showMessageDialog(null,
                        "Tu vas tout casser !!\n" + ex.getMessage(), "Error Massage",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonAjoutActionPerformed

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
            java.util.logging.Logger.getLogger(ModifRecette.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifRecette.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifRecette.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifRecette.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModifRecette dialog = new ModifRecette(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjout;
    private javax.swing.JButton jButtonModif;
    private javax.swing.JButton jButtonQuitter;
    private javax.swing.JButton jButtonRaf;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelNbPers;
    private javax.swing.JLabel jLabelPrix;
    private javax.swing.JLabel jLabelPrixPP;
    private javax.swing.JLabel jLabelTitre;
    private resto.gui.objets.element.JListeIngredient jListeIngredient1;
    private javax.swing.JTextField jTextFieldNbPers;
    private javax.swing.JTextField jTextFieldTitre;
    // End of variables declaration//GEN-END:variables

    private void recalc() {
        try {
            prixTmp = 0;
            for (IngredientDto ing : jListeIngredient1.getIngr()) {
                prixTmp += ing.getPrix();
            }
            this.jLabelPrix.setText("" + Outils.round(prixTmp, 4));
            this.jLabelPrixPP.setText("" + Outils.round(prixTmp / Integer.parseInt(jTextFieldNbPers.getText()), 4));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Tu vas tout casser !!\n" + ex.getMessage(), "Error Massage",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}