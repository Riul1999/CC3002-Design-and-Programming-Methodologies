package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.*;

/**
 * A class that holds all the information of an axe.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class Axe extends Weapon{

    /**
     * Creates an axe with a name, a base damage and it's weight.
     *
     * @param name
     *      the axe's name
     * @param damage
     *      the axe's damage
     * @param weight
     *      the axe's weight
     *
     */
    public Axe(final String name, final int damage, final int weight) {
        super(name,damage,weight,WeaponType.AXE);
    }

    @Override
    public void equipToEngineer(Engineer character){
        character.equipAxe(this);
    }

    @Override
    public void equipToKnight(Knight character){
        character.equipAxe(this);
    }
}
