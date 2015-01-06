/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.persistance.dto;

import be.esi.alg2.dto.Dto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Dto d'instanciation d'une catégorie
 */
public class ListeAlimentDto extends Dto<Integer> {

    private Collection<IngredientDto> ingredients;
    private Integer numLigne;

    /**
     * Instanciation d'une catégorie persistante
     *
     * @param id identifiant de la catégorie
     * @param lstAli id de l'Aliment
     */
    public ListeAlimentDto(Integer id, Integer numLigne, Collection<IngredientDto> ingredients) {
        this.id = id;
        this.numLigne = numLigne;
        this.ingredients = ingredients;
    }

    /**
     * Instanciation d'une catégorie non persistante
     *
     * @param lstAli id de l'Aliment
     */
    public ListeAlimentDto(Integer id) {
        this.id = id;
        this.ingredients = null;
        this.numLigne = 0;
    }

    public List<AlimentDto> getListAliment() {
        List<AlimentDto> ali = new ArrayList();
        for (IngredientDto ing : ingredients) {
            ali.add(ing.getId());
        }
        return ali;
    }

    public Collection<IngredientDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<IngredientDto> ingredients) {
        this.ingredients = ingredients;
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

    @Override
    public String toString() {
        String res = "[ListeAlimentDto] ";
        if (isPersistant()) {
            res = res + "(" + getId() + ") ";
        } else {
            res = res + "(**) ";
        }
        for (IngredientDto ing : ingredients) {
            res = res + ing;
        }

        return res;
    }
}
