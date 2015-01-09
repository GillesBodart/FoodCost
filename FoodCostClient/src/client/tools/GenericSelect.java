/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.tools;

import be.esi.alg2.dto.Dto;
import be.esi.alg2.gui.outils.JDRechGenerique;
import be.esi.alg2.gui.outils.MaJTableInitialisationException;
import be.esi.alg2.gui.outils.SelectObject;
import client.implementation.FoodClientImpl;

/**
 *
 * @author Gilles
 * @param <T>
 * @param <Q>
 */
public abstract class GenericSelect<T,Q extends Dto<?>> extends SelectObject<T, Q>{
    
    protected FoodClientImpl modele;

    public GenericSelect(FoodClientImpl modele) {
        this.modele = modele;
    }

    @Override
    protected abstract void initLargeurs();


    @Override
    protected abstract String getCle(Q t);

    @Override
    protected abstract String getShortDescription(Q t);

    @Override
    protected abstract Q trouveObjet(String string) throws Exception;

    @Override
    protected abstract Q getObjectById(Object o) throws Exception;

    @Override
    protected abstract JDRechGenerique<T, Q> getPanelRecherche() throws MaJTableInitialisationException;
    
    
    
}
