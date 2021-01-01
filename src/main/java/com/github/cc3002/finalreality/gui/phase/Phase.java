package com.github.cc3002.finalreality.gui.phase;

import com.github.cc3002.finalreality.gui.gameController.GameController;
import com.github.cc3002.finalreality.gui.gameController.InvalidActionException;

/**
 * A class that simulates a state (phase) of a GameController.
 *
 * @author Rodrigo Urrea Loyola.
 */
public class Phase  implements IPhase{
    protected final GameController controller;

    /**
     * Creates a new Phase an associate ir with its game.
     * @param gameController the controller associated to this Phase.
     */
    public Phase(GameController gameController){
        this.controller = gameController;
    }


    @Override
    public void beginTurn() throws InvalidActionException {
        throw new InvalidActionException("Error, the current Phase is TurnPhase you can't begin a turn");
    }

    @Override
    public void endTurn() throws InvalidActionException {
        throw new InvalidActionException("Error, the actual Phase is WaitPhase you can't end a turn");
    }

    @Override
    public void equipWeaponToActual(Integer weaponPos) throws InvalidActionException {
        throw new InvalidActionException("Error, the actual Phase is WaitPhase, you can't equip a weapon");
    }

    @Override
    public void actualAttack(Integer attackedPos) throws InvalidActionException {
        throw new InvalidActionException("Error, the actual Phase is WaitPhase, you can't attack");
    }
}
