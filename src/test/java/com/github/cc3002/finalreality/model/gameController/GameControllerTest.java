package com.github.cc3002.finalreality.model.gameController;

import com.github.cc3002.finalreality.controller.gameController.GameController;
import com.github.cc3002.finalreality.controller.gameController.InvalidActionException;
import com.github.cc3002.finalreality.gui.phase.TurnPhase;
import com.github.cc3002.finalreality.gui.phase.WaitPhase;
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


import static org.junit.jupiter.api.Assertions.*;

/**
 * Set of tests for the GameController class.
 *
 * @author Rodrigo Urrea Loyola
 */
public class GameControllerTest {

    private GameController testGame;

    /**
     * Do a basic SetUp for all the tests
     */
    @BeforeEach
    public void setUp() {
        String testKnight = "Knight;King arthur;1000;80\n";
        String testWhiteMage = "WhiteMage;Merlin;600;35;400\n";
        String testGoblin = "Enemy;goblin;150;10;30;5\n";
        String testArcherGoblin = "Enemy;Archer goblin;90;10;75;10\n";
        String testGoblinChampion = "Enemy;Goblin Champion;1500;100;90;30\n";
        String testSword = "Sword;Excalibur;120;15\n";
        String testAxe = "Axe;Titanic Hydra;200;40\n";
        String testStaff = "Staff;Chitauri;15;25;200\n";
        String input = testKnight+testGoblin+testWhiteMage+testArcherGoblin+testGoblinChampion+testSword+testAxe+testStaff+"\n";
        testGame = new GameController();
        testGame.initializeGame(input);
    }

    /**
     * Checks if a GameController is constructed correctly
     */
    @Test
    public void checkConstruction(){
        assertTrue(testGame.getTURNS().isEmpty());
        assertFalse(testGame.getEndGame());
        assertFalse(testGame.getPlayerWinner());
        assertEquals(WaitPhase.class,testGame.getPhase().getClass());
        assertEquals(-1,testGame.getActCharacterIndex());
        assertFalse(testGame.getActPlayerCharacter());
        assertEquals(-1,testGame.getActTarget());
        assertEquals("",testGame.getInfo());
    }

    /**
     * Checks the correct behavior of the initializeGame method.
     */
    @Test
    public void checkInitializeGame() {
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
        GameController newGame = new GameController();
        newGame.initializeGame(input);
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
    public void waitAllTurnsTest() {
        assertTrue(testGame.getTURNS().isEmpty());
        testGame.waitAllTurns();
        assertFalse(testGame.getTURNS().isEmpty());
        assertEquals(5,testGame.getTURNS().size());
    }


    /**
     * Checks the correct behavior of the AliveEnemyHandler ,the method eliminateEnemy and the method checkEndByEnemy
     */
    @Test
    public void eliminateEnemyTest(){
        GameController c = new GameController();
        String testKnight = "Knight;King arthur;1000;80\n";
        String testGoblin = "Enemy;goblin;1500;100;300;5\n";
        String testGoblin2 = "Enemy;goblin;1;0;1;50\n";
        String testSword = "Sword;Excalibur;120;15\n";
        String input = testGoblin+testGoblin2+testKnight+testSword+"\n";
        c.initializeGame(input);

        assertFalse(c.getEndGame());
        c.eliminateEnemy(c.getEnemy(0));

        c.equipWeapon(c.getPlayer(0),c.getWeapon(0));
        c.charactersAttack(c.getPlayer(0),c.getEnemy(1));

        assertTrue(c.getEndGame());
        assertTrue(c.getPlayerWinner());
    }

    /**
     * Checks the correct behavior of the AlivePlayerCharacterHandler, the method eliminatePlayer and the method checkEndByPlayer
     */
    @Test
    public void eliminatePlayerTest(){
        GameController c = new GameController();
        String testKnight = "Knight;King arthur;1000;80\n";
        String testKnight2 = "Knight;King arthur's son;100;10\n";
        String testGoblin = "Enemy;goblin;1500;100;300;5\n";
        String input = testGoblin+testKnight+testKnight2+"\n";
        c.initializeGame(input);

        assertFalse(c.getEndGame());
        c.eliminatePlayerCharacter(c.getPlayer(0));

        c.charactersAttack(c.getEnemy(0),c.getPlayer(1));

        assertTrue(c.getEndGame());
        assertFalse(c.getPlayerWinner());
    }

    /**
     * Checks the correct initialization of the controller phase.
     */
    @Test
    public void checkInitialPhase(){
        assertEquals(WaitPhase.class,testGame.getPhase().getClass());
        assertNotEquals(TurnPhase.class, testGame.getPhase().getClass());
    }

    /**
     *  This method checks that the method beginTurn change the Phase from WaitPhase to TurnPhase, that it throws
     *  an InvalidActionException when the method is called out the WaitPhase, and checks that the actCharacterIndex and
     *  actPlayerCharacter values are correct.
     */
    @Test
    public void checkBeginTurn() {
        String testWhiteMage = "WhiteMage;Merlin;600;35;400\n";
        String testGoblin = "Enemy;goblin;150;15;30;30\n";
        String testEngineer = "Engineer;beauchef's engineer;200;30\n";
        String testAxe = "Axe;Titanic Hydra;200;40\n";
        String testStaff = "Staff;Chitauri;15;25;200\n";
        String input = testGoblin+testEngineer+testWhiteMage+testAxe+testStaff+"\n";
        GameController controller = new GameController();
        controller.initializeGame(input);

        controller.equipWeapon(controller.getPlayer(1), controller.getWeapon(1));
        controller.equipWeapon(controller.getPlayer(0), controller.getWeapon(0));
        controller.waitAllTurns();

        controller.beginTurn();
        assertEquals(1,controller.getActCharacterIndex());
        assertTrue(controller.getActPlayerCharacter());
        assertEquals(controller.getTURNS().peek(),controller.getPlayer(controller.getActCharacterIndex()));
        WhiteMage merlin = new WhiteMage("Merlin", controller.getTURNS(), 600,35,400);
        merlin.equip(new Staff("Chitauri",15,25,200));
        assertEquals(merlin,controller.getPlayer(controller.getActCharacterIndex()));
        assertEquals(TurnPhase.class,controller.getPhase().getClass());

        boolean val = false;
        try {
            controller.getPhase().beginTurn();
        }catch (InvalidActionException e){
            val = true;
        }
        assertTrue(val);

        controller.charactersAttack(controller.getPlayer(1), controller.getEnemy(0) );

        assertEquals(0,controller.getActCharacterIndex());
        assertFalse(controller.getActPlayerCharacter());
        assertEquals(controller.getTURNS().peek(),controller.getEnemy(controller.getActCharacterIndex()));
        assertTrue(controller.getActTarget() != -1);
        Enemy goblin = new Enemy("goblin", controller.getTURNS(), 150,15,30,30);
        assertEquals(goblin, controller.getEnemy(controller.getActCharacterIndex()));
        assertEquals(TurnPhase.class, controller.getPhase().getClass());
    }

    /**
     * This method checks the correct behavior of the changePhase method.
     */
    @Test
    public void checkChangePhase(){
        assertEquals(WaitPhase.class,testGame.getPhase().getClass());
        testGame.changePhase( new TurnPhase(testGame));
        assertEquals(TurnPhase.class,testGame.getPhase().getClass());
    }

    /**
     * This method checks the correct behavior of the setActualPlayerCharacter method.
     */
    @Test
    public void checkSetActPlayerCharacter(){
        testGame.setActPlayerCharacter(testGame.getPlayer(0));
        assertTrue(testGame.getActPlayerCharacter());
        assertEquals(0,testGame.getActCharacterIndex());

        testGame.setActPlayerCharacter(testGame.getEnemy(0));
        assertFalse(testGame.getActPlayerCharacter());
        assertEquals(0,testGame.getActCharacterIndex());
    }

    /**
     * This method checks the correct behavior of the resetTurn method.
     */
    @Test
    public void checksResetTurn(){
        testGame.setActPlayerCharacter(testGame.getPlayer(0));
        testGame.resetTurn();
        assertEquals(-1,testGame.getActCharacterIndex());
        assertFalse(testGame.getActPlayerCharacter());
        assertEquals(-1,testGame.getActTarget());
    }

    /**
     * This method checks if the method equipWeapon doesn't change the current state, and
     * that it throws the InvalidActionException Exception when the method is called out the TurnPhase.
     */
    @Test
    public void checkEquipWeapon() {
        String testWhiteMage = "WhiteMage;Merlin;600;35;400\n";
        String testGoblin = "Enemy;goblin;150;10;30;30\n";
        String testStaff = "Staff;Chitauri;15;25;200\n";
        String testStaff2 = "Staff;Gandalf's Staff;20;40;250\n";
        String input = testGoblin+testWhiteMage+testStaff+testStaff2+"\n";
        GameController controller = new GameController();
        controller.initializeGame(input);

        boolean val = false;
        try {
            controller.getPhase().equipWeaponToActual(0);
        } catch (InvalidActionException e){
            val = true;
        }
        assertTrue(val);
        controller.beginTurn();
        assertEquals(TurnPhase.class,controller.getPhase().getClass());
        controller.equipWeaponToActual(0);
        assertEquals(TurnPhase.class,controller.getPhase().getClass());
        controller.equipWeaponToActual(1);
        assertEquals(TurnPhase.class,controller.getPhase().getClass());
    }

    /**
     * This method checks the correct behavior of the setActTarget method.
     */
    @Test
    public void checkSetActTarget(){
        assertEquals(-1,testGame.getActTarget());
        testGame.setActTarget(0);
        assertEquals(0,testGame.getActTarget());
    }

    /**
     * This method checks that the method actualAttack change the phase from TurnPhase to WaitPhase, and
     * that it throws the InvalidActionException Exception when the method is called out the TurnPhase.
     */
    @Test
    public void checkAttack() throws InterruptedException {
        String testWhiteMage = "WhiteMage;Merlin;600;35;400\n";
        String testGoblin = "Enemy;goblin;150;10;60;30\n";
        String testStaff = "Staff;Chitauri;15;25;100\n";
        String input = testGoblin+testWhiteMage+testStaff+"\n";
        GameController controller = new GameController();
        controller.initializeGame(input);

        boolean val = false;
        try {
            controller.getPhase().actualAttack(0);
        }catch (InvalidActionException e){
            val = true;
        }
        assertTrue(val);

        controller.getPlayer(0).waitTurn();
        Thread.sleep(6000);
        controller.beginTurn();
        assertEquals(TurnPhase.class,controller.getPhase().getClass());
        controller.equipWeaponToActual(0);
        controller.setActTarget(0);
        controller.actualAttack();
        assertEquals(WaitPhase.class,controller.getPhase().getClass());
        assertTrue(controller.getEnemy(0).getLifePoints() < 150);

        controller.getEnemy(0).waitTurn();
        Thread.sleep(6000);
        controller.beginTurn();
        assertEquals(TurnPhase.class,controller.getPhase().getClass());
        controller.actualAttack();
        assertEquals(WaitPhase.class,controller.getPhase().getClass());
        assertTrue(controller.getPlayer(0).getLifePoints() < 600);
    }

    /**
     * Checks the correct behavior of the getAlivePlayer method.
     */
    @Test
    public void checkGetAlivePlayer(){
        assertEquals(testGame.getPlayer(0),testGame.getAlivePlayer(0));
        testGame.eliminatePlayerCharacter(testGame.getPlayer(0));
        assertEquals(testGame.getPlayer(1),testGame.getAlivePlayer(0));
    }

    /**
     * Checks the correct behavior of the getStringOfPlayer method.
     */
    @Test
    public void checkGetStringOfPlayer(){
        String player1 = "Name: King arthur"+"\n"+
                "HP: 1000"+"\n"+"DF: 80"+ "\n"+
                "W.N.: Hand"+"\n"+"W.D.: 1"+ "\n"+
                "W.W.: 10";
        String player2 = "Name: Merlin"+"\n"+
                "HP: 600"+"\n"+"DF: 35"+ "\n"+
                "W.N.: Hand"+"\n"+"W.D.: 1"+ "\n"+
                "W.W.: 10";
        assertEquals(player1,testGame.getStringOfPlayer(0));
        assertEquals(player2,testGame.getStringOfPlayer(1));
    }

    /**
     * Checks the correct behavior of the getStringOfEnemy method.
     */
    @Test
    public void checkGetStringOfEnemy(){
        String enemy1 = "Name: goblin"+"\n"+
                "HP: 150"+"\n"+"DF: 10"+ "\n"+
                "DMG: 30"+"\n"+"WGT: 5";
        String enemy2 = "Name: Archer goblin"+"\n"+
                "HP: 90"+"\n"+"DF: 10"+ "\n"+
                "DMG: 75"+"\n"+"WGT: 10";
        assertEquals(enemy1,testGame.getStringOfEnemy(0));
        assertEquals(enemy2,testGame.getStringOfEnemy(1));
    }

    /**
     * Checks the correct behavior of the getStringOfWeapon method.
     */
    @Test
    public void checkGetStringOfWeapon(){
        String weapon1 = "Name: Excalibur"+"\n"+
                "DMG: 120"+"\n"+"WGT: 15";
        String weapon2 = "Name: Titanic Hydra"+"\n"+
                "DMG: 200"+"\n"+"WGT: 40";
        assertEquals(weapon1,testGame.getStringOfWeapon(0));
        assertEquals(weapon2,testGame.getStringOfWeapon(1));
    }

    /**
     * Checks the correct behavior of the getStringOfPhase method.
     */
    @Test
    public void checkStringOfPhase(){
        assertEquals("WaitPhase",testGame.getStringOfPhase());

        testGame.changePhase( new TurnPhase(testGame));
        testGame.setActPlayerCharacter(testGame.getPlayer(0));
        assertEquals("Player Turn",testGame.getStringOfPhase());
        testGame.setActPlayerCharacter(testGame.getEnemy(0));
        assertEquals("Enemy Turn",testGame.getStringOfPhase());
    }

    /**
     * Checks the correct behavior of the resetInfo method.
     */
    @Test
    public void checkResetInfo(){
        assertEquals("",testGame.getInfo());
        testGame.actualAttack();
        assertNotEquals("",testGame.getInfo());
        testGame.resetInfo();
        assertEquals("",testGame.getInfo());
    }

    @Test
    public void checkBeginRound(){
        assertEquals(WaitPhase.class,testGame.getPhase().getClass());
        assertTrue(testGame.getTURNS().isEmpty());
        testGame.beginRound();
        assertFalse(testGame.getTURNS().isEmpty());
        assertEquals(TurnPhase.class,testGame.getPhase().getClass());
    }
}
