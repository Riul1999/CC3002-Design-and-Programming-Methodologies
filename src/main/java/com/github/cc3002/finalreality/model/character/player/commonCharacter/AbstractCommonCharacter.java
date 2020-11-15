package com.github.cc3002.finalreality.model.character.player.commonCharacter;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * An abstract class that holds the common behaviour of all the common characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public abstract class AbstractCommonCharacter extends AbstractPlayerCharacter implements ICommonCharacter {

    /**
     *
     * @param name
     *      the common character's name
     * @param turnsQueue
     *      the queue with the characters waiting for their turn
     * @param lifePoints
     *      the common character's life points
     * @param defense
     *      the common character's defense
     */
    public AbstractCommonCharacter(@NotNull String name,
                                   @NotNull BlockingQueue<ICharacter> turnsQueue,
                                   @NotNull Integer lifePoints,
                                   Integer defense) {
        super(name, turnsQueue, lifePoints, defense);
    }

    @Override
    public boolean equals(Object o) {
        return ( o instanceof AbstractCommonCharacter && super.equals(o));
    }

    @Override
    public int hashCode() {
        return Objects.hash( super.hashCode() , AbstractCommonCharacter.class );
    }
}
