/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.tools;

import client.implementation.FoodClientImpl;
import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

/**
 *
 * @author Gilles
 */
public class GenericDialog extends JDialog {

    protected FoodClientImpl modele;
    
    public GenericDialog(Frame owner, boolean modal, FoodClientImpl modele,String title) {
        super(owner, modal);
        setLocationRelativeTo(null);
        setTitle(title);
        setIconImage(new ImageIcon("Logo.jpg").getImage());
        this.modele=modele;
    }
    
}
