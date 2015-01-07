/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.implementation;

import common.dto.CommandeDto;
import common.dto.ComposantDto;
import common.dto.GenericDto;
import common.dto.IngredientDto;
import common.dto.ListeAlimentDto;
import common.dto.ListeRecetteDto;
import common.dto.RecetteDto;
import common.interfaces.FoodModele;
import common.seldto.GenericSel;
import common.tools.CaseEnum;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Gilles
 */
public class FoodClientImpl implements FoodModele{

    private FoodModele foodRemote;

    public FoodClientImpl(FoodModele foodRemote) {
        try {
            this.foodRemote = foodRemote;
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public List getAll(CaseEnum cat) throws RemoteException {
        return foodRemote.getAll(cat);
    }

    @Override
    public GenericDto getByName(CaseEnum cat, String name) throws RemoteException {
        return foodRemote.getByName(cat, name);
    }

    @Override
    public GenericDto getById(CaseEnum cat, GenericDto id) throws RemoteException {
        return foodRemote.getById(cat, id);
    }

    @Override
    public List getBySel(CaseEnum cat, GenericSel sel) throws RemoteException {
        return foodRemote.getBySel(cat, sel);
    }

    @Override
    public int add(CaseEnum cat, GenericDto rec) throws RemoteException {
        return foodRemote.add(cat, rec);
    }

    @Override
    public int getNbElem(CaseEnum cat, GenericDto rec) throws RemoteException {
        return foodRemote.getNbElem(cat, rec);
    }

    @Override
    public int update(CaseEnum cat, GenericDto rec1, GenericDto rec2) throws RemoteException {
        return foodRemote.update(cat, rec1, rec2);
    }

    @Override
    public int delete(CommandeDto com, ComposantDto id) throws RemoteException {
        return foodRemote.delete(com, id);
    }

    @Override
    public int delete(RecetteDto rec, IngredientDto id) throws RemoteException {
        return foodRemote.delete(rec, id);
    }

    @Override
    public List<IngredientDto> getIngredientsFromCommande(CommandeDto com) throws RemoteException {
        return foodRemote.getIngredientsFromCommande(com);
    }

    @Override
    public int delete(ListeAlimentDto lst, IngredientDto ing) throws RemoteException {
        return foodRemote.delete(lst,ing);
    }

    @Override
    public int delete(ListeRecetteDto lst, ComposantDto cmp) throws RemoteException {
        return foodRemote.delete(lst,cmp);
    }

    @Override
    public List get(CaseEnum cat, GenericDto dto) throws RemoteException {
        return foodRemote.get(cat, dto);
    }
    
}
