package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * An abstract class that holds the common behaviour of all the common characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public abstract class AbstractCommonCharacter extends PlayerCharacter{

    /**
     *
     * @param name
     *      the common character's name
     * @param turnsQueue
     *      the queue with the characters waiting for their turn
     * @param characterClass
     *      the class of this character
     */
    public AbstractCommonCharacter(@NotNull String name,
                                   @NotNull BlockingQueue<ICharacter> turnsQueue,
                                   final CharacterClass characterClass) {
        super(name, turnsQueue, characterClass);
    }
}