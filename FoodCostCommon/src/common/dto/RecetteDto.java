/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.dto;

import common.tools.GenericDto;
import common.exception.RestoDTOException;
import common.tools.CommonTool;
import java.util.ArrayList;

/**
 * Dto d'instanciation d'un rayon
 */
public class RecetteDto extends GenericDto<Integer> {

    private String libelle;
    private Double recPrix;
    private ListeAlimentDto Aliments;
    private Integer NbPers;

    public RecetteDto(String libelle) {
        this.libelle = libelle.toLowerCase();
    }

    public RecetteDto(Integer id, String libelle) {
        this.id = id;
        this.libelle = libelle.toLowerCase();
    }

    public RecetteDto(Integer id, String libelle, ListeAlimentDto Aliments) throws RestoDTOException {
        if (Aliments == null) {
            throw new RestoDTOException("Instanciation d'une recette: liste d'élément non fournie");
        }
        this.id = id;
        this.libelle = libelle.toLowerCase();
        this.Aliments = Aliments;

    }

    public RecetteDto(Integer id, String libelle, ListeAlimentDto Aliments, Double recPrix) throws RestoDTOException {
        if (Aliments == null) {
            throw new RestoDTOException("Instanciation d'une recette: liste d'élément non fournie");
        }
        this.recPrix = recPrix;
        this.id = id;
        this.libelle = libelle.toLowerCase();
        this.Aliments = Aliments;

    }

    public RecetteDto(Integer id, String libelle, ListeAlimentDto Aliments, Double recPrix, Integer NbPers) throws RestoDTOException {
        if (Aliments == null) {
            throw new RestoDTOException("Instanciation d'une recette: liste d'élément non fournie");
        }
        this.recPrix = recPrix;
        this.id = id;
        this.libelle = libelle.toLowerCase();
        this.Aliments = Aliments;
        this.NbPers = NbPers;
    }

    public Double getRecPrix() {
        return recPrix;
    }

    public void setRecPrix(Double recPrix) {
        this.recPrix = recPrix;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        if (!this.libelle.equals(libelle)) {
            this.libelle = libelle.toLowerCase();
        }
    }

    public ListeAlimentDto getListeAliments() {
        return Aliments;
    }

    public void setListeAliments(ListeAlimentDto Aliments) {
        this.Aliments = Aliments;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNbPers() {
        return NbPers;
    }

    public void setNbPers(Integer NbPers) {
        this.NbPers = NbPers;
    }

    @Override
    public String toString() {
        String res = "[RecetteDTO] ";
        if (isPersistant()) {
            res = res + "(" + getId() + ") ";
        } else {
            res = res + "(**) ";
        }
        res = res + getLibelle();
        if (getListeAliments() != null) {
            for (AlimentDto elmt : Aliments.getListAliment()) {
                res = res + elmt.getLibelle();
            }
        }
        return res;
    }

    public ArrayList<String> getContenu() {
        ArrayList<String> str = new ArrayList();
        if (NbPers > 1) {
            str.add("Recette : " + libelle + " pour " + NbPers + " personnes");
        } else {
            str.add("Recette : " + libelle + " pour " + NbPers + " personne");
        }
        str.add("Liste d'ingrédients : ");
        for (IngredientDto ing : Aliments.getIngredients()) {
            str.add("   -> "+ing.getQte().toString() + ing.getUnit() + " de " + ing.getId().getLibelle());
        }
        str.add(" ");
        str.add("Prix total de la recette " + recPrix+" €");
        str.add("Le prix par personne est de " + CommonTool.round(recPrix/NbPers, 4)+" €");
        return str;
    }
}
