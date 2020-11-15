package com.github.cc3002.finalreality.model.character;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public abstract class AbstractCharacter implements ICharacter {

  protected final BlockingQueue<ICharacter> turnsQueue;
  protected final String name;
  protected ScheduledExecutorService scheduledExecutor;
  protected Integer lifePoints;
  protected Integer defense;
  protected Integer damage;

  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                              @NotNull String name,
                              @NotNull Integer lifePoints,
                              Integer defense,
                              Integer damage) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.lifePoints = lifePoints;
    this.defense = defense;
    this.damage = damage;
  }

  @Override
  public abstract void waitTurn();

  /**
   * Adds this character to the turns queue.
   */
  protected void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  @Override
  public void attack(ICharacter iCharacter) {
    if (this.alive()) iCharacter.receiveDamage(this.getDamage());
  }

  @Override
  public void receiveDamage(Integer damage) {
    this.lifePoints -= (damage - this.defense);
  }

  @Override
  public boolean alive() { return this.lifePoints > 0; }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Integer getLifePoints() { return lifePoints;}

  @Override
  public Integer getDefense() { return defense;}

  @Override
  public abstract Integer getDamage();

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ( !(o instanceof AbstractCharacter)){
      return false;
    }
    final AbstractCharacter that = (AbstractCharacter) o;
    return     getName().equals(that.getName())
            && getLifePoints().equals((that.getLifePoints()))
            && getDefense().equals(that.getDefense())
            && getDamage().equals(that.getDamage());
  }

  @Override
  public int hashCode() {
    return Objects.hash( getName(), getLifePoints(), getDefense(), getDamage() , AbstractCharacter.class );
  }
}
