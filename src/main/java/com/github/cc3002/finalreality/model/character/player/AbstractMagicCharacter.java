package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * An abstract class that holds the common behaviour of all the magic characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public abstract class AbstractMagicCharacter extends PlayerCharacter{

    protected Integer currentMana;
    protected Integer maxMana;

    /**
     *
     * @param name
     *      the magic character's name
     * @param turnsQueue
     *      the queue with the characters waiting for their turn
     * @param characterClass
     *      the class of this character
     * @param lifePoints
     *      the magic character's life points
     * @param defense
     *      the magic character's defense
     * @param  maxMana
     *      the maximum mana of the magic character
     *
     */
    public AbstractMagicCharacter(@NotNull String name,
                                  @NotNull BlockingQueue<ICharacter> turnsQueue,
                                  final CharacterClass characterClass,
                                  @NotNull Integer lifePoints,
                                  Integer defense,
                                  @NotNull Integer maxMana) {
        super(name, turnsQueue, characterClass,lifePoints,defense);
        this.maxMana = maxMana;
        this.currentMana = maxMana;
    }

    /**
     * Returns this character's maximum mana.
     */
    public Integer getMaxMana() { return maxMana;}


    @Override
    public int hashCode() {
        return Objects.hash(getName(),getCharacterClass(),
                getLifePoints(),getDefense(),getMaxMana());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractMagicCharacter)) {
            return false;
        }
        final AbstractMagicCharacter that = (AbstractMagicCharacter) o;
        return     getCharacterClass() == that.getCharacterClass()
                && getName().equals(that.getName())
                && getLifePoints().equals((that.getLifePoints()))
                && getDefense().equals(that.getDefense())
                && getMaxMana().equals(that.getMaxMana());
    }
}
