package psa.fitness;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Test;

import psa.expression.ExpressionGeneration;
import psa.helper.Generator;
import psa.model.Generation;
import psa.system.Candidate;
import psa.system.Population;

public class FitnessCalculationTest {

	@Test
	public void TestFittest() {
		Generator.getInstance();
		Population p = Population.getInstance();
		if (p.getGenerationMap().size() == 0) {
			p.createGeneration0();
		}
		ExpressionGeneration exp = new ExpressionGeneration();
		exp.CalculateExpression();
		FitnessCalculation fc = new FitnessCalculation();
		fc.fitness();
		Generation g = p.getGenerationMap().get(0);
		boolean max = false;
		for (Candidate c : g.getCandidateList()) {
			if (c.getFitness() <= g.getFittest()) {
				max = true;
			}
		}
		assertEquals(true, max);
	}

	@Test
	public void TestInfinity() {
		Generator.getInstance();
		Population p = Population.getInstance();
		if (p.getGenerationMap().size() == 0) {
			p.createGeneration0();
		}
		ExpressionGeneration exp = new ExpressionGeneration();
		exp.CalculateExpression();
		FitnessCalculation fc = new FitnessCalculation();
		fc.fitness();
		Generation g = p.getGenerationMap().get(0);
		boolean infinite = false;
		for (Candidate c : g.getCandidateList()) {
			try {
				double inv = 1 / c.gettMax();
				if (1 / inv == 0.0) {
					infinite = true;
				}
			} catch (Exception e) {

			}
		}
		assertEquals(false, infinite);
	}

	@Test
	public void TestFitness() {
		Generator.getInstance();
		Population p = Population.getInstance();
		p.getGenerationMap().clear();
		System.out.println("SSSSSSS"+p.getGenerationMap().size());
		if (p.getGenerationMap().size() == 0) {
			p.createGeneration0();
		}
		ExpressionGeneration exp = new ExpressionGeneration();
		exp.CalculateExpression();
		Candidate c = p.getGenerationMap().get(Collections.max(p.getGenerationMap().keySet())).getCandidateList()
						.get(0);
		c.settMax(1);
		FitnessCalculation fc = new FitnessCalculation();
		fc.fitness();
		System.out.println("eeeeeeeeeeeeeeeeeee   " + c.gettMax());
		System.out.println("eeeeeeeeeeeeeeeeeee   " + c.getFitness());

		assertEquals(1.0 * Math.pow(10, 7), c.getFitness(), 0.0);
	}

}