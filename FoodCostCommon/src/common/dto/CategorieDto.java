/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.dto;

import common.exception.RestoDTOException;

/**
 * Dto d'instanciation d'une catégorie
 */
public class CategorieDto extends GenericDto<Integer> {

    private String nom;

    /**
     * Instanciation d'une catégorie persistante
     *
     * @param id identifiant de la catégorie
     * @param nom nomellé de la catégorie
     */
    public CategorieDto(Integer id, String nom) {
        this.id = id;
        this.nom = nom.toLowerCase();
    }

    /**
     * Instanciation d'une catégorie non persistante
     *
     * @param nom nomellé de la catégorie
     */
    public CategorieDto(String nom) {
        this.id = null;
        this.nom = nom.toLowerCase();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws RestoDTOException {
        if (nom == null || nom.length() == 0) {
            throw new RestoDTOException("Le nom ne peut pas être vide");
        }
        if (nom.length() > 255) {
            throw new RestoDTOException("Le nom ne peut pas excéder 255 caractères!");
        }
        if (!this.nom.equals(nom)) {
            this.nom = nom;
        }
    }

    @Override
    public String toString() {
        String res = "[CategorieDTO] ";
        if (isPersistant()) {
            res = res + "(" + getId() + ") ";
        } else {
            res = res + "(**) ";
        }
        res = res + getNom();
        return res;
    }
}
