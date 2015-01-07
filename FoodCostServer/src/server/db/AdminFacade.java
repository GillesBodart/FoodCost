/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.db;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import resto.db.AlimentDB;
import resto.db.CategorieDB;
import resto.db.CommandeDB;
import resto.db.DBManager;
import resto.db.ListeAlimentDB;
import resto.db.ListeRecetteDB;
import resto.db.RecetteDB;
import resto.db.SousCategorieDB;
import resto.exception.RestoBusinessException;
import resto.exception.RestoDTOException;
import resto.exception.RestoDbException;
import resto.persistance.dto.AlimentDto;
import resto.persistance.dto.CategorieDto;
import resto.persistance.dto.CommandeDto;
import resto.persistance.dto.ComposantDto;
import resto.persistance.dto.IngredientDto;
import resto.persistance.dto.RecetteDto;
import resto.persistance.dto.SousCategorieDto;
import resto.seldto.AlimentSel;
import resto.seldto.CategorieSel;
import resto.seldto.CommandeSel;
import resto.seldto.RecetteSel;
import resto.seldto.SousCategorieSel;

/**
 *
 * @author Gilles
 */
public class AdminFacade {

    public static Collection<AlimentDto> getAllAliments() throws RestoBusinessException {
        AlimentSel aliSel = new AlimentSel(0);
        try {
            DBManager.startTransaction();
            Collection<AlimentDto> col = AlimentDB.rechCollection(aliSel);
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

    public static Collection<RecetteDto> getAllRecettes() throws RestoBusinessException {

        try {
            RecetteSel rctSel = new RecetteSel(0);
            DBManager.startTransaction();
            Collection<RecetteDto> col = RecetteDB.rechCollection(rctSel);
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

    public static Collection<CategorieDto> getAllCategories() throws RestoBusinessException {

        try {
            CategorieSel rctSel = new CategorieSel(0);
            DBManager.startTransaction();
            Collection<CategorieDto> col = CategorieDB.rechCollection(rctSel);
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

    public static Collection<SousCategorieDto> getAllSousCategories() throws RestoBusinessException {

        try {
            SousCategorieSel rctSel = new SousCategorieSel(0, "");
            DBManager.startTransaction();
            Collection<SousCategorieDto> col = SousCategorieDB.rechCollection(rctSel);
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

    public static CategorieDto getCategorieByNom(CategorieDto categorieDto) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            CategorieDto ret = CategorieDB.getCategorie(categorieDto.getNom());
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

    public static SousCategorieDto getSousCategorieByNom(SousCategorieDto sousCat) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            SousCategorieDto ret = SousCategorieDB.getSousCategorie(sousCat.getNom());
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

    public static AlimentDto getAlimentByNom(AlimentDto ali) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            AlimentDto ret = AlimentDB.getAliment(ali.getLibelle());
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

    public static RecetteDto getRecetteByNom(RecetteDto rct) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            RecetteDto ret = RecetteDB.getRecette(rct.getLibelle());
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

    public static Collection<AlimentDto> getAliment(AlimentSel ali) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            Collection<AlimentDto> ret = AlimentDB.getAliment(ali);
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

    public static Collection<RecetteDto> getRecette(RecetteSel rct) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            Collection<RecetteDto> ret = RecetteDB.getRecette(rct);
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

    public static Collection<CategorieDto> getCategorie(CategorieSel cat) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            Collection<CategorieDto> ret = CategorieDB.getCategorie(cat);
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

    public static Collection<SousCategorieDto> getSousCategorie(SousCategorieSel sousCat) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            Collection<SousCategorieDto> ret = SousCategorieDB.getSousCategorie(sousCat);
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

    public static Collection<CommandeDto> getCommande(CommandeSel com) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            Collection<CommandeDto> ret = CommandeDB.getCommande(com);
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
            int ret =  CategorieDB.updateDb(cat);
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
        public static int modifCommande(CategorieDto categorieDto) throws RestoBusinessException {
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
        public static int modifListeAli(RecetteDto rec,IngredientDto mod) throws RestoBusinessException {
        try {
            DBManager.startTransaction();
            int ret =  ListeAlimentDB.updateIngreDb(rec.getListeAliments(), mod);
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
        public static int modifListeRecette(CommandeDto com,ComposantDto mod) throws RestoBusinessException {
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
    
    
    
}
