package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.CharacterClass;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public interface ICharacter {

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Returns this character's class.
   */
  CharacterClass getCharacterClass();

  /**
   * Returns this character's life points
   */
  Integer getLifePoints();

  /**
   * Returns this character's defense
   */
  Integer getDefense();

  /**
   * Returns the damage of this enemy
   */
  Integer getDamage();

  /**
   * Emulates that this ICharacter attacks iCharacter, this method reduce the iCharacter's lifePoints
   * the same amount as the attack of this ICharacter minus the iCharacter's defense
   * @param iCharacter the attacked character
   */
  void attack(ICharacter iCharacter);

  /**
   * Dismiss this ICharacter lifePoints the same amount as this ICharacter defense minus damage
   * @param damage the damage received
   */
  void receiveDamage(Integer damage);

  /**
   * Returns true if the ICharacter is alive or false if it isn't, if the ICharacter has more than 0
   * lifePoints, it's alive
   */
  boolean alive();
}
