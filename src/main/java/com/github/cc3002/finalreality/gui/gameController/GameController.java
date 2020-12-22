package com.github.cc3002.finalreality.gui.gameController;

import com.github.cc3002.finalreality.gui.handlers.AliveHandlers.AliveEnemyHandler;
import com.github.cc3002.finalreality.gui.handlers.AliveHandlers.AlivePlayerCharacterHandler;
import com.github.cc3002.finalreality.gui.handlers.EndTurnHandler;
import com.github.cc3002.finalreality.gui.handlers.BeginTurnHandler;
import com.github.cc3002.finalreality.gui.phase.IPhase;
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


import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * A class that controls the development of a game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class GameController {
    private final BufferedReader in;
    private final ArrayList<IPlayerCharacter> playerCharacters = new ArrayList<>();
    private final ArrayList<Enemy> enemies = new ArrayList<>();
    private final ArrayList<IWeapon> weapons = new ArrayList<>();
    private final BlockingQueue<ICharacter> TURNS = new LinkedBlockingQueue<>();
    private boolean endGame;
    private boolean playerWinner;
    private IPhase actPhase;
    private Integer actCharacterIndex;
    private boolean actPlayerCharacter;

    private final AlivePlayerCharacterHandler alivePlayerCharacterHandler;
    private final AliveEnemyHandler aliveEnemyHandler;
    private final EndTurnHandler endTurnHandler;
    private final BeginTurnHandler beginTurnHandler;

    /**
     * Creates a new game, with a list of PlayerCharacters, a list of Enemies and a list of Weapons.
     * This elements can be used to simulate a game.
     */
    public GameController(BufferedReader initIn) throws IOException {
        alivePlayerCharacterHandler = new AlivePlayerCharacterHandler(this);
        aliveEnemyHandler = new AliveEnemyHandler(this);
        endTurnHandler = new EndTurnHandler(this);
        beginTurnHandler = new BeginTurnHandler(this);
        endGame = false;
        playerWinner = false;
        actPhase = new WaitPhase(this);
        actCharacterIndex = -1;
        actPlayerCharacter = false;

        in = initIn;
        initializeGame();
    }

    /**
     * Special constructor to make a artificial game. Used to define test cases.
     * @param info a String with the information about de playerCharacters,enemies and weapons
     */
    public GameController(String info) throws IOException {
        this(new BufferedReader(new StringReader(info)));
    }

    private void initializeGame() throws IOException {
        String item;
        do {
            item = in.readLine();
            if (item == null){
                throw new IOException("end of input");
            }
            String[] features = item.split(";");
            createItem(features);
        } while (!item.equals(""));
    }

    /**
     * This method creates an item (PlayerCharacter,Enemy,Weapon) with the info in features, this method
     * uses the first string in features to determine the class of the created object. The created object
     * is added to the game.
     * @param features a list of Strings which contains the information about the object.
     */
    private void createItem(String[] features) {
        if ("Knight".equals(features[0])) {
            createKnight(features);
        } else if ("Engineer".equals(features[0])) {
            createEngineer(features);
        } else if ("Thief".equals(features[0])) {
            createThief(features);
        } else if ("BlackMage".equals(features[0])) {
            createBlackMage(features);
        } else if ("WhiteMage".equals(features[0])) {
            createWhiteMage(features);
        } else if ("Enemy".equals(features[0])) {
            createEnemy(features);
        } else if ("Axe".equals(features[0])) {
            createAxe(features);
        } else if ("Bow".equals(features[0])) {
            createBow(features);
        } else if ("Knife".equals(features[0])) {
            createKnife(features);
        } else if ("Sword".equals(features[0])) {
            createSword(features);
        } else if ("Staff".equals(features[0])) {
            createStaff(features);
        }
    }

    /**
     * This method creates a Knight whit the information in features
     */
    private void createKnight(String[] features) {
        Knight character = new Knight(features[1],TURNS,Integer.parseInt(features[2]),Integer.parseInt(features[3]));
        addPlayerCharacterToGame(character);
    }


    /**
     * This method creates a Engineer whit the information in features
     */
    private void createEngineer(String[] features) {
        Engineer character = new Engineer(features[1],TURNS,Integer.parseInt(features[2]),Integer.parseInt(features[3]));
        addPlayerCharacterToGame(character);
    }

    /**
     * This method creates a Thief whit the information in features
     */
    private void createThief(String[] features) {
        Thief character = new Thief(features[1],TURNS,Integer.parseInt(features[2]),Integer.parseInt(features[3]));
        addPlayerCharacterToGame(character);
    }

    /**
     * This method creates a WhiteMage whit the information in features
     */
    private void createWhiteMage(String[] features) {
        WhiteMage character = new WhiteMage(features[1],TURNS,Integer.parseInt(features[2]),Integer.parseInt(features[3]),Integer.parseInt(features[4]));
        addPlayerCharacterToGame(character);
    }

    /**
     * This method creates a BlackMage whit the information in features
     */
    private void createBlackMage(String[] features) {
        BlackMage character = new BlackMage(features[1],TURNS,Integer.parseInt(features[2]),Integer.parseInt(features[3]),Integer.parseInt(features[4]));
        addPlayerCharacterToGame(character);
    }

    /**
     * This method creates an Enemy whit the information in features
     */
    private void createEnemy(String[] features) {
        Enemy character = new Enemy(features[1],TURNS,Integer.parseInt(features[2]),Integer.parseInt(features[3]),Integer.parseInt(features[4]),Integer.parseInt(features[5]));
        addEnemyToGame(character);
    }

    /**
     * This method creates an Axe whit the information in features
     */
    private void createAxe(String[] features) {
        Axe weapon = new Axe(features[1],Integer.parseInt(features[2]),Integer.parseInt(features[3]));
        addPWeaponToGame(weapon);
    }

    /**
     * This method creates a Bow whit the information in features
     */
    private void createBow(String[] features) {
        Bow weapon = new Bow(features[1],Integer.parseInt(features[2]),Integer.parseInt(features[3]));
        addPWeaponToGame(weapon);
    }

    /**
     * This method creates a Knife whit the information in features
     */
    private void createKnife(String[] features) {
        Knife weapon = new Knife(features[1],Integer.parseInt(features[2]),Integer.parseInt(features[3]));
        addPWeaponToGame(weapon);
    }

    /**
     * This method creates a Sword whit the information in features
     */
    private void createSword(String[] features) {
        Sword weapon = new Sword(features[1],Integer.parseInt(features[2]),Integer.parseInt(features[3]));
        addPWeaponToGame(weapon);
    }

    /**
     * This method creates a Staff whit the information in features
     */
    private void createStaff(String[] features) {
        Staff weapon = new Staff(features[1],Integer.parseInt(features[2]),Integer.parseInt(features[3]),Integer.parseInt(features[4]));
        addPWeaponToGame(weapon);
    }

    /**
     * This method add a PlayerCharacter to the playerCharacters array and add its Listeners.
     */
    private void addPlayerCharacterToGame(IPlayerCharacter character) {
        playerCharacters.add(character);
        character.addAliveListener(alivePlayerCharacterHandler);
        character.addEndTurnListener(endTurnHandler);
        character.addBeginTurnListener(beginTurnHandler);
    }

    /**
     * This method add an Enemy to the enemies array and add its Listeners.
     */
    private void addEnemyToGame(Enemy character) {
        enemies.add(character);
        character.addAliveListener(aliveEnemyHandler);
        character.addEndTurnListener(endTurnHandler);
        character.addBeginTurnListener(beginTurnHandler);
    }

    /** This method add a Weapon to the weapons array.
     */
    private void addPWeaponToGame(IWeapon weapon) {
        weapons.add(weapon);
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
        TURNS.remove(character);
        playerCharacters.remove(character);
        checkEndByPlayer();
    }

    /**
     * This method removes a defeated Enemy from enemies.
     * This method probably will change later, is only a prototype.
     * @param character an Enemy that has been defeated
     */
    public void eliminateEnemy(Enemy character) {
        TURNS.remove(character);
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
        try {
            actPhase.endTurn();
        } catch (InvalidActionException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is executed when a BeginTurnHandler is alerted, this method change
     * the value of freeTurn to false, to indicate that the a new turn will begin.
     * This method will probably change later, is only a prototype.
     */
    public void beginTurn() {
        try {
            actPhase.beginTurn();
        } catch (InvalidActionException e) {
            e.printStackTrace();
        }
        if (!actPlayerCharacter && actCharacterIndex!= -1){
            Enemy actEnemy = enemies.get(actCharacterIndex);
            Random r = new Random();
            int plyrIndex = r.nextInt(playerCharacters.size());
            IPlayerCharacter plyr = playerCharacters.get(plyrIndex);
            charactersAttack( actEnemy, plyr);
        }
    }

    /**
     * This method returns the value of endGame.
     */
    public boolean getEndGame(){
        return endGame;
    }

    /**
     * This method returns the actual Phase of the controller.
     */
    public IPhase getPhase(){
        return actPhase;
    }

    public void changePhase(IPhase aPhase) {
        this.actPhase = aPhase;
    }

    public Integer getActCharacterIndex(){
        return actCharacterIndex;
    }

    public boolean getActPlayerCharacter(){
        return actPlayerCharacter;
    }

    public void setActPlayerCharacter(ICharacter character) {
        if (playerCharacters.contains(character)){
            actPlayerCharacter = true;
            actCharacterIndex = playerCharacters.indexOf(character);
        } else {
            actPlayerCharacter = false;
            actCharacterIndex = enemies.indexOf(character);
        }
    }

    public void addToTURNS() {
        //if (actPlayerCharacter){
        //    playerCharacters.get(actCharacterIndex).waitTurn();
        //} else {
        //    enemies.get(actCharacterIndex).waitTurn();
        //}
        actCharacterIndex = -1;
        actPlayerCharacter = false;
    }

    public void equipWeaponToActual(Integer weaponPos){
        if (actPlayerCharacter){
            try {
                actPhase.equipWeaponToActual(weaponPos);
            } catch (InvalidActionException e) {
                e.printStackTrace();
            }
        }
    }

    public void actualAttack(Integer attackedPos){
        try {
            actPhase.actualAttack( attackedPos);
        } catch (InvalidActionException e) {
            e.printStackTrace();
        }
    }
}
