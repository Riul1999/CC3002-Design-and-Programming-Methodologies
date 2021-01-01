package com.github.cc3002.finalreality.gui.handlers.AliveHandlers;

import com.github.cc3002.finalreality.gui.gameController.GameController;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

import java.beans.PropertyChangeEvent;

/**
 * This handler observes if a playerCharacter dies, and if it does, the handler calls the eliminatePlayer method.
 * The body of the propertyChange method may change.
 *
 * @author Rodrigo Urrea Loyola
 */
public class AlivePlayerCharacterHandler extends AliveAbstractCharacterHandler {

    private final GameController GAME;

    /**
     * Creates a new AlivePlayerCharacterHandler an associate it with its game.
     * @param actualGame the game where its created the AlivePlayerCharacterHandler
     */
    public AlivePlayerCharacterHandler(GameController actualGame) {
        GAME = actualGame;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        IPlayerCharacter character = (IPlayerCharacter) evt.getNewValue();
        GAME.eliminatePlayerCharacter(character);
    }
}
