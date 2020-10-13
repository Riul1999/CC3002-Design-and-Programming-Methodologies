package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single knight of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class Knight extends AbstractCommonCharacter{

    /**
     *
     * @param name
     *      the knight's name
     * @param turnsQueue
     *      the queue with the characters waiting for their turn
     * @param lifePoints
     *      the knight's life points
     * @param defense
     *      the knight's defense
     *
     */
    public Knight(@NotNull String name,
                  @NotNull BlockingQueue<ICharacter> turnsQueue,
                  @NotNull Integer lifePoints,
                  Integer defense) {
        super(name, turnsQueue, CharacterClass.KNIGHT, lifePoints, defense);
    }
}
