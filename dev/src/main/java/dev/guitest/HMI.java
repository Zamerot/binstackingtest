package dev.guitest;

import dev.business.GAProcessor;
import dev.business.StripBin;
import dev.gui.PackageView2;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Shape3D;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.util.List;

/**
 * Created by Jason on 4/04/2016.
 */
public class HMI  extends Application
{
  public Parent createContent() throws Exception {

    // Box
    Box testBox = new Box(5, 5, 5);
    testBox.setMaterial(new PhongMaterial(Color.RED));
    testBox.setDrawMode(DrawMode.FILL);

    Box testBox2 = new Box(5, 5, 5);
    testBox2.setMaterial(new PhongMaterial(Color.GREEN));
    testBox2.setDrawMode(DrawMode.FILL);
    testBox2.setTranslateX(7);

    // Create and position camera
    PerspectiveCamera camera = new PerspectiveCamera(true);
    camera.getTransforms().addAll (
        new Rotate(-20, Rotate.Y_AXIS),
        new Rotate(-20, Rotate.X_AXIS),
        new Translate(0, 0, -50));

    Group shapeGroup = new Group();
    shapeGroup.getChildren().add(testBox);
    shapeGroup.getChildren().add(testBox2);

    // Build the Scene Graph
    Group root = new Group();
    root.getChildren().add(camera);
    root.getChildren().add(shapeGroup);

    // Use a SubScene
    SubScene subScene = new SubScene(root, 600, 600);
    subScene.setFill(Color.ALICEBLUE);
    subScene.setCamera(camera);
    Group group = new Group();
    group.getChildren().add(subScene);
    return group;

  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setResizable(false);
    Scene scene = new Scene(createContent());
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * Java main for when running without JavaFX launcher
   */
  public static void main(String[] args) {
    launch(args);
  }
}
