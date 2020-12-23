package com.github.cc3002.finalreality.gui.phase;

import com.github.cc3002.finalreality.gui.gameController.InvalidActionException;

public interface IPhase {

    /**
     * This method starts a new turn if it's called from WaitPhase class,
     * else, it throws an InvalidActionException.
     */
    void beginTurn() throws InvalidActionException;

    /**
     * This method ends the actual turn if it's called from TurnPhase class,
     * else, it throws an InvalidActionException.
     */
    void endTurn() throws InvalidActionException;

    /**
     * This method equips a weapon to the current Character if it's called from
     * TurnPhase class, else, it throws an InvalidActionException.
     * @param weaponPos the position of the equipped weapon.
     */
    void equipWeaponToActual(Integer weaponPos) throws InvalidActionException;

    /**
     * This method do the attack action between the actual character again
     * the attackedPos character if it's called from TurnPhase class, else,
     * it throws an InvalidActionException.
     * @param attackedPos the position of the attacked character.
     */
    void actualAttack(Integer attackedPos) throws InvalidActionException;
}
