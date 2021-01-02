package com.github.cc3002.finalreality.model.character;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

import com.github.cc3002.finalreality.controller.handlers.AliveHandlers.AliveAbstractCharacterHandler;
import com.github.cc3002.finalreality.controller.handlers.EndTurnHandler;
import com.github.cc3002.finalreality.controller.handlers.BeginTurnHandler;
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
  private final PropertyChangeSupport aliveChange;
  private final PropertyChangeSupport endTurnChange;
  private final PropertyChangeSupport beginTurnChange;

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
    aliveChange = new PropertyChangeSupport(this);
    endTurnChange = new PropertyChangeSupport(this);
    beginTurnChange = new PropertyChangeSupport(this);
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
    if (this.alive()) {
      iCharacter.receiveDamage(this.getDamage());
    }
  }

  @Override
  public void receiveDamage(Integer damage) {
    this.lifePoints -= (damage - this.defense);
    if (lifePoints < 0) {
      aliveChange.firePropertyChange(new PropertyChangeEvent(this, "entered text", null, this));
    }
    endTurnChange.firePropertyChange(new PropertyChangeEvent(this,"entered text",null,null));
    beginTurnChange.firePropertyChange(new PropertyChangeEvent(this,"entered text",null,null));

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

  @Override
  public String toString() {
    return "Name: "+getName()+
            ",LifePoints: "+getLifePoints()+
            ",Defense: "+getDefense();
  }

  @Override
  public void addAliveListener(AliveAbstractCharacterHandler res) {
    aliveChange.addPropertyChangeListener(res);
  }

  @Override
  public void addEndTurnListener(EndTurnHandler res){
    endTurnChange.addPropertyChangeListener(res);
  }

  @Override
  public void addBeginTurnListener(BeginTurnHandler res) {
    beginTurnChange.addPropertyChangeListener(res);
  }
}
