/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.exception;

/**
 * Exception lanc&eacute;e par les acc&eacute;s db
 */
public class RestoDbException extends RestoException {

    /**
     * Creates a new instance of
     * <code>BibliothequeDBException</code> without detail message.
     */
    public RestoDbException() {
    }

    /**
     * Constructs an instance of
     * <code>BibliothequeDBException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public RestoDbException(String msg) {
        super(msg);
    }
}
