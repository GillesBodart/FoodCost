/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.exception;

/**
 * Exception lanc&eacute;e par la manipulation des dto
 */
public class RestoDTOException extends RestoException {

    /**
     * Creates a new instance of
     * <code>BibliothequeDTOException</code> without detail message.
     */
    public RestoDTOException() {
    }

    /**
     * Constructs an instance of
     * <code>BibliothequeDTOException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public RestoDTOException(String msg) {
        super(msg);
    }
}
