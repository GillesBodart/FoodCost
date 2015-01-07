/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.tools;

import java.io.Serializable;

/**
 *
 * @author Gilles
 */
public enum Quantity implements Serializable{

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

    private Quantity() {
    }

    private Quantity(String nom) {
        this.nom = nom;
    }

    public abstract int facteur();

    @Override
    public String toString() {
        return nom;
    }

    public static Quantity[] values(Unit unit) {
        Quantity[] vals = null;
        switch (unit) {
            case KG:
                vals = new Quantity[]{Quantity.G,Quantity.KG, Quantity.CS, Quantity.CC};
                break;
            case L:
                vals = new Quantity[]{Quantity.ML, Quantity.BOUT1, Quantity.BOUT2, Quantity.BOUT3, Quantity.BOUT4, Quantity.CS, Quantity.CC};
                break;
            case PCE:
                vals = new Quantity[]{Quantity.PCE};
                break;
            case H:
                vals = new Quantity[]{Quantity.MIN};
                break;
        }
        return vals;
    }
}
