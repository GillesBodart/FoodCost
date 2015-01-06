/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.gui.table;

import be.esi.alg2.gui.outils.MaJTable;
import be.esi.alg2.gui.outils.MaJTableInitialisationException;
import java.util.Collection;
import resto.persistance.dto.CommandeDto;

/**
 *
 * @author g38302
 */
public class MaJTableCommande extends MaJTable<CommandeDto> {

    public MaJTableCommande() throws MaJTableInitialisationException {
    }

    public MaJTableCommande(Collection<CommandeDto> data) throws MaJTableInitialisationException {
        this();
        setFont(new java.awt.Font("Traditional Arabic", 0, 24));
        setData(data);

    }

    @Override
    protected void setTitres() {
        String[] t = {"id", "Client", "prix"};
        titres = t;
    }

    @Override
    protected void setMethods() {
        String[] t = {"getId", "getLibelle", "getRecPrix"};
        methodes = t;
    }

    @Override
    protected void setLargeurs() {
        int[] t = {70, 300, 150};
        largeurs = t;
    }
}
