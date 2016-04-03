package dev.business;

import org.jenetics.*;
import org.jenetics.engine.Engine;
import org.jenetics.engine.EvolutionResult;
import org.jenetics.util.Factory;
import org.jscience.mathematics.number.Float64;

import java.util.ArrayList;
import java.util.List;

/**
* Created by Jason on 3/04/2016.
*/
public class GAProcessor
{


  public static List<Item> sampleData(int n)
  {
    List<Item> items = new ArrayList<>();


    for(int i = 0; i < n; i++)
    {
      Item item = new Item();
      item.setHeight((Math.random()+1) *10);
      item.setWidth((Math.random()+1) * 10);
      item.setLength((Math.random() +1) * 10);
      item.setName("item " + i);
      items.add(item);
    }

    return items;
  }




  public List<StripBin> finBest(List<Item> items, double width, double length)
  {
    BinFunction ff = new BinFunction(items, width, length);

    Factory<Genotype<BitGene>> genotype = Genotype.of(BitChromosome.of(items.size()));

    Engine<BitGene, Float64> engine = Engine.builder(ff::apply, genotype).maximalPhenotypeAge(30)
        .populationSize(items.size()).selector(new RouletteWheelSelector<>())
        .alterers(new Mutator(0.001), new SinglePointCrossover(0.16))
        .build();

    Genotype<BitGene> result = engine.stream().limit(items.size()).collect(EvolutionResult.toBestGenotype());

    System.out.println(result);

    List<StripBin> best = ff.create(result);

    int totalItems  = 0;
    for(int i= 0; i < best.size(); i++)
    {
      totalItems += best.get(i).getItems().size();
    }

    System.out.println("Bins " + best.size() + "  Total Items " + totalItems);

    return best;
  }



}
