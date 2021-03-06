/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.persistance.dto;

import be.esi.alg2.dto.Dto;
import resto.exception.RestoDTOException;
import resto.outils.Unite;

/**
 * Dto d'instanciation d'un rayon
 */
public class AlimentDto extends Dto<Integer> {

    private String libelle;
    private String fournisseur;
    private Double aliPrix;
    private SousCategorieDto categorie;
    private Unite unit;

    public AlimentDto(String libelle) {
        this.libelle = libelle.toLowerCase();
    }

    public AlimentDto(Integer aliId, String libelle, SousCategorieDto categorie, Double aliPrix, String fournisseur, Unite unit) throws RestoDTOException {
        if (categorie == null) {
            throw new RestoDTOException("Instanciation d'Aliment: Catégorie non fournie");
        }
        this.id = aliId;
        this.libelle = libelle.toLowerCase();
        this.categorie = categorie;
        this.aliPrix = aliPrix;
        this.fournisseur = fournisseur.toLowerCase();
        this.unit = unit;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur.toLowerCase();
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        if (!this.libelle.equalsIgnoreCase(libelle)) {
            this.libelle = libelle.toLowerCase();
        }
    }

    public SousCategorieDto getCategorie() {
        return categorie;
    }

    public void setCategorie(SousCategorieDto categorie) {
        this.categorie = categorie;
    }

    public String getNomCategorie() {
        return categorie.getNom();
    }

    public Double getAliPrix() {
        return aliPrix;
    }

    public void setAliPrix(Double aliPrix) {
        this.aliPrix = aliPrix;
    }

    public Unite getUnit() {
        return unit;
    }

    public String getUnitName() {
        return unit.toString();
    }

    public void setUnit(Unite unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        String res = "[AlimentDTO] ";
        if (isPersistant()) {
            res = res + "(" + getId() + ") ";
        } else {
            res = res + "(**) ";
        }
        res = res + getLibelle();
        if (getCategorie() != null) {
            res = res + getCategorie();
        }
        return res;
    }
}
