package psa.fitness;

import java.util.Collections;
import java.util.List;

import psa.crossover.GenerationCrosssover;
import psa.expression.ExpressionGeneration;
import psa.model.Generation;
import psa.system.Candidate;
import psa.system.Population;

public class FitnessCalculation {
	Population p;
	double meanTMax = 0;

	public void fitness() {
		p = Population.getInstance();
		Generation currentGen = p.getGenerationMap().get(Collections.max(p.getGenerationMap().keySet()));
		List<Candidate> candidateList = currentGen.getCandidateList();
		int sumTmax = 0;
		for (int i = 0; i < candidateList.size(); i++) {
			double inv = 1.0 / candidateList.get(i).gettMax();
			candidateList.get(i).setFitness(inv*Math.pow(10, 7));
			sumTmax = sumTmax + candidateList.get(i).gettMax();
		}
		meanTMax = sumTmax / candidateList.size();
		Collections.sort(candidateList, Candidate.CanComparator);

		currentGen.setMeanTMax(meanTMax);
		currentGen.setFittest(candidateList.get(0).getFitness());
		System.out.println("gen NUmber....." + Collections.max(p.getGenerationMap().keySet()));
		System.out.println("Tmax....." + candidateList.get(candidateList.size() - 1).gettMax());

		System.out.println("fittest value....."+currentGen.getFittest());
		System.out.println("----------------------------------------------------------------------");

	}

}
