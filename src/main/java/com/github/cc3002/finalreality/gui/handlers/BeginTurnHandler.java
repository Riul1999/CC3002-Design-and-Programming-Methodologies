package com.github.cc3002.finalreality.gui.handlers;

import com.github.cc3002.finalreality.gui.gameController.GameController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * This handler observes if a characters ends its turns (attacks), and if it ends its turns, checks if there are
 * any other character in the queue TURNS, if there are any character in the queue, starts a new turn calling the beginTurn method.
 * The body of the propertyChange method may change.
 *
 * @author Rodrigo Urrea Loyola
 */
public class BeginTurnHandler implements PropertyChangeListener {
    private final GameController GAME;

    /**
     * Creates a new StartTurnHandler an associate it with its game.
     * @param actualGame the game where its created the StartTurnHandler
     */
    public BeginTurnHandler(GameController actualGame){
        GAME = actualGame;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (!GAME.getTURNS().isEmpty()) {
            GAME.beginTurn();
        }

    }
}
