/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui.objets.dialogs.modif;

import client.implementation.FoodClientImpl;
import client.tools.GenericDialog;
import common.dto.SousCategorieDto;
import common.tools.CaseEnum;
import javax.swing.JOptionPane;

/**
 *
 * @author Gilles
 */
public class ModifSousCategorie extends GenericDialog {

    private SousCategorieDto sousCat;


    public ModifSousCategorie(java.awt.Frame parent, boolean modal,FoodClientImpl modele, SousCategorieDto sousCat) {
        super(parent, modal,modele,"Modification de la sous-catégorie : " + sousCat.getNom());
        initComponents();
        try {
            this.sousCat = sousCat;
            this.jTextFieldNom.setText(sousCat.getNom());
            this.selectCategorie1.setSelectionByObject(sousCat.getCategorie());
            this.jLabelNbE.setText(modele.getNbElem(CaseEnum.SOUS_CATEGORIE,sousCat) + "");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Fais un peu attention tu vas tout bousiller " + ex.getMessage(), "Error Massage",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabelNbE = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        selectCategorie1 = new client.gui.objets.element.SelectCategorie(modele);
        jTextFieldNom = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jLabel1.setText("Nom :");

        jLabel2.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jLabel2.setText("Nombre d'éléments :");

        jButton1.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jButton1.setText("Modifier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jButton2.setText("Quitter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabelNbE.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jLabelNbE.setText("[QTE]");

        jLabel5.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jLabel5.setText("Apparenté à la catégorie :");

        jTextFieldNom.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jTextFieldNom.setText("[NOM]");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelNbE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selectCategorie1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(selectCategorie1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jLabelNbE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            sousCat.setNom(jTextFieldNom.getText());
            sousCat.setCategorie(selectCategorie1.getObjectSelected());
            int reply = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment modifier cette sous-catégorie ?", "Veuillez confirmer", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                modele.update(CaseEnum.MAJ_SOUS_CATEGORIE, sousCat, null);
                dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Tu vas tout casser !!" + ex.getMessage(), "Error Massage",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelNbE;
    private javax.swing.JTextField jTextFieldNom;
    private client.gui.objets.element.SelectCategorie selectCategorie1;
    // End of variables declaration//GEN-END:variables
}
