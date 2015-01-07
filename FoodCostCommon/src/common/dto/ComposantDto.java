/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.dto;

import common.exception.RestoDTOException;

/**
 * Dto d'instanciation d'une catégorie
 */
public class ComposantDto extends GenericDto<RecetteDto> {

    private Integer qte;

    /**
     * Instanciation d'une catégorie persistante
     *
     * @param id identifiant de la catégorie
     * @param nom nomellé de la catégorie
     */
    public ComposantDto(RecetteDto id, Integer qte) {
        this.id = id;
        this.qte = qte;
    }

    /**
     * Instanciation d'une catégorie non persistante
     *
     * @param nom nomellé de la catégorie
     */
    public ComposantDto(RecetteDto id) {
        this.id = id;
    }

    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) throws RestoDTOException {
        this.qte = qte;
    }

    public Double getPrix() {
        return id.getRecPrix() / id.getNbPers() * qte;

    }

    public void setId(RecetteDto rct) {
        this.id = rct;
    }

    @Override
    public String toString() {
        String res = "[ComposantDTO] ";
        if (isPersistant()) {
            res = res + "(" + getId() + ") ";
        } else {
            res = res + "(**) ";
        }
        res = res + getQte() + " g";
        return res;
    }
}
