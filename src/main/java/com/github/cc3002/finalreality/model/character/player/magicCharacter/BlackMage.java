package com.github.cc3002.finalreality.model.character.player.magicCharacter;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single black mage of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class BlackMage extends AbstractMagicCharacter {

    /**
     *
     * @param name
     *      the black mage's name
     * @param turnsQueue
     *      the queue with the characters waiting for their turn
     * @param lifePoints
     *      the black mage's life points
     * @param defense
     *      the black mage's defense
     * @param maxMana
     *      the black mage's maximum mana
     */
    public BlackMage(@NotNull String name,
                     @NotNull BlockingQueue<ICharacter> turnsQueue,
                     @NotNull Integer lifePoints,
                     Integer defense,
                     @NotNull Integer maxMana) {
        super(name, turnsQueue, lifePoints,defense,maxMana);
    }

    @Override
    public void equip(IWeapon weapon) {
        if (this.alive()) weapon.equipToBlackMage(this);
    }

    @Override
    public boolean equals(Object o) {
        return ( o instanceof BlackMage && super.equals(o));
    }

    @Override
    public int hashCode() {
        return Objects.hash( super.hashCode() , BlackMage.class );
    }

    @Override
    public String toString() {
        return super.toString()+
                ",Class: BlackMage";
    }
}
