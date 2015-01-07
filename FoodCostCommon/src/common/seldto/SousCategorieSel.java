/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.seldto;

import common.dto.CategorieDto;
import common.exception.RestoDTOException;
import java.io.Serializable;

/**
 * Dto d'instanciation d'une catégorie
 */
public class SousCategorieSel extends GenericSel{

    private Integer id;
    private String nom;
    private CategorieDto categorie;

    /**
     * Instanciation d'une catégorie persistante
     *
     * @param id identifiant de la catégorie
     * @param nom libellé de la catégorie
     */
    public SousCategorieSel(Integer id, String nom) {
        this.id = id;
        this.nom = nom.toLowerCase();
    }

    /**
     * Instanciation d'une catégorie persistante
     *
     * @param id identifiant de la catégorie
     */
    public SousCategorieSel(Integer id) {
        this.id = id;
    }

    /**
     * Instanciation d'une catégorie persistante
     *
     * @param id identifiant de la catégorie
     * @param nom libellé de la catégorie
     * @param categorie categorie de la sous catégorie
     */
    public SousCategorieSel(Integer id, String nom, CategorieDto categorie) {
        this.id = id;
        this.nom = nom.toLowerCase();
        this.categorie = categorie;
    }

    /**
     * Instanciation d'une catégorie non persistante
     *
     * @param nom nomellé de la catégorie
     */
    public SousCategorieSel(String nom) {
        this.id = null;
        this.nom = nom.toLowerCase();
    }

    public CategorieDto getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieDto categorie) {
        this.categorie = categorie;
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
            this.nom = nom.toLowerCase();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
