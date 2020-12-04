package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.commonCharacter.Engineer;
import com.github.cc3002.finalreality.model.character.player.commonCharacter.Thief;

import java.util.Objects;

/**
 * A class that holds all the information of a bow.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class Bow extends AbstractWeapon {

    /**
     * Creates a bow with a name, a base damage and it's weight.
     *
     * @param name
     *      the bow's name
     * @param damage
     *      the bow's damage
     * @param weight
     *      the bow's weight
     *
     */
    public Bow(final String name, final int damage, final int weight) {
        super(name,damage,weight);
    }

    @Override
    public boolean equals(Object o) {
        return ( o instanceof Bow && super.equals(o));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Bow.class);
    }

    @Override
    public void equipToEngineer(Engineer character){
        character.equipBow(this);
    }

    @Override
    public void equipToThief(Thief character){
        character.equipBow(this);
    }

    @Override
    public String toString() {
        return super.toString()+
                ",Class: Bow";
    }
}
