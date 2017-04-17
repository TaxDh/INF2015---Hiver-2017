/*
 * Traite les erreurs lorsqu'il y en a
 */
package projetagile;

public class InvalidArgumentException extends Exception {

    public InvalidArgumentException(String message) {
        super(message);
    }

}
