/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui.table;

import be.esi.alg2.gui.outils.MaJTable;
import be.esi.alg2.gui.outils.MaJTableInitialisationException;
import java.util.Collection;
import resto.persistance.dto.RecetteDto;

/**
 *
 * @author g38302
 */
public class MaJTableRecette extends MaJTable<RecetteDto> {

    public MaJTableRecette() throws MaJTableInitialisationException {
    }

    public MaJTableRecette(Collection<RecetteDto> data) throws MaJTableInitialisationException {
        this();
        setFont(new java.awt.Font("Traditional Arabic", 0, 24));
        setData(data);

    }

    @Override
    protected void setTitres() {
        String[] t = {"id", "libellé", "prix", "Couverts"};
        titres = t;
    }

    @Override
    protected void setMethods() {
        String[] t = {"getId", "getLibelle", "getRecPrix", "getNbPers"};
        methodes = t;
    }

    @Override
    protected void setLargeurs() {
        int[] t = {70, 300, 150, 100};
        largeurs = t;
    }
}
