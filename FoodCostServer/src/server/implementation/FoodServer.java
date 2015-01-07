/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.implementation;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Gilles
 */
public class FoodServer {
    public static void main(String[] argv) {
        try {
            FoodServeurImpl folders[] = new FoodServeurImpl[100];
            for (int i = 0; i < folders.length; i++) {
                folders[i] = new FoodServeurImpl();
            }
            LocateRegistry.createRegistry(1099);
            int cpt = 0;
            for (FoodServeurImpl draw : folders) {
                cpt++;
                Naming.rebind("FoodSocket" + cpt, draw);
            }
            System.out.println("Food Server is ready. 100 Sockets are available");
            ServeurControle controle = new ServeurControle();
            controle.setVisible(true);
            while (!controle.isExit()) {
                Thread.sleep(1);
            }
            System.exit(0);
        } catch (RemoteException | MalformedURLException | InterruptedException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
