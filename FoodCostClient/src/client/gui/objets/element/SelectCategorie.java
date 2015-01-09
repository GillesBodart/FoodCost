/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui.objets.element;

import be.esi.alg2.gui.outils.JDRechGenerique;
import be.esi.alg2.gui.outils.MaJTableInitialisationException;
import java.util.Collection;
import client.gui.criteres.JPCritSelCategorie;
import client.gui.recherche.JDRechercheCategorie;
import client.gui.table.MaJTableCategorie;
import client.implementation.FoodClientImpl;
import client.tools.GenericSelect;
import common.dto.CategorieDto;
import common.exception.RestoBusinessException;
import common.seldto.CategorieSel;
import common.tools.CaseEnum;
import java.rmi.RemoteException;

/**
 *
 * @author Gilles
 */
public class SelectCategorie extends GenericSelect<CategorieSel, CategorieDto> {

    public SelectCategorie(FoodClientImpl modele) {
        super(modele);
    }

    @Override
    protected String getShortDescription(CategorieDto t) {
        return "[" + t.getId() + "] " + t.getNom();
    }

    @Override
    protected CategorieDto trouveObjet(String crit) throws RestoBusinessException {
        try {
            CategorieSel sel;
            try {
                int id = Integer.parseInt(crit);
                sel = new CategorieSel(id);
            } catch (NumberFormatException ex) {
                sel = new CategorieSel(crit);
            }
            Collection<CategorieDto> col = modele.getBySel(CaseEnum.CATEGORIE, sel);
            if (!col.isEmpty()) {
                return col.iterator().next();
            }

        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    protected CategorieDto getObjectById(Object id) throws RestoBusinessException {
        try {
            Collection<CategorieDto> col = modele.getBySel(CaseEnum.CATEGORIE, new CategorieSel((Integer) id));
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
    protected JDRechGenerique<CategorieSel, CategorieDto> getPanelRecherche() throws MaJTableInitialisationException {
        return new JDRechercheCategorie(null, true,modele, "Sélection d'édition", new JPCritSelCategorie(), new MaJTableCategorie());
    }

    @Override
    protected String getCle(CategorieDto t) {
        return t.getNom();
    }
}
