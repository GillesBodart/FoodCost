/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui.objets.element;

import be.esi.alg2.gui.outils.JDRechGenerique;
import be.esi.alg2.gui.outils.MaJTableInitialisationException;
import be.esi.alg2.gui.outils.SelectObject;
import java.util.Collection;
import resto.business.AdminFacade;
import client.gui.criteres.JPCritSelSousCategorie;
import client.gui.recherche.JDRechercheSousCategorie;
import client.gui.table.MaJTableSousCategorie;
import common.dto.SousCategorieDto;
import common.exception.RestoBusinessException;
import common.seldto.SousCategorieSel;

/**
 *
 * @author Gilles
 */
public class SelectSousCategorie extends SelectObject<SousCategorieSel, SousCategorieDto> {

    @Override
    protected String getShortDescription(SousCategorieDto t) {
        return "[" + t.getId() + "] " + t.getNom();
    }

    @Override
    protected SousCategorieDto trouveObjet(String crit) throws RestoBusinessException {
        SousCategorieSel sel;
        try {
            int id = Integer.parseInt(crit);
            sel = new SousCategorieSel(id);
        } catch (NumberFormatException ex) {
            sel = new SousCategorieSel(crit);
        }
        Collection<SousCategorieDto> col = AdminFacade.getSousCategorie(sel);
        if (!col.isEmpty()) {
            return col.iterator().next();
        }
        return null;
    }

    @Override
    protected SousCategorieDto getObjectById(Object id) throws RestoBusinessException {
        Collection<SousCategorieDto> col = AdminFacade.getSousCategorie(new SousCategorieSel((Integer) id));
        if (!col.isEmpty()) {
            return col.iterator().next();
        }
        return null;
    }

    @Override
    protected void initLargeurs() {
        setLargeurCritere(300);
    }

    @Override
    protected JDRechGenerique<SousCategorieSel, SousCategorieDto> getPanelRecherche() throws MaJTableInitialisationException {
        return new JDRechercheSousCategorie(null, true, "Sélection d'une sous-catégorie", new JPCritSelSousCategorie(), new MaJTableSousCategorie());
    }

    @Override
    protected String getCle(SousCategorieDto t) {
        return t.getNom();
    }
}
