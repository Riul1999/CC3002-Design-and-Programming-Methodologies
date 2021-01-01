package com.github.cc3002.finalreality.gui.phase;

import com.github.cc3002.finalreality.gui.gameController.GameController;
import com.github.cc3002.finalreality.gui.gameController.InvalidActionException;

/**
 * This State represents when the GameController has an active Character.
 *
 * @author Rodrigo Urrea Loyola.
 */
public class TurnPhase extends Phase{
    public TurnPhase(GameController gameController) {
        super(gameController);
    }

    /**
     * This method ends a the actual turn of the current game of the controller.
     */
    @Override
    public void endTurn(){
        controller.getTURNS().remove();
        controller.resetTurn();
        controller.changePhase( new WaitPhase(controller));
    }

    /**
     * This method attach a weapon in the position weaponPos of the weapons array
     * the current character.
     * @param weaponPos the position of the weapon that will be attached to the current character.
     */
    @Override
    public void equipWeaponToActual(Integer weaponPos){
        controller.equipWeapon(controller.getPlayer(controller.getActCharacterIndex()), controller.getWeapon(weaponPos) );
    }

    /**
     * This method do the attack action between the actual character and the character in
     * the attackedPos position.
     * @param attackedPos the position of the attacked character.
     */
    @Override
    public void actualAttack(Integer attackedPos) throws InvalidActionException {
        if (attackedPos < 0 )
            throw new InvalidActionException("Error, please select a target");
        if( controller.getActPlayerCharacter()){
            controller.charactersAttack(controller.getPlayer(controller.getActCharacterIndex()), controller.getEnemy(attackedPos));
        } else {
            controller.charactersAttack(controller.getEnemy(controller.getActCharacterIndex()),controller.getAlivePlayer(attackedPos));
        }
    }

    @Override
    public String toString(){
        if(controller.getActPlayerCharacter()){
            return "Player Turn";
        } else{
            return "Enemy Turn";
        }
    }
}
