/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.dto;

import be.esi.alg2.dto.Dto;

/**
 *
 * @author Gilles
 */
public class ModificationIngreDto extends Dto<IngredientDto> {

    private int ended;

    /**
     * Instanciation d'une catégorie persistante
     *
     * @param id identifiant de la catégorie
     * @param nom nomellé de la catégorie
     */
    public ModificationIngreDto(IngredientDto id, int ended) {
        this.id = id;
        this.ended = ended;
    }

    public int getEnded() {
        return ended;
    }
}
