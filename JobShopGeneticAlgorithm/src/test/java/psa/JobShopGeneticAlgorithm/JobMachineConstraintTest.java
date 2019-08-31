package psa.JobShopGeneticAlgorithm;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import psa.helper.Generator;
import psa.model.Constants;
import psa.system.Population;
import psa.model.Constants;

public class JobMachineConstraintTest {

	/*
	 * Test if every job runs on every machine atleast once in a candidate
	 */
	@Test
	public void testJobMachineCoverage() {

		Generator.getInstance();
		Population population = Population.getInstance();
		if (population.getGenerationMap().size() == 0) {
			population.createGeneration0();
		}
		List<String> chromosomeList = population.getGenerationMap().get(0).getCandidateList().get(0)
				.getChromosomesList();

		boolean test = false;
		here: for (int i = 0; i < Constants.TOTAL_JOBS; i++) {
			for (int j = 0; j < Constants.TOTAL_MACHINES; j++) {
				String s = String.format("%02d", i) + String.format("%02d", j);
				for (String t : chromosomeList) {
					if (!t.substring(2).equals(s)) {
						//System.out.println("find:"+s+"..........list:"+t);
						test = false;
					} else {
						test = true;
						break;
					}
				}
				if(!test) break here;
			}
		}
		assertEquals(true, test);

	}

}
