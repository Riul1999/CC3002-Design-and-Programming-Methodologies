package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single engineer of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class Engineer extends AbstractCommonCharacter{

    /**
     *
     * @param name
     *      the engineer's name
     * @param turnsQueue
     *      the queue with the characters waiting for their turn
     *
     */
    public Engineer(@NotNull String name,
                  @NotNull BlockingQueue<ICharacter> turnsQueue) {
        super(name, turnsQueue, CharacterClass.ENGINEER);
    }
}
