/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.outils;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import resto.persistance.dto.IngredientDto;

/**
 *
 * @author Gilles
 */
public class Outils {

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

    public static void enregistrer(String url, String titre, ArrayList<String> cont) {
        try {
            Document document = new Document();
            FileOutputStream fos = new FileOutputStream(url + System.getProperty("file.separator") + titre + ".pdf");
            PdfWriter.getInstance(document, fos);
            document.open();
            document.addTitle(titre);
            document.addCreationDate();
            int i = 0;
            for (String str : cont) {
                if (i == 0) {
                    
                    document.add(new Paragraph(str, new Font(Font.FontFamily.HELVETICA, 25, Font.UNDERLINE)));
                    document.add(new Paragraph(" ",new Font(Font.FontFamily.HELVETICA, 25)));
                } else {
                    document.add(new Paragraph(str, new Font(Font.FontFamily.HELVETICA, 18)));
                }
                i++;

            }
            document.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<IngredientDto> triFournisseur(Collection<IngredientDto> list){
        ArrayList<IngredientDto> tri = new ArrayList<>(list);
        Collections.sort(tri);
        return tri;
    }
    
    
}
