package com.github.cc3002.finalreality.gui.gameController;

import com.github.cc3002.finalreality.gui.handlers.AliveHandlers.AliveEnemyHandler;
import com.github.cc3002.finalreality.gui.handlers.AliveHandlers.AlivePlayerCharacterHandler;
import com.github.cc3002.finalreality.gui.handlers.EndTurnHandler;
import com.github.cc3002.finalreality.gui.handlers.BeginTurnHandler;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.commonCharacter.Knight;
import com.github.cc3002.finalreality.model.character.player.magicCharacter.WhiteMage;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.Staff;
import com.github.cc3002.finalreality.model.weapon.Sword;


import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * A class that controls the development of a game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class GameController {
    private final ArrayList<IPlayerCharacter> playerCharacters = new ArrayList<>();
    private final ArrayList<Enemy> enemies = new ArrayList<>();
    private final ArrayList<IWeapon> weapons = new ArrayList<>();
    private final BlockingQueue<ICharacter> TURNS = new LinkedBlockingQueue<>();
    private boolean endGame;
    private boolean playerWinner;
    private boolean freeTurn;

    /**
     * Creates a new game, with a list of PlayerCharacters, a list of Enemies and a list of Weapons.
     * This elements can be used to simulate a game.
     */
    public GameController(){
        AlivePlayerCharacterHandler alivePlayerCharacterHandler = new AlivePlayerCharacterHandler(this);
        AliveEnemyHandler aliveEnemyHandler = new AliveEnemyHandler(this);
        EndTurnHandler endTurnHandler = new EndTurnHandler(this);
        BeginTurnHandler beginTurnHandler = new BeginTurnHandler(this);
        freeTurn = true;
        endGame = false;
        playerWinner = false;

        Knight arthurKing = new Knight("King arthur", TURNS,1000,80);
        playerCharacters.add(arthurKing);
        arthurKing.addAliveListener(alivePlayerCharacterHandler);
        arthurKing.addEndTurnListener(endTurnHandler);
        arthurKing.addBeginTurnListener(beginTurnHandler);
        Enemy commonGoblin = new Enemy("goblin", TURNS,150,10,30,5);
        enemies.add(commonGoblin);
        commonGoblin.addAliveListener(aliveEnemyHandler);
        commonGoblin.addEndTurnListener(endTurnHandler);
        commonGoblin.addBeginTurnListener(beginTurnHandler);
        WhiteMage merlin = new WhiteMage("Merlin", TURNS,600,35,400);
        playerCharacters.add(merlin);
        merlin.addAliveListener(alivePlayerCharacterHandler);
        merlin.addEndTurnListener(endTurnHandler);
        merlin.addBeginTurnListener(beginTurnHandler);
        Enemy archerGoblin = new Enemy("Archer goblin", TURNS,90,10,75,10);
        enemies.add(archerGoblin);
        archerGoblin.addAliveListener(aliveEnemyHandler);
        archerGoblin.addEndTurnListener(endTurnHandler);
        archerGoblin.addBeginTurnListener(beginTurnHandler);
        Enemy goblinChampion = new Enemy("Goblin Champion", TURNS,1500,100,90,30);
        enemies.add(goblinChampion);
        goblinChampion.addAliveListener(aliveEnemyHandler);
        goblinChampion.addEndTurnListener(endTurnHandler);
        goblinChampion.addBeginTurnListener(beginTurnHandler);

        Sword excalibur = new Sword("Excalibur",120,15);
        weapons.add(excalibur);
        Axe titanicHydra = new Axe("Titanic Hydra",200,40);
        weapons.add(titanicHydra);
        Staff chitauri = new Staff("Chitauri",15,25,200);
        weapons.add(chitauri);
    }

    /**
     * Method that returns the BlockingQueue turns fo the game. This method is used in
     * the tests.
     */
    public BlockingQueue<ICharacter> getTURNS(){
        return TURNS;
    }

    /**
     * @param index the position of the wanted PlayerCharacter in the array.
     * @return the PlayerCharacter in the position index of the playerCharacters array.
     */
    public IPlayerCharacter getPlayer(Integer index){
        return playerCharacters.get(index);
    }

    /**
     * @param index the position of the wanted Enemy in the array.
     * @return the Enemy in the position index of the enemies array.
     */
    public Enemy getEnemy(Integer index){
        return enemies.get(index);
    }

    /**
     * @param index the position of the wanted Weapon in the array.
     * @return the Weapon in the position index of the weapons array.
     */
    public IWeapon getWeapon(Integer index){
        return weapons.get(index);
    }

    /**
     * This method equip the IWeapon weapon to the IPlayerCharacter playerCharacter.
     * @param playerCharacter the character which to equip the weapon
     * @param weapon the weapon to equip to the playerCharacter
     */
    public void equipWeapon(IPlayerCharacter playerCharacter, IWeapon weapon){
        playerCharacter.equip(weapon);
    }

    /**
     * This method simulates that the attackerCharacter attacks the attackedCharacter.
     *  @param attackerCharacter the character who attacks.
     * @param attackedCharacter the character who is attacked.
     */
    public void charactersAttack(ICharacter attackerCharacter, ICharacter attackedCharacter){
        attackerCharacter.attack(attackedCharacter);
    }

    /**
     * This method removes a defeated PlayerCharacter from playerCharacters.
     * This method probably will change later, is only a prototype.
     * @param character an IPlayerCharacter that has been defeated
     */
    public void eliminatePlayerCharacter(IPlayerCharacter character) {
        playerCharacters.remove(character);
        checkEndByPlayer();
    }

    /**
     * This method removes a defeated Enemy from enemies.
     * This method probably will change later, is only a prototype.
     * @param character an Enemy that has been defeated
     */
    public void eliminateEnemy(Enemy character) {
        enemies.remove(character);
        checkEndByEnemy();
    }

    /**
     * This method check if the game is ended because all the playerCharacters were defeated.
     * This method update the value of endGame and playerWinner.
     * This method will probably change later, is only a prototype.
     */
    public void checkEndByPlayer() {
        endGame = playerCharacters.isEmpty();
        if (endGame)
            playerWinner = false;
    }

    /**
     * This method check if the game is ended because all the enemies were defeated.
     * This method update the value of endGame and playerWinner.
     * This method will probably change later, is only a prototype.
     */
    public void checkEndByEnemy() {
        endGame = enemies.isEmpty();
        if (endGame)
            playerWinner = true;
    }

    /**
     * This method returns if the playerCharacters wins or not, this value only get sense if
     * the value of endGame is true. This method will probably change later, is only a prototype.
     */
    public boolean getPlayerWinner(){
        return playerWinner;
    }

    /**
     * This method puts all the characters of the game into the queue TURNS, and wait 6 seconds.
     * This method probably will change later, is only a prototype.
     */
    public void waitAllTurns() throws InterruptedException {
        for (ICharacter character:playerCharacters){
            character.waitTurn();
        }
        for (ICharacter character:enemies){
            character.waitTurn();
        }
        Thread.sleep(6000);
    }

    /**
     * This method is executed when a EndTurnHandler is alerted, this method change
     * the value of freeTurn to true, to indicate that the last turn was finished.
     * This method will probably change later, is only a prototype.
     */
    public void endTurn(){
        freeTurn = true;
    }

    /**
     * This method is executed when a BeginTurnHandler is alerted, this method change
     * the value of freeTurn to false, to indicate that the a new turn will begin.
     * This method will probably change later, is only a prototype.
     */
    public void beginTurn() {
        freeTurn = false;
    }

    /**
     * This method returns the value of freeTurn.
     */
    public boolean getFreeTurn(){
        return freeTurn;
    }

    /**
     * This method returns the value of endGame.
     */
    public boolean getEndGame(){
        return endGame;
    }

}
