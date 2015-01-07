/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.dto;

import common.exception.RestoDTOException;
import java.util.ArrayList;

/**
 * Dto d'instanciation d'un rayon
 */
public class CommandeDto extends GenericDto<Integer>{

    private String libelle;
    private Double recPrix;
    private ListeRecetteDto recettes;

    public CommandeDto(String libelle) {
        this.libelle = libelle.toLowerCase();
    }

    public CommandeDto(Integer id, String libelle) {
        this.id = id;
        this.libelle = libelle.toLowerCase();
    }

    public CommandeDto(Integer id, String libelle, ListeRecetteDto Recettes) throws RestoDTOException {
        if (Recettes == null) {
            throw new RestoDTOException("Instanciation d'une recette: liste d'élément non fournie");
        }
        this.id = id;
        this.libelle = libelle.toLowerCase();
        this.recettes = Recettes;

    }

    public CommandeDto(Integer id, String libelle, ListeRecetteDto Recettes, Double recPrix) throws RestoDTOException {
        if (Recettes == null) {
            throw new RestoDTOException("Instanciation d'une recette: liste d'élément non fournie");
        }
        this.recPrix = recPrix;
        this.id = id;
        this.libelle = libelle.toLowerCase();
        this.recettes = Recettes;
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

    public ListeRecetteDto getListeRecettes() {
        return recettes;
    }

    public void setListeRecettes(ListeRecetteDto recettes) {
        this.recettes = recettes;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNbPers() {
        int nbPers = 0;
        for (ComposantDto comp : recettes.getComposants()) {
            nbPers += comp.getQte();
        }
        return nbPers;
    }

    @Override
    public String toString() {
        String res = "[CommandeDTO] ";
        if (isPersistant()) {
            res = res + "(" + getId() + ") ";
        } else {
            res = res + "(**) ";
        }
        res = res + getLibelle();
        if (getListeRecettes() != null) {
            for (RecetteDto elmt : recettes.getListRecette()) {
                res = res + elmt.getLibelle();
            }
        }
        return res;
    }

    public ArrayList<String> getContenu() {
        ArrayList<String> str = new ArrayList();

        str.add("Bon de commande pour : " + libelle);
        str.add("Liste de recettes : ");
        for (ComposantDto cmp : recettes.getComposants()) {
            if (cmp.getQte() > 1) {
                str.add("   -> " + cmp.getId().getLibelle() + " pour " + cmp.getQte().toString() + " personnes ");
            } else {
                str.add("   -> " + cmp.getId().getLibelle() + " pour " + cmp.getQte().toString() + " personne ");
            }
        }
        str.add(" ");
        str.add("Prix total de la commande " + recPrix + " €");
        return str;
    }
    
    /*public ArrayList<String> getContenuListe() {
        try {
            ArrayList<String> str = new ArrayList();

            str.add("Liste d'ingrédients du bon de commande pour : " + libelle);
            str.add("Liste d'ingrédients : ");
            for (IngredientDto ing : CommonTool.triFournisseur(AdminFacade.getIngredientsFromCommande(this))) {
                str.add("( "+ing.getId().getFournisseur()+" ) "+ing.getQte().toString() + ing.getUnit() + " de " + ing.getId().getLibelle());
            }
            str.add(" ");
            str.add("Prix total de la commande " + recPrix + " €");
            return str;
        } catch (RestoBusinessException ex) {
            
        }
        return null;
    }*/
}
