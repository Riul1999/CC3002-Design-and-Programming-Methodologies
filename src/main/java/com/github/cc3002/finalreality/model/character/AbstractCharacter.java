package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.CharacterClass;

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
  private final CharacterClass characterClass;
  protected ScheduledExecutorService scheduledExecutor;
  protected Integer lifePoints;
  protected Integer defense;
  protected Integer damage;

  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                              @NotNull String name,
                              CharacterClass characterClass,
                              @NotNull Integer lifePoints,
                              Integer defense,
                              Integer damage) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.characterClass = characterClass;
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
  public CharacterClass getCharacterClass() {
    return characterClass;
  }

  @Override
  public Integer getLifePoints() { return lifePoints;}

  @Override
  public Integer getDefense() { return defense;}

  @Override
  public abstract Integer getDamage();
}
