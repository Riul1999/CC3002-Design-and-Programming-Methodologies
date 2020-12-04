package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.commonCharacter.Knight;
import com.github.cc3002.finalreality.model.weapon.Axe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Set of tests for the Enemy class.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 * @see AbstractPlayerCharacter
 */
class EnemyTest extends  AbstractCharacterTest{

  private static final String ENEMY_NAME = "Goblin";
  private static final int WEIGHT = 10;
  private static final Integer LIFE = 1000;
  private static final Integer DEFENSE = 30;
  private static final Integer DAMAGE= 16;

  protected Enemy testCharacters;

  /**
   *Setup method.
   *Creates a turn queue.
   *Creates 4 new enemies (all different) and links it to a turn queue.
   */
  @BeforeEach
  void setUp() {
    abstractCharacterBasicSetUp();
    testCharacters = new Enemy(ENEMY_NAME, turns, LIFE, DEFENSE, DAMAGE, WEIGHT);
  }

  /**
   * Checks that the character waits the appropriate amount of time for it's turn.
   */
  @Test
  void waitTurnTest() {
    abstractCharacterWaitTurn(testCharacters);
  }

  /**
   * Checks that the equals method works properly.
   * @param expectedCharacter Same Enemy
   * @param testEqualCharacter Test Enemy
   * @param differentClassCharacter Different object PlayerCharacter
   * @param differentName Different name Enemy
   * @param differentLifePoints Different life points Enemy
   * @param differentDefense  Different defense Enemy
   * @param differentDamage Different damage Enemy
   * @param differentWeight Different weight Enemy
   */
  protected static void checkConstruction(final Enemy expectedCharacter,
                                          final Enemy testEqualCharacter,
                                          final ICharacter differentClassCharacter,
                                          final Enemy differentName,
                                          final Enemy differentLifePoints,
                                          final Enemy differentDefense,
                                          final Enemy differentDamage,
                                          final Enemy differentWeight) {
    abstractCharacterCheckConstruction(expectedCharacter,
                                       testEqualCharacter,
                                       differentClassCharacter,
                                       differentName,
                                       differentLifePoints,
                                       differentDefense);

    assertNotEquals(testEqualCharacter,differentDamage);
    assertNotEquals(testEqualCharacter.hashCode(),differentDamage.hashCode());

    assertNotEquals(testEqualCharacter,differentWeight);
    assertNotEquals(testEqualCharacter.hashCode(),differentWeight.hashCode());

  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
      checkConstruction(new Enemy(ENEMY_NAME, turns, LIFE, DEFENSE, DAMAGE, WEIGHT),
                        testCharacters,
                        new Knight(ENEMY_NAME, turns, LIFE, DEFENSE),
                        new Enemy("test goblin", turns, LIFE, DEFENSE, DAMAGE, WEIGHT),
                        new Enemy(ENEMY_NAME, turns, LIFE+1, DEFENSE, DAMAGE, WEIGHT),
                        new Enemy(ENEMY_NAME, turns, LIFE, DEFENSE+1, DAMAGE, WEIGHT),
                        new Enemy(ENEMY_NAME, turns, LIFE, DEFENSE, DAMAGE+1, WEIGHT),
                        new Enemy(ENEMY_NAME, turns, LIFE, DEFENSE, DAMAGE, WEIGHT+1)
      );
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

    Enemy enemy2 = new Enemy(ENEMY_NAME, turns, LIFE, DEFENSE, DAMAGE, WEIGHT);
    Knight player2 = new Knight("Dicky", turns , LIFE , DEFENSE);
    assertTrue(enemy2.alive());
    player2.attack(enemy2);
    assertTrue(enemy2.alive());
  }

  @Test
  public void aliveAttackTest() {
    Enemy enemy = testCharacters;
    Enemy enemy2 = new Enemy( "Dead" , turns, 10, DEFENSE, DAMAGE, WEIGHT);
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

  /**
   * Checks that the class toString method works properly.
   */
  @Test
  public void toStringTest(){
    String expectedEnemy = "Name: Goblin,LifePoints: 1000,Defense: 30,Damage: 16,Weight: 10,Class: Enemy";
    assertEquals(expectedEnemy,testCharacters.toString());
  }
}