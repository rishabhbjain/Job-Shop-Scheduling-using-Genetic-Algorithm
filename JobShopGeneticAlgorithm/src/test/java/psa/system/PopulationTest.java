package psa.system;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import psa.helper.Generator;
import psa.model.Constants;

public class PopulationTest {

	@Test
	public void TestChromosomeCount() {
		Generator.getInstance();
		assertEquals(Constants.TOTAL_JOBS*Constants.TOTAL_MACHINES,Population.getInstance().createCandidate().getChromosomesList().size());
	}
	
	@Test
	public void TestMachineChromosome() {
		Boolean output = false;
		Generator.getInstance();
		String chromosome = Population.getInstance().createCandidate().getChromosomesList()
							.get(new Random().nextInt(Constants.TOTAL_JOBS*Constants.TOTAL_MACHINES));
		if(Integer.parseInt(chromosome.substring(4))<Constants.TOTAL_MACHINES) {
			output = true;
		}
		
		
		assertEquals(true, output);
	}
	
	@Test
	public void TestJobChromosome() {
		Boolean output = false;
		Generator.getInstance();
		String chromosome = Population.getInstance().createCandidate().getChromosomesList()
							.get(new Random().nextInt(Constants.TOTAL_JOBS*Constants.TOTAL_MACHINES));
		if(Integer.parseInt(chromosome.substring(2,4))<Constants.TOTAL_JOBS) {
			output = true;
		}
		
		
		assertEquals(true, output);
	}
	
	@Test
	public void TestOperationChromosome() {
		Boolean output = false;
		Generator.getInstance();
		String chromosome = Population.getInstance().createCandidate().getChromosomesList()
							.get(new Random().nextInt(Constants.TOTAL_JOBS*Constants.TOTAL_MACHINES));
		if(Integer.parseInt(chromosome.substring(0,2))<Constants.TOTAL_OPERATIONS) {
			output = true;
		}
		
		
		assertEquals(true, output);
	}
	
	@Test
	public void TestGenerationSize() {
		//Generator.getInstance();
		Population population = Population.getInstance();
		population.createGeneration0();
		assertEquals(Constants.POPULATION_SIZE, population.getGenerationMap().get(0).getCandidateList().size());
		
	}
}
