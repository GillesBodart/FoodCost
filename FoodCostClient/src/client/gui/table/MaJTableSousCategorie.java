/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui.table;

import be.esi.alg2.gui.outils.MaJTable;
import be.esi.alg2.gui.outils.MaJTableInitialisationException;
import common.dto.SousCategorieDto;
import java.util.Collection;

/**
 *
 * @author g38302
 */
public class MaJTableSousCategorie extends MaJTable<SousCategorieDto> {

    public MaJTableSousCategorie() throws MaJTableInitialisationException {
    }

    public MaJTableSousCategorie(Collection<SousCategorieDto> data) throws MaJTableInitialisationException {
        this();
        setFont(new java.awt.Font("Traditional Arabic", 0, 24));
        setData(data);
    }

    @Override
    protected void setTitres() {
        String[] t = {"id", "libellé", "Categorie"};
        titres = t;
    }

    @Override
    protected void setMethods() {
        String[] t = {"getId", "getNom", "getNomCategorie"};
        methodes = t;
    }

    @Override
    protected void setLargeurs() {
        int[] t = {50, 300, 200};
        largeurs = t;
    }
}