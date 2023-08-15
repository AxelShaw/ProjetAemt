package be.helha.aemt.groupeA6.exceptions;

public class InvalidUserInputException extends Exception {

    private static final long serialVersionUID = 1L;
    
    public InvalidUserInputException(String emailVal) {
        super("L'email \"" + emailVal + "\" est invalide. Format attendu : email@helha.be");
    }
}
