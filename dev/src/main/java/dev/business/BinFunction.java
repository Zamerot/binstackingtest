package dev.business;

import org.jenetics.BitGene;
import org.jenetics.Chromosome;
import org.jenetics.Genotype;
import org.jscience.mathematics.number.Float64;

import java.util.ArrayList;
import java.util.List;

/**
* Created by Jason on 3/04/2016.
*/
public class BinFunction
{
  double size;

  List<Item> items;


  double maxWidth;

  double maxLength;

  public BinFunction(List<Item> items, double maxWidth, double maxLength)
  {
    this.items = items;
    this.maxWidth = maxWidth;
    this.maxLength = maxLength;
  }

  public List<Item> getItems()
  {
    return items;
  }

  public List<StripBin> create(final Genotype<BitGene> genotype)
  {
    final Chromosome<BitGene> ch = genotype.getChromosome();

    ArrayList<StripBin> bins = new ArrayList<>();
    StripBin bin = new StripBin(maxLength, maxWidth);
    bins.add(bin);


    int i = 0;
    int n;
    for( i = i,  n= ch.length(); i < n; ++i)
    {
      if(ch.getGene(i).getBit())
      {
        Item item = items.get(i);

        if(!bin.add(item))
        {
          double remainingLength = maxLength - bin.getLength();

          if(remainingLength > item.getLength())
          {
            // Bin is full so create new bin
            bin = new StripBin(remainingLength, maxWidth);
            bins.add(bin);
          }
          else
          {

          }
        }
      }
    }


    return bins;
  }

  public Float64 apply(final Genotype<BitGene> genotype)
  {
    List<StripBin> bins = create(genotype);

    int totalItems = bins.stream().mapToInt((stripBin)->{
      return stripBin.getItems().size();
    }).sum();

    return Float64.valueOf(totalItems);
  }


}
