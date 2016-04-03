package dev.business;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 3/04/2016.
 */
public class StripBin
{
  double length;

  double width;

  double maxLength;

  double maxWidth;

  List<Item> items = new ArrayList<Item>();

  public StripBin(double maxLength, double maxWidth)
  {
    this.maxLength = maxLength;
    this.maxWidth = maxWidth;
  }

  public double getLength()
  {
    return length;
  }

  public void setLength(int length)
  {
    this.length = length;
  }

  public double getWidth()
  {
    return width;
  }

  public void setWidth(int width)
  {
    this.width = width;
  }

  public boolean add(Item item)
  {
    if(item.getWidth() + width > maxWidth ||
       item.getLength() + length > maxLength)
    {
      // item too large to fit in this bin
      return false;
    }

    items.add(item);

    this.width += item.getWidth();

    if(item.getLength() > length)
    {
      this.length = item.getLength();
    }

    return true;
  }

  public List<Item> getItems()
  {
    return items;
  }
}
