package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.controller.gameController.GameController;
import com.github.cc3002.finalreality.gui.nodes.MovableNodeBuilder;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Main entry point for the application.
 * <p>
 * <all the details of the interface are expressed in the readme file>
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public class FinalReality extends Application {
  private final GameController  CONTROLLER = new GameController();

  private final Group root = new Group();
  private static final String RESOURCE_PATH = "src/main/resources/";

  //This is the group of the labels and parameters of the player characters.
  private final Label playerCharacter1 = new Label("");
  private final Label playerCharacter2 = new Label("");
  private final Label playerCharacter3 = new Label("");
  private final Label playerCharacter4 = new Label("");
  private final Label playerCharacter5 = new Label("");
  private final Integer posYPlayer = 350;
  private final ArrayList<Integer> posXPlayer = new ArrayList<>();
  private final Integer posYPlayerImages = posYPlayer - 100;
  private final Integer posYPlayerAttack = posYPlayer + 100;

  //This is the group of the labels and parameters of the enemies.
  private final Label enemyCharacter1 = new Label("");
  private final Label enemyCharacter2 = new Label("");
  private final Label enemyCharacter3 = new Label("");
  private final Integer posYEnemy = 200;
  private final Integer posYEnemyImages = posYEnemy - 100;
  private final Integer posYEnemyTarget = posYEnemy + 90;

  //This is the group of the labels and parameters of the weapons.
  private final Label weapon1 = new Label("");
  private final Label weapon2 = new Label("");
  private final Label weapon3 = new Label("");
  private final Label weapon4 = new Label("");
  private final Label weapon5 = new Label("");
  private final Integer posYWeapon = 600;
  private final Integer posYWeaponImages = posYWeapon - 100;
  private final Integer posYWeaponEquip = posYWeapon + 50;

  //This is the group of labels of the game
  private final Label round = new Label("");
  private final Label phase = new Label("");
  private final Label info = new Label("");
  private final Label endLabel = new Label("");

  private Integer actRound = 0;
  private Button attackButton;


  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws FileNotFoundException {
    createComponents();


    //This part charge the background of the stage.
    var background = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "background.png")));
    root.getChildren().add(background);

    primaryStage.setTitle("Final reality");
    primaryStage.setResizable(false);

    Scene scene = new Scene(root, 1280, 720);

    Label stageLabel = new Label("First room, the goblin cave");
    stageLabel.setLayoutX(540);
    stageLabel.setLayoutY(10);
    root.getChildren().add(stageLabel);


    //This part set the position and the image of every player character in the party (actually five)
    playerCharacter1.setLayoutX(50);
    posXPlayer.add(50);
    playerCharacter1.setLayoutY(posYPlayer);
    root.getChildren().add(playerCharacter1);
    var knight = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "knight.png")
            .setPosition(50, posYPlayerImages)
            .setSize(100, 50)
            .build();
    root.getChildren().add(knight.getNode());

    playerCharacter2.setLayoutX(150);
    posXPlayer.add(150);
    playerCharacter2.setLayoutY(posYPlayer);
    root.getChildren().add(playerCharacter2);
    var wizard = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "whiteMage.jpg")
            .setPosition(150, posYPlayerImages)
            .setSize(100, 50)
            .build();
    root.getChildren().add(wizard.getNode());

    playerCharacter3.setLayoutX(240);
    posXPlayer.add(240);
    playerCharacter3.setLayoutY(posYPlayer);
    root.getChildren().add(playerCharacter3);
    var engineer = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "engineer.jpg")
            .setPosition(240, posYPlayerImages)
            .setSize(100, 50)
            .build();
    root.getChildren().add(engineer.getNode());

    playerCharacter4.setLayoutX(390);
    posXPlayer.add(390);
    playerCharacter4.setLayoutY(posYPlayer);
    root.getChildren().add(playerCharacter4);
    var thief = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "thief.jpg")
            .setPosition(390, posYPlayerImages)
            .setSize(100, 50)
            .build();
    root.getChildren().add(thief.getNode());

    playerCharacter5.setLayoutX(500);
    posXPlayer.add(500);
    playerCharacter5.setLayoutY(posYPlayer);
    root.getChildren().add(playerCharacter5);
    var blackMage = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "blackMage.png")
            .setPosition(500, posYPlayerImages)
            .setSize(100, 50)
            .build();
    root.getChildren().add(blackMage.getNode());


    //This part set the position and the image of every enemy (actually three)
    enemyCharacter1.setLayoutX(1060);
    enemyCharacter1.setLayoutY(posYEnemy);
    root.getChildren().add(enemyCharacter1);
    var archerGoblin = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "archerGoblin.png")
            .setPosition(1060, posYEnemyImages)
            .setSize(100, 50)
            .build();
    root.getChildren().add(archerGoblin.getNode());

    enemyCharacter2.setLayoutX(920);
    enemyCharacter2.setLayoutY(posYEnemy);
    root.getChildren().add(enemyCharacter2);
    var goblinChampion = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "goblinChampion.jpg")
            .setPosition(920, posYEnemyImages)
            .setSize(100, 50)
            .build();
    root.getChildren().add(goblinChampion.getNode());

    enemyCharacter3.setLayoutX(780);
    enemyCharacter3.setLayoutY(posYEnemy);
    root.getChildren().add(enemyCharacter3);
    var commonGoblin = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "commonGoblin.jpg")
            .setPosition(780, posYEnemyImages)
            .setSize(100, 50)
            .build();
    root.getChildren().add(commonGoblin.getNode());


    //This part set the position and the image of every weapon in the inventory (actually five)
    weapon1.setLayoutX(270);
    weapon1.setLayoutY(posYWeapon);
    root.getChildren().add(weapon1);
    var sword = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "sword.jpg")
            .setPosition(270, posYWeaponImages)
            .setSize(100, 50)
            .build();
    root.getChildren().add(sword.getNode());

    weapon2.setLayoutX(370);
    weapon2.setLayoutY(posYWeapon);
    root.getChildren().add(weapon2);
    var axe = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "axe.png")
            .setPosition(370, posYWeaponImages)
            .setSize(100, 50)
            .build();
    root.getChildren().add(axe.getNode());

    weapon3.setLayoutX(485);
    weapon3.setLayoutY(posYWeapon);
    root.getChildren().add(weapon3);
    var staff = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "staff.png")
            .setPosition(485, posYWeaponImages)
            .setSize(100, 50)
            .build();
    root.getChildren().add(staff.getNode());

    weapon4.setLayoutX(645);
    weapon4.setLayoutY(posYWeapon);
    root.getChildren().add(weapon4);
    var knife = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "knife.jpg")
            .setPosition(645, posYWeaponImages)
            .setSize(100, 50)
            .build();
    root.getChildren().add(knife.getNode());

    weapon5.setLayoutX(765);
    weapon5.setLayoutY(posYWeapon);
    root.getChildren().add(weapon5);
    var bow = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "bow.jpg")
            .setPosition(765, posYWeaponImages)
            .setSize(100, 50)
            .build();
    root.getChildren().add(bow.getNode());

    //This part set all the buttons of the interface.

    //The attack button, for the players characters
    attackButton = new Button("Attack");
    attackButton.setLayoutX(50);
    attackButton.setLayoutY(posYPlayerAttack);
    attackButton.setOnAction(event -> CONTROLLER.actualAttack());
    root.getChildren().add(attackButton);

    //The target buttons, one per enemy.
    Button targetButton1 = new Button("SetTarget");
    targetButton1.setLayoutX(1060);
    targetButton1.setLayoutY(posYEnemyTarget);
    targetButton1.setOnAction(event -> CONTROLLER.setActTarget(0));
    root.getChildren().add(targetButton1);

    Button targetButton2 = new Button("SetTarget");
    targetButton2.setLayoutX(920);
    targetButton2.setLayoutY(posYEnemyTarget);
    targetButton2.setOnAction(event -> CONTROLLER.setActTarget(1));
    root.getChildren().add(targetButton2);

    Button targetButton3 = new Button("SetTarget");
    targetButton3.setLayoutX(780);
    targetButton3.setLayoutY(posYEnemyTarget);
    targetButton3.setOnAction(event -> CONTROLLER.setActTarget(2));
    root.getChildren().add(targetButton3);

    //The equip buttons, one per weapon.
    Button equipButton = new Button("Equip");
    equipButton.setLayoutX(270);
    equipButton.setLayoutY(posYWeaponEquip);
    equipButton.setOnAction(event -> CONTROLLER.equipWeaponToActual(0));
    root.getChildren().add(equipButton);

    Button equipButton2 = new Button("Equip");
    equipButton2.setLayoutX(370);
    equipButton2.setLayoutY(posYWeaponEquip);
    equipButton2.setOnAction(event -> CONTROLLER.equipWeaponToActual(1));
    root.getChildren().add(equipButton2);

    Button equipButton3 = new Button("Equip");
    equipButton3.setLayoutX(485);
    equipButton3.setLayoutY(posYWeaponEquip);
    equipButton3.setOnAction(event -> CONTROLLER.equipWeaponToActual(2));
    root.getChildren().add(equipButton3);

    Button equipButton4 = new Button("Equip");
    equipButton4.setLayoutX(645);
    equipButton4.setLayoutY(posYWeaponEquip);
    equipButton4.setOnAction(event -> CONTROLLER.equipWeaponToActual(3));
    root.getChildren().add(equipButton4);

    Button equipButton5 = new Button("Equip");
    equipButton5.setLayoutX(765);
    equipButton5.setLayoutY(posYWeaponEquip);
    equipButton5.setOnAction(event -> CONTROLLER.equipWeaponToActual(4));
    root.getChildren().add(equipButton5);

    //The begin button, to star the round.
    Button beginButton = new Button("Begin Round");
    beginButton.setLayoutX(920);
    beginButton.setLayoutY(400);
    beginButton.setOnAction(event -> beginRound());
    root.getChildren().add(beginButton);

    //This part contains all the extra labels, to show more information to the user
    round.setLayoutX(600);
    round.setLayoutY(30);
    root.getChildren().add(round);

    phase.setLayoutX(920);
    phase.setLayoutY(20);
    root.getChildren().add(phase);

    info.setLayoutX(920);
    info.setLayoutY(450);
    root.getChildren().add(info);

    endLabel.setLayoutX(600);
    endLabel.setLayoutY(300);
    root.getChildren().add(endLabel);

    setupTimer();

    primaryStage.setScene(scene);

    primaryStage.show();

  }

  /**
   * This method refresh the information in the round label and begin the round.
   */
  private void beginRound() {
    actRound++;
    round.setText("Round " + actRound);
    CONTROLLER.beginRound();
  }


  /**
   * This method creates an input String to pass it to the initialize method
   * of the CONTROLLER.
   */
  private void createComponents() {
    String commonGoblin = "Enemy;Archer goblin;450;100;60;15\n";
    String archerGoblin = "Enemy;Common goblin;250;40;100;10\n";
    String goblinChampion = "Enemy;Goblin Champion;1000;150;120;30\n";

    String knight = "Knight;King arthur;1000;80\n";
    String whiteMage = "WhiteMage;Merlin;600;35;400\n";
    String engineer = "Engineer;Beauchef's engineer;600;45\n";
    String thief = "Thief;Bank Thief;250;20\n";
    String blackMage = "BlackMage;Veigar;600;35;400\n";

    String sword = "Sword;Excalibur;240;15\n";
    String axe = "Axe;Titanic Hydra;400;40\n";
    String staff = "Staff;Needlessly Large Rod;150;20;200\n";
    String knife = "Knife;Chef's Knife;150;15\n";
    String bow = "Bow;Ashe's bow;250;10\n";

    String input = commonGoblin+goblinChampion+archerGoblin+
                   knight+whiteMage+engineer+thief+blackMage+
                   sword+axe+staff+knife+bow+
                   "\n";
    CONTROLLER.initializeGame(input);
  }

  private void setupTimer(){
    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long now) {
        //This part checks if the game was ended.
        if (CONTROLLER.getEndGame()) {
          String result;
          if (CONTROLLER.getPlayerWinner())
            result = "VICTORY";
          else
            result = "DEFEAT";
          endLabel.setText(result);
        }

        //This part checks if the actual character is a enemy, in that case the enemy automatically attacks.
        if (!CONTROLLER.getActPlayerCharacter() && CONTROLLER.getActCharacterIndex() != -1) {
          try {
            Thread.sleep(600);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          CONTROLLER.actualAttack();
        }

        //This part checks if the actual character is a player, in that case change the position of the attack button near the actual player
        if (CONTROLLER.getActPlayerCharacter() && CONTROLLER.getActCharacterIndex()!= -1){
          attackButton.setLayoutX(posXPlayer.get(CONTROLLER.getActCharacterIndex()));
        }

        //This part update the information of the player characters.
        String playerChar1 = CONTROLLER.getStringOfPlayer(0);
        playerCharacter1.setText(playerChar1);
        String playerChar2 = CONTROLLER.getStringOfPlayer(1);
        playerCharacter2.setText(playerChar2);
        String playerChar3 = CONTROLLER.getStringOfPlayer(2);
        playerCharacter3.setText(playerChar3);
        String playerChar4 = CONTROLLER.getStringOfPlayer(3);
        playerCharacter4.setText(playerChar4);
        String playerChar5 = CONTROLLER.getStringOfPlayer(4);
        playerCharacter5.setText(playerChar5);

        //This part update the information of the enemies.
        String enemy1 = CONTROLLER.getStringOfEnemy(0);
        enemyCharacter1.setText(enemy1);
        String enemy2 = CONTROLLER.getStringOfEnemy(1);
        enemyCharacter2.setText(enemy2);
        String enemy3 = CONTROLLER.getStringOfEnemy(2);
        enemyCharacter3.setText(enemy3);

        //This part update the information of the weapons.
        String weap1 = CONTROLLER.getStringOfWeapon(0);
        weapon1.setText(weap1);
        String weap2 = CONTROLLER.getStringOfWeapon(1);
        weapon2.setText(weap2);
        String weap3 = CONTROLLER.getStringOfWeapon(2);
        weapon3.setText(weap3);
        String weap4 = CONTROLLER.getStringOfWeapon(3);
        weapon4.setText(weap4);
        String weap5 = CONTROLLER.getStringOfWeapon(4);
        weapon5.setText(weap5);

        //This part update the current phase of the game.
        String actPhase = CONTROLLER.getStringOfPhase();
        phase.setText(actPhase);

        //This part checks if there is any new information in the info field, if there is new information, it update the info label.
        if (!CONTROLLER.getInfo().equals("")){
          String information = CONTROLLER.getInfo();
          CONTROLLER.resetInfo();
          info.setText(information);
        }
      }
    };
    timer.start();
  }
}