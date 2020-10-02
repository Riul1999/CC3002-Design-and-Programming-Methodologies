package com.github.cc3002.finalreality.model.weapon;

/**
 * A class that holds all the information of a staff.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class Staff extends Weapon{

    /**
     * Creates a staff with a name, a base damage and it's weight.
     *
     * @param name
     *      the staff's name
     * @param damage
     *      the staff's damage
     * @param weight
     *      the staff's weight
     *
     */
    public Staff(final String name, final int damage, final int weight) {
        super(name,damage,weight,WeaponType.STAFF);
    }
}
