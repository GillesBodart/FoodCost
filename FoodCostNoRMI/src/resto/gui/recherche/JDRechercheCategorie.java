/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.gui.recherche;

import be.esi.alg2.gui.outils.JDRechGenerique;
import be.esi.alg2.gui.outils.MaJTableInitialisationException;
import java.util.Collection;
import javax.swing.ImageIcon;
import resto.business.AdminFacade;
import resto.exception.RestoBusinessException;
import resto.gui.criteres.JPCritSelCategorie;
import resto.gui.table.MaJTableCategorie;
import resto.persistance.dto.CategorieDto;
import resto.seldto.CategorieSel;

/**
 *
 * @author g38302
 */
public class JDRechercheCategorie extends JDRechGenerique<CategorieSel, CategorieDto> {

    public JDRechercheCategorie(java.awt.Frame parent, boolean modal, String title, JPCritSelCategorie crit, MaJTableCategorie jT) {
        super(parent, modal, title, crit, jT);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(this.getClass().getResource("/img/Logo.jpg")).getImage());
    }

    @Override
    protected Collection<CategorieDto> recherche(CategorieSel crit) throws RestoBusinessException {
        return AdminFacade.getCategorie(crit);
    }

    public static void main(String[] args) throws MaJTableInitialisationException {
        new JDRechercheCategorie(null, true, "Sélection d'une catégorie", new JPCritSelCategorie(),
                new MaJTableCategorie()).setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}