package br.edu.ifg.sistemacomercial.util.exception;

/**
 *
 * @author danilo
 */
public class SistemaException extends Exception {

    public SistemaException(String message) {
        super(message);
    }

    public SistemaException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
