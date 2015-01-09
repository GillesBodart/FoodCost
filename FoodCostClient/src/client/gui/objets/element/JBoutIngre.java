/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui.objets.element;

import client.gui.objets.dialogs.ChoixModifIngre;
import client.implementation.FoodClientImpl;
import client.tools.GenericPanel;
import common.dto.IngredientDto;
import common.dto.ListeAlimentDto;
import common.dto.ModificationIngreDto;

/**
 *
 * @author Gilles
 */
public class JBoutIngre extends GenericPanel {

    private ListeAlimentDto lst;
    private IngredientDto ing;
    private boolean modif;
    private int ended;
    public final int SUPPR_ENDED = 1;
    public final int MODIF_ENDED = 2;

    /**
     * Creates new form JPanelIngre
     */
    public JBoutIngre(FoodClientImpl modele,IngredientDto ing, ListeAlimentDto lst) {
        super(modele);
        initComponents();
        this.lst = lst;
        this.ing = ing;
        modif = false;
        maj();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonIn = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(32767, 50));

        jButtonIn.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jButtonIn.setText("jButton1");
        jButtonIn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonIn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonIn, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonIn, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInActionPerformed
        ChoixModifIngre modif = new ChoixModifIngre(null, true,modele, ing, lst);
        modif.setVisible(true);
        this.ing = modif.getIngre();
        if (modif.isModifEnded()) {
            maj();
            ended = MODIF_ENDED;
        } else {
            sup();
            ended = SUPPR_ENDED;
        }

    }//GEN-LAST:event_jButtonInActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIn;
    // End of variables declaration//GEN-END:variables

    private void maj() {
        String buff = ing.getId().getFournisseur() + " : " + ing.getId().getLibelle() + " : " + ing.getQte() + "  " + ing.getUnit().toString() + "   " + ing.getPrix() + " €";
        jButtonIn.setText(buff);
    }

    private void sup() {
        String buff = ing.getId().getLibelle() + " : Element supprimé";
        jButtonIn.setText(buff);
    }

    public ModificationIngreDto getModif() {
        if (modif) {
            return new ModificationIngreDto(ing, ended);
        } else {
            return null;
        }
    }

    public IngredientDto getIngre() {
        return ing;
    }
}
