package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.github.cc3002.finalreality.model.weapon.Weapon;
import com.github.cc3002.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class PlayerCharacter extends AbstractCharacter {

  protected Weapon equippedWeapon = new Weapon("NULL",-1,-1, WeaponType.NULLWEAPON);

  /**
   * Creates a new character.
   *
   * @param name
   *     the player character's name
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param characterClass
   *     the class of this character
   * @param lifePoints
   *     the player character's life points
   * @param defense
   *     the player character's defense
   *
   */

  public PlayerCharacter(@NotNull String name,
                         @NotNull BlockingQueue<ICharacter> turnsQueue,
                         final CharacterClass characterClass,
                         @NotNull Integer lifePoints,
                         Integer defense) {
    super(turnsQueue, name, characterClass, lifePoints, defense);
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor
            .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
  }

  /**
   * Equip a weapon to the character.
   *
   * @param weapon
   *      the equipped weapon
   */
  public void equip(Weapon weapon) {
      this.equippedWeapon = weapon;
  }

  /**
   * Returns this character's equipped weapon.
   */
  public Weapon getEquippedWeapon() {
    return equippedWeapon;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(),getCharacterClass(),
                        getLifePoints(),getDefense());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PlayerCharacter)) {
      return false;
    }
    final PlayerCharacter that = (PlayerCharacter) o;
    return     getCharacterClass() == that.getCharacterClass()
            && getName().equals(that.getName())
            && getLifePoints().equals((that.getLifePoints()))
            && getDefense().equals(that.getDefense());
  }

}
