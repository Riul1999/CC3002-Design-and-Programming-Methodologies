package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import com.github.cc3002.finalreality.model.weapon.WeaponType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {

  private static final String ENEMY_NAME = "Goblin";
  private static final String ENEMY_NAME2 = "Goblin Champion";

  protected BlockingQueue<ICharacter> turns;
  protected List<Enemy> testCharacters;
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
    testCharacters = new ArrayList<>();

    testCharacters.add(new Enemy(ENEMY_NAME, 10, turns));
    testCharacters.add(new Enemy(ENEMY_NAME2, 10, turns));
    testCharacters.add(new Enemy(ENEMY_NAME, 15, turns));
    testCharacters.add(new Enemy(ENEMY_NAME2, 10, turns));
  }

  /**
   * Checks that the character waits the appropriate amount of time for it's turn.
   */
  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    testCharacters.get(0).waitTurn();
    try {
      // Thread.sleep is not accurate so this values may be changed to adjust the
      // acceptable error margin.
      // We're testing that the character waits approximately 1 second.
      Thread.sleep(900);
      Assertions.assertEquals(0, turns.size());
      Thread.sleep(200);
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(testCharacters.get(0), turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * Checks that the equals method works properly.
   * @param expectedCharacter Enemy
   * @param testEqualCharacter Enemy
   * @param sameClassDifferentWeight Enemy
   * @param sameClassDifferentName Enemy
   * @param differentClassCharacter PlayerCharacter
   */
  protected static void checkConstruction(final ICharacter expectedCharacter,
                                   final ICharacter testEqualCharacter,
                                   final ICharacter sameClassDifferentWeight,
                                   final ICharacter sameClassDifferentName,
                                   final ICharacter differentClassCharacter) {
    assertEquals(testEqualCharacter, expectedCharacter);
    assertEquals(testEqualCharacter.hashCode(),expectedCharacter.hashCode());
    assertNotEquals(sameClassDifferentWeight, testEqualCharacter);
    assertNotEquals(sameClassDifferentWeight.hashCode(),testEqualCharacter.hashCode());
    assertNotEquals(sameClassDifferentName,expectedCharacter);
    assertNotEquals(sameClassDifferentName.hashCode(),expectedCharacter.hashCode());
    assertNotEquals(testEqualCharacter, differentClassCharacter);
    assertNotEquals(differentClassCharacter.hashCode(),expectedCharacter.hashCode());
    assertNotEquals(testEqualCharacter.getClass(),differentClassCharacter.getClass());
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    for (var enemy : testCharacters) {
      String name = enemy.getName();
      int weight = enemy.getWeight();
      checkConstruction(new Enemy(name, weight, turns),
              enemy,
              new Enemy(name, weight+1, turns),
              new Enemy("test goblin",weight,turns),
              new PlayerCharacter(name, turns, CharacterClass.THIEF));
    }
  }
}