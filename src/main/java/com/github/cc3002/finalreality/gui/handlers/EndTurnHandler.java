package com.github.cc3002.finalreality.gui.handlers;

import com.github.cc3002.finalreality.gui.gameController.GameController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * This handler observes if a characters ends its turns (attacks), and if it ends its turns, obtains the
 * ICharacter who has ended its turn and finally print the name of the character.
 * The body of the propertyChange method may change.
 *
 * @author Rodrigo Urrea Loyola
 */
public class EndTurnHandler implements PropertyChangeListener {
    private final GameController GAME;


    /**
     * Creates a new StartTurnHandler an associate it with its game.
     * @param actualGame the game where its created the StartTurnHandler
     */
    public EndTurnHandler(GameController actualGame){
        GAME = actualGame;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        GAME.endTurn();
    }
}
