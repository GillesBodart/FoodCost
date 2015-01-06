/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.gui.table;

import be.esi.alg2.gui.outils.MaJTable;
import be.esi.alg2.gui.outils.MaJTableInitialisationException;
import java.util.Collection;
import resto.persistance.dto.CategorieDto;

/**
 *
 * @author g38302
 */
public class MaJTableCategorie extends MaJTable<CategorieDto> {

    public MaJTableCategorie() throws MaJTableInitialisationException {
    }

    public MaJTableCategorie(Collection<CategorieDto> data) throws MaJTableInitialisationException {
        this();
        setFont(new java.awt.Font("Traditional Arabic", 0, 24));
        setData(data);

    }

    @Override
    protected void setTitres() {
        String[] t = {"id", "libellé"};
        titres = t;
    }

    @Override
    protected void setMethods() {
        String[] t = {"getId", "getNom"};
        methodes = t;
    }

    @Override
    protected void setLargeurs() {
        int[] t = {50, 400};
        largeurs = t;
    }
}