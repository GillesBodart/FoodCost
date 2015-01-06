/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.application;

import resto.business.AdminFacade;
import resto.exception.RestoBusinessException;
import resto.exception.RestoDTOException;
import resto.outils.Unite;
import resto.persistance.dto.AlimentDto;
import resto.persistance.dto.CategorieDto;
import resto.persistance.dto.SousCategorieDto;

/**
 *
 * @author Gilles
 */
public class Fill {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            CategorieDto leg = new CategorieDto("Légume");
            AdminFacade.AjoutCategorie(leg);
            CategorieDto fru = new CategorieDto("Fruit");
            AdminFacade.AjoutCategorie(fru);
            CategorieDto via = new CategorieDto("Viande");
            AdminFacade.AjoutCategorie(via);
            CategorieDto poi = new CategorieDto("Poisson");
            AdminFacade.AjoutCategorie(poi);
            CategorieDto con = new CategorieDto("Condiment");
            AdminFacade.AjoutCategorie(con);
            CategorieDto boi = new CategorieDto("Boisson");
            AdminFacade.AjoutCategorie(boi);

            SousCategorieDto tom = new SousCategorieDto(0, "Tomate", AdminFacade.getCategorieByNom(leg));
            SousCategorieDto cucu = new SousCategorieDto(0, "Cucurbitacé", AdminFacade.getCategorieByNom(leg));
            SousCategorieDto sal = new SousCategorieDto(0, "Salade", AdminFacade.getCategorieByNom(leg));
            SousCategorieDto pdt = new SousCategorieDto(0, "Pomme de terre", AdminFacade.getCategorieByNom(leg));
            AdminFacade.AjoutSousCategorie(tom);
            AdminFacade.AjoutSousCategorie(cucu);
            AdminFacade.AjoutSousCategorie(sal);
            AdminFacade.AjoutSousCategorie(pdt);
            SousCategorieDto pom = new SousCategorieDto(0, "Pomme", AdminFacade.getCategorieByNom(fru));
            SousCategorieDto pec = new SousCategorieDto(0, "Pêche", AdminFacade.getCategorieByNom(fru));
            SousCategorieDto poir = new SousCategorieDto(0, "Poire", AdminFacade.getCategorieByNom(fru));
            SousCategorieDto bai = new SousCategorieDto(0, "Baies", AdminFacade.getCategorieByNom(fru));
            AdminFacade.AjoutSousCategorie(pom);
            AdminFacade.AjoutSousCategorie(pec);
            AdminFacade.AjoutSousCategorie(poir);
            AdminFacade.AjoutSousCategorie(bai);
            SousCategorieDto boe = new SousCategorieDto(0, "Boeuf", AdminFacade.getCategorieByNom(via));
            SousCategorieDto vea = new SousCategorieDto(0, "Veau", AdminFacade.getCategorieByNom(via));
            SousCategorieDto mou = new SousCategorieDto(0, "Mouton", AdminFacade.getCategorieByNom(via));
            SousCategorieDto vol = new SousCategorieDto(0, "Volaille", AdminFacade.getCategorieByNom(via));
            AdminFacade.AjoutSousCategorie(boe);
            AdminFacade.AjoutSousCategorie(vea);
            AdminFacade.AjoutSousCategorie(mou);
            AdminFacade.AjoutSousCategorie(vol);
            SousCategorieDto ppoi = new SousCategorieDto(0, "Poisson", AdminFacade.getCategorieByNom(poi));
            SousCategorieDto cru = new SousCategorieDto(0, "Crustacés", AdminFacade.getCategorieByNom(poi));
            SousCategorieDto fdm = new SousCategorieDto(0, "Fruits de mer", AdminFacade.getCategorieByNom(poi));
            AdminFacade.AjoutSousCategorie(ppoi);
            AdminFacade.AjoutSousCategorie(cru);
            AdminFacade.AjoutSousCategorie(fdm);
            SousCategorieDto epi = new SousCategorieDto(0, "Epices", AdminFacade.getCategorieByNom(con));
            SousCategorieDto aro = new SousCategorieDto(0, "Arômes", AdminFacade.getCategorieByNom(con));
            SousCategorieDto subs = new SousCategorieDto(0, "Produits de substitutions", AdminFacade.getCategorieByNom(con));
            AdminFacade.AjoutSousCategorie(epi);
            AdminFacade.AjoutSousCategorie(aro);
            AdminFacade.AjoutSousCategorie(subs);
            SousCategorieDto vin = new SousCategorieDto(0, "Vin", AdminFacade.getCategorieByNom(boi));
            SousCategorieDto spi = new SousCategorieDto(0, "Spiritueux", AdminFacade.getCategorieByNom(boi));
            SousCategorieDto dig = new SousCategorieDto(0, "Digestif", AdminFacade.getCategorieByNom(boi));
            SousCategorieDto sod = new SousCategorieDto(0, "Soda", AdminFacade.getCategorieByNom(boi));
            AdminFacade.AjoutSousCategorie(vin);
            AdminFacade.AjoutSousCategorie(spi);
            AdminFacade.AjoutSousCategorie(dig);
            AdminFacade.AjoutSousCategorie(sod);
/*
            AlimentDto tcb = new AlimentDto(0, "Tomate coeur de boeuf", AdminFacade.getSousCategorieByNom(tom), 1.853, "Tirtiaux", Unite.KG);
            AlimentDto tce = new AlimentDto(0, "Tomate cerise", AdminFacade.getSousCategorieByNom(tom), 2.1853, "Tirtiaux", Unite.KG);
            AlimentDto concon = new AlimentDto(0, "Concombre", AdminFacade.getSousCategorieByNom(cucu), 0.59, "Tirtiaux", Unite.KG);
            AlimentDto courg = new AlimentDto(0, "Courgette", AdminFacade.getSousCategorieByNom(cucu), 1.34, "Tirtiaux", Unite.KG);
            AlimentDto salche = new AlimentDto(0, "Salade de chêne", AdminFacade.getSousCategorieByNom(sal), 1.12, "Tirtiaux", Unite.KG);
            AlimentDto rok = new AlimentDto(0, "roquette", AdminFacade.getSousCategorieByNom(sal), 3.12, "Tirtiaux", Unite.KG);
            AdminFacade.AjoutAliment(tcb);
            AdminFacade.AjoutAliment(tce);
            AdminFacade.AjoutAliment(concon);
            AdminFacade.AjoutAliment(courg);
            AdminFacade.AjoutAliment(salche);
            AdminFacade.AjoutAliment(rok);
            AlimentDto pdtb = new AlimentDto(0, "Bintje", AdminFacade.getSousCategorieByNom(pdt), 0.853, "Colruyt", Unite.KG);
            AlimentDto pdtn = new AlimentDto(0, "Nicolas", AdminFacade.getSousCategorieByNom(pdt), 0.7853, "Colruyt", Unite.KG);
            AlimentDto gold = new AlimentDto(0, "Jonagold", AdminFacade.getSousCategorieByNom(pom), 0.95, "Tirtiaux", Unite.KG);
            AlimentDto pink = new AlimentDto(0, "Pink Lady", AdminFacade.getSousCategorieByNom(pom), 1.84, "Tirtiaux", Unite.KG);
            AlimentDto pplate = new AlimentDto(0, "Pêche plate", AdminFacade.getSousCategorieByNom(sal), 1.12, "Tirtiaux", Unite.KG);
            AlimentDto pblan = new AlimentDto(0, "Pêche blanche", AdminFacade.getSousCategorieByNom(sal), 3.12, "Tirtiaux", Unite.KG);
            AdminFacade.AjoutAliment(pdtb);
            AdminFacade.AjoutAliment(pdtn);
            AdminFacade.AjoutAliment(gold);
            AdminFacade.AjoutAliment(pink);
            AdminFacade.AjoutAliment(pplate);
            AdminFacade.AjoutAliment(pblan);
            AlimentDto poid = new AlimentDto(0, "Doyenne", AdminFacade.getSousCategorieByNom(poir), 1.553, "Colruyt", Unite.KG);
            AlimentDto poic = new AlimentDto(0, "Conférence", AdminFacade.getSousCategorieByNom(poir), 2.7853, "Colruyt", Unite.KG);
            AlimentDto mur = new AlimentDto(0, "Mûre", AdminFacade.getSousCategorieByNom(bai), 0.95, "Tirtiaux", Unite.KG);
            AlimentDto cas = new AlimentDto(0, "Cassis", AdminFacade.getSousCategorieByNom(bai), 1.84, "Tirtiaux", Unite.KG);
            AlimentDto coal = new AlimentDto(0, "Cote à l'os", AdminFacade.getSousCategorieByNom(boe), 18.12, "Mirguet", Unite.KG);
            AlimentDto entr = new AlimentDto(0, "Entrecote", AdminFacade.getSousCategorieByNom(boe), 20.12, "Anciaux", Unite.KG);
            AdminFacade.AjoutAliment(poid);
            AdminFacade.AjoutAliment(poic);
            AdminFacade.AjoutAliment(mur);
            AdminFacade.AjoutAliment(cas);
            AdminFacade.AjoutAliment(coal);
            AdminFacade.AjoutAliment(entr);
            AlimentDto cve = new AlimentDto(0, "Cotes", AdminFacade.getSousCategorieByNom(vea), 25.553, "Anciaux", Unite.KG);
            AlimentDto medve = new AlimentDto(0, "Médaillon", AdminFacade.getSousCategorieByNom(vea), 24.7853, "Anciaux", Unite.KG);
            AlimentDto mouc = new AlimentDto(0, "Cotes d'agenau", AdminFacade.getSousCategorieByNom(mou), 0.95, "Tirtiaux", Unite.KG);
            AlimentDto mouf = new AlimentDto(0, "Filet d'agneau", AdminFacade.getSousCategorieByNom(mou), 1.84, "Tirtiaux", Unite.KG);
            AlimentDto cuca = new AlimentDto(0, "Cuisses de cannard", AdminFacade.getSousCategorieByNom(vol), 18.12, "Mirguet", Unite.KG);
            AlimentDto bpou = new AlimentDto(0, "Blanc de poulet", AdminFacade.getSousCategorieByNom(vol), 3.12, "Anciaux", Unite.KG);
            AdminFacade.AjoutAliment(cve);
            AdminFacade.AjoutAliment(medve);
            AdminFacade.AjoutAliment(mouc);
            AdminFacade.AjoutAliment(mouf);
            AdminFacade.AjoutAliment(cuca);
            AdminFacade.AjoutAliment(bpou);
            AlimentDto sole = new AlimentDto(0, "Sole", AdminFacade.getSousCategorieByNom(ppoi), 28.553, "Coumont", Unite.KG);
            AlimentDto cabi = new AlimentDto(0, "Cabillaud", AdminFacade.getSousCategorieByNom(ppoi), 24.0253, "Coumont", Unite.KG);
            AlimentDto hom = new AlimentDto(0, "Homard", AdminFacade.getSousCategorieByNom(cru), 18.95, "ISPC", Unite.KG);
            AlimentDto scamp = new AlimentDto(0, "Scampi", AdminFacade.getSousCategorieByNom(cru), 20.84, "ISPC", Unite.KG);
            AlimentDto hui = new AlimentDto(0, "Huitres", AdminFacade.getSousCategorieByNom(fdm), 3.12, "ISPC", Unite.KG);
            AlimentDto moul = new AlimentDto(0, "Moules", AdminFacade.getSousCategorieByNom(fdm), 3.12, "ISPC", Unite.KG);
            AdminFacade.AjoutAliment(sole);
            AdminFacade.AjoutAliment(cabi);
            AdminFacade.AjoutAliment(hom);
            AdminFacade.AjoutAliment(scamp);
            AdminFacade.AjoutAliment(hui);
            AdminFacade.AjoutAliment(moul);
            AlimentDto sel = new AlimentDto(0, "Sel", AdminFacade.getSousCategorieByNom(epi), 0.553, "ISPC", Unite.KG);
            AlimentDto poivre = new AlimentDto(0, "Poivre", AdminFacade.getSousCategorieByNom(epi), 24.0253, "ISPC", Unite.KG);
            AlimentDto thy = new AlimentDto(0, "Thym", AdminFacade.getSousCategorieByNom(aro), 3.95, "ISPC", Unite.KG);
            AlimentDto lau = new AlimentDto(0, "Laurier", AdminFacade.getSousCategorieByNom(aro), 2.84, "ISPC", Unite.KG);
            AlimentDto roux = new AlimentDto(0, "Roux", AdminFacade.getSousCategorieByNom(subs), 3.12, "ISPC", Unite.KG);
            AlimentDto mai = new AlimentDto(0, "Maïzena", AdminFacade.getSousCategorieByNom(subs), 3.12, "ISPC", Unite.KG);
            AlimentDto blanc = new AlimentDto(0, "Blanc", AdminFacade.getSousCategorieByNom(vin), 12.553, "ISPC", Unite.L);
            AlimentDto rose = new AlimentDto(0, "Rose", AdminFacade.getSousCategorieByNom(vin), 10.0253, "ISPC", Unite.L);
            AlimentDto g27 = new AlimentDto(0, "Get27", AdminFacade.getSousCategorieByNom(spi), 18.95, "ISPC", Unite.L);
            AlimentDto mali = new AlimentDto(0, "Malibu", AdminFacade.getSousCategorieByNom(spi), 20.84, "ISPC", Unite.L);
            AlimentDto cog = new AlimentDto(0, "Cognac", AdminFacade.getSousCategorieByNom(dig), 23.12, "ISPC", Unite.L);
            AlimentDto arm = new AlimentDto(0, "Armagnac", AdminFacade.getSousCategorieByNom(dig), 19.12, "ISPC", Unite.L);
            AlimentDto coc = new AlimentDto(0, "Coca-Cola", AdminFacade.getSousCategorieByNom(sod), 1.24, "ISPC", Unite.L);
            AlimentDto sprit = new AlimentDto(0, "Sprite", AdminFacade.getSousCategorieByNom(sod), 1.20, "ISPC", Unite.L);
            AdminFacade.AjoutAliment(sel);
            AdminFacade.AjoutAliment(poivre);
            AdminFacade.AjoutAliment(thy);
            AdminFacade.AjoutAliment(lau);
            AdminFacade.AjoutAliment(mai);
            AdminFacade.AjoutAliment(roux);
            AdminFacade.AjoutAliment(blanc);
            AdminFacade.AjoutAliment(rose);
            AdminFacade.AjoutAliment(cog);
            AdminFacade.AjoutAliment(arm);
            AdminFacade.AjoutAliment(mali);
            AdminFacade.AjoutAliment(g27);
            AdminFacade.AjoutAliment(coc);
            AdminFacade.AjoutAliment(sprit);*/

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
