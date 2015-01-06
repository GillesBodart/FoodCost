/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.gui.objets.element;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import resto.persistance.dto.ComposantDto;
import resto.persistance.dto.ListeRecetteDto;
import resto.persistance.dto.ModificationCompDto;

/**
 *
 * @author Gilles
 */
public class JListeRecette extends javax.swing.JPanel {

    private ArrayList<ModificationCompDto> listModif;

    /**
     * Creates new form JListeComposant
     */
    public JListeRecette() {
        initComponents();
    }

    public void addElem(JPanelComp ing) {
        jPanelContainer.add(ing);
        jScrollPane1.setViewportView(jPanelContainer);
        jScrollPane1.getVerticalScrollBar().setValue(jScrollPane1.getVerticalScrollBar().getMaximum());
        jPanelContainer.revalidate();
        jPanelContainer.repaint();
    }

    public void addElem(JBoutComp ing) {
        jPanelContainer.add(ing);
        jScrollPane1.setViewportView(jPanelContainer);
        jScrollPane1.getVerticalScrollBar().setValue(jScrollPane1.getVerticalScrollBar().getMaximum());
        jPanelContainer.revalidate();
        jPanelContainer.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelContainer = new javax.swing.JPanel();

        jScrollPane1.setMaximumSize(new java.awt.Dimension(300, 32767));

        jPanelContainer.setMaximumSize(new java.awt.Dimension(300, 32767));
        jPanelContainer.setLayout(new javax.swing.BoxLayout(jPanelContainer, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(jPanelContainer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelContainer;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public void setElmnt(ListeRecetteDto listeRecette, boolean modif) {
        Dimension dim = this.getPreferredSize();
        if (modif) {
            for (ComposantDto ing : listeRecette.getComposants()) {
                JBoutComp jb = new JBoutComp(ing, listeRecette);
                jb.setPreferredSize(new Dimension(dim.width, jb.getPreferredSize().height));
                this.addElem(jb);
            }
        } else {
            for (ComposantDto ing : listeRecette.getComposants()) {
                JPanelComp jp = new JPanelComp(ing);
                jp.setPreferredSize(new Dimension(dim.width, jp.getPreferredSize().height));
                this.addElem(jp);
            }
        }
    }

    public void removeLastPanel() {
        this.jPanelContainer.remove(this.jPanelContainer.getComponentCount() - 1);
        jPanelContainer.revalidate();
        jPanelContainer.repaint();
    }

    public ArrayList<ModificationCompDto> getModif() {
        ArrayList<ModificationCompDto> mod = new ArrayList<>();
        ModificationCompDto elem;
        for (Component comp : jPanelContainer.getComponents()) {
            JBoutComp bou = (JBoutComp) comp;
            elem = bou.getModif();
            if (elem != null) {
                mod.add(elem);
            }
        }
        return mod;
    }

    public ArrayList<ComposantDto> getComp() {
        ArrayList<ComposantDto> ing = new ArrayList<>();
        ModificationCompDto elem;
        for (Component comp : jPanelContainer.getComponents()) {
            JBoutComp bou = (JBoutComp) comp;
            elem = bou.getModif();
            if (elem != null && elem.getEnded() != 2) {
                ing.add(elem.getId());
            } else {
                ing.add(bou.getComp());
            }
        }
        return ing;
    }

    public int getNbPers() {
        int nbPers = 0;
        for (ComposantDto comp : getComp()) {
            nbPers += comp.getQte();
        }
        return nbPers;
    }
}
