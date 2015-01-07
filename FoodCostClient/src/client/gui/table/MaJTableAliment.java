/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui.table;

import be.esi.alg2.gui.outils.MaJTable;
import be.esi.alg2.gui.outils.MaJTableInitialisationException;
import java.util.Collection;
import resto.persistance.dto.AlimentDto;

/**
 *
 * @author g38302
 */
public class MaJTableAliment extends MaJTable<AlimentDto> {

    public MaJTableAliment() throws MaJTableInitialisationException {
    }

    public MaJTableAliment(Collection<AlimentDto> data) throws MaJTableInitialisationException {
        this();
        setFont(new java.awt.Font("Traditional Arabic", 0, 24));
        setData(data);

    }

    @Override
    protected void setTitres() {
        String[] t = {"id", "libellé", "fournisseur", "prix", "sous-categorie", "unité"};
        titres = t;
    }

    @Override
    protected void setMethods() {
        String[] t = {"getId", "getLibelle", "getFournisseur", "getAliPrix", "getNomCategorie", "getUnitName"};
        methodes = t;
    }

    @Override
    protected void setLargeurs() {
        int[] t = {70, 300, 150, 150, 300, 120};
        largeurs = t;
    }
}
