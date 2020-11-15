package com.github.cc3002.finalreality.model.character.player.magicCharacter;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single white mage of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class WhiteMage extends AbstractMagicCharacter {

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
        super(name, turnsQueue, lifePoints, defense, maxMana);
    }

    @Override
    public void equip(IWeapon weapon) {
        if (this.alive()) weapon.equipToWhiteMage(this);
    }

    @Override
    public boolean equals(Object o) {
        return ( o instanceof WhiteMage && super.equals(o));
    }

    @Override
    public int hashCode() {
        return Objects.hash( super.hashCode() , WhiteMage.class );
    }
}
