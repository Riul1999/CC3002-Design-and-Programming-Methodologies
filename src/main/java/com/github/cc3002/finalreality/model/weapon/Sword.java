package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.*;

/**
 * A class that holds all the information of a sword.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class Sword extends Weapon{

    /**
     * Creates a sword with a name, a base damage and it's weight.
     *
     * @param name
     *      the sword's name
     * @param damage
     *      the sword's damage
     * @param weight
     *      the sword's weight
     *
     */
    public Sword(final String name, final int damage, final int weight) {
        super(name,damage,weight,WeaponType.SWORD);
    }

    @Override
    public void equipToKnight(Knight character){
        character.equipSword(this);
    }

    @Override
    public void equipToThief(Thief character){
        character.equipSword(this);
    }

}
