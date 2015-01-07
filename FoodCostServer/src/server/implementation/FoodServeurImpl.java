/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.implementation;

import common.dto.*;
import common.interfaces.FoodModele;
import common.seldto.*;
import common.tools.CaseEnum;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
    public List getAll(CaseEnum cat) throws RemoteException {
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
    public GenericDto getByName(CaseEnum cat, String name) throws RemoteException {
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
    public GenericDto getById(CaseEnum cat, GenericDto id) throws RemoteException {
        try {
            switch (cat) {
                case ALIMENT:
                    return AdminFacade.getAlimentById((AlimentDto)id);
                case CATEGORIE:
                    return AdminFacade.getCategorieById((CategorieDto)id);
                case RECETTE:
                    return AdminFacade.getRecetteById((RecetteDto)id);
                case SOUS_CATEGORIE:
                    return AdminFacade.getSousCategorieById((SousCategorieDto)id);
                default:
                    return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List getBySel(CaseEnum cat, GenericSel sel) throws RemoteException {
         try {
            switch (cat) {
                case ALIMENT:
                    return AdminFacade.getAliment((AlimentSel)sel);
                case CATEGORIE:
                    return AdminFacade.getCategorie((CategorieSel)sel);
                case RECETTE:
                    return AdminFacade.getRecette((RecetteSel)sel);
                case SOUS_CATEGORIE:
                    return AdminFacade.getSousCategorie((SousCategorieSel)sel);
                case COMMANDE:
                    return AdminFacade.getCommande((CommandeSel)sel);
                default:
                    return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int add(CaseEnum cat, GenericDto rec) throws RemoteException {
        try {
            switch (cat) {
                case ALIMENT:
                    return AdminFacade.AjoutAliment((AlimentDto)rec);
                case CATEGORIE:
                    return AdminFacade.AjoutCategorie((CategorieDto)rec);
                case RECETTE:
                    return AdminFacade.AjoutRecettes((RecetteDto)rec);
                case SOUS_CATEGORIE:
                    return AdminFacade.AjoutSousCategorie((SousCategorieDto)rec);
                case COMMANDE:
                    return AdminFacade.AjoutCommande((CommandeDto)rec);
                default:
                    return -1;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    @Override
    public int getNbElem(CaseEnum cat, GenericDto rec) throws RemoteException {
        try {
            switch (cat) {
                case CATEGORIE:
                    return AdminFacade.getNbElem((CategorieDto)rec);
                case ELEM_SOUS_CATEGORIE:
                    return AdminFacade.getNbSC((CategorieDto)rec);
                case SOUS_CATEGORIE:
                    return AdminFacade.getNbElem((SousCategorieDto)rec);
                default:
                    return -1;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    @Override
    public int update(CaseEnum cat, GenericDto dto1,GenericDto dto2) throws RemoteException {
        try {
            switch (cat) {
                case ALIMENT:
                    return AdminFacade.modifAliment((AlimentDto)dto1);
                case CATEGORIE:
                    return AdminFacade.modifCategorie((CategorieDto)dto1);
                case RECETTE:
                    AdminFacade.majDBFromRecette((RecetteDto)dto1);
                    return 1;     
                case LISTE_ALIMENT:
                    return AdminFacade.modifListeAli((RecetteDto)dto1,(IngredientDto)dto2);
                case LISTE_RECETTE:
                    return AdminFacade.modifListeRecette((CommandeDto)dto1,(ComposantDto)dto2);
                case SOUS_CATEGORIE:
                    return AdminFacade.modifSousCategorie((SousCategorieDto)dto1);
                case COMMANDE:
                    return AdminFacade.modifCommande((CommandeDto)dto1);
                default:
                    return -1;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    @Override
    public int delete(CommandeDto com, ComposantDto id) throws RemoteException {
        try {
            return AdminFacade.supprimeCompo(com, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    @Override
    public int delete(RecetteDto rec, IngredientDto id) throws RemoteException {
        try {
            return AdminFacade.supprimeIngre(rec, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    @Override
    public List<IngredientDto> getIngredientsFromCommande(CommandeDto com) throws RemoteException {
        try {
            return AdminFacade.getIngredientsFromCommande(com);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int delete(ListeAlimentDto lst, IngredientDto ing) throws RemoteException {
        try {
            return AdminFacade.supprimeIngre(lst, ing);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    @Override
    public int delete(ListeRecetteDto lst, ComposantDto ing) throws RemoteException {
        try {
            return AdminFacade.supprimeCompo(lst, ing);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    @Override
    public List get(CaseEnum cat, GenericDto dto) throws RemoteException {
        try {
            switch (cat) {
                
                case CONTENTENU_LISTE_COMMANDE:
                    return AdminFacade.getContenuListe((CommandeDto)dto);
                default:
                    return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
