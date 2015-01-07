/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui.criteres;

import be.esi.alg2.gui.outils.JPCritSelGenerique;
import javax.swing.JOptionPane;


/**
 *
 * @author g38302
 */
public class JPCritSelAliment extends JPCritSelGenerique<AlimentSel> {

    public JPCritSelAliment() {
        initComponents();
    }

    @Override
    public void setSel(AlimentSel sel) {
        if (sel == null) {
            jTLibelle.setText("");
        } else {
            jTLibelle.setText(sel.getLibelle());
        }
    }

    @Override
    public AlimentSel getCriteres() {
        AlimentSel e = null;
        try {
            e = new AlimentSel(0, jTLibelle.getText(), new SousCategorieDto(jTCate.getText()), 0.0, jTFou.getText(), null);
        } catch (RestoDTOException ex) {
            JOptionPane.showMessageDialog(null,
                    "AAAAA mais qu'est ce que tu fais !! ", "Error Massage",
                    JOptionPane.ERROR_MESSAGE);
        }
        return e;
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
        jTLibelle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTCate = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jTFou = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();

        jLabel1.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jLabel1.setText("Début de nom de l'aliment : ");

        jTLibelle.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jLabel2.setText("Début de nom de la catégorie : ");

        jTCate.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jLabel3.setText("Début de nom du fournisseur : ");

        jTFou.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTLibelle, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                    .addComponent(jTCate, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                    .addComponent(jTFou))
                .addContainerGap())
            .addComponent(jSeparator2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jTLibelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jTCate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTCate;
    private javax.swing.JTextField jTFou;
    private javax.swing.JTextField jTLibelle;
    // End of variables declaration//GEN-END:variables
}