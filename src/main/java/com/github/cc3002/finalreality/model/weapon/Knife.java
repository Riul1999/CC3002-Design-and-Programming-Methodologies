package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.magicCharacter.BlackMage;
import com.github.cc3002.finalreality.model.character.player.commonCharacter.Knight;

import java.util.Objects;

/**
 * A class that holds all the information of a knife.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class Knife extends AbstractWeapon {

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
        super(name,damage,weight);
    }

    @Override
    public boolean equals(Object o) {
        return ( o instanceof  Knife && super.equals(o));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Knife.class);
    }

    @Override
    public void equipToBlackMage(BlackMage character){
        character.equipKnife(this);
    }

    @Override
    public void equipToKnight(Knight character){
        character.equipKnife(this);
    }

    @Override
    public String toString() {
        return super.toString()+
                ",Class: Knife";
    }
}
