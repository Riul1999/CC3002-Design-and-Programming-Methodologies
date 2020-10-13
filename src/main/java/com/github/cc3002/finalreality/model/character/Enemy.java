package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.CharacterClass;
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

  private final int weight;
  private int damage;

  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
  public Enemy(@NotNull final String name,
               final int weight,
               @NotNull final BlockingQueue<ICharacter> turnsQueue,
               @NotNull Integer lifePoints,
               Integer defense,
               Integer damage) {
    super(turnsQueue, name, CharacterClass.ENEMY, lifePoints, defense);
    this.weight = weight;
    this.damage = damage;
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
  public int getWeight() {
    return weight;
  }

  /**
   * Returns the damage of this enemy
   */
  public int getDamage() { return damage;}

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Enemy)) {
      return false;
    }
    final Enemy enemy = (Enemy) o;
    return getWeight() == enemy.getWeight() &&
            getDamage() == enemy.getDamage() &&
            getName().equals(enemy.getName()) &&
            getLifePoints().equals(enemy.getLifePoints()) &&
            getDefense().equals(enemy.getDefense());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(),getWeight(),getLifePoints(),getDefense(),getDamage());
  }
}
