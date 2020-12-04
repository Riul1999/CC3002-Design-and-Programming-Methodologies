package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.*;

import java.util.ArrayList;
import java.util.List;

import com.github.cc3002.finalreality.model.character.player.magicCharacter.BlackMage;
import com.github.cc3002.finalreality.model.character.player.commonCharacter.Engineer;
import com.github.cc3002.finalreality.model.character.player.commonCharacter.Knight;
import com.github.cc3002.finalreality.model.character.player.commonCharacter.Thief;
import com.github.cc3002.finalreality.model.character.player.magicCharacter.WhiteMage;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Set of tests for the IPlayerCharacter class.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 * @see AbstractPlayerCharacter
 */
class PlayerCharacterTest extends AbstractCharacterTest{

  private static final String BLACK_MAGE_NAME = "Vivi";
  private static final String KNIGHT_NAME = "Adelbert";
  private static final String WHITE_MAGE_NAME = "Eiko";
  private static final String ENGINEER_NAME = "Cid";
  private static final String THIEF_NAME = "Zidane";
  private static final Integer LIFE = 1000;
  private static final Integer DEFENSE = 30;
  private static final Integer MANA = 200;

  protected List<IPlayerCharacter> testCharacters;
  protected WhiteMage whiteMage;
  protected BlackMage blackMage;

  /**
   * Setup method.
   * Creates a turn queue and a test weapon.
   * Creates 5 new characters (each of different classes) and links it to a turn queue.
   */
  @BeforeEach
  void setUp() {
    abstractCharacterBasicSetUp();
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
    abstractCharacterWaitTurn(testCharacters.get(0));
  }

  /**
   * Checks that the equals method works properly.
   * @param expectedCharacter Same PlayerCharacter
   * @param testEqualCharacter Test PlayerCharacter
   * @param differentClassCharacter Enemy different object Enemy
   * @param differentName Different name PlayerCharacter
   * @param differentLifePoints Different life points PlayerCharacter
   * @param differentDefense  Different defense PlayerCharacter
   * @param differentTypePlayerCharacter Different class PlayerCharacter
   */
  protected void checkConstruction(final IPlayerCharacter expectedCharacter,
                                   final IPlayerCharacter testEqualCharacter,
                                   final ICharacter differentClassCharacter,
                                   final IPlayerCharacter differentName,
                                   final IPlayerCharacter differentLifePoints,
                                   final IPlayerCharacter differentDefense,
                                   final IPlayerCharacter differentTypePlayerCharacter,
                                   final IPlayerCharacter differentWeapon) {

    abstractCharacterCheckConstruction(expectedCharacter,
                                       testEqualCharacter,
                                       differentClassCharacter,
                                       differentName,
                                       differentLifePoints,
                                       differentDefense);

    assertNotEquals(testEqualCharacter, differentTypePlayerCharacter);
    assertNotEquals(testEqualCharacter.hashCode(), differentTypePlayerCharacter.hashCode());

    assertNotEquals(testEqualCharacter, differentWeapon);
    assertNotEquals(testEqualCharacter.hashCode(), differentWeapon.hashCode());

  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    Engineer armedEngineer = new Engineer(ENGINEER_NAME, turns, LIFE, DEFENSE);
    armedEngineer.equip(new Axe("Test Axe",10,15));
    Enemy enemy = new Enemy("Enemy", turns, LIFE, DEFENSE, 10, 10);
    checkConstruction(new Engineer(ENGINEER_NAME, turns, LIFE, DEFENSE),
                      testCharacters.get(0),
                      enemy,
                      new Engineer("Test", turns, LIFE, DEFENSE),
                      new Engineer(ENGINEER_NAME, turns, LIFE+1, DEFENSE),
                      new Engineer(ENGINEER_NAME,turns, LIFE,DEFENSE+1),
                      new Knight(ENGINEER_NAME, turns, LIFE,DEFENSE),
                      armedEngineer);

    Knight armedKnight = new Knight(KNIGHT_NAME, turns, LIFE, DEFENSE);
    armedKnight.equip(new Axe("Test Axe",10,15));
    checkConstruction(new Knight(KNIGHT_NAME, turns, LIFE, DEFENSE),
              testCharacters.get(1),
            enemy, new Knight("Test", turns, LIFE, DEFENSE),
            new Knight(KNIGHT_NAME, turns, LIFE+1, DEFENSE), new Knight(KNIGHT_NAME,turns, LIFE,DEFENSE+1), new Engineer(KNIGHT_NAME, turns, LIFE,DEFENSE),
            armedKnight
    );

    Thief armedThief = new Thief(THIEF_NAME, turns, LIFE, DEFENSE);
    armedThief.equip(new Sword("Test Sword",10,15));
    checkConstruction(new Thief(THIEF_NAME, turns, LIFE, DEFENSE),
            testCharacters.get(2),
            enemy, new Thief("Test", turns, LIFE, DEFENSE),
            new Thief(THIEF_NAME, turns, LIFE+1, DEFENSE), new Thief(THIEF_NAME,turns, LIFE,DEFENSE+1), new Engineer(THIEF_NAME, turns, LIFE,DEFENSE),
            armedThief
    );

    BlackMage armedBlackMage = new BlackMage(ENGINEER_NAME, turns, LIFE, DEFENSE,MANA);
    armedBlackMage.equip(new Knife("Test Axe",10,15));
    checkConstruction(new BlackMage(BLACK_MAGE_NAME, turns, LIFE, DEFENSE, MANA),
            blackMage,
            enemy, new BlackMage("Test", turns, LIFE, DEFENSE, MANA),
            new BlackMage(BLACK_MAGE_NAME, turns, LIFE + 1, DEFENSE, MANA), new BlackMage(BLACK_MAGE_NAME, turns, LIFE, DEFENSE + 1, MANA), new WhiteMage(BLACK_MAGE_NAME, turns, LIFE, DEFENSE, MANA),
            armedBlackMage
    );
    assertEquals(blackMage,blackMage);
    assertNotEquals(blackMage,new BlackMage(BLACK_MAGE_NAME,turns,LIFE,DEFENSE,MANA+1));
    assertNotEquals(blackMage.hashCode(),new BlackMage(BLACK_MAGE_NAME,turns,LIFE,DEFENSE,MANA+1).hashCode());

    WhiteMage armedWhiteMage = new WhiteMage(ENGINEER_NAME, turns, LIFE, DEFENSE,MANA);
    armedWhiteMage.equip(new Staff("Test Axe",10,15,100));
    checkConstruction(new WhiteMage(WHITE_MAGE_NAME,turns,LIFE,DEFENSE,MANA),
            whiteMage,
            enemy, new WhiteMage("Test", turns, LIFE, DEFENSE, MANA),
            new WhiteMage(WHITE_MAGE_NAME,turns,LIFE+1,DEFENSE,MANA), new WhiteMage(WHITE_MAGE_NAME,turns,LIFE,DEFENSE+1,MANA), new BlackMage(WHITE_MAGE_NAME, turns, LIFE, DEFENSE, MANA),
            armedWhiteMage
    );
    assertEquals(whiteMage,whiteMage);
    assertNotEquals(whiteMage,new WhiteMage(WHITE_MAGE_NAME,turns,LIFE,DEFENSE,MANA+1));
    assertNotEquals(whiteMage.hashCode(),new WhiteMage(WHITE_MAGE_NAME,turns,LIFE,DEFENSE,MANA+1).hashCode());
  }

  /**
   * Checks that the equip and getEquippedWeapon works properly.
   */
  @Test
  void equipWeaponTest() {
    IPlayerCharacter engineer = testCharacters.get(0);
    IPlayerCharacter knight = testCharacters.get(1);
    IPlayerCharacter thief = testCharacters.get(2);

    IWeapon axe = new Axe("War Axe", 10,15);
    IWeapon bow = new Bow("War Bow", 10,15);
    IWeapon staff = new Staff("War Staff", 10,15,15);
    IWeapon sword = new Sword("War Sword", 10,15);
    IWeapon knife = new Knife("War Knife", 10,15);


    assertEquals(new Hand(),blackMage.getEquippedWeapon());
    blackMage.equip(testWeapon);
    assertEquals(new Hand(),whiteMage.getEquippedWeapon());
    whiteMage.equip(testWeapon);
    assertEquals(new Hand(),engineer.getEquippedWeapon());
    engineer.equip(testWeapon);
    assertEquals(new Hand(),knight.getEquippedWeapon());
    knight.equip(testWeapon);
    assertEquals(new Hand(),thief.getEquippedWeapon());
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

  @Test
  public void attackTest(){
    IPlayerCharacter player = testCharacters.get(0);
    Enemy enemy = new Enemy("Enemy", turns, LIFE, DEFENSE, 10, 10);
    assertEquals(LIFE, player.getLifePoints());
    Integer expLifePoints = player.getLifePoints() - (enemy.getDamage() - player.getDefense());
    enemy.attack(player);
    assertEquals(expLifePoints , player.getLifePoints());
  }

  @Test
  public void aliveTest() {
    IPlayerCharacter player = testCharacters.get(0);
    Enemy enemy = new Enemy("Goblin's God", turns, LIFE, DEFENSE, 2000, 10);
    assertTrue(player.alive());
    enemy.attack(player);
    assertFalse(player.alive());

    IPlayerCharacter player2 = testCharacters.get(1);
    Enemy enemy2 = new Enemy("Slime", turns, LIFE, DEFENSE, 0, 10);
    assertTrue(player2.alive());
    enemy2.attack(player2);
    assertTrue(player2.alive());
  }

  @Test
  public void aliveAttackTest() {
    IPlayerCharacter player = testCharacters.get(0);
    IPlayerCharacter player2 = testCharacters.get(1);
    Enemy enemy = new Enemy("Goblin's God", turns, LIFE, DEFENSE, 2000, 10);
    Axe axe = new Axe("Dicky's axe", 100 , 10);
    player.equip(axe);
    player2.equip(axe);
    assertTrue(player.alive());
    assertTrue(player2.alive());
    assertTrue(enemy.alive());
    enemy.attack(player2);
    assertEquals(LIFE,enemy.getLifePoints());
    player2.attack(enemy);
    assertEquals(LIFE,enemy.getLifePoints());
    player.attack(enemy);
    assertNotEquals(LIFE,enemy.getLifePoints());
  }

  @Test
  public void aliveEquipTest() {
    Engineer engineer = (Engineer) testCharacters.get(0);
    Engineer engineer2 = new Engineer(ENGINEER_NAME,turns,LIFE,DEFENSE);
    Knight knight = (Knight) testCharacters.get(1);
    Knight knight2 = new Knight(ENGINEER_NAME,turns,LIFE,DEFENSE);
    Thief thief = (Thief) testCharacters.get(2);
    Thief thief2 = new Thief(ENGINEER_NAME,turns,LIFE,DEFENSE);
    WhiteMage whiteWizard = whiteMage;
    WhiteMage whiteWizard2 = new WhiteMage(WHITE_MAGE_NAME,turns,LIFE,DEFENSE,MANA);
    BlackMage blackWizard = blackMage;
    BlackMage blackWizard2 = new BlackMage(WHITE_MAGE_NAME,turns,LIFE,DEFENSE,MANA);

    Enemy enemy = new Enemy("Goblin's God", turns, LIFE, DEFENSE, 2000, 10);

    IWeapon defaultWeapon = new Hand();
    Axe testAxe = new Axe("Dicky's axe", 100 , 10);
    Sword testSword = new Sword("Dicky's sword", 100 , 10);
    Knife testKnife = new Knife("Dicky's knife", 100 , 10);
    Bow testBow = new Bow("Dicky's bow", 100 , 10);
    Staff testStaff = new Staff("Dicky's staff", 100 , 10 , 100);

    assertTrue(engineer.alive());
    assertTrue(engineer2.alive());
    assertTrue(enemy.alive());
    enemy.attack(engineer2);

    assertEquals(defaultWeapon , engineer2.getEquippedWeapon());
    engineer2.equip(testAxe);
    assertEquals(defaultWeapon , engineer2.getEquippedWeapon());
    assertEquals(defaultWeapon , engineer.getEquippedWeapon());
    engineer.equip(testAxe);
    assertEquals(testAxe,engineer.getEquippedWeapon());

    assertEquals(defaultWeapon , engineer2.getEquippedWeapon());
    engineer2.equip(testBow);
    assertEquals(defaultWeapon , engineer2.getEquippedWeapon());
    assertEquals(testAxe , engineer.getEquippedWeapon());
    engineer.equip(testBow);
    assertEquals(testBow,engineer.getEquippedWeapon());

    assertTrue(knight.alive());
    assertTrue(knight2.alive());
    assertTrue(enemy.alive());
    enemy.attack(knight2);

    assertEquals(defaultWeapon , knight2.getEquippedWeapon());
    knight2.equip(testAxe);
    assertEquals(defaultWeapon , knight2.getEquippedWeapon());
    assertEquals(defaultWeapon , knight.getEquippedWeapon());
    knight.equip(testAxe);
    assertEquals(testAxe,knight.getEquippedWeapon());

    assertEquals(defaultWeapon , knight2.getEquippedWeapon());
    knight2.equip(testSword);
    assertEquals(defaultWeapon , knight2.getEquippedWeapon());
    assertEquals(testAxe , knight.getEquippedWeapon());
    knight.equip(testSword);
    assertEquals(testSword,knight.getEquippedWeapon());

    assertEquals(defaultWeapon , knight2.getEquippedWeapon());
    knight2.equip(testKnife);
    assertEquals(defaultWeapon , knight2.getEquippedWeapon());
    assertEquals(testSword , knight.getEquippedWeapon());
    knight.equip(testKnife);
    assertEquals(testKnife,knight.getEquippedWeapon());

    assertTrue(thief.alive());
    assertTrue(thief2.alive());
    assertTrue(enemy.alive());
    enemy.attack(thief2);

    assertEquals(defaultWeapon , thief2.getEquippedWeapon());
    thief2.equip(testSword);
    assertEquals(defaultWeapon , thief2.getEquippedWeapon());
    assertEquals(defaultWeapon , thief.getEquippedWeapon());
    thief.equip(testSword);
    assertEquals(testSword,thief.getEquippedWeapon());

    assertEquals(defaultWeapon , thief2.getEquippedWeapon());
    thief2.equip(testStaff);
    assertEquals(defaultWeapon , thief2.getEquippedWeapon());
    assertEquals(testSword , thief.getEquippedWeapon());
    thief.equip(testStaff);
    assertEquals(testStaff,thief.getEquippedWeapon());

    assertEquals(defaultWeapon , thief2.getEquippedWeapon());
    thief2.equip(testBow);
    assertEquals(defaultWeapon , thief2.getEquippedWeapon());
    assertEquals(testStaff , thief.getEquippedWeapon());
    thief.equip(testBow);
    assertEquals(testBow,thief.getEquippedWeapon());

    assertTrue(whiteWizard.alive());
    assertTrue(whiteWizard2.alive());
    assertTrue(enemy.alive());
    enemy.attack(whiteWizard2);

    assertEquals(defaultWeapon , whiteWizard2.getEquippedWeapon());
    whiteWizard2.equip(testStaff);
    assertEquals(defaultWeapon , whiteWizard2.getEquippedWeapon());
    assertEquals(defaultWeapon , whiteWizard.getEquippedWeapon());
    whiteWizard.equip(testStaff);
    assertEquals(testStaff,whiteWizard.getEquippedWeapon());

    assertTrue(blackWizard.alive());
    assertTrue(blackWizard2.alive());
    assertTrue(enemy.alive());
    enemy.attack(blackWizard2);

    assertEquals(defaultWeapon , blackWizard2.getEquippedWeapon());
    blackWizard2.equip(testKnife);
    assertEquals(defaultWeapon , blackWizard2.getEquippedWeapon());
    assertEquals(defaultWeapon , blackWizard.getEquippedWeapon());
    blackWizard.equip(testKnife);
    assertEquals(testKnife,blackWizard.getEquippedWeapon());

    assertEquals(defaultWeapon , blackWizard2.getEquippedWeapon());
    blackWizard2.equip(testStaff);
    assertEquals(defaultWeapon , blackWizard2.getEquippedWeapon());
    assertEquals(testKnife , blackWizard.getEquippedWeapon());
    blackWizard.equip(testStaff);
    assertEquals(testStaff,blackWizard.getEquippedWeapon());

  }

  /**
   * Checks that the class toString method works properly.
   */
  @Test
  public void toStringTest() {
    String expectedEngineer = "Name: Cid,LifePoints: 1000,Defense: 30,[Weapon: Name: Hand,Damage: 1,Weight: 10,Class: Hand],Class: Engineer";
    String expectedKnight = "Name: Adelbert,LifePoints: 1000,Defense: 30,[Weapon: Name: Hand,Damage: 1,Weight: 10,Class: Hand],Class: Knight";
    String expectedThief = "Name: Zidane,LifePoints: 1000,Defense: 30,[Weapon: Name: Hand,Damage: 1,Weight: 10,Class: Hand],Class: Thief";
    String expectedWhiteMage = "Name: Eiko,LifePoints: 1000,Defense: 30,[Weapon: Name: Hand,Damage: 1,Weight: 10,Class: Hand],MaxMana: 200,Class: WhiteMage";
    String expectedBlackMage = "Name: Vivi,LifePoints: 1000,Defense: 30,[Weapon: Name: Hand,Damage: 1,Weight: 10,Class: Hand],MaxMana: 200,Class: BlackMage";

    assertEquals(expectedEngineer,testCharacters.get(0).toString());
    assertEquals(expectedKnight,testCharacters.get(1).toString());
    assertEquals(expectedThief,testCharacters.get(2).toString());
    assertEquals(expectedWhiteMage,whiteMage.toString());
    assertEquals(expectedBlackMage,blackMage.toString());
  }
}
