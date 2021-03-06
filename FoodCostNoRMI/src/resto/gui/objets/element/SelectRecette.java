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
import resto.exception.RestoDTOException;
import resto.gui.criteres.JPCritSelRecette;
import resto.gui.recherche.JDRechercheRecette;
import resto.gui.table.MaJTableRecette;
import resto.persistance.dto.RecetteDto;
import resto.seldto.RecetteSel;

/**
 *
 * @author Gilles
 */
public class SelectRecette extends SelectObject<RecetteSel, RecetteDto> {

    @Override
    protected String getShortDescription(RecetteDto t) {
        return "[" + t.getId() + "] " + t.getLibelle();
    }

    @Override
    protected RecetteDto trouveObjet(String crit) throws RestoBusinessException {
        RecetteSel sel;
        try {
            int id = Integer.parseInt(crit);
            sel = new RecetteSel(id);
        } catch (NumberFormatException | RestoDTOException ex) {
            try {
                sel = new RecetteSel(0);
            } catch (RestoDTOException ex1) {
                throw new RestoBusinessException("Objet non trouvé.");
            }
        }
        Collection<RecetteDto> col = AdminFacade.getRecette(sel);
        if (!col.isEmpty()) {
            return col.iterator().next();
        }
        return null;
    }

    @Override
    protected RecetteDto getObjectById(Object id) throws RestoBusinessException {
        try {
            Collection<RecetteDto> col = AdminFacade.getRecette(new RecetteSel((Integer) id));
            if (!col.isEmpty()) {
                return col.iterator().next();
            }
            return null;
        } catch (RestoDTOException ex) {
            throw new RestoBusinessException("Objet non trouvé.");
        }
    }

    @Override
    protected void initLargeurs() {
        setLargeurCritere(200);
    }

    @Override
    protected JDRechGenerique<RecetteSel, RecetteDto> getPanelRecherche() throws MaJTableInitialisationException {
        return new JDRechercheRecette(null, true, "Sélection d'édition", new JPCritSelRecette(), new MaJTableRecette());
    }

    @Override
    protected String getCle(RecetteDto t) {
        return t.getLibelle();
    }
}
