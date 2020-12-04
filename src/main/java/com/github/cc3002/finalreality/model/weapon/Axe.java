package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.commonCharacter.Engineer;
import com.github.cc3002.finalreality.model.character.player.commonCharacter.Knight;

import java.util.Objects;

/**
 * A class that holds all the information of an axe.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class Axe extends AbstractWeapon {

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
        super(name,damage,weight);
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Axe && super.equals(o));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Axe.class);
    }

    @Override
    public void equipToEngineer(Engineer character){
        character.equipAxe(this);
    }

    @Override
    public void equipToKnight(Knight character){
        character.equipAxe(this);
    }

    @Override
    public String toString() {
        return super.toString()+
                ",Class: Axe";
    }
}
