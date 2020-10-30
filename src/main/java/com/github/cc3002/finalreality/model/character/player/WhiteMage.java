package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single white mage of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class WhiteMage extends AbstractMagicCharacter{

    /**
     *
     * @param name
     *      the white mage's name
     * @param turnsQueue
     *      the queue with the characters waiting for their turn
     * @param lifePoints
     *       the white mage's life points
     * @param defense
     *       the white mage's defense
     * @param maxMana
     *        the white mage's maximum mana
     *
     */
    public WhiteMage(@NotNull String name,
                     @NotNull BlockingQueue<ICharacter> turnsQueue,
                     @NotNull Integer lifePoints,
                     Integer defense,
                     @NotNull Integer maxMana) {
        super(name, turnsQueue, CharacterClass.WHITE_MAGE, lifePoints, defense, maxMana);
    }

    @Override
    public void equip(Weapon weapon) {
        if (this.alive()) weapon.equipToWhiteMage(this);
    }
}
