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
 * A class that holds all the information of a single player character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter implements IPlayerCharacter{
  protected AbstractWeapon equippedWeapon;

  /**
   * Creates a new character.
   *
   * @param name
   *     the player character's name
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param lifePoints
   *     the player character's life points
   * @param defense
   *     the player character's defense
   *
   */

  public AbstractPlayerCharacter(@NotNull String name,
                                 @NotNull BlockingQueue<ICharacter> turnsQueue,
                                 @NotNull Integer lifePoints,
                                 Integer defense) {
    super(turnsQueue, name, lifePoints, defense, 0);
    this.equippedWeapon = new Hand();
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor
            .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
  }

  @Override
  public void equip(IWeapon weapon) {}

  @Override
  public void equipAxe(Axe axe) {this.equippedWeapon = axe;}

  @Override
  public void equipBow(Bow bow) {this.equippedWeapon = bow;}

  @Override
  public void equipStaff(Staff staff) {this.equippedWeapon = staff;}

  @Override
  public void equipSword(Sword sword) {this.equippedWeapon = sword;}

  @Override
  public void equipKnife(Knife knife) {this.equippedWeapon = knife;}

  @Override
  public IWeapon getEquippedWeapon() {
    return equippedWeapon;
  }

  @Override
  public Integer getDamage() {
    return equippedWeapon.getDamage();}

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), AbstractPlayerCharacter.class, getEquippedWeapon());
  }

  @Override
  public boolean equals(final Object o) {
    if (!(o instanceof AbstractPlayerCharacter)) {
      return false;
    }
    AbstractPlayerCharacter that = (AbstractPlayerCharacter) o;
    return Objects.equals(getEquippedWeapon(), that.getEquippedWeapon()) && super.equals(o);
  }

  @Override
  public String toString() {
    return super.toString() +
            ",[Weapon: "+getEquippedWeapon()+"]";
  }

}
