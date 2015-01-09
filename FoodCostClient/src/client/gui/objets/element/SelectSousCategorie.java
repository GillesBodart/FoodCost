/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui.objets.element;

import be.esi.alg2.gui.outils.JDRechGenerique;
import be.esi.alg2.gui.outils.MaJTableInitialisationException;
import java.util.Collection;
import client.gui.criteres.JPCritSelSousCategorie;
import client.gui.recherche.JDRechercheSousCategorie;
import client.gui.table.MaJTableSousCategorie;
import client.implementation.FoodClientImpl;
import client.tools.GenericSelect;
import common.dto.SousCategorieDto;
import common.exception.RestoBusinessException;
import common.seldto.SousCategorieSel;
import common.tools.CaseEnum;
import java.rmi.RemoteException;

/**
 *
 * @author Gilles
 */
public class SelectSousCategorie extends GenericSelect<SousCategorieSel, SousCategorieDto> {

    public SelectSousCategorie(FoodClientImpl modele) {
        super(modele);
    }

    @Override
    protected String getShortDescription(SousCategorieDto t) {
        return "[" + t.getId() + "] " + t.getNom();
    }

    @Override
    protected SousCategorieDto trouveObjet(String crit) throws RestoBusinessException {
        try {
            SousCategorieSel sel;
            try {
                int id = Integer.parseInt(crit);
                sel = new SousCategorieSel(id);
            } catch (NumberFormatException ex) {
                sel = new SousCategorieSel(crit);
            }
            Collection<SousCategorieDto> col = modele.getBySel(CaseEnum.SOUS_CATEGORIE, sel);
            if (!col.isEmpty()) {
                return col.iterator().next();
            }
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    protected SousCategorieDto getObjectById(Object id) throws RestoBusinessException {
        try {
            Collection<SousCategorieDto> col = modele.getBySel(CaseEnum.SOUS_CATEGORIE, new SousCategorieSel((Integer) id));
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
        setLargeurCritere(300);
    }

    @Override
    protected JDRechGenerique<SousCategorieSel, SousCategorieDto> getPanelRecherche() throws MaJTableInitialisationException {
        return new JDRechercheSousCategorie(null, true,modele, "Sélection d'une sous-catégorie", new JPCritSelSousCategorie(), new MaJTableSousCategorie());
    }

    @Override
    protected String getCle(SousCategorieDto t) {
        return t.getNom();
    }
}
