package com.github.cc3002.finalreality.gui.phase;

import com.github.cc3002.finalreality.gui.gameController.GameController;
import com.github.cc3002.finalreality.model.character.ICharacter;

public class WaitPhase extends Phase{
    public WaitPhase(GameController gameController) {
        super(gameController);
    }

    @Override
    public void beginTurn(){
        ICharacter character = controller.getTURNS().peek();
        controller.setActPlayerCharacter(character);
        controller.changePhase( new TurnPhase(controller));
    }
}
