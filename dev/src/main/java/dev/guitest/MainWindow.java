package dev.guitest;/**
 * Created by Jason on 5/04/2016.
 */

import dev.business.GAProcessor;
import dev.business.StripBin;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class MainWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    private Pane createContent()
    {
        VBox mainBox = new VBox();

        mainBox.getChildren().add(new Label("Label HERE"));


        GAProcessor processor = new GAProcessor();
        List<StripBin> best = processor.finBest(GAProcessor.sampleData(200), 200, 100);

        mainBox.getChildren().add(new Boxes(best, 200, 100));

        return mainBox;
    }


    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Main App");

        Scene scene = new Scene(createContent());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
