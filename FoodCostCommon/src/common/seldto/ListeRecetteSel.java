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
public class ListeRecetteSel extends GenericSel{

    private Integer id;
    private Integer numLigne;
    private Integer aliId;

    /**
     * Instanciation d'une catégorie persistante
     *
     * @param id identifiant de la catégorie
     */
    public ListeRecetteSel(Integer id, Integer numLigne) {
        this.id = id;
        this.numLigne = numLigne;
    }

    public ListeRecetteSel(int id, int numLigne, Integer aliId) {
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

    public Integer getRctId() {
        return aliId;
    }

    public void setRctId(Integer aliId) {
        this.aliId = aliId;
    }
}
