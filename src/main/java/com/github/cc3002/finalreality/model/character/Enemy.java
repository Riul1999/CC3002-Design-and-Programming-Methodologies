package com.github.cc3002.finalreality.model.character;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author Rodrigo Urrea Loyola
 */
public class Enemy extends AbstractCharacter {

  private final Integer weight;

  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
  public Enemy(@NotNull final String name,
               @NotNull final BlockingQueue<ICharacter> turnsQueue,
               @NotNull Integer lifePoints,
               Integer defense,
               Integer damage,
               final Integer weight) {
    super(turnsQueue, name, lifePoints, defense, damage);
    this.weight = weight;
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor
            .schedule(this::addToQueue, this.getWeight() / 10, TimeUnit.SECONDS);
  }

  /**
   * Returns the weight of this enemy.
   */
  public Integer getWeight() {
    return weight;
  }

  @Override
  public Integer getDamage() {return damage;}

  @Override
  public boolean equals(final Object o) {
    if (!(o instanceof Enemy)) {
      return false;
    }
    final Enemy enemy = (Enemy) o;
    return  getWeight().equals(enemy.getWeight()) && super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(),getWeight(),Enemy.class);
  }

  @Override
  public String toString() {
    return super.toString()+
            ",Damage: "+getDamage()+
            ",Weight: "+getWeight()+
            ",Class: Enemy";
  }
}
