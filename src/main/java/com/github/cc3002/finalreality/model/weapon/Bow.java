package com.github.cc3002.finalreality.model.weapon;

/**
 * A class that holds all the information of a bow.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class Bow extends Weapon{

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
        super(name,damage,weight,WeaponType.BOW);
    }
}
