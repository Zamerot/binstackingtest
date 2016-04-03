package dev.business;

/**
 * Created by Jason on 3/04/2016.
 */
public class Item
{
  double width;

  double height;

  double length;

  double rotation;

  String name;

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public Item()
  {
  }

  public Item(double width, double height, double length)
  {
    this.width = width;
    this.height = height;
    this.length = length;
  }

  public Item(double width, double height, double length, double rotation)
  {
    this.width = width;
    this.height = height;
    this.length = length;
    this.rotation = rotation;
  }

  public double getWidth()
  {
    return width;
  }

  public void setWidth(double width)
  {
    this.width = width;
  }

  public double getHeight()
  {
    return height;
  }

  public void setHeight(double height)
  {
    this.height = height;
  }

  public double getLength()
  {
    return length;
  }

  public void setLength(double length)
  {
    this.length = length;
  }

  public double getRotation()
  {
    return rotation;
  }

  public void setRotation(double rotation)
  {
    this.rotation = rotation;
  }
}
