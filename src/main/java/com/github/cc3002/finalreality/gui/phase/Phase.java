package com.github.cc3002.finalreality.gui.phase;

import com.github.cc3002.finalreality.gui.gameController.GameController;
import com.github.cc3002.finalreality.gui.gameController.InvalidActionException;

public class Phase  implements IPhase{
    protected final GameController controller;

    public Phase(GameController gameController){
        this.controller = gameController;
    }


    @Override
    public void beginTurn() throws InvalidActionException {
        throw new InvalidActionException("Error, invalid Phase to do that");
    }

    @Override
    public void endTurn() throws InvalidActionException {
        throw new InvalidActionException("Error, invalid Phase to do that");
    }

    @Override
    public void equipWeaponToActual(Integer weaponPos) throws InvalidActionException {
        throw new InvalidActionException("Error, invalid Phase to do that");
    }

    @Override
    public void actualAttack(Integer attackedPos) throws InvalidActionException {
        throw new InvalidActionException("Error, invalid Phase to do that");
    }
}
