/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.seldto;

import common.tools.GenericSel;
import java.io.Serializable;

/**
 * Dto d'instanciation d'une catégorie
 */
public class ListeAlimentSel extends GenericSel{

    private Integer id;
    private Integer numLigne;
    private Integer aliId;

    /**
     * Instanciation d'une catégorie persistante
     *
     * @param id identifiant de la catégorie
     */
    public ListeAlimentSel(Integer id, Integer numLigne) {
        this.id = id;
        this.numLigne = numLigne;
    }

    public ListeAlimentSel(int id, int numLigne, Integer aliId) {
        this(id, numLigne);
        this.aliId = aliId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumLigne() {
        return numLigne;
    }

    public void setNumLigne(Integer numLigne) {
        this.numLigne = numLigne;
    }

    public Integer getAliId() {
        return aliId;
    }

    public void setAliId(Integer aliId) {
        this.aliId = aliId;
    }
}
