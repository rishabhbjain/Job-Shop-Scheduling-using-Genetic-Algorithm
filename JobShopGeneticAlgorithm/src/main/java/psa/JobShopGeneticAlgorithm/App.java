package psa.JobShopGeneticAlgorithm;


import java.util.Collections;
import java.util.List;

import psa.crossover.GenerationCrosssover;
import psa.expression.ExpressionGeneration;
import psa.fitness.FitnessCalculation;
import psa.helper.Generator;
import psa.model.Generation;
import psa.system.Candidate;
import psa.system.Population;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		/*
		 * Generator.getInstance(); Population.getInstance().createCandidate();
		 */
    	
		
		  System.out.println( "-----Job Shop scheduling Problem-----" ); 
		  Generator.getInstance(); 
		  Population p = Population.getInstance(); 
		  for (int i = 0 ; i< 100; i++) {
		  ExpressionGeneration eg = new ExpressionGeneration();
		  eg.CalculateExpression();
		  
		  FitnessCalculation fit = new FitnessCalculation(); fit.fitness();
		  
		  GenerationCrosssover gc = new GenerationCrosssover();
		  
		  gc.doCrossover(); }
		 
		  
		  // display fittest candidate
		Generation currentGen = p.getGenerationMap().get(Collections.max(p.getGenerationMap().keySet()));  
	    List  <String>  candi = (List<String>) currentGen.getCandidateList().get(0).getChromosomesList();
		System.out.println("--------------Fittest Candidate----------------");
	    for(int i= 0  ; i< candi.size(); i++ ) {
		System.out.print(" -"+candi.get(i)+ "-" );	
		
		}
    }
}
