package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.*;

import java.util.Objects;

/**
 * A class that holds all the information of a staff.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class Staff extends Weapon{

    private final Integer magicDamage;

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
    public Staff(final String name, final int damage, final int weight, final Integer magicDamage) {

        super(name,damage,weight,WeaponType.STAFF);
        this.magicDamage=magicDamage;
    }

    public Integer getMagicDamage() { return magicDamage;}

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Staff)) {
            return false;
        }
        final Staff weaponStaff = (Staff) o;
        return getDamage() == weaponStaff.getDamage() &&
                getWeight() == weaponStaff.getWeight() &&
                getName().equals(weaponStaff.getName()) &&
                getMagicDamage().equals(weaponStaff.getMagicDamage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDamage(), getWeight(), getMagicDamage());
    }

    @Override
    public void equipToBlackMage(BlackMage character){
        character.equipStaff(this);
    }

    @Override
    public void equipToThief(Thief character){
        character.equipStaff(this);
    }

    @Override
    public void equipToWhiteMage(WhiteMage character){
        character.equipStaff(this);
    }
}
