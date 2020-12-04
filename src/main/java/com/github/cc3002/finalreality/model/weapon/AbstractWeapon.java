package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.magicCharacter.BlackMage;
import com.github.cc3002.finalreality.model.character.player.commonCharacter.Engineer;
import com.github.cc3002.finalreality.model.character.player.commonCharacter.Knight;
import com.github.cc3002.finalreality.model.character.player.commonCharacter.Thief;
import com.github.cc3002.finalreality.model.character.player.magicCharacter.WhiteMage;

import java.util.Objects;

/**
 * A class that holds all the information of a weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public abstract class AbstractWeapon implements IWeapon{

  private final String name;
  private final Integer damage;
  private final Integer weight;

  /**
   * Creates a weapon with a name, a base damage, weight and it's type.
   *
   */
  public AbstractWeapon(final String name, final Integer damage, final Integer weight) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Integer getDamage() {
    return damage;
  }

  @Override
  public Integer getWeight() {
    return weight;
  }


  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractWeapon)) {
      return false;
    }
    final AbstractWeapon weapon = (AbstractWeapon) o;
    return getDamage().equals(weapon.getDamage()) &&
           getWeight().equals(weapon.getWeight()) &&
           getName().equals(weapon.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getWeight(), AbstractWeapon.class);
  }

  @Override
  public void equipToBlackMage(BlackMage character){}

  @Override
  public void equipToEngineer(Engineer character){}

  @Override
  public void equipToKnight(Knight character){}

  @Override
  public void equipToThief(Thief character){}

  @Override
  public void equipToWhiteMage(WhiteMage character){}

  @Override
  public String toString() {
    return "Name: "+getName()+
           ",Damage: "+getDamage()+
           ",Weight: "+getWeight();
  }
}
