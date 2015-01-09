/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.tools;

import be.esi.alg2.gui.outils.JDRechGenerique;
import be.esi.alg2.gui.outils.JPCritSelGenerique;
import be.esi.alg2.gui.outils.MaJTable;
import client.implementation.FoodClientImpl;
import java.awt.Frame;
import java.util.Collection;
import javax.swing.ImageIcon;

/**
 *
 * @author Gilles
 */
public abstract class GenericRecherche<T,Q> extends JDRechGenerique<T, Q>{

    protected FoodClientImpl modele;

    public GenericRecherche( Frame parent, boolean modal,FoodClientImpl modele, String title, JPCritSelGenerique<T> crit, MaJTable<Q> jT) {
        super(parent, modal, title, crit, jT);
        this.modele = modele;
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(this.getClass().getResource("/img/Logo.jpg")).getImage());
    }
    
    
    
    @Override
    protected abstract Collection<Q> recherche(T s) throws Exception;
    
}
