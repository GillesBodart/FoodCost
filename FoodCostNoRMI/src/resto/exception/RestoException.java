/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.exception;

/**
 * Exception lanc&eacute;e par une m&eacute;thode d'une 'Facade'
 */
public class RestoException extends Exception {

    /**
     * Creates a new instance of
     * <code>NBibliothequeException</code> without detail message.
     */
    public RestoException() {
    }

    /**
     * Constructs an instance of
     * <code>NBibliothequeException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public RestoException(String msg) {
        super(msg);
    }
}
