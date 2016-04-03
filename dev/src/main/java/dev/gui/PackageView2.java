package dev.gui;

import dev.business.Item;
import dev.business.StripBin;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


import java.util.List;

/**
 * Created by Jason on 3/04/2016.
 */
public class PackageView2 extends VBox
{

  public PackageView2(List<StripBin> bin, double width, double length)
  {
    this.setWidth(width);
    this.setHeight(length);
    this.setStyle("-fx-border-color:black; -fx-background-color: dark gray;");

    for(int i = 0; i < bin.size(); i++)
    {
      HBox row = new HBox();

      StripBin stripBin = bin.get(i);

      for (int j = 0; j < stripBin.getItems().size(); j++)
      {
        Item item = stripBin.getItems().get(j);

        FlowPane flowPane = new FlowPane();

        Label label = new Label(item.getName());
        flowPane.getChildren().add(label);

        flowPane.setStyle("-fx-border-color:White; -fx-background-color: blue;");
        flowPane.setPrefHeight(item.getLength());
        flowPane.setPrefWidth(item.getWidth());

        row.getChildren().add(flowPane);
      }

      row.setPrefWidth(stripBin.getWidth());
      row.setPrefHeight(stripBin.getLength());
      this.getChildren().add(row);
    }
  }
}
