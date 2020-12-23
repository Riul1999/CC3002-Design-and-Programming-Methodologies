package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.gui.gameController.GameController;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main entry point for the application.
 * <p>
 * <Complete here with the details of the implemented application>
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public class FinalReality extends Application {
  private final GameController  CONTROLLER = new GameController();

  private final Label actualPlayerCharacter = new Label("");
  private final Label enemyCharacter1 = new Label("");
  private final Label weapon1 = new Label("");
  private final Label weapon2 = new Label("");
  private final Label round = new Label("");
  private final Label endLabel = new Label("");

  private Integer actRound = 0;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    createComponents();

    primaryStage.setTitle("Final reality");
    primaryStage.setResizable(false);

    Group root = new Group();
    Scene scene = new Scene(root, 640, 480);

    Label stageLabel = new Label("First room, the goblin cave");
    stageLabel.setLayoutX(280);
    stageLabel.setLayoutY(10);
    root.getChildren().add(stageLabel);

    actualPlayerCharacter.setLayoutX(50);
    actualPlayerCharacter.setLayoutY(200);
    root.getChildren().add(actualPlayerCharacter);

    enemyCharacter1.setLayoutX(400);
    enemyCharacter1.setLayoutY(50);
    root.getChildren().add(enemyCharacter1);

    weapon1.setLayoutX(20);
    weapon1.setLayoutY(400);
    root.getChildren().add(weapon1);

    weapon2.setLayoutX(160);
    weapon2.setLayoutY(400);
    root.getChildren().add(weapon2);

    Button attackButton = new Button("Atack");
    attackButton.setLayoutX(20);
    attackButton.setLayoutY(300);
    attackButton.setOnAction(event -> CONTROLLER.actualAttack());
    root.getChildren().add(attackButton);

    Button targetButton = new Button("SetTarget");
    targetButton.setLayoutX(400);
    targetButton.setLayoutY(80);
    targetButton.setOnAction(event -> CONTROLLER.setActTarget(0));
    root.getChildren().add(targetButton);

    Button equipButton = new Button("Equip");
    equipButton.setLayoutX(20);
    equipButton.setLayoutY(350);
    equipButton.setOnAction(event -> CONTROLLER.equipWeaponToActual(0));
    root.getChildren().add(equipButton);

    Button equipButton2 = new Button("Equip");
    equipButton2.setLayoutX(160);
    equipButton2.setLayoutY(350);
    equipButton2.setOnAction(event -> CONTROLLER.equipWeaponToActual(1));
    root.getChildren().add(equipButton2);

    round.setLayoutX(300);
    round.setLayoutY(40);
    root.getChildren().add(round);

    endLabel.setAlignment(Pos.CENTER);
    root.getChildren().add(endLabel);

    setupTimer();

    primaryStage.setScene(scene);

    primaryStage.show();
  }

  /**
   * This method creates an input String to pass it to the initialize method
   * of the CONTROLLER. In the future the input will be created by the player.
   */
  private void createComponents() {
    String goblin = "Enemy;goblin;150;10;60;30\n";
    String knight = "Knight;King arthur;1000;80\n";
    String sword = "Sword;Excalibur;120;15\n";
    String axe = "Axe;Titanic Hydra;200;40\n";
    String input = goblin+knight+sword+axe+"\n";
    CONTROLLER.initializeGame(input);
  }

  private void setupTimer(){
    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long now) {
        if (CONTROLLER.getEndGame()) {
          String result;
          if (CONTROLLER.getPlayerWinner())
            result = "VICTORY";
          else
            result = "DEFEAT";
          endLabel.setText(result);
          return;
        }

        String playerChar1 = CONTROLLER.getStringOfPlayer(0);
        actualPlayerCharacter.setText(playerChar1);

        String enemy1 = CONTROLLER.getStringOfEnemy(0);
        enemyCharacter1.setText(enemy1);

        String weap1 = CONTROLLER.getStringOfWeapon(0);
        weapon1.setText(weap1);

        String weap2 = CONTROLLER.getStringOfWeapon(1);
        weapon2.setText(weap2);


        if (CONTROLLER.getTURNS().isEmpty()){
          CONTROLLER.waitAllTurns();
          actRound++;
          round.setText("Round "+ actRound);
          CONTROLLER.beginTurn();
        }

        if ( !CONTROLLER.getActPlayerCharacter()){
          CONTROLLER.actualAttack();
        }
      }
    };
    timer.start();
  }
}