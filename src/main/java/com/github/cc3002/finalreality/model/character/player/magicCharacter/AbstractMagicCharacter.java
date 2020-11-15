package com.github.cc3002.finalreality.model.character.player.magicCharacter;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * An abstract class that holds the common behaviour of all the magic characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public abstract class AbstractMagicCharacter extends AbstractPlayerCharacter implements IMagicCharacter {

    protected Integer currentMana;
    protected Integer maxMana;

    /**
     *
     * @param name
     *      the magic character's name
     * @param turnsQueue
     *      the queue with the characters waiting for their turn
     * @param lifePoints
     *      the magic character's life points
     * @param defense
     *      the magic character's defense
     * @param  maxMana
     *      the maximum mana of the magic character
     *
     */
    public AbstractMagicCharacter (@NotNull String name,
                                  @NotNull BlockingQueue<ICharacter> turnsQueue,
                                  @NotNull Integer lifePoints,
                                  Integer defense,
                                  @NotNull Integer maxMana) {
        super(name, turnsQueue,lifePoints,defense);
        this.maxMana = maxMana;
        this.currentMana = maxMana;
    }

    @Override
    public Integer getMaxMana() { return maxMana;}


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),getMaxMana(),AbstractMagicCharacter.class);
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof  AbstractMagicCharacter)) {
            return false;
        }
        AbstractMagicCharacter mage = (AbstractMagicCharacter) o;
        return  getMaxMana().equals(mage.getMaxMana()) && super.equals(o);
    }
}
