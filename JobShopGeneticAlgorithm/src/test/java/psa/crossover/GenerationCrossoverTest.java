package psa.crossover;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import psa.helper.Generator;
import psa.model.Generation;
import psa.system.Candidate;
import psa.system.Population;

public class GenerationCrossoverTest {
	
	@Test
	public void TestCrossover() {
		List<Candidate> candidateList = new ArrayList<Candidate>();
		boolean test = false;
		
		Generator.getInstance();
		Population population = Population.getInstance();
		candidateList.add(population.createCandidate());
		candidateList.add(population.createCandidate());
		Generation gen = new Generation();
		gen.setCandidateList(candidateList);
		population.getGenerationMap().put(0, gen);
		
		GenerationCrosssover genCross = new GenerationCrosssover();
		genCross.doCrossover();
		
		List<Candidate> newCandidateList = population.getGenerationMap().get(1).getCandidateList();
		
		boolean first = newCandidateList.get(0).getChromosomesList().subList(0, (newCandidateList.get(0).getChromosomesList().size())/2)
				.equals(candidateList.get(0).getChromosomesList().subList(0, (candidateList.get(0).getChromosomesList().size())/2));
		
		if(newCandidateList.get(0).getChromosomesList().subList(0, (newCandidateList.get(0).getChromosomesList().size())/2)
		.equals(candidateList.get(0).getChromosomesList().subList(0, (candidateList.get(0).getChromosomesList().size())/2)) ||
				newCandidateList.get(0).getChromosomesList().subList(0, (newCandidateList.get(0).getChromosomesList().size())/2)
				.equals(candidateList.get(1).getChromosomesList().subList(0, (candidateList.get(0).getChromosomesList().size())/2)
				)) {
			test = true;	
		}
		
		assertEquals(true, test);
	}

}
