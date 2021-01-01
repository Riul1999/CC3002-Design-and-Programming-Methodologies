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
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * A class that controls the development of a game.
 *
 * @author Rodrigo Urrea Loyola
 */
public class GameController {
    private final ArrayList<IPlayerCharacter> playerCharacters = new ArrayList<>();
    private final ArrayList<IPlayerCharacter> alivePlayerCharacters = new ArrayList<>();
    private final ArrayList<Enemy> enemies = new ArrayList<>();
    private final ArrayList<Enemy> aliveEnemies = new ArrayList<>();
    private final ArrayList<IWeapon> weapons = new ArrayList<>();
    private final BlockingQueue<ICharacter> TURNS = new LinkedBlockingQueue<>();
    private boolean endGame;
    private boolean playerWinner;
    private IPhase actPhase;
    private Integer actCharacterIndex;
    private boolean actPlayerCharacter;
    private Integer actTarget;

    private final AlivePlayerCharacterHandler alivePlayerCharacterHandler;
    private final AliveEnemyHandler aliveEnemyHandler;
    private final EndTurnHandler endTurnHandler;
    private final BeginTurnHandler beginTurnHandler;
    private String info;

    /**
     * Creates a new game, and initialize a lot of parameters that will be used to simulates a game.
     */
    public GameController() {
        alivePlayerCharacterHandler = new AlivePlayerCharacterHandler(this);
        aliveEnemyHandler = new AliveEnemyHandler(this);
        endTurnHandler = new EndTurnHandler(this);
        beginTurnHandler = new BeginTurnHandler(this);
        endGame = false;
        playerWinner = false;
        actPhase = new WaitPhase(this);
        actCharacterIndex = -1;
        actPlayerCharacter = false;
        actTarget = -1;
        info = "";
    }

    /**
     * This method receives the String info, with a codification of the elements of the game (Characters, weapons), and
     * creates its, including its to the GameController.
     * This method must be called before play a game.
     * @param info a String with the codification of the elements of the game.
     */
    public void initializeGame(String info) {
        BufferedReader in = new BufferedReader(new StringReader(info));
        String item = null;
        do {
            try {
                item = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (item == null){
                try {
                    throw new IOException("end of input");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                String[] features = item.split(";");
                createItem(features);
            }
        } while (!Objects.equals(item, ""));
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
        alivePlayerCharacters.add(character);
        character.addAliveListener(alivePlayerCharacterHandler);
        character.addEndTurnListener(endTurnHandler);
        character.addBeginTurnListener(beginTurnHandler);
    }

    /**
     * This method add an Enemy to the enemies array and add its Listeners.
     */
    private void addEnemyToGame(Enemy character) {
        enemies.add(character);
        aliveEnemies.add(character);
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
     * @param character an IPlayerCharacter that has been defeated
     */
    public void eliminatePlayerCharacter(IPlayerCharacter character) {
        TURNS.remove(character);
        alivePlayerCharacters.remove(character);
        checkEndByPlayer();
    }

    /**
     * This method removes a defeated Enemy from enemies.
     * @param character an Enemy that has been defeated
     */
    public void eliminateEnemy(Enemy character) {
        TURNS.remove(character);
        aliveEnemies.remove(character);
        checkEndByEnemy();
    }

    /**
     * This method check if the game is ended because all the playerCharacters were defeated.
     * This method update the value of endGame and playerWinner.
     */
    public void checkEndByPlayer() {
        endGame = alivePlayerCharacters.isEmpty();
        if (endGame)
            playerWinner = false;
    }

    /**
     * This method check if the game is ended because all the enemies were defeated.
     * This method update the value of endGame and playerWinner.
     */
    public void checkEndByEnemy() {
        endGame = aliveEnemies.isEmpty();
        if (endGame)
            playerWinner = true;
    }

    /**
     * This method returns if the playerCharacters wins or not, this value only get sense if
     * the value of endGame is true.
     */
    public boolean getPlayerWinner(){
        return playerWinner;
    }

    /**
     * This method returns the value of endGame.
     */
    public boolean getEndGame(){
        return endGame;
    }

    /**
     * This method puts all the characters of the game into the queue TURNS, and wait 6 seconds.
     */
    public void waitAllTurns() {
        for (ICharacter character:alivePlayerCharacters){
            character.waitTurn();
        }
        for (ICharacter character:aliveEnemies){
            character.waitTurn();
        }
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is executed when a EndTurnHandler is alerted or by the interface.
     * This method call the endTurn method of the actPhase class, if the actPhase isn't
     * TurnPhase it will throw an InvalidActionException.
     */
    public void endTurn(){
        try {
            actPhase.endTurn();
        } catch (InvalidActionException e) {
            info += e.getMessage()+"\n";
        }
    }

    /**
     * This method is executed when a BeginTurnHandler is alerted or by the interface.
     * This method call the beginTurn method of the actPhase class, if the actPhase isn't
     * a WaitPhase it will throw an InvalidActionException.
     * If the new actual Character is an Enemy, this method sets the target index of
     * the Enemy.
     */
    public void beginTurn() {
        try {
            actPhase.beginTurn();
        } catch (InvalidActionException e) {
            info += e.getMessage()+"\n";
        }
        if (!actPlayerCharacter && actCharacterIndex!= -1){
            Random r = new Random();
            int plyrIndex = r.nextInt(alivePlayerCharacters.size());
            setActTarget(plyrIndex);
        }
    }

    /**
     * This method returns the actual Phase of the controller.
     */
    public IPhase getPhase(){
        return actPhase;
    }

    /**
     * This method change the current phase of the gameController.
     * @param aPhase the new phase
     */
    public void changePhase(IPhase aPhase) {
        this.actPhase = aPhase;
    }

    /**
     * This method returns the value of actCharacterIndex
     */
    public Integer getActCharacterIndex(){
        return actCharacterIndex;
    }

    /**
     * This method returns a boolean that indicates if the actCharacter is a
     * PlayerCharacter.
     */
    public boolean getActPlayerCharacter(){
        return actPlayerCharacter;
    }

    /**
     * This method change the value of actCharacterIndex and actPlayerCharacter.
     * This method is only called from the method beginTurn in the WaitPhase class.
     * @param character the new actual character.
     */
    public void setActPlayerCharacter(ICharacter character) {
        if (playerCharacters.contains(character)){
            actPlayerCharacter = true;
            actCharacterIndex = playerCharacters.indexOf(character);
        } else {
            actPlayerCharacter = false;
            actCharacterIndex = enemies.indexOf(character);
        }
    }

    /**
     * This method resets the value of the actual variables of the actual turn.
     */
    public void resetTurn() {
        actCharacterIndex = -1;
        actPlayerCharacter = false;
        actTarget = -1;
    }

    /**
     * This method equip the weaponPos weapon of the weapons array to the actual character,
     * only if it is a PlayerCharacter. This method will be used by the interface.
     * @param weaponPos the position of the equipped weapon.
     */
    public void equipWeaponToActual(Integer weaponPos){
        if (actPlayerCharacter){
            try {
                actPhase.equipWeaponToActual(weaponPos);
            } catch (InvalidActionException e) {
                info += e.getMessage()+"\n";
            }
        }
    }

    /**
     * This method sets the new actual target of the character.
     * This method will be used by the interface.
     * @param target the position of the target.
     */
    public void setActTarget(Integer target){
        actTarget = target;
    }

    /**
     * This method returns the value of actTarget, used in the tests and by the interface.
     */
    public Integer getActTarget(){
        return actTarget;
    }

    /**
     * This method represents the attack between the actual character again the target
     * character in the actTarget position. This method will be used by the interface.
     */
    public void actualAttack(){
        try {
            actPhase.actualAttack(actTarget);
        } catch (InvalidActionException e) {
            info += e.getMessage()+"\n";
        }
    }

    /**
     * This method returns the PlayerCharacter in the position pos in the alivePlayerCharacters array.
     * @param pos the position of the playerCharacter.
     */
    public IPlayerCharacter getAlivePlayer(Integer pos){
        return alivePlayerCharacters.get(pos);
    }

    /**
     * This method returns the String of the PlayerCharacter in the pos position.
     * This method is used by the interface.
     * @param pos the position of the PlayerCharacter in the playerCharacters array.
     */
    public String getStringOfPlayer(int pos) {
        IPlayerCharacter plyr = getPlayer(pos);
        return "Name: " + plyr.getName()+"\n"+
               "HP: " + plyr.getLifePoints()+"\n"+
               "DF: " + plyr.getDefense()+"\n"+
               "W.N.: " + plyr.getEquippedWeapon().getName()+"\n"+
               "W.D.: " + plyr.getEquippedWeapon().getDamage()+"\n"+
               "W.W.: " + plyr.getEquippedWeapon().getWeight();
    }

    /**
     * This method returns the String of the Enemy in the pos position.
     * This method is used by the interface.
     * @param pos the position of the Enemy in the enemies array.
     */
    public String getStringOfEnemy(int pos) {
        Enemy character = getEnemy(pos);
        return  "Name: " + character.getName()+"\n"+
                "HP: " + character.getLifePoints()+"\n"+
                "DF: " + character.getDefense()+"\n"+
                "DMG: " + character.getDamage()+"\n"+
                "WGT: " + character.getWeight();
    }

    /**
     * This method returns the String of the Weapon in the pos position.
     * This method is used by the interface.
     * @param pos the position of the Weapon in the weapons array.
     */
    public String getStringOfWeapon(int pos) {
        IWeapon weapon = getWeapon(pos);
        return  "Name: " + weapon.getName()+"\n"+
                "DMG: " + weapon.getDamage()+"\n"+
                "WGT: " + weapon.getWeight();
    }

    /**
     * This method returns the String of the actual Phase.
     * This method is used by the interface.
     */
    public String getStringOfPhase() {
        return getPhase().toString();
    }

    /**
     * This method returns the value of info. The field info contains the information about the InvalidActionExceptions
     * that occur in the execution of the game.
     */
    public String getInfo() {
        return info;
    }

    /**
     * This method reset the value of info.
     * This method is called by the interface.
     */
    public void resetInfo() {
        info = "";
    }

    /**
     * This method begin a round of a game.
     * This method is used by the interface.
     */
    public void beginRound() {
        waitAllTurns();
        beginTurn();
    }
}
