package psa.expression;

import psa.system.Candidate;
import psa.model.Constants;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import psa.system.Population;
import psa.model.Generation;
import psa.fitness.FitnessCalculation;
import psa.helper.Generator;
import psa.model.Job;
import psa.model.Machine;

public class ExpressionGeneration {
	private int job;
	private int machine;
	private int executionTime;

	Generator g = Generator.getInstance();

	public ExpressionGeneration() {

	}

	public void CalculateExpression() {
		
		Population p = Population.getInstance();
		Generation currentGen = p.getGenerationMap().get(Collections.max(p.getGenerationMap().keySet()));

		List<Candidate> candidateList = currentGen.getCandidateList();
		for (int c = 0; c < candidateList.size(); c++) {
			Candidate candidate = candidateList.get(c);

			List candi = candidate.getChromosomesList();
			for (int i = 0; i < candi.size(); i++) {
				String chromozome = (String) candi.get(i);

				int operation = Integer.parseInt(chromozome.substring(0, 2));
				job = Integer.parseInt(chromozome.substring(2, 4));
				machine = Integer.parseInt(chromozome.substring(4));
				Machine m = g.getMachineMap().get(machine);
				Job j = g.getJobMap().get(job);
				calculateDuration(m, j);

			}

			calculateTMax(candidate);
			g.resetJobs();
			g.resetMachines();
		}
	}

	public void calculateDuration(Machine m, Job j) {
		executionTime = Constants.JMEXECUTIONTIME[job][machine];
		int jobEndTime = j.getEndTime();
		int prevMcTime = m.getCurrentTime();
		if (jobEndTime == 0) {
			m.setCurrentTime(prevMcTime + executionTime);
			j.setStartTime(prevMcTime);
			j.setEndTime(prevMcTime + executionTime);
		} else {
			if (jobEndTime > prevMcTime) {
				m.setCurrentTime(jobEndTime + executionTime);
				j.setStartTime(jobEndTime);
				j.setEndTime(jobEndTime + executionTime);

			} else {
				m.setCurrentTime(prevMcTime + executionTime);
				j.setStartTime(prevMcTime);
				j.setEndTime(prevMcTime + executionTime);
			}
		}

	}
	
	public void calculateTMax(Candidate candidate) {
		int tMax = 0;
	
		for(Entry<Integer, Machine> i :g.getMachineMap().entrySet()) {		
			tMax = i.getValue().getCurrentTime()>tMax ? i.getValue().getCurrentTime() : tMax;
			
		}
		candidate.settMax(tMax);
	}

}
