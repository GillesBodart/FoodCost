/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui.criteres;

import be.esi.alg2.gui.outils.JPCritSelGenerique;
import common.seldto.CategorieSel;

/**
 *
 * @author g38302
 */
public class JPCritSelCategorie extends JPCritSelGenerique<CategorieSel> {

    public JPCritSelCategorie() {
        initComponents();
    }

    @Override
    public void setSel(CategorieSel sel) {
        if (sel == null) {
            jTLibelle.setText("");
        } else {
            jTLibelle.setText(sel.getNom());
        }
    }

    @Override
    public CategorieSel getCriteres() {
        CategorieSel e = new CategorieSel(0, jTLibelle.getText());
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

        jLabel1.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jLabel1.setText("Début de nom de la catégorie : ");

        jTLibelle.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTLibelle, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jTLibelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTLibelle;
    // End of variables declaration//GEN-END:variables
}
