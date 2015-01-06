/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.gui.objets.element;

import be.esi.alg2.gui.outils.JDRechGenerique;
import be.esi.alg2.gui.outils.MaJTableInitialisationException;
import be.esi.alg2.gui.outils.SelectObject;
import java.util.Collection;
import resto.business.AdminFacade;
import resto.exception.RestoBusinessException;
import resto.gui.criteres.JPCritSelCategorie;
import resto.gui.recherche.JDRechercheCategorie;
import resto.gui.table.MaJTableCategorie;
import resto.persistance.dto.CategorieDto;
import resto.seldto.CategorieSel;

/**
 *
 * @author Gilles
 */
public class SelectCategorie extends SelectObject<CategorieSel, CategorieDto> {

    @Override
    protected String getShortDescription(CategorieDto t) {
        return "[" + t.getId() + "] " + t.getNom();
    }

    @Override
    protected CategorieDto trouveObjet(String crit) throws RestoBusinessException {
        CategorieSel sel;
        try {
            int id = Integer.parseInt(crit);
            sel = new CategorieSel(id);
        } catch (NumberFormatException ex) {
            sel = new CategorieSel(crit);
        }
        Collection<CategorieDto> col = AdminFacade.getCategorie(sel);
        if (!col.isEmpty()) {
            return col.iterator().next();
        }
        return null;
    }

    @Override
    protected CategorieDto getObjectById(Object id) throws RestoBusinessException {
        Collection<CategorieDto> col = AdminFacade.getCategorie(new CategorieSel((Integer) id));
        if (!col.isEmpty()) {
            return col.iterator().next();
        }
        return null;
    }

    @Override
    protected void initLargeurs() {
        setLargeurCritere(200);
    }

    @Override
    protected JDRechGenerique<CategorieSel, CategorieDto> getPanelRecherche() throws MaJTableInitialisationException {
        return new JDRechercheCategorie(null, true, "Sélection d'édition", new JPCritSelCategorie(), new MaJTableCategorie());
    }

    @Override
    protected String getCle(CategorieDto t) {
        return t.getNom();
    }
}
