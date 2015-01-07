/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.seldto;

import common.dto.SousCategorieDto;
import common.exception.RestoDTOException;
import common.tools.Unit;

/**
 * Classe d'instanciation de critères de sélection de marques Le critère complet
 * correspond au et logique de toutes les valeurs sgnificatives données
 */
public class AlimentSel extends GenericSel{

    private String libelle;
    private String fournisseur;
    private Double aliPrix;
    private SousCategorieDto categorie;
    private Integer id;
    private Unit unit;

    public AlimentSel(Integer id, String libelle) {
        this.id = id;
        this.libelle = libelle.toLowerCase();
    }

    public AlimentSel(Integer aliId, String libelle, SousCategorieDto categorie, Double aliPrix, String fournisseur, Unit unit) throws RestoDTOException {
        this.id = aliId;
        this.libelle = libelle.toLowerCase();
        this.categorie = categorie;
        this.aliPrix = aliPrix;
        this.fournisseur = fournisseur.toLowerCase();
        this.unit = unit;
    }

    public AlimentSel(String libelle) {
        this.id = 0;
        this.libelle = libelle.toLowerCase();
    }

    public AlimentSel(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public Integer getId() {
        return id;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur.toLowerCase();
    }

    public Double getAliPrix() {
        return aliPrix;
    }

    public void setAliPrix(Double aliPrix) {
        this.aliPrix = aliPrix;
    }

    public SousCategorieDto getSousCategorie() {
        return categorie;
    }

    public void setSousCategorie(SousCategorieDto categorie) {
        this.categorie = categorie;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
