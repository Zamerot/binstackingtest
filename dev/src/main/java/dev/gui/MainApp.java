package dev.gui;

import dev.business.GAProcessor;
import dev.business.StripBin;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.List;

/**
 * Created by Jason on 3/04/2016.
 */
public class MainApp extends Application
{
  @Override
  public void start(Stage primaryStage) throws Exception
  {
    primaryStage.setTitle("Hello World!");
    Button btn = new Button();
    btn.setText("Say 'Hello World'");
    btn.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        System.out.println("Hello World!");
      }
    });

    StackPane root = new StackPane();

    GAProcessor processor = new GAProcessor();
    List<StripBin> best = processor.finBest(GAProcessor.sampleData(200), 100, 200);

    PackageView2 packageView = new PackageView2(best, 100, 200);
    root.getChildren().add(packageView);
    primaryStage.setScene(new Scene(root, 300, 250));
    primaryStage.show();
  }
}
