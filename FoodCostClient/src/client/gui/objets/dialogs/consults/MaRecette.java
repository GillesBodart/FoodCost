/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui.objets.dialogs.consults;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import client.gui.objets.dialogs.MonJFileChooser;
import resto.outils.Outils;
import resto.persistance.dto.RecetteDto;

/**
 *
 * @author Gilles
 */
public class MaRecette extends javax.swing.JDialog {
    
    private RecetteDto rec;

    /**
     * Creates new form MaRecette
     */
    public MaRecette(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setIconImage(new ImageIcon(this.getClass().getResource("/img/Logo.jpg")).getImage());
        initComponents();
        setLocationRelativeTo(null);
        
        
    }
    
    public MaRecette(java.awt.Frame parent, boolean modal, RecetteDto rec) {
        this(parent, modal);
        this.rec = rec;
        this.jLabelTitre.setText(rec.getLibelle());
        this.jLabelPrix.setText("" + Outils.round(rec.getRecPrix(), 4));
        this.jLabelPrixPP.setText("" + Outils.round(rec.getRecPrix() / rec.getNbPers(), 4));
        this.jListeIngredient1.setElmnt(rec.getListeAliments(), false);
        setTitle("Apperçu de la recette : " + rec.getLibelle());
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jListeIngredient1 = new client.gui.objets.element.JListeIngredient();
        jLabelPrixPP1 = new javax.swing.JLabel();
        jLabelPrix1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelTitre.setFont(new java.awt.Font("Traditional Arabic", 0, 36)); // NOI18N
        jLabelTitre.setText("[Titre]");

        jLabel2.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jLabel2.setText("Prix :");

        jLabel3.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jLabel3.setText("Prix PP:");

        jLabelPrix.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jLabelPrix.setText("0");

        jLabelPrixPP.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jLabelPrixPP.setText("0");

        jButton1.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jButton1.setText("Quitter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jButton2.setText("Enregistrer sous");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabelPrixPP1.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jLabelPrixPP1.setText("€");

        jLabelPrix1.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jLabelPrix1.setText("€");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelTitre)
                    .addComponent(jListeIngredient1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPrix)
                    .addComponent(jLabelPrixPP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPrix1)
                    .addComponent(jLabelPrixPP1))
                .addGap(11, 11, 11))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabelTitre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jListeIngredient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabelPrix))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabelPrixPP)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPrix1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPrixPP1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            MonJFileChooser jfc = new MonJFileChooser();
            jfc.setVisible(true);
            Outils.enregistrer(jfc.getUrl(), rec.getLibelle(), rec.getContenu());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Un problème d'acces au fichier est survenu ... \n" + ex.getMessage(), "Error Massage",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(MaRecette.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaRecette.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaRecette.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaRecette.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MaRecette dialog = new MaRecette(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelPrix;
    private javax.swing.JLabel jLabelPrix1;
    private javax.swing.JLabel jLabelPrixPP;
    private javax.swing.JLabel jLabelPrixPP1;
    private javax.swing.JLabel jLabelTitre;
    private client.gui.objets.element.JListeIngredient jListeIngredient1;
    // End of variables declaration//GEN-END:variables
}