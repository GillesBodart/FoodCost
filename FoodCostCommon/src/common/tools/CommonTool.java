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

    public static Unit getUnite(String nom) {
        Unit elm = null;
        if (nom.equals("Kg")) {
            elm = Unit.KG;
        }
        if (nom.equals("L")) {
            elm = Unit.L;
        }
        if (nom.equals("Pièce")) {
            elm = Unit.PCE;
        }
        if (nom.equals("Heure")) {
            elm = Unit.H;
        }
        return elm;
    }

    public static Quantity getQte(String nom) {
        Quantity elm = null;
        if (nom.equals(Quantity.G.toString())) {
            elm = Quantity.G;
        }
        if (nom.equals(Quantity.KG.toString())) {
            elm = Quantity.KG;
        }
        if (nom.equals(Quantity.ML.toString())) {
            elm = Quantity.ML;
        }
        if (nom.equals(Quantity.BOUT1.toString())) {
            elm = Quantity.BOUT1;
        }
        if (nom.equals(Quantity.BOUT2.toString())) {
            elm = Quantity.BOUT1;
        }
        if (nom.equals(Quantity.BOUT3.toString())) {
            elm = Quantity.BOUT1;
        }
        if (nom.equals(Quantity.BOUT4.toString())) {
            elm = Quantity.BOUT1;
        }
        if (nom.equals(Quantity.CC.toString())) {
            elm = Quantity.CC;
        }
        if (nom.equals(Quantity.CS.toString())) {
            elm = Quantity.CS;
        }
        if (nom.equals(Quantity.PCE.toString())) {
            elm = Quantity.PCE;
        }
        if (nom.equals(Quantity.MIN.toString())) {
            elm = Quantity.MIN;
        }
        return elm;
    }

    public static Quantity stand(Unit unit) {

        Quantity elm = null;
        switch (unit) {
            case KG:
                elm = Quantity.G;
                break;
            case L:
                elm = Quantity.ML;
                break;
            case PCE:
                elm = Quantity.PCE;
                break;
            case H:
                elm = Quantity.MIN;
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
