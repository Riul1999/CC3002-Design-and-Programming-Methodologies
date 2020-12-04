package com.github.cc3002.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of the hands of a PlayerCharacter.
 * This type of weapon represents that the PlayerCharacter don't have a weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class Hand extends AbstractWeapon{

    /**
     * Creates a hand with a default name, base damage and weight.
     */
    public Hand() {
        super("Hand",1,10);
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Hand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Hand.class);
    }

    @Override
    public String toString() {
        return super.toString()+
                ",Class: Hand";
    }
}
