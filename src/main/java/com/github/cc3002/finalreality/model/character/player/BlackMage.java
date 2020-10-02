package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single black mage of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class BlackMage extends AbstractMagicCharacter{

    /**
     *
     * @param name
     *      the black mage's name
     * @param turnsQueue
     *      the queue with the characters waiting for their turn
     *
     */
    public BlackMage(@NotNull String name,
                  @NotNull BlockingQueue<ICharacter> turnsQueue) {
        super(name, turnsQueue, CharacterClass.BLACK_MAGE);
    }
}
