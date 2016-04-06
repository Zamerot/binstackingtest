package dev.guitest;

import dev.business.Item;
import dev.business.StripBin;
import dev.example.Xform;
import javafx.geometry.Point3D;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import java.util.List;

/**
 * Created by Jason on 5/04/2016.
 */
public class Boxes extends Group {

    private Camera camera;

    private final Xform world = new Xform();


    public Boxes(List<StripBin> boxes, double width, double length)
    {
        Box mainBox = new Box(width, 10, length);
        mainBox.setMaterial(new PhongMaterial(Color.GREY));

        Group boxesGroup = new Group();
//        boxesGroup.getChildren().add(mainBox);


        Sphere origin = new Sphere(50);
        origin.setMaterial(new PhongMaterial(Color.RED));



        buildAxis();


        Color currentColor = Color.RED;

        double transLength = 0;
        double transWidth = 0;
        double transHeight = mainBox.getHeight();

        double widest = 0;

        for(StripBin bin : boxes)
        {
            for (Item item : bin.getItems())
            {
                Box tempBox = new Box(item.getWidth(), item.getHeight(), item.getLength());

                currentColor = determineCurrent(currentColor);
                tempBox.setMaterial(new PhongMaterial(currentColor));
                tempBox.setTranslateY(transHeight);
                tempBox.setTranslateX(transWidth);
                tempBox.setTranslateZ(transLength);


                boxesGroup.getChildren().add(tempBox);

                transLength += tempBox.getDepth();

                if(tempBox.getWidth() > widest)
                {
                    widest = tempBox.getWidth();
                }
            }

            transWidth += widest;

            transLength = 0;
        }

//

//        camera.getTransforms().addAll (
//                new Rotate(-20, Rotate.Y_AXIS),
//                new Rotate(-20, Rotate.X_AXIS),
//                new Translate(-width/2,0, -50));


        camera = new PerspectiveCamera(true);

//        camera.setTranslateY(-500);
//        camera.setTranslateX(-150);
//        camera.setTranslateZ(300);

//        camera = new PerspectiveCamera(true);
//        camera.setFieldOfView(62);
//        camera.setTranslateY(-150);
//        camera.setTranslateX(-250);
//        camera.setTranslateZ(-100);
//        camera.setTranslateY(-5);

        Rotate rotateY;
        Rotate rotateX;
        Rotate rotateZ;
        Translate translate;


//        camera.getTransforms().addAll(
//                rotateY = new Rotate(0, Rotate.Y_AXIS),
//                rotateX = new Rotate(0, Rotate.X_AXIS),
//                rotateZ = new Rotate(0, Rotate.Z_AXIS),
//                translate = new Translate(50, 0, 90));

        boxesGroup.getChildren().add(origin);

        Group root = new Group();
        root.getChildren().add(camera);
        root.getChildren().add(world);


        SubScene subScene;
        subScene = new SubScene(root, 600, 600, true, SceneAntialiasing.DISABLED);
        subScene.setCamera(camera);

        this.getChildren().add(subScene);
    }


    private void buildAxis()
    {
        System.out.println("buildAxes()");
        final PhongMaterial redMaterial = new PhongMaterial();
        redMaterial.setDiffuseColor(Color.DARKRED);
        redMaterial.setSpecularColor(Color.RED);

        final PhongMaterial greenMaterial = new PhongMaterial();
        greenMaterial.setDiffuseColor(Color.DARKGREEN);
        greenMaterial.setSpecularColor(Color.GREEN);

        final PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.DARKBLUE);
        blueMaterial.setSpecularColor(Color.BLUE);

        final Box xAxis = new Box(500, 1, 1);
        final Box yAxis = new Box(1, 500, 1);
        final Box zAxis = new Box(1, 1, 500);

        xAxis.setMaterial(redMaterial);
        yAxis.setMaterial(greenMaterial);
        zAxis.setMaterial(blueMaterial);

        Group axisGroup = new Group();

        axisGroup.getChildren().addAll(xAxis, yAxis, zAxis);
        axisGroup.setVisible(false);
        world.getChildren().addAll(axisGroup);
    }


    private Color determineCurrent(Color c)
    {
        if(c.equals(Color.RED))
        {
            return Color.GREEN;
        }
        else if(c.equals(Color.GREEN))
        {
            return Color.RED;
        }

        return c;
    }
}
