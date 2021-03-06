/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.dto;

import common.tools.GenericDto;
import common.exception.RestoDTOException;
import common.tools.Quantity;

/**
 * Dto d'instanciation d'une catégorie
 */
public class IngredientDto extends GenericDto<AlimentDto> implements Comparable{

    private Integer qte;
    private Quantity unit;

    /**
     * Instanciation d'une catégorie persistante
     *
     * @param id identifiant de la catégorie
     * @param nom nomellé de la catégorie
     */
    public IngredientDto(AlimentDto id, Integer qte, Quantity val) {
        this.id = id;
        this.qte = qte;
        this.unit = val;
    }

    /**
     * Instanciation d'une catégorie non persistante
     *
     * @param nom nomellé de la catégorie
     */
    public IngredientDto(AlimentDto id) {
        this.id = id;
    }

    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) throws RestoDTOException {
        this.qte = qte;
    }

    public Double getPrix() {
        Double prix = id.getAliPrix();
        return id.getUnit().calcul(prix, qte * unit.facteur(), 4);

    }

    public Quantity getUnit() {
        return unit;
    }

    public void setUnit(Quantity unit) {
        this.unit = unit;
    }

    public void setId(AlimentDto ali) {
        this.id = ali;
    }

    @Override
    public String toString() {
        String res = "[IngredientDTO] ";
        if (isPersistant()) {
            res = res + "(" + getId() + ") ";
        } else {
            res = res + "(**) ";
        }
        res = res + getQte() + " g";
        return res;
    }

    @Override
    public int compareTo(Object o) {
        IngredientDto ing = (IngredientDto) o ;
        return this.getId().getFournisseur().compareToIgnoreCase(ing.getId().getFournisseur());
        
    }
}
