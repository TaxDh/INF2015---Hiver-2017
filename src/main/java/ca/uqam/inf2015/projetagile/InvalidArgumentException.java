/*
 * Traite les erreurs lorsqu'il y en a
 */
package ca.uqam.inf2015.projetagile;

public class InvalidArgumentException extends Exception {

    public InvalidArgumentException(String message) {
        super(message);
    }
    
}
