/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.db;

import common.dto.AlimentDto;
import common.dto.CategorieDto;
import common.dto.CommandeDto;
import common.dto.ComposantDto;
import common.dto.IngredientDto;
import common.dto.ListeAlimentDto;
import common.dto.ListeRecetteDto;
import common.dto.RecetteDto;
import common.dto.SousCategorieDto;
import common.exception.RestoBusinessException;
import common.exception.RestoDTOException;
import common.exception.RestoDbException;
import common.seldto.AlimentSel;
import common.seldto.CategorieSel;
import common.seldto.CommandeSel;
import common.seldto.RecetteSel;
import common.seldto.SousCategorieSel;
import common.tools.CommonTool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Gilles
 */
public class AdminFacade {
    public static List<AlimentDto> getAllAliments() throws RestoBusinessException {
        AlimentSel aliSel = new AlimentSel(0);
        try {
            DBManager.startTransaction();
            List<AlimentDto> col = AlimentDB.rechCollection(aliSel);
            DBManager.valideTransaction();
            return col;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Liste des Aliments inaccessible! \n" + msg);
            }
        }
    }

    public static List<RecetteDto> getAllRecettes() throws RestoBusinessException {

        try {
            RecetteSel rctSel = new RecetteSel(0);
            DBManager.startTransaction();
            List<RecetteDto> col = RecetteDB.rechCollection(rctSel);
            DBManager.valideTransaction();
            return col;
        } catch (RestoDTOException | RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Liste des Recettes inaccessible! \n" + msg);
            }
        }
    }

    public static List<CategorieDto> getAllCategories() throws RestoBusinessException {

        try {
            CategorieSel rctSel = new CategorieSel(0);
            DBManager.startTransaction();
            List<CategorieDto> col = CategorieDB.rechCollection(rctSel);
            DBManager.valideTransaction();
            return col;
        } catch (Exception eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Liste des categories inaccessible! \n" + msg);
            }
        }
    }

    public static List<SousCategorieDto> getAllSousCategories() throws RestoBusinessException {

        try {
            SousCategorieSel rctSel = new SousCategorieSel(0, "");
            DBManager.startTransaction();
            List<SousCategorieDto> col = SousCategorieDB.rechCollection(rctSel);
            DBManager.valideTransaction();
            return col;
        } catch (Exception eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Liste des categories inaccessible! \n" + msg);
            }
        }
    }

    public static int AjoutRecettes(RecetteDto rec) throws RestoBusinessException {

        try {
            DBManager.startTransaction();
            int idLst = ListeAlimentDB.insertDb(rec.getListeAliments());
            rec.getListeAliments().setId(idLst);
            int ret = RecetteDB.insertDb(rec);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Ajout de recette impossible! \n" + msg);
            }
        }
    }

    public static int AjoutCommande(CommandeDto com) throws RestoBusinessException {

        try {
            DBManager.startTransaction();
            int idLst = ListeRecetteDB.insertDb(com.getListeRecettes());
            com.getListeRecettes().setId(idLst);
            int ret = CommandeDB.insertDb(com);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Ajout de commande impossible! \n" + msg);
            }
        }
    }

    public static int AjoutAliment(AlimentDto ali) throws RestoBusinessException {

        try {
            DBManager.startTransaction();
            int ret = AlimentDB.insertDb(ali);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Ajout d'Aliment impossible! \n" + msg);
            }
        }
    }

    public static int AjoutCategorie(CategorieDto categorieDto) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            int ret = CategorieDB.insertDb(categorieDto);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Ajout de catégorie impossible! \n" + msg);
            }
        }
    }

    public static int AjoutSousCategorie(SousCategorieDto souaCat) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            int ret = SousCategorieDB.insertDb(souaCat);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Ajout de sous-catégorie impossible! \n" + msg);
            }
        }
    }

    public static CategorieDto getCategorieByName(String name) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            CategorieDto ret = CategorieDB.getCategorie(name);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Ajout de catégorie impossible! \n" + msg);
            }
        }
    }

    public static CategorieDto getCategorieById(CategorieDto categorieDto) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            CategorieDto ret = CategorieDB.getCategorie(categorieDto.getId());
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Ajout de catégorie impossible! \n" + msg);
            }
        }
    }

    public static SousCategorieDto getSousCategorieByName(String name) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            SousCategorieDto ret = SousCategorieDB.getSousCategorie(name);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Ajout de sous-catégorie impossible! \n" + msg);
            }
        }
    }

    public static SousCategorieDto getSousCategorieById(SousCategorieDto sousCat) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            SousCategorieDto ret = SousCategorieDB.getSousCategorie(sousCat.getId());
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Ajout de sous-catégorie impossible! \n" + msg);
            }
        }
    }

    public static AlimentDto getAlimentById(AlimentDto ali) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            AlimentDto ret = AlimentDB.getAliment(ali.getId());
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Recherche d' Aliment impossible! \n" + msg);
            }
        }
    }

    public static AlimentDto getAlimentByName(String name) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            AlimentDto ret = AlimentDB.getAliment(name);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Recherche d' Aliment impossible! \n" + msg);
            }
        }
    }

    public static RecetteDto getRecetteById(RecetteDto rct) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            RecetteDto ret = RecetteDB.getRecette(rct.getId());
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Recherche d' Aliment impossible! \n" + msg);
            }
        }
    }

    public static RecetteDto getRecetteByName(String name) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            RecetteDto ret = RecetteDB.getRecette(name);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Recherche d' Aliment impossible! \n" + msg);
            }
        }
    }

    public static List<AlimentDto> getAliment(AlimentSel ali) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            List<AlimentDto> ret = AlimentDB.getAliment(ali);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Recherche d' Aliment impossible! \n" + msg);
            }
        }
    }

    public static List<RecetteDto> getRecette(RecetteSel rct) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            List<RecetteDto> ret = RecetteDB.getRecette(rct);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Recherche de recette impossible! \n" + msg);
            }
        }
    }

    public static List<CategorieDto> getCategorie(CategorieSel cat) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            List<CategorieDto> ret = CategorieDB.getCategorie(cat);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Ajout de catégorie impossible! \n" + msg);
            }
        }
    }

    public static List<SousCategorieDto> getSousCategorie(SousCategorieSel sousCat) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            List<SousCategorieDto> ret = SousCategorieDB.getSousCategorie(sousCat);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Récupération de sous-catégorie impossible! \n" + msg);
            }
        }
    }

    public static List<CommandeDto> getCommande(CommandeSel com) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            List<CommandeDto> ret = CommandeDB.getCommande(com);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Récupération de commande impossible! \n" + msg);
            }
        }
    }

    public static int getNbElem(SousCategorieDto sousCat) throws RestoBusinessException {
        try {
            return AlimentDB.getAliment(new AlimentSel(0, "", sousCat, 0.0, "", null)).size();
        } catch (RestoDTOException | RestoDbException ex) {
            throw new RestoBusinessException("Récupération des éléments impossible ! \n" + ex);
        }
    }

    public static int getNbElem(CategorieDto cat) throws RestoBusinessException {
        try {
            int size = 0;
            for (SousCategorieDto sousCat : SousCategorieDB.getSousCategorie(new SousCategorieSel(0, "", cat))) {
                size += getNbElem(sousCat);
            }
            return size;
        } catch (RestoDbException ex) {
            throw new RestoBusinessException("Récupération des éléments impossible ! \n" + ex);
        }
    }

    public static int getNbSC(CategorieDto cat) throws RestoBusinessException {
        try {

            return SousCategorieDB.getSousCategorie(new SousCategorieSel(0, "", cat)).size();
        } catch (RestoDbException ex) {
            throw new RestoBusinessException("Récupération des éléments impossible ! \n" + ex);
        }
    }

    public static List<IngredientDto> getIngredientsFromCommande(CommandeDto com) throws RestoBusinessException {
        HashMap<Integer, Double> listeIng;
        listeIng = new HashMap<>();
        for (ComposantDto rec : com.getListeRecettes().getComposants()) {
            double fact = 1.0 / rec.getId().getNbPers() * rec.getQte();
            for (IngredientDto ing : rec.getId().getListeAliments().getIngredients()) {
                if (!listeIng.containsKey(ing.getId().getId())) {
                    listeIng.put(ing.getId().getId(), fact * ing.getQte() * ing.getUnit().facteur());
                } else {
                    listeIng.put(ing.getId().getId(), listeIng.get(ing.getId().getId()) + (fact * ing.getQte() * ing.getUnit().facteur()));
                }
            }
        }
        try {
            DBManager.startTransaction();
            List<IngredientDto> ret = ListeRecetteDB.getIngredients(listeIng);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Recherche d' Aliment impossible! \n" + msg);
            }
        }
    }

    public static int modifCategorie(CategorieDto cat) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            int ret = CategorieDB.updateDb(cat);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Modification de la catégorie impossible! \n" + msg);
            }
        }
    }

    public static int modifSousCategorie(SousCategorieDto sousCat) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            int ret = SousCategorieDB.updateDb(sousCat);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Ajout de catégorie impossible! \n" + msg);
            }
        }
    }

    public static int modifAliment(AlimentDto ali) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            int ret = AlimentDB.updateDb(ali);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Modification d'aliment impossible ! \n" + msg);
            }
        }
    }

    public static int modifCommande(CommandeDto commandeDto) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            CommandeDB.updateDb(commandeDto);
            int ret = 1;
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Ajout de catégorie impossible! \n" + msg);
            }
        }
    }

    public static int modifListeAli(RecetteDto rec, IngredientDto mod) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            int ret = ListeAlimentDB.updateIngreDb(rec.getListeAliments(), mod);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Ajout de catégorie impossible! \n" + msg);
            }
        }
    }

    public static int modifListeRecette(CommandeDto com, ComposantDto mod) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            int ret = ListeRecetteDB.updateCompoDb(com.getListeRecettes(), mod);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Ajout de catégorie impossible! \n" + msg);
            }
        }
    }

    public static int supprimeCompo(CommandeDto com, ComposantDto id) throws RestoBusinessException {

        try {
            DBManager.startTransaction();
            int ret = ListeRecetteDB.deleteCompoDb(com.getListeRecettes(), id);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Ajout de catégorie impossible! \n" + msg);
            }
        }
    }

    public static int supprimeIngre(RecetteDto rec, IngredientDto id) throws RestoBusinessException {

        try {
            DBManager.startTransaction();
            int ret = ListeAlimentDB.deleteIngreDb(rec.getListeAliments(), id);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Ajout de catégorie impossible! \n" + msg);
            }
        }
    }

    public static void majDBFromRecette(RecetteDto rec) throws RestoBusinessException {

        try {
            DBManager.startTransaction();
            ListeRecetteDB.majDB(rec);
            RecetteDB.updateDb(rec);
            DBManager.valideTransaction();
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Ajout de catégorie impossible! \n" + msg);
            }
        }
    }
//
    public static int supprimeIngre(ListeAlimentDto lst, IngredientDto ing) throws RestoBusinessException {
       try {
            DBManager.startTransaction();
            int ret = ListeAlimentDB.deleteIngreDb(lst, ing);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Ajout de catégorie impossible! \n" + msg);
            }
        }
    }

    public static int supprimeCompo(ListeRecetteDto lst, ComposantDto ing) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            int ret = ListeRecetteDB.deleteCompoDb(lst, ing);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Ajout de catégorie impossible! \n" + msg);
            }
        }
    }
    
    public static List<String> getContenuListe(CommandeDto com) throws RestoBusinessException {
        try {
            List<String> str = new ArrayList();

            str.add("Liste d'ingrédients du bon de commande pour : " + com.getLibelle());
            str.add("Liste d'ingrédients : ");
            for (IngredientDto ing : CommonTool.triFournisseur(getIngredientsFromCommande(com))) {
                str.add("( "+ing.getId().getFournisseur()+" ) "+ing.getQte().toString() + ing.getUnit() + " de " + ing.getId().getLibelle());
            }
            str.add(" ");
            str.add("Prix total de la commande " + com.getRecPrix() + " €");
            return str;
        } catch (Exception eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Ajout de catégorie impossible! \n" + msg);
            }
        }
    }

    public static int updateCommande(CommandeDto commandeDto) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            int ret = 1;
            CommandeDB.updateDb(commandeDto);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Ajout de catégorie impossible! \n" + msg);
            }
        }
       
    }


    public static int AjoutElementCommande(ListeRecetteDto listeRecetteDto, ComposantDto composantDto) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            int ret = ListeRecetteDB.insertCompoDb(listeRecetteDto, composantDto);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Ajout de recette impossible! \n" + msg);
            }
        }
    }

    public static int AjoutIngredient(ListeAlimentDto listeAlimentDto, IngredientDto ingredientDto) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            int ret = ListeAlimentDB.insertIngrDb(listeAlimentDto, ingredientDto);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Ajout de recette impossible! \n" + msg);
            }
        }
         
    }

    public static int updateSousCategorie(SousCategorieDto sousCategorieDto) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            int ret = SousCategorieDB.updateDb(sousCategorieDto);
            DBManager.valideTransaction();
            return ret;
        } catch (RestoDbException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.annuleTransaction();
            } catch (RestoDbException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new RestoBusinessException("Ajout de recette impossible! \n" + msg);
            }
        }
    }

}
