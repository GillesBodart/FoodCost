/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui.objets.element;

import be.esi.alg2.gui.outils.JDRechGenerique;
import be.esi.alg2.gui.outils.MaJTableInitialisationException;
import java.util.Collection;
import client.gui.criteres.JPCritSelAliment;
import client.gui.recherche.JDRechercheAliment;
import client.gui.table.MaJTableAliment;
import client.implementation.FoodClientImpl;
import client.tools.GenericSelect;
import common.dto.AlimentDto;
import common.exception.RestoBusinessException;
import common.seldto.AlimentSel;
import common.tools.CaseEnum;
import java.rmi.RemoteException;

/**
 *
 * @author Gilles
 */
public class SelectAliment extends GenericSelect<AlimentSel, AlimentDto> {

    public SelectAliment(FoodClientImpl modele) {
        super(modele);
    }

    @Override
    protected String getShortDescription(AlimentDto t) {
        return "[" + t.getId() + "] " + t.getLibelle();
    }

    @Override
    protected AlimentDto trouveObjet(String crit) throws RestoBusinessException {
        try {
            AlimentSel sel;
            try {
                int id = Integer.parseInt(crit);
                sel = new AlimentSel(id);
            } catch (NumberFormatException ex) {
                sel = new AlimentSel(crit);
            }
            Collection<AlimentDto> col = modele.getBySel(CaseEnum.ALIMENT, sel);
            if (!col.isEmpty()) {
                return col.iterator().next();
            }
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    protected AlimentDto getObjectById(Object id) throws RestoBusinessException {
        try {
            Collection<AlimentDto> col = modele.getBySel(CaseEnum.ALIMENT, new AlimentSel((Integer) id));
            if (!col.isEmpty()) {
                return col.iterator().next();
            }

        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    protected void initLargeurs() {
        setLargeurCritere(200);
    }

    @Override
    protected JDRechGenerique<AlimentSel, AlimentDto> getPanelRecherche() throws MaJTableInitialisationException {
        return new JDRechercheAliment(null, true,modele, "Sélection d'édition", new JPCritSelAliment(), new MaJTableAliment());
    }

    @Override
    protected String getCle(AlimentDto t) {
        return t.getLibelle();
    }
}
