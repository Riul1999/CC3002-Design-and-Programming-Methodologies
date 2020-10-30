package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.*;
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
     * @param lifePoints
     *      the black mage's life points
     * @param defense
     *      the black mage's defense
     * @param maxMana
     *      the black mage's maximun mana
     */
    public BlackMage(@NotNull String name,
                     @NotNull BlockingQueue<ICharacter> turnsQueue,
                     @NotNull Integer lifePoints,
                     Integer defense,
                     @NotNull Integer maxMana) {
        super(name, turnsQueue, CharacterClass.BLACK_MAGE,lifePoints,defense,maxMana);
    }

    @Override
    public void equip(Weapon weapon) {
        if (this.alive()) weapon.equipToBlackMage(this);
    }
}
