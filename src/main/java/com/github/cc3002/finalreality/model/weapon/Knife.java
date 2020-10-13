package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.*;

/**
 * A class that holds all the information of a knife.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class Knife extends Weapon{

    /**
     * Creates a knife with a name, a base damage and it's weight.
     *
     * @param name
     *      the knife's name
     * @param damage
     *      the knife's damage
     * @param weight
     *      the knife's weight
     *
     */
    public Knife(final String name, final int damage, final int weight) {
        super(name,damage,weight,WeaponType.KNIFE);
    }

    @Override
    public void equipToBlackMage(BlackMage character){
        character.equipKnife(this);
    }

    @Override
    public void equipToKnight(Knight character){
        character.equipKnife(this);
    }

}
