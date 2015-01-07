/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.exception;

/**
 * Exception lanc&eacute;e par la manipulation des dto
 */
public class RestoBusinessException extends RestoException {

    /**
     * Creates a new instance of
     * <code>BibliothequeDTOException</code> without detail message.
     */
    public RestoBusinessException() {
    }

    /**
     * Constructs an instance of
     * <code>BibliothequeDTOException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public RestoBusinessException(String msg) {
        super(msg);
    }
}
