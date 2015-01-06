/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.gui.criteres;

import be.esi.alg2.gui.outils.JPCritSelGenerique;
import javax.swing.JOptionPane;
import resto.exception.RestoDTOException;
import resto.seldto.RecetteSel;

/**
 *
 * @author g38302
 */
public class JPCritSelRecette extends JPCritSelGenerique<RecetteSel> {

    public JPCritSelRecette() {
        initComponents();
    }

    @Override
    public void setSel(RecetteSel sel) {
        if (sel == null) {
            jTLibelle.setText("");
        } else {
            jTLibelle.setText(sel.getLibelle());
            jTCouv.setText("" + sel.getNbPers());
        }
    }

    @Override
    public RecetteSel getCriteres() {
        RecetteSel e = null;
        try {
            if (jTCouv.getText().isEmpty()) {
                e = new RecetteSel(0, jTLibelle.getText(), null, 0.0, 0);

            } else {
                e = new RecetteSel(0, jTLibelle.getText(), null, 0.0, Integer.parseInt(jTCouv.getText()));
            }
        } catch (RestoDTOException ex) {
            JOptionPane.showMessageDialog(null,
                    "Arrete de vouloir entrer autres chauses que des chiffres pour le nombre de couverts !" + ex.getMessage(), "Error Massage",
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
        jTCouv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jLabel1.setText("Début de nom de la recette :");

        jTLibelle.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N

        jTCouv.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jLabel2.setText("Nombre de couverts :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTLibelle, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(jTCouv, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jTLibelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jTCouv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTCouv;
    private javax.swing.JTextField jTLibelle;
    // End of variables declaration//GEN-END:variables
}
