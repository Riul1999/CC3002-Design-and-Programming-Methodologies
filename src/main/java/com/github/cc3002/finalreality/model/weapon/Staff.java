package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.magicCharacter.BlackMage;
import com.github.cc3002.finalreality.model.character.player.commonCharacter.Thief;
import com.github.cc3002.finalreality.model.character.player.magicCharacter.WhiteMage;

import java.util.Objects;

/**
 * A class that holds all the information of a staff.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class Staff extends AbstractWeapon {

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
     * @param magicDamage
     *      the staff's magic damage
     *
     */
    public Staff(final String name, final int damage, final int weight, final Integer magicDamage) {

        super(name,damage,weight);
        this.magicDamage=magicDamage;
    }

    public Integer getMagicDamage() { return magicDamage;}

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Staff)) {
            return false;
        }
        final Staff weaponStaff = (Staff) o;
        return getMagicDamage().equals(weaponStaff.getMagicDamage()) && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMagicDamage(), Staff.class);
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

    @Override
    public String toString() {
        return super.toString()+
                ",MagicDamage: "+getMagicDamage()+
                ",Class: Staff";
    }
}
