/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.interfaces;

import common.dto.CommandeDto;
import common.dto.ComposantDto;
import common.tools.GenericDto;
import common.dto.IngredientDto;
import common.dto.ListeAlimentDto;
import common.dto.ListeRecetteDto;
import common.dto.RecetteDto;
import common.tools.GenericSel;
import common.tools.CaseEnum;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Gilles
 */
public interface FoodModele extends Remote {

    public List getAll(CaseEnum cat)  throws RemoteException;
    public GenericDto getByName(CaseEnum cat, String name)  throws RemoteException;
    public GenericDto getById(CaseEnum cat, GenericDto id)  throws RemoteException;
    public List getBySel(CaseEnum cat, GenericSel sel)  throws RemoteException;
    public List get(CaseEnum cat, GenericDto dto)  throws RemoteException;
    public int add( CaseEnum cat, GenericDto dto1, GenericDto dto2) throws RemoteException;
    public int getNbElem( CaseEnum cat, GenericDto rec) throws RemoteException;
    public int update( CaseEnum cat, GenericDto rec1,GenericDto rec2) throws RemoteException;
    public int delete(CommandeDto com, ComposantDto id) throws RemoteException;
    public int delete(RecetteDto rec, IngredientDto id) throws RemoteException;
    public int delete(ListeAlimentDto lst, IngredientDto ing) throws RemoteException;
    public int delete(ListeRecetteDto lst, ComposantDto ing) throws RemoteException;
    public List<IngredientDto> getIngredientsFromCommande(CommandeDto com) throws RemoteException;

}


