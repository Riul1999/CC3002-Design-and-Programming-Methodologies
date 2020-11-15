package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.magicCharacter.BlackMage;
import com.github.cc3002.finalreality.model.character.player.commonCharacter.Engineer;
import com.github.cc3002.finalreality.model.character.player.commonCharacter.Knight;
import com.github.cc3002.finalreality.model.character.player.commonCharacter.Thief;
import com.github.cc3002.finalreality.model.character.player.magicCharacter.WhiteMage;

/**
 * This represents a weapon from the game.
 * A weapon can be equipped only to a player.
 *
 * @author Rodrigo Urrea Loyola
 */

public interface IWeapon {

    /**
     * @return the name of the weapon
     */
    String getName();

    /**
     * @return the damage of the weapon
     */
    Integer getDamage();

    /**
     * @return the weight of the weapon
     */
    Integer getWeight();

    /**
     * Equip this weapon to a BlackMage
     */
    void equipToBlackMage(BlackMage character);

    /**
     * Equip this weapon to an Engineer
     */
    void equipToEngineer(Engineer character);

    /**
     * Equip this weapon to a Knight
     */
    void equipToKnight(Knight character);

    /**
     * Equip this weapon to a Thief
     */
    void equipToThief(Thief character);

    /**
     * Equip this weapon to a WhiteMage
     */
    void equipToWhiteMage(WhiteMage character);
}
