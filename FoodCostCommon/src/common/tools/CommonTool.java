/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.tools;

import common.dto.IngredientDto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author Gilles
 */
public class CommonTool {

    public static double round(double valueToRound, int numberOfDecimalPlaces) {
        double multipicationFactor = Math.pow(10, numberOfDecimalPlaces);
        double interestedInZeroDPs = valueToRound * multipicationFactor;
        return Math.round(interestedInZeroDPs) / multipicationFactor;
    }

    public static Unite getUnite(String nom) {
        Unite elm = null;
        if (nom.equals("Kg")) {
            elm = Unite.KG;
        }
        if (nom.equals("L")) {
            elm = Unite.L;
        }
        if (nom.equals("Pièce")) {
            elm = Unite.PCE;
        }
        if (nom.equals("Heure")) {
            elm = Unite.H;
        }
        return elm;
    }

    public static Quantite getQte(String nom) {
        Quantite elm = null;
        if (nom.equals(Quantite.G.toString())) {
            elm = Quantite.G;
        }
        if (nom.equals(Quantite.KG.toString())) {
            elm = Quantite.KG;
        }
        if (nom.equals(Quantite.ML.toString())) {
            elm = Quantite.ML;
        }
        if (nom.equals(Quantite.BOUT1.toString())) {
            elm = Quantite.BOUT1;
        }
        if (nom.equals(Quantite.BOUT2.toString())) {
            elm = Quantite.BOUT1;
        }
        if (nom.equals(Quantite.BOUT3.toString())) {
            elm = Quantite.BOUT1;
        }
        if (nom.equals(Quantite.BOUT4.toString())) {
            elm = Quantite.BOUT1;
        }
        if (nom.equals(Quantite.CC.toString())) {
            elm = Quantite.CC;
        }
        if (nom.equals(Quantite.CS.toString())) {
            elm = Quantite.CS;
        }
        if (nom.equals(Quantite.PCE.toString())) {
            elm = Quantite.PCE;
        }
        if (nom.equals(Quantite.MIN.toString())) {
            elm = Quantite.MIN;
        }
        return elm;
    }

    public static Quantite stand(Unite unit) {

        Quantite elm = null;
        switch (unit) {
            case KG:
                elm = Quantite.G;
                break;
            case L:
                elm = Quantite.ML;
                break;
            case PCE:
                elm = Quantite.PCE;
                break;
            case H:
                elm = Quantite.MIN;
                break;
        }
        return elm;
    }

    
    public static ArrayList<IngredientDto> triFournisseur(Collection<IngredientDto> list){
        ArrayList<IngredientDto> tri = new ArrayList<>(list);
        Collections.sort(tri);
        return tri;
    }
    
    
}
