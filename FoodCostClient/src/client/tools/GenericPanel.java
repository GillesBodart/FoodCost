/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.tools;

import client.implementation.FoodClientImpl;
import javax.swing.JPanel;

/**
 *
 * @author Gilles
 */
public class GenericPanel extends JPanel{
    
    protected FoodClientImpl modele;

    public GenericPanel(FoodClientImpl modele) {
        this.modele = modele;
    }

    public FoodClientImpl getModele() {
        return modele;
    }
    
    
}
