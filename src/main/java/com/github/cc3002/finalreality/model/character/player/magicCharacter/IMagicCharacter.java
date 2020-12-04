package com.github.cc3002.finalreality.model.character.player.magicCharacter;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

/**
 * This represents a magic character from the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public interface IMagicCharacter extends IPlayerCharacter {

    /**
     * Returns this character's maximum mana.
     */
    Integer getMaxMana();
}
