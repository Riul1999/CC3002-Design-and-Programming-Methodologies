package com.github.cc3002.finalreality.gui.phase;

import com.github.cc3002.finalreality.gui.gameController.GameController;
import com.github.cc3002.finalreality.model.character.ICharacter;

/**
 * This State represents when the GameController hasn't an active Character.
 *
 * @author Rodrigo Urrea Loyola
 */
public class WaitPhase extends Phase{
    public WaitPhase(GameController gameController) {
        super(gameController);
    }

    /**
     * This method begins a new turn of the current game of the controller.
     */
    @Override
    public void beginTurn(){
        ICharacter character = controller.getTURNS().peek();
        controller.setActPlayerCharacter(character);
        controller.changePhase( new TurnPhase(controller));
    }

    @Override
    public String toString(){
        return "WaitPhase";
    }
}
