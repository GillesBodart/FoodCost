/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui.objets.element;

import be.esi.alg2.gui.outils.JDRechGenerique;
import be.esi.alg2.gui.outils.MaJTableInitialisationException;
import java.util.Collection;
import client.gui.criteres.JPCritSelRecette;
import client.gui.recherche.JDRechercheRecette;
import client.gui.table.MaJTableRecette;
import client.implementation.FoodClientImpl;
import client.tools.GenericSelect;
import common.dto.RecetteDto;
import common.exception.RestoBusinessException;
import common.exception.RestoDTOException;
import common.seldto.RecetteSel;
import common.tools.CaseEnum;
import java.rmi.RemoteException;

/**
 *
 * @author Gilles
 */
public class SelectRecette extends GenericSelect<RecetteSel, RecetteDto> {

    public SelectRecette(FoodClientImpl modele) {
        super(modele);
    }

    @Override
    protected String getShortDescription(RecetteDto t) {
        return "[" + t.getId() + "] " + t.getLibelle();
    }

    @Override
    protected RecetteDto trouveObjet(String crit) throws RestoBusinessException {
        try {
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
            Collection<RecetteDto> col = modele.getBySel(CaseEnum.RECETTE, sel);
            if (!col.isEmpty()) {
                return col.iterator().next();
            }
            
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    protected RecetteDto getObjectById(Object id) throws RestoBusinessException {
        try {
            Collection<RecetteDto> col = modele.getBySel(CaseEnum.RECETTE,new RecetteSel((Integer) id));
            if (!col.isEmpty()) {
                return col.iterator().next();
            }
            return null;
        } catch (Exception ex) {
            throw new RestoBusinessException("Objet non trouvé.");
        }
    }

    @Override
    protected void initLargeurs() {
        setLargeurCritere(200);
    }

    @Override
    protected JDRechGenerique<RecetteSel, RecetteDto> getPanelRecherche() throws MaJTableInitialisationException {
        return new JDRechercheRecette(null, true,modele, "Sélection d'édition", new JPCritSelRecette(), new MaJTableRecette());
    }

    @Override
    protected String getCle(RecetteDto t) {
        return t.getLibelle();
    }
}
