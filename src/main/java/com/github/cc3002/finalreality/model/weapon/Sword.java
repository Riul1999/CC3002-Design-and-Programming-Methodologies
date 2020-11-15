package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.commonCharacter.Knight;
import com.github.cc3002.finalreality.model.character.player.commonCharacter.Thief;

import java.util.Objects;

/**
 * A class that holds all the information of a sword.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class Sword extends AbstractWeapon {

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
        super(name,damage,weight);
    }

    @Override
    public boolean equals(Object o) {
        return ( o instanceof Sword && super.equals(o));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Sword.class);
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
