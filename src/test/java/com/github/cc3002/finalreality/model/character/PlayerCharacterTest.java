package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.github.cc3002.finalreality.model.character.player.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Set of tests for the {@code GameCharacter} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 * @see PlayerCharacter
 */
class PlayerCharacterTest{

  private static final String BLACK_MAGE_NAME = "Vivi";
  private static final String KNIGHT_NAME = "Adelbert";
  private static final String WHITE_MAGE_NAME = "Eiko";
  private static final String ENGINEER_NAME = "Cid";
  private static final String THIEF_NAME = "Zidane";
  private static int LIFE = 1000;
  private static int DEFENSE = 30;
  private static Integer MANA = 200;

  protected BlockingQueue<ICharacter> turns;
  protected List<PlayerCharacter> testCharacters;
  protected WhiteMage whiteMage;
  protected BlackMage blackMage;
  protected Weapon testWeapon;

  /**
   * Setup method.
   * Creates a turn queue and a test weapon.
   * Creates 5 new characters (each of different classes) and links it to a turn queue.
   */
  @BeforeEach
  void setUp() {
    turns = new LinkedBlockingQueue<>();
    testWeapon = new Axe("Test", 15, 10);
    testCharacters = new ArrayList<>();

    blackMage = new BlackMage(BLACK_MAGE_NAME,turns,LIFE,DEFENSE,MANA);
    whiteMage = new WhiteMage(WHITE_MAGE_NAME,turns,LIFE,DEFENSE,MANA);
    testCharacters.add(new Engineer(ENGINEER_NAME,turns,LIFE,DEFENSE));
    testCharacters.add(new Knight(KNIGHT_NAME,turns,LIFE,DEFENSE));
    testCharacters.add(new Thief(THIEF_NAME,turns,LIFE,DEFENSE));
  }

  /**
   * Checks that the character waits the appropriate amount of time for it's turn.
   */
  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    testCharacters.get(0).equip(testWeapon);
    testCharacters.get(0).waitTurn();
    try {
      // Thread.sleep is not accurate so this values may be changed to adjust the
      // acceptable error margin.
      // We're testing that the character waits approximately 1 second.
      Thread.sleep(700);
      Assertions.assertEquals(0, turns.size());
      Thread.sleep(500);
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(testCharacters.get(0), turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * Checks that the equals method works properly.
   * @param expectedCharacter Same PlayerCharacter
   * @param testEqualCharacter Test PlayerCharacter
   * @param sameClassDifferentName Different name PlayerCharacter
   * @param differentClassCharacter Different class PlayerCharacter
   * @param differentLifePoints Different life points PlayerCharacter
   * @param differentDefense  Different defense PlayerCharacter
   * @param enemy Enemy different object Enemy
   */
  protected void checkConstruction(final ICharacter expectedCharacter,
                                   final ICharacter testEqualCharacter,
                                   final ICharacter sameClassDifferentName,
                                   final ICharacter differentClassCharacter,
                                   final ICharacter differentLifePoints,
                                   final ICharacter differentDefense,
                                   final ICharacter enemy) {
    assertEquals(expectedCharacter, testEqualCharacter);
    assertEquals(expectedCharacter.hashCode(),testEqualCharacter.hashCode());
    assertNotEquals(testEqualCharacter,sameClassDifferentName);
    assertNotEquals(testEqualCharacter.hashCode(),sameClassDifferentName.hashCode());
    assertNotEquals(testEqualCharacter, differentClassCharacter);
    assertNotEquals(testEqualCharacter.hashCode(),differentClassCharacter.hashCode());
    assertNotEquals(testEqualCharacter, differentLifePoints);
    assertNotEquals(testEqualCharacter.hashCode(),differentLifePoints.hashCode());
    assertNotEquals(testEqualCharacter, differentDefense);
    assertNotEquals(testEqualCharacter.hashCode(),differentDefense.hashCode());
    assertNotEquals(testEqualCharacter, enemy);
    assertNotEquals(testEqualCharacter.hashCode(),enemy.hashCode());
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var enemy = new Enemy("Enemy", 10, turns, LIFE, DEFENSE, 10);
    for (var character :
        testCharacters) {
      var characterClass = character.getCharacterClass();
      var characterName = character.getName();
      checkConstruction(new PlayerCharacter(characterName, turns, characterClass, LIFE, DEFENSE),
              character,
              new PlayerCharacter("Test", turns, characterClass, LIFE, DEFENSE),
              new PlayerCharacter(characterName, turns,
                characterClass == CharacterClass.THIEF ? CharacterClass.BLACK_MAGE : CharacterClass.THIEF,LIFE,DEFENSE),
              new PlayerCharacter(characterName, turns, characterClass, LIFE+1, DEFENSE),
              new PlayerCharacter(characterName,turns,characterClass,LIFE,DEFENSE+1),
              enemy);
    }
    checkConstruction(new BlackMage(BLACK_MAGE_NAME, turns, LIFE, DEFENSE, MANA),
            blackMage,
            new BlackMage("Test", turns, LIFE, DEFENSE, MANA),
            new WhiteMage(BLACK_MAGE_NAME, turns, LIFE, DEFENSE, MANA),
            new BlackMage(BLACK_MAGE_NAME, turns, LIFE + 1, DEFENSE, MANA),
            new BlackMage(BLACK_MAGE_NAME, turns, LIFE, DEFENSE + 1, MANA),
            enemy);
    assertEquals(blackMage,blackMage);
    assertNotEquals(blackMage,new BlackMage(BLACK_MAGE_NAME,turns,LIFE,DEFENSE,MANA+1));
    assertNotEquals(blackMage.hashCode(),new BlackMage(BLACK_MAGE_NAME,turns,LIFE,DEFENSE,MANA+1).hashCode());

    checkConstruction(new WhiteMage(WHITE_MAGE_NAME,turns,LIFE,DEFENSE,MANA),
            whiteMage,
            new WhiteMage("Test", turns, LIFE, DEFENSE, MANA),
            new BlackMage(WHITE_MAGE_NAME, turns, LIFE, DEFENSE, MANA),
            new WhiteMage(WHITE_MAGE_NAME,turns,LIFE+1,DEFENSE,MANA),
            new WhiteMage(WHITE_MAGE_NAME,turns,LIFE,DEFENSE+1,MANA),
            enemy);
    assertEquals(whiteMage,whiteMage);
    assertNotEquals(whiteMage,new WhiteMage(WHITE_MAGE_NAME,turns,LIFE,DEFENSE,MANA+1));
    assertNotEquals(whiteMage.hashCode(),new WhiteMage(WHITE_MAGE_NAME,turns,LIFE,DEFENSE,MANA+1).hashCode());
  }

  /**
   * Checks that the equip and getEquippedWeapon works properly.
   */
  @Test
  void equipWeaponTest() {
    PlayerCharacter engineer = testCharacters.get(0);
    PlayerCharacter knight = testCharacters.get(1);
    PlayerCharacter thief = testCharacters.get(2);

    Weapon axe = new Axe("War Axe", 10,15);
    Weapon bow = new Bow("War Bow", 10,15);
    Weapon staff = new Staff("War Staff", 10,15,15);
    Weapon sword = new Sword("War Sword", 10,15);
    Weapon knife = new Knife("War Knife", 10,15);

    assertEquals(WeaponType.NULLWEAPON,blackMage.getEquippedWeapon().getType());
    blackMage.equip(testWeapon);
    assertEquals(WeaponType.NULLWEAPON,whiteMage.getEquippedWeapon().getType());
    whiteMage.equip(testWeapon);
    assertEquals(WeaponType.NULLWEAPON,engineer.getEquippedWeapon().getType());
    engineer.equip(testWeapon);
    assertEquals(WeaponType.NULLWEAPON,knight.getEquippedWeapon().getType());
    knight.equip(testWeapon);
    assertEquals(WeaponType.NULLWEAPON,thief.getEquippedWeapon().getType());
    thief.equip(testWeapon);

    blackMage.equip(axe);
    assertNotEquals(blackMage.getEquippedWeapon(),axe);
    whiteMage.equip(axe);
    assertNotEquals(whiteMage.getEquippedWeapon(),axe);
    engineer.equip(axe);
    assertEquals(engineer.getEquippedWeapon(),axe);
    knight.equip(axe);
    assertEquals(knight.getEquippedWeapon(),axe);
    thief.equip(axe);
    assertNotEquals(thief.getEquippedWeapon(),axe);

    blackMage.equip(bow);
    assertNotEquals(blackMage.getEquippedWeapon(),bow);
    whiteMage.equip(bow);
    assertNotEquals(whiteMage.getEquippedWeapon(),bow);
    engineer.equip(bow);
    assertEquals(engineer.getEquippedWeapon(),bow);
    knight.equip(bow);
    assertNotEquals(knight.getEquippedWeapon(),bow);
    thief.equip(bow);
    assertEquals(thief.getEquippedWeapon(),bow);

    blackMage.equip(staff);
    assertEquals(blackMage.getEquippedWeapon(),staff);
    whiteMage.equip(staff);
    assertEquals(whiteMage.getEquippedWeapon(),staff);
    engineer.equip(staff);
    assertNotEquals(engineer.getEquippedWeapon(),staff);
    knight.equip(staff);
    assertNotEquals(knight.getEquippedWeapon(),staff);
    thief.equip(staff);
    assertEquals(thief.getEquippedWeapon(),staff);

    blackMage.equip(sword);
    assertNotEquals(blackMage.getEquippedWeapon(),sword);
    whiteMage.equip(sword);
    assertNotEquals(whiteMage.getEquippedWeapon(),sword);
    engineer.equip(sword);
    assertNotEquals(engineer.getEquippedWeapon(),sword);
    knight.equip(sword);
    assertEquals(knight.getEquippedWeapon(),sword);
    thief.equip(sword);
    assertEquals(thief.getEquippedWeapon(),sword);

    blackMage.equip(knife);
    assertEquals(blackMage.getEquippedWeapon(),knife);
    whiteMage.equip(knife);
    assertNotEquals(whiteMage.getEquippedWeapon(),knife);
    engineer.equip(knife);
    assertNotEquals(engineer.getEquippedWeapon(),knife);
    knight.equip(knife);
    assertEquals(knight.getEquippedWeapon(),knife);
    thief.equip(knife);
    assertNotEquals(thief.getEquippedWeapon(),knife);
  }
}
