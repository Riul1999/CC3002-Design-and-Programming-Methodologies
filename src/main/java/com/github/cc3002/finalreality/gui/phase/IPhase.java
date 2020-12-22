package com.github.cc3002.finalreality.gui.phase;

import com.github.cc3002.finalreality.gui.gameController.InvalidActionException;

public interface IPhase {

    void beginTurn() throws InvalidActionException;

    void endTurn() throws InvalidActionException;

    void equipWeaponToActual(Integer weaponPos) throws InvalidActionException;

    void actualAttack(Integer attackedPos) throws InvalidActionException;
}
