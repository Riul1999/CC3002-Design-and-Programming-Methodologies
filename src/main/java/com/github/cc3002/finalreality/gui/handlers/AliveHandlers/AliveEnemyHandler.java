package com.github.cc3002.finalreality.gui.handlers.AliveHandlers;

import com.github.cc3002.finalreality.gui.gameController.GameController;
import com.github.cc3002.finalreality.model.character.Enemy;

import java.beans.PropertyChangeEvent;

/**
 * This handler observes if a enemy dies, and if it does, the handler calls the eliminateEnemy method.
 * The body of the propertyChange method may change.
 *
 * @author Rodrigo Urrea Loyola
 */
public class AliveEnemyHandler extends AliveAbstractCharacterHandler {

    private static GameController GAME;

    /**
     * Creates a new AliveEnemyHandler an associate it with its game.
     * @param actualGame the game where its created the AliveEnemyHandler
     */
    public AliveEnemyHandler(GameController actualGame) {
        GAME = actualGame;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Enemy character = (Enemy) evt.getNewValue();
        GAME.eliminateEnemy(character);
    }
}
