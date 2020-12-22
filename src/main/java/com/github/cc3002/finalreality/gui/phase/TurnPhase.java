package com.github.cc3002.finalreality.gui.phase;

import com.github.cc3002.finalreality.gui.gameController.GameController;

public class TurnPhase extends Phase{
    public TurnPhase(GameController gameController) {
        super(gameController);
    }

    @Override
    public void endTurn(){
        controller.getTURNS().remove();
        controller.addToTURNS();
        controller.changePhase( new WaitPhase(controller));
    }

    @Override
    public void equipWeaponToActual(Integer weaponPos){
        controller.equipWeapon(controller.getPlayer(controller.getActCharacterIndex()), controller.getWeapon(weaponPos) );
    }

    @Override
    public void actualAttack(Integer attackedPos){
        if( controller.getActPlayerCharacter()){
            controller.charactersAttack(controller.getPlayer(controller.getActCharacterIndex()), controller.getEnemy(attackedPos));
        } else {
            controller.charactersAttack(controller.getEnemy(controller.getActCharacterIndex()),controller.getPlayer(attackedPos));
        }
    }
}
