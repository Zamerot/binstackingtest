package dev.guitest;

import javafx.scene.Group;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

/**
 * Created by Jason on 4/04/2016.
 */
public class XForm extends Group
{
  public Translate t  = new Translate();
  public Translate p  = new Translate();
  public Translate ip = new Translate();
  public Rotate    rx = new Rotate();

  {
    rx.setAxis(Rotate.X_AXIS);
  }

  public Rotate ry = new Rotate();

  {
    ry.setAxis(Rotate.Y_AXIS);
  }

  public Rotate rz = new Rotate();

  {
    rz.setAxis(Rotate.Z_AXIS);
  }

  public Scale s = new Scale();

  public XForm()
  {
    super();
    getTransforms().addAll(t, p, rz, ry, rx, s, ip);
  }
}
