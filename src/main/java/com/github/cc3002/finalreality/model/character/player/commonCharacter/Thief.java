package com.github.cc3002.finalreality.model.character.player.commonCharacter;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single thief of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class Thief extends AbstractCommonCharacter {

    /**
     *
     * @param name
     *      the thief's name
     * @param turnsQueue
     *      the queue with the characters waiting for their turn
     * @param lifePoints
     *      the thief's life points
     * @param defense
     *      the thief's defense
     *
     */
    public Thief(@NotNull String name,
                  @NotNull BlockingQueue<ICharacter> turnsQueue,
                 @NotNull Integer lifePoints,
                 Integer defense) {
        super(name, turnsQueue, lifePoints, defense);
    }

    @Override
    public void equip(IWeapon weapon) {
        if(this.alive()) weapon.equipToThief(this);
    }

    @Override
    public boolean equals(Object o) {
        return ( o instanceof Thief && super.equals(o));
    }

    @Override
    public int hashCode() {
        return Objects.hash( super.hashCode() , Thief.class );
    }
}
