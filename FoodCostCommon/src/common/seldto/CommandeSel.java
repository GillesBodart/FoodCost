/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.seldto;

import common.dto.ListeRecetteDto;
import common.exception.RestoDTOException;
import java.io.Serializable;

/**
 * Dto d'instanciation d'un rayon
 */
public class CommandeSel extends GenericSel {

    private Integer id;
    private String libelle;
    private Double recPrix;
    private ListeRecetteDto Recettes;

    public CommandeSel(Integer id) throws RestoDTOException {
        this.recPrix = 0.0;
        this.id = id;
        this.libelle = "";
        this.Recettes = null;
    }

    public CommandeSel(Integer id, String libelle, ListeRecetteDto Recettes, Double recPrix, Integer NbPers) throws RestoDTOException {

        this.recPrix = recPrix;
        this.id = id;
        this.libelle = libelle.toLowerCase();
        this.Recettes = Recettes;

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
        return Recettes;
    }

    public void setListeRecettes(ListeRecetteDto Recettes) {
        this.Recettes = Recettes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
