package dev.gui;

import dev.business.Item;
import dev.business.StripBin;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.List;

/**
 * Created by Jason on 3/04/2016.
 */
public class PackageView extends HBox
{


  public PackageView(List<StripBin> bin, double width, double length)
  {
    Canvas canvas = new Canvas(500, 500);

    this.getChildren().add(canvas);

    GraphicsContext g = canvas.getGraphicsContext2D();

    g.setFill(Color.BLUE);
    g.fillRect(100, 100, width , length);
    g.setStroke(Color.BLACK);
    g.setFill(Color.WHITE);

    double x = 100;
    double y = 100;

    for(int i = 0; i < bin.size(); i++)
    {
      StripBin stripBin = bin.get(i);

      for (int j = 0; j < stripBin.getItems().size(); j++)
      {
        Item item = stripBin.getItems().get(j);

        g.fillRect(x, y, item.getWidth(), item.getLength());

        x+= item.getWidth();
      }

      x = 100;
      y+= stripBin.getLength();
    }
  }
}
