package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.github.cc3002.finalreality.model.weapon.*;
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
   * Equip a weapon to the character if the character isn't a instance of PlayerCharacter or
   * AbstractCommonCharacter or AbstractMagicCharacter.
   *
   * @param weapon
   *      the equipped weapon
   */
  public void equip(Weapon weapon) {}

  /**
   * Equip an Axe to the character
   */
  public void equipAxe(Axe axe) {this.equippedWeapon = axe;}

  /**
   * Equip a Bow to the character
   */
  public void equipBow(Bow bow) {this.equippedWeapon = bow;}

  /**
   * Equip a Staff to the character
   */
  public void equipStaff(Staff staff) {this.equippedWeapon = staff;}

  /**
   * Equip a Sword to the character
   */
  public void equipSword(Sword sword) {this.equippedWeapon = sword;}

  /**
   * Equip a Knife to the character
   */
  public void equipKnife(Knife knife) {this.equippedWeapon = knife;}

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
