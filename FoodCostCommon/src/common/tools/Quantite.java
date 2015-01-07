/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.tools;

/**
 *
 * @author Gilles
 */
public enum Quantite {

    G("g") {
        @Override
        public int facteur() {
            return 1;

        }
    },
    KG("Kg") {
        @Override
        public int facteur() {
            return 1000;

        }
    },
    ML("mL") {
        @Override
        public int facteur() {
            return 1;

        }
    },
    CS("Cuillère à soupe") {
        @Override
        public int facteur() {
            return 15;
        }
    },
    CC("Cuillère à café") {
        @Override
        public int facteur() {
            return 5;
        }
    },
    BOUT1("Bouteille 1L") {
        @Override
        public int facteur() {
            return 1000;
        }
    },
    BOUT2("Bouteille 70cL") {
        @Override
        public int facteur() {
            return 700;
        }
    },
    BOUT3("Bouteille 33cL") {
        @Override
        public int facteur() {
            return 330;
        }
    },
    BOUT4("Bouteille 25cL") {
        @Override
        public int facteur() {
            return 250;
        }
    },
    PCE("Pièce") {
        @Override
        public int facteur() {
            return 1;
        }
    },
    MIN("Minutes") {
        @Override
        public int facteur() {
            return 1;
        }
    };
    private String nom;

    private Quantite() {
    }

    private Quantite(String nom) {
        this.nom = nom;
    }

    public abstract int facteur();

    @Override
    public String toString() {
        return nom;
    }

    public static Quantite[] values(Unite unit) {
        Quantite[] vals = null;
        switch (unit) {
            case KG:
                vals = new Quantite[]{Quantite.G,Quantite.KG, Quantite.CS, Quantite.CC};
                break;
            case L:
                vals = new Quantite[]{Quantite.ML, Quantite.BOUT1, Quantite.BOUT2, Quantite.BOUT3, Quantite.BOUT4, Quantite.CS, Quantite.CC};
                break;
            case PCE:
                vals = new Quantite[]{Quantite.PCE};
                break;
            case H:
                vals = new Quantite[]{Quantite.MIN};
                break;
        }
        return vals;
    }
}
