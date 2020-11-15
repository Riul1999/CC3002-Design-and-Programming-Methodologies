package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.*;

public interface IPlayerCharacter extends ICharacter {

    /**
     * Equip a weapon to the character if the character isn't a instance of PlayerCharacter or
     * AbstractCommonCharacter or AbstractMagicCharacter.
     *
     * @param weapon
     *      the equipped weapon
     */
    void equip(IWeapon weapon);

    /**
     * Equip an Axe to the character
     */
    void equipAxe(Axe axe);

    /**
     * Equip a Bow to the character
     */
    void equipBow(Bow bow);

    /**
     * Equip a Staff to the character
     */
    void equipStaff(Staff staff);

    /**
     * Equip a Sword to the character
     */
    void equipSword(Sword sword);

    /**
     * Equip a Knife to the character
     */
    void equipKnife(Knife knife);

    /**
     * Returns this character's equipped weapon.
     */
    IWeapon getEquippedWeapon();

}
