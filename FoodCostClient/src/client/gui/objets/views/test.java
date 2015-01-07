/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui.objets.views;

import client.implementation.FoodClientImpl;
import common.interfaces.FoodModele;
import java.rmi.Naming;

/**
 *
 * @author Gilles
 */
public class test {

    private static FoodClientImpl modele;

    public static void main(String[] args) {

        try {

            FoodModele fm = (FoodModele) Naming.lookup("rmi://gillesbodart.ddns.net:1099/FoodSocket1");
            modele = new FoodClientImpl(fm);
            System.out.println("conected");
        } catch (Exception ex) {
            System.out.println("error");
            System.out.println(ex.getMessage());
        }
    }

}
