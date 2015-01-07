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
import resto.exception.RestoBusinessException;
import client.gui.criteres.JPCritSelAliment;
import client.gui.recherche.JDRechercheAliment;
import client.gui.table.MaJTableAliment;
import resto.persistance.dto.AlimentDto;
import resto.seldto.AlimentSel;

/**
 *
 * @author Gilles
 */
public class SelectAliment extends SelectObject<AlimentSel, AlimentDto> {

    @Override
    protected String getShortDescription(AlimentDto t) {
        return "[" + t.getId() + "] " + t.getLibelle();
    }

    @Override
    protected AlimentDto trouveObjet(String crit) throws RestoBusinessException {
        AlimentSel sel;
        try {
            int id = Integer.parseInt(crit);
            sel = new AlimentSel(id);
        } catch (NumberFormatException ex) {
            sel = new AlimentSel(crit);
        }
        Collection<AlimentDto> col = AdminFacade.getAliment(sel);
        if (!col.isEmpty()) {
            return col.iterator().next();
        }
        return null;
    }

    @Override
    protected AlimentDto getObjectById(Object id) throws RestoBusinessException {
        Collection<AlimentDto> col = AdminFacade.getAliment(new AlimentSel((Integer) id));
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
    protected JDRechGenerique<AlimentSel, AlimentDto> getPanelRecherche() throws MaJTableInitialisationException {
        return new JDRechercheAliment(null, true, "Sélection d'édition", new JPCritSelAliment(), new MaJTableAliment());
    }

    @Override
    protected String getCle(AlimentDto t) {
        return t.getLibelle();
    }
}
