package com.github.cc3002.finalreality.gui.gameController;

/**
 * A class that informs about problems in GameController or Phase classes.
 *
 * @author Rodrigo Urrea Loyola.
 */
public class InvalidActionException extends Exception{
    private final String msg;
    public InvalidActionException(String msg){
        super(msg);
        this.msg = msg;
    }

    /**
     * This method return the msg of the Exception.
     */
    public String getMessage(){
        return msg;
    }
}
