package com.github.cc3002.finalreality.model.character.player.commonCharacter;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single engineer of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class Engineer extends AbstractCommonCharacter {

    /**
     *
     * @param name
     *      the engineer's name
     * @param turnsQueue
     *      the queue with the characters waiting for their turn
     * @param lifePoints
     *      the engineer's life points
     * @param defense
     *      the engineer's defense
     *
     */
    public Engineer(@NotNull String name,
                    @NotNull BlockingQueue<ICharacter> turnsQueue,
                    @NotNull Integer lifePoints,
                    Integer defense) {
        super(name, turnsQueue, lifePoints, defense);
    }

    @Override
    public void equip(IWeapon weapon) {
        if (this.alive()) weapon.equipToEngineer(this);
    }

    @Override
    public boolean equals(Object o) {
        return ( o instanceof Engineer && super.equals(o));
    }

    @Override
    public int hashCode() {
        return Objects.hash( super.hashCode() , Engineer.class );
    }
}
