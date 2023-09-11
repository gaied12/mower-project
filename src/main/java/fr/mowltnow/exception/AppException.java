package fr.mowltnow.exception;

/**
 * @author oussama.gaied
 * @since 09/09/2023
 */
public class AppException extends RuntimeException{
    public AppException(String errorMsg) {
        super(errorMsg);
    }

}
