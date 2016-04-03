package dev.business;

import org.jenetics.BitChromosome;
import org.jenetics.BitGene;
import org.jenetics.Genotype;
import org.jenetics.engine.Engine;
import org.jenetics.engine.EvolutionResult;
import org.jenetics.util.Factory;

/**
 * Created by Jason on 3/04/2016.
 */
public class Sample
{
  // 2.) Definition of the fitness function.
  private static Integer eval(Genotype<BitGene> gt) {
    return ((BitChromosome)gt.getChromosome()).bitCount();
  }

  public static void main(String[] args) {
    // 1.) Define the genotype (factory) suitable
    //     for the problem.
    Factory<Genotype<BitGene>> gtf =
        Genotype.of(BitChromosome.of(10, 0.5));

    // 3.) Create the execution environment.
    Engine<BitGene, Integer> engine = Engine
        .builder(Sample::eval, gtf)
        .build();

    // 4.) Start the execution (evolution) and
    //     collect the result.
    Genotype<BitGene> result = engine.stream()
        .limit(100)
        .collect(EvolutionResult.toBestGenotype());

    System.out.println("Hello World:\n" + result);
  }
}
