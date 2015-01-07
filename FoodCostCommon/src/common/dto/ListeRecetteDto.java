/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.dto;

import be.esi.alg2.dto.Dto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Dto d'instanciation d'une catégorie
 */
public class ListeRecetteDto extends Dto<Integer> {

    private Collection<ComposantDto> composants;
    private Integer numLigne;

    /**
     * Instanciation d'une catégorie persistante
     *
     * @param id identifiant de la catégorie
     * @param lstAli id de l'Recette
     */
    public ListeRecetteDto(Integer id, Integer numLigne, Collection<ComposantDto> composants) {
        this.id = id;
        this.numLigne = numLigne;
        this.composants = composants;
    }

    /**
     * Instanciation d'une catégorie non persistante
     *
     * @param lstAli id de l'Recette
     */
    public ListeRecetteDto(Integer id) {
        this.id = id;
        this.composants = null;
        this.numLigne = 0;
    }

    public List<RecetteDto> getListRecette() {
        List<RecetteDto> ali = new ArrayList();
        for (ComposantDto comp : composants) {
            ali.add(comp.getId());
        }
        return ali;
    }

    public Collection<ComposantDto> getComposants() {
        return composants;
    }

    public void setComposants(Collection<ComposantDto> composants) {
        this.composants = composants;
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
        String res = "[ListeRecetteDto] ";
        if (isPersistant()) {
            res = res + "(" + getId() + ") ";
        } else {
            res = res + "(**) ";
        }
        for (ComposantDto comp : composants) {
            res = res + comp;
        }

        return res;
    }
}
