package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import com.github.cc3002.finalreality.model.weapon.WeaponType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {

  private static final String ENEMY_NAME = "Goblin";
  private static final int WEIGHT = 10;
  private static Integer LIFE = 1000;
  private static Integer DEFENSE = 30;
  private static Integer DAMAGE= 16;

  protected BlockingQueue<ICharacter> turns;
  protected Enemy testCharacters;
  protected Weapon testWeapon;

  /**
   *Setup method.
   *Creates a turn queue.
   *Creates 4 new enemies (all different) and links it to a turn queue.
   */
  @BeforeEach
  void setUp() {
    turns = new LinkedBlockingQueue<>();
    testWeapon = new Weapon("Test", 15, 10, WeaponType.AXE);
    testCharacters = new Enemy(ENEMY_NAME, WEIGHT, turns, LIFE, DEFENSE, DAMAGE);
  }

  /**
   * Checks that the character waits the appropriate amount of time for it's turn.
   */
  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    testCharacters.waitTurn();
    try {
      // Thread.sleep is not accurate so this values may be changed to adjust the
      // acceptable error margin.
      // We're testing that the character waits approximately 1 second.
      Thread.sleep(900);
      Assertions.assertEquals(0, turns.size());
      Thread.sleep(200);
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(testCharacters, turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * Checks that the equals method works properly.
   * @param expectedCharacter Same Enemy
   * @param testEqualCharacter Test Enemy
   * @param differentWeight Different weight Enemy
   * @param differentDamage Different damage Enemy
   * @param differentName Different name Enemy
   * @param differentLifePoints Different life points Enemy
   * @param differentDefense  Different defense Enemy
   * @param differentClassCharacter Different object PlayerCharacter
   */
  protected static void checkConstruction(final ICharacter expectedCharacter,
                                   final ICharacter testEqualCharacter,
                                   final ICharacter differentWeight,
                                   final ICharacter differentDamage,
                                   final ICharacter differentName,
                                   final ICharacter differentLifePoints,
                                   final ICharacter differentDefense,
                                   final ICharacter differentClassCharacter) {
    assertEquals(testEqualCharacter, expectedCharacter);
    assertEquals(testEqualCharacter.hashCode(),expectedCharacter.hashCode());
    assertNotEquals(testEqualCharacter,differentWeight);
    assertNotEquals(testEqualCharacter.hashCode(),differentWeight.hashCode());
    assertNotEquals(testEqualCharacter,differentDamage);
    assertNotEquals(testEqualCharacter.hashCode(),differentDamage.hashCode());
    assertNotEquals(testEqualCharacter,differentName);
    assertNotEquals(testEqualCharacter.hashCode(),differentName.hashCode());
    assertNotEquals(testEqualCharacter,differentLifePoints);
    assertNotEquals(testEqualCharacter.hashCode(),differentLifePoints.hashCode());
    assertNotEquals(testEqualCharacter,differentDefense);
    assertNotEquals(testEqualCharacter.hashCode(),differentDefense.hashCode());
    assertNotEquals(testEqualCharacter, differentClassCharacter);
    assertNotEquals(testEqualCharacter.hashCode(),differentClassCharacter.hashCode());
    assertNotEquals(testEqualCharacter.getClass(),differentClassCharacter.getClass());
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
      checkConstruction(new Enemy(ENEMY_NAME, WEIGHT, turns, LIFE, DEFENSE, DAMAGE),
              testCharacters,
              new Enemy(ENEMY_NAME, WEIGHT+1, turns, LIFE, DEFENSE, DAMAGE),
              new Enemy(ENEMY_NAME, WEIGHT, turns, LIFE, DEFENSE, DAMAGE+1),
              new Enemy("test goblin", WEIGHT, turns, LIFE, DEFENSE, DAMAGE),
              new Enemy(ENEMY_NAME, WEIGHT, turns, LIFE+1, DEFENSE, DAMAGE),
              new Enemy(ENEMY_NAME, WEIGHT, turns, LIFE, DEFENSE+1, DAMAGE),
              new PlayerCharacter(ENEMY_NAME, turns, CharacterClass.THIEF, LIFE, DEFENSE));
  }

  @Test
  public void attackTest(){
    Enemy enemy = testCharacters;
    Knight player = new Knight("King", turns , LIFE , DEFENSE);
    Axe axe = new Axe("King's axe" , 10 , WEIGHT);
    player.equip(axe);
    assertEquals(LIFE, enemy.getLifePoints());
    Integer expLifePoints = enemy.getLifePoints() - (player.getDamage() - enemy.getDefense());
    player.attack(enemy);
    assertEquals(expLifePoints , enemy.getLifePoints());
  }

  @Test
  public void aliveTest() {
    Enemy enemy = testCharacters;
    Knight player = new Knight("God", turns , LIFE , DEFENSE);
    Axe axe = new Axe("God's axe" , 2000 , WEIGHT);
    player.equip(axe);
    assertTrue(enemy.alive());
    player.attack(enemy);
    assertFalse(enemy.alive());

    Enemy enemy2 = new Enemy(ENEMY_NAME, WEIGHT, turns, LIFE, DEFENSE, DAMAGE);
    Knight player2 = new Knight("Dicky", turns , LIFE , DEFENSE);
    assertTrue(enemy2.alive());
    player2.attack(enemy2);
    assertTrue(enemy2.alive());
  }

  @Test
  public void aliveAttackTest() {
    Enemy enemy = testCharacters;
    Enemy enemy2 = new Enemy( "Dead" , WEIGHT , turns , 10 , DEFENSE , DAMAGE);
    Knight player = new Knight("Dicky", turns , LIFE , DEFENSE);
    Axe axe = new Axe("Dicky's axe", 100 , WEIGHT);
    player.equip(axe);
    assertTrue(enemy.alive());
    assertTrue(enemy2.alive());
    assertTrue(player.alive());
    player.attack(enemy2);
    assertEquals(LIFE,player.getLifePoints());
    enemy2.attack(player);
    assertEquals(LIFE,player.getLifePoints());
    enemy.attack(player);
    assertNotEquals(LIFE,player.getLifePoints());
  }
}