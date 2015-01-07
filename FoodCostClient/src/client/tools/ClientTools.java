/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.tools;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Gilles
 */
public class ClientTools {
    
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
    
}
