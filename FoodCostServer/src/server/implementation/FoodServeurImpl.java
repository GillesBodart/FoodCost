/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.implementation;

import common.dto.AlimentDto;
import common.dto.CategorieDto;
import common.dto.CommandeDto;
import common.dto.ComposantDto;
import common.dto.GenericDto;
import common.dto.IngredientDto;
import common.dto.RecetteDto;
import common.dto.SousCategorieDto;
import common.exception.RestoBusinessException;
import common.interfaces.FoodModele;
import common.seldto.AlimentSel;
import common.seldto.CategorieSel;
import common.seldto.CommandeSel;
import common.seldto.GenericSel;
import common.seldto.RecetteSel;
import common.seldto.SousCategorieSel;
import common.tools.Category;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.List;
import server.db.AdminFacade;

/**
 *
 * @author Gilles
 */
public class FoodServeurImpl extends UnicastRemoteObject implements FoodModele {

    public FoodServeurImpl() throws RemoteException {
    }

    @Override
    public Collection<AlimentDto> getAllAliments() throws RemoteException {
        try {
            return AdminFacade.getAllAliments();
        } catch (RestoBusinessException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public Collection<RecetteDto> getAllRecettes() throws RemoteException {
        try {
            return AdminFacade.getAllRecettes();
        } catch (RestoBusinessException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public Collection<CategorieDto> getAllCategories() throws RemoteException {
        try {
            return AdminFacade.getAllCategories();
        } catch (RestoBusinessException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public Collection<SousCategorieDto> getAllSousCategories() throws RemoteException {
        try {
            return AdminFacade.getAllSousCategories();
        } catch (RestoBusinessException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public int AjoutRecettes(RecetteDto rec) throws RemoteException {
        try {
            return AdminFacade.AjoutRecettes(rec);
        } catch (RestoBusinessException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }

    @Override
    public int AjoutCommande(CommandeDto com) throws RemoteException {
        try {
            return AdminFacade.AjoutCommande(com);
        } catch (RestoBusinessException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }

    @Override
    public int AjoutAliment(AlimentDto ali) throws RemoteException {
        try {
            return AdminFacade.AjoutAliment(ali);
        } catch (RestoBusinessException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }

    @Override
    public int AjoutCategorie(CategorieDto categorieDto) throws RemoteException {
        try {
            return AdminFacade.AjoutAliment(ali);
        } catch (RestoBusinessException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }

    @Override
    public int AjoutSousCategorie(SousCategorieDto souaCat) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CategorieDto getCategorieByNom(CategorieDto categorieDto) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CategorieDto getCategorieById(CategorieDto categorieDto) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SousCategorieDto getSousCategorieByNom(SousCategorieDto sousCat) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SousCategorieDto getSousCategorieById(SousCategorieDto sousCat) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AlimentDto getAlimentById(AlimentDto ali) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AlimentDto getAlimentByNom(AlimentDto ali) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RecetteDto getRecetteById(RecetteDto rct) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RecetteDto getRecetteByNom(RecetteDto rct) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<AlimentDto> getAliment(AlimentSel ali) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<RecetteDto> getRecette(RecetteSel rct) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<CategorieDto> getCategorie(CategorieSel cat) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<SousCategorieDto> getSousCategorie(SousCategorieSel sousCat) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<CommandeDto> getCommande(CommandeSel com) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNbElem(SousCategorieDto sousCat) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNbSC(CategorieDto cat) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IngredientDto> getIngredientsFromCommande(CommandeDto com) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int modifCategorie(CategorieDto cat) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int modifSousCategorie(SousCategorieDto sousCat) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int modifAliment(AlimentDto ali) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int modifCommande(CategorieDto categorieDto) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int modifListeAli(RecetteDto rec, IngredientDto mod) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int modifListeRecette(CommandeDto com, ComposantDto mod) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int supprimeCompo(CommandeDto com, ComposantDto id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int supprimeIngre(RecetteDto rec, IngredientDto id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void majDBFromRecette(RecetteDto rec) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAll(Category cat) throws RemoteException {
        try {
            switch (cat) {
                case ALIMENT:
                    return AdminFacade.getAllAliments();
                case CATEGORIE:
                    return AdminFacade.getAllCategories();
                case RECETTE:
                    return AdminFacade.getAllRecettes();
                case SOUS_CATEGORIE:
                    return AdminFacade.getAllSousCategories();
                default:
                    return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public GenericDto getByName(Category cat, String name) throws RemoteException {
        try {
            switch (cat) {
                case ALIMENT:
                    return AdminFacade.getAlimentByName(name);
                case CATEGORIE:
                    return AdminFacade.getCategorieByName(name);
                case RECETTE:
                    return AdminFacade.getRecetteByName(name);
                case SOUS_CATEGORIE:
                    return AdminFacade.getSousCategorieByName(name);
                default:
                    return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public GenericDto getById(Category cat, int id) throws RemoteException {
        try {
            switch (cat) {
                case ALIMENT:
                    return AdminFacade.getAlimentById(id);
                case CATEGORIE:
                    return AdminFacade.getCategorieById(id);
                case RECETTE:
                    return AdminFacade.getRecetteById(id);
                case SOUS_CATEGORIE:
                    return AdminFacade.getSousCategorieById(id);
                default:
                    return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Collection<GenericDto> getBySel(Category cat, GenericSel sel) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int add(Category cat, GenericDto rec) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNbElem(Category cat, GenericDto rec) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Category cat, GenericDto rec) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(CommandeDto com, ComposantDto id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(RecetteDto rec, IngredientDto id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateDBFromRecette(RecetteDto rec) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
