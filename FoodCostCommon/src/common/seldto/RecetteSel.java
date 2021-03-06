/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.seldto;

import common.tools.GenericSel;
import common.dto.ListeAlimentDto;
import common.exception.RestoDTOException;
import java.io.Serializable;

/**
 * Dto d'instanciation d'un rayon
 */
public class RecetteSel extends GenericSel{

    private Integer id;
    private String libelle;
    private Double recPrix;
    private ListeAlimentDto Aliments;
    private Integer NbPers;

    public RecetteSel(Integer id) throws RestoDTOException {
        this.recPrix = 0.0;
        this.id = id;
        this.libelle = "";
        this.Aliments = null;
    }

    public RecetteSel(Integer id, String libelle, ListeAlimentDto Aliments, Double recPrix, Integer NbPers) throws RestoDTOException {

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

    public Integer getId() {
        return id;
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
}
