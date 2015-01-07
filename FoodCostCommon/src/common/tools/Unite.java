/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.tools;

/**
 *
 * @author Gilles
 */
public enum Unite {

    KG("Kg") {
        @Override
        public Double calcul(Double prix, int qte, int deci) {
            prix /= 1000;
            prix *= qte;
            return CommonTool.round(prix, 4);

        }
    },
    L("L") {
        @Override
        public Double calcul(Double prix, int qte, int deci) {
            prix /= 1000;
            prix *= qte;
            return CommonTool.round(prix, 4);

        }
    },
    PCE("Pièce") {
        @Override
        public Double calcul(Double prix, int qte, int deci) {
            prix *= qte;
            return CommonTool.round(prix, 4);
        }
    },
    H("Heure") {
        @Override
        public Double calcul(Double prix, int qte, int deci) {
            prix /= 60;
            prix *= qte;
            return CommonTool.round(prix, 4);
        }
    };
    private String nom;

    private Unite() {
    }

    private Unite(String nom) {
        this.nom = nom;
    }

    public abstract Double calcul(Double prix, int qte, int deci);

    @Override
    public String toString() {
        return nom;
    }
}
