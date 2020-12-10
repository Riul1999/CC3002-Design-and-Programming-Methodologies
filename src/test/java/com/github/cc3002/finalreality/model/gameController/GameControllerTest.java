package com.github.cc3002.finalreality.model.gameController;

import com.github.cc3002.finalreality.gui.gameController.GameController;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.commonCharacter.Engineer;
import com.github.cc3002.finalreality.model.character.player.commonCharacter.Knight;
import com.github.cc3002.finalreality.model.character.player.commonCharacter.Thief;
import com.github.cc3002.finalreality.model.character.player.magicCharacter.BlackMage;
import com.github.cc3002.finalreality.model.character.player.magicCharacter.WhiteMage;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Set of tests for the GameController class.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class GameControllerTest {

    private GameController testGame;

    /**
     * Do a basic SetUp for all the tests
     */
    @BeforeEach
    public void setUp() throws IOException {
        String testKnight = "Knight;King arthur;1000;80\n";
        String testWhiteMage = "WhiteMage;Merlin;600;35;400\n";
        String testGoblin = "Enemy;goblin;150;10;30;5\n";
        String testArcherGoblin = "Enemy;Archer goblin;90;10;75;10\n";
        String testGoblinChampion = "Enemy;Goblin Champion;1500;100;90;30\n";
        String testSword = "Sword;Excalibur;120;15\n";
        String testAxe = "Axe;Titanic Hydra;200;40\n";
        String testStaff = "Staff;Chitauri;15;25;200\n";
        String input = testKnight+testGoblin+testWhiteMage+testArcherGoblin+testGoblinChampion+testSword+testAxe+testStaff+"\n";
        testGame = new GameController(input);
    }

    /**
     * Checks if a GameController is constructed correctly
     */
    @Test
    public void checkConstruction(){
        assertTrue(testGame.getTURNS().isEmpty());
        assertTrue(testGame.getFreeTurn());
        assertFalse(testGame.getEndGame());
        assertFalse(testGame.getPlayerWinner());
    }

    /**
     * Checks the correct beavior of the initializeGame method.
     */
    @Test
    public void checkInitializeGame() throws IOException {
        String testKnight = "Knight;King arthur;1000;80\n";
        String testEngineer = "Engineer;beauchef's engineer;200;30\n";
        String testThief = "Thief;Bank Thief;100;10\n";
        String testWhiteMage = "WhiteMage;Merlin;600;35;400\n";
        String testBlackMage = "BlackMage;DarkMerlin;600;35;400\n";
        String testGoblin = "Enemy;goblin;150;10;30;5\n";
        String testAxe = "Axe;Titanic Hydra;200;40\n";
        String testBow = "Bow;Ashe's bow;200;10\n";
        String testKnife = "Knife;Chef's Knife;50;15\n";
        String testSword = "Sword;Excalibur;120;15\n";
        String testStaff = "Staff;Chitauri;15;25;200\n";
        String input = testKnight+testEngineer+testThief+testWhiteMage+testBlackMage+testGoblin+testAxe+testBow+testKnife+testSword+testStaff+"\n";
        GameController newGame = new GameController(input);
        assertEquals(new Knight("King arthur", newGame.getTURNS(), 1000,80),newGame.getPlayer(0));
        assertEquals(new Engineer("beauchef's engineer", newGame.getTURNS(), 200,30),newGame.getPlayer(1));
        assertEquals(new Thief("Bank Thief", newGame.getTURNS(), 100,10),newGame.getPlayer(2));
        assertEquals(new WhiteMage("Merlin", newGame.getTURNS(), 600,35,400),newGame.getPlayer(3));
        assertEquals(new BlackMage("DarkMerlin", newGame.getTURNS(), 600,35,400),newGame.getPlayer(4));
        assertEquals(new Enemy("goblin", newGame.getTURNS(), 150,10,30,5),newGame.getEnemy(0));
        assertEquals(new Axe("Titanic Hydra",200,40),newGame.getWeapon(0));
        assertEquals(new Bow("Ashe's bow",200,10),newGame.getWeapon(1));
        assertEquals(new Knife("Chef's Knife",50,15),newGame.getWeapon(2));
        assertEquals(new Sword("Excalibur",120,15),newGame.getWeapon(3));
        assertEquals(new Staff("Chitauri",15,25,200),newGame.getWeapon(4));
    }
    /**
     * Checks the correct behavior of the method getPlayer
     */
    @Test
    public void getPlayerTest(){
        IPlayerCharacter expectedPlayerCharacter = new WhiteMage("Merlin", testGame.getTURNS(),600,35,400);
        assertEquals(expectedPlayerCharacter,testGame.getPlayer(1));
    }

    /**
     * Checks the correct behavior of the method getEnemy
     */
    @Test
    public void getEnemyTest(){
        Enemy expectedEnemy = new Enemy("Goblin Champion", testGame.getTURNS(), 1500,100,90,30);
        assertEquals(expectedEnemy,testGame.getEnemy(2));
    }

    /**
     * Checks the correct behavior of the method getWeapon
     */
    @Test
    public void  getWeaponTest(){
        IWeapon expectedWeapon = new Sword("Excalibur",120,15);
        assertEquals(expectedWeapon,testGame.getWeapon(0));
    }

    /**
     * Checks the correct behavior of the method equipWeapon
     */
    @Test
    public void  equipWeaponTest(){
        IWeapon expectedEquippedWeapon = new Axe("Titanic Hydra",200,40);
        assertNotEquals(expectedEquippedWeapon,testGame.getPlayer(0).getEquippedWeapon());
        testGame.equipWeapon(testGame.getPlayer(0),testGame.getWeapon(1));
        assertEquals(expectedEquippedWeapon,testGame.getPlayer(0).getEquippedWeapon());
    }

    /**
     * Checks the correct behavior of the method charactersAttack
     */
    @Test
    public void charactersAttackTest(){
        ICharacter attacker = testGame.getPlayer(0);
        ICharacter attacked = testGame.getEnemy(0);
        Integer expectedLife = attacked.getLifePoints() - (attacker.getDamage()-attacked.getDefense());
        testGame.charactersAttack(attacker,attacked);
        assertEquals(expectedLife,attacked.getLifePoints());
    }

    /**
     * Checks if the method waitAllTurns put all the characters on the queue TURNS
     */
    @Test
    public void waitAllTurnsTest() throws InterruptedException {
        assertTrue(testGame.getTURNS().isEmpty());
        testGame.waitAllTurns();
        assertFalse(testGame.getTURNS().isEmpty());
        assertEquals(5,testGame.getTURNS().size());
    }

    /**
     * Checks the correct behavior of the BeginTurnHandler and the method beginTurn
     */
    @Test
    public void beginTurnTest() throws InterruptedException {
        testGame.waitAllTurns();
        ICharacter character = testGame.getTURNS().poll();
        testGame.charactersAttack(character, testGame.getEnemy(1));
        assertFalse(testGame.getFreeTurn());
    }

    /**
     * Checks the correct behavior of the EndTurnHandler and the method endTurn
     */
    @Test
    public void endTurnTest() throws InterruptedException {
        testGame.waitAllTurns();
        while (!testGame.getTURNS().isEmpty()){
            ICharacter character = testGame.getTURNS().poll();
            testGame.charactersAttack(character, testGame.getEnemy(2));
        }
        assertTrue(testGame.getFreeTurn());
    }

    /**
     * Checks the correct behavior of the AliveEnemyHandler ,the method eliminateEnemy and the method checkEndByEnemy
     */
    @Test
    public void eliminateEnemyTest(){
        testGame.eliminateEnemy(testGame.getEnemy(0));
        testGame.eliminateEnemy(testGame.getEnemy(1));

        IPlayerCharacter player = testGame.getPlayer(0);
        testGame.equipWeapon(player,testGame.getWeapon(0));
        Enemy enemy = testGame.getEnemy(0);
        assertFalse(testGame.getEndGame());
        testGame.charactersAttack(player,enemy);
        assertFalse(enemy.alive());
        assertTrue(testGame.getEndGame());
        assertTrue(testGame.getPlayerWinner());
    }

    /**
     * Checks the correct behavior of the AlivePlayerCharacterHandler, the method eliminatePlayer and the method checkEndByPlayer
     */
    @Test
    public void eliminatePlayerTest(){
        testGame.eliminatePlayerCharacter(testGame.getPlayer(0));

        IPlayerCharacter player = testGame.getPlayer(0);
        Enemy enemy = testGame.getEnemy(2);
        assertFalse(testGame.getEndGame());
        while(player.alive()) {
            testGame.charactersAttack(enemy, player);
        }
        assertTrue(testGame.getEndGame());
        assertFalse(testGame.getPlayerWinner());
    }
}
