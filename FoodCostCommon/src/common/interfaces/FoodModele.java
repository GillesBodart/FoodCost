/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.interfaces;

import common.dto.AlimentDto;
import common.dto.CategorieDto;
import common.dto.CommandeDto;
import common.dto.ComposantDto;
import common.dto.GenericDto;
import common.dto.IngredientDto;
import common.dto.RecetteDto;
import common.dto.SousCategorieDto;
import common.seldto.AlimentSel;
import common.seldto.CategorieSel;
import common.seldto.CommandeSel;
import common.seldto.GenericSel;
import common.seldto.RecetteSel;
import common.seldto.SousCategorieSel;
import common.tools.Category;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Gilles
 */
public interface FoodModele extends Remote {

    public List getAll(Category cat)  throws RemoteException;
    public GenericDto getByName(Category cat, String name)  throws RemoteException;
    public GenericDto getById(Category cat, int id)  throws RemoteException;
    public List getBySel(Category cat, GenericSel sel)  throws RemoteException;
    public int add( Category cat, GenericDto rec) throws RemoteException;
    public int getNbElem( Category cat, GenericDto rec) throws RemoteException;
    public int update( Category cat, GenericDto rec) throws RemoteException;
    public int delete(CommandeDto com, ComposantDto id) throws RemoteException;
    public int delete(RecetteDto rec, IngredientDto id) throws RemoteException;

    public List<IngredientDto> getIngredientsFromCommande(CommandeDto com) throws RemoteException;

    public void updateDBFromRecette(RecetteDto rec) throws RemoteException;

}


