package psa.system;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import psa.helper.Generator;
import psa.model.*;

import psa.model.Constants;

public class Population {

	private static Population population;
	private int[][] operationJob;
	private Map<Integer, Generation> generationMap;
	Map mcJob = new HashMap<Integer, List<String>>();

	private Population() {
		operationJob = new int[Constants.TOTAL_JOBS][Constants.TOTAL_OPERATIONS];
		generationMap = new HashMap<Integer, Generation>();
		createGeneration0();

	}

	public static Population getInstance() {
		if (population == null) {
			population = new Population();
		}
		return population;
	}

	public int[][] getOperationJob() {
		return operationJob;
	}

	public void setOperationJob(int[][] operationJob) {
		this.operationJob = operationJob;
	}

	public Map<Integer, Generation> getGenerationMap() {
		return generationMap;
	}

	public void setGenerationMap(Map<Integer, Generation> generationMap) {
		this.generationMap = generationMap;
	}

	/*
	 * Method to create the initial generation i.e. generation0
	 */
	public void createGeneration0() {
		Generation gen = new Generation();
		List<Candidate> candidateList = null;

		for (int i = 0; i < Constants.POPULATION_SIZE; i++) {
			candidateList = gen.getCandidateList();
			candidateList.add(createCandidate());
		}
		gen.setCandidateList(candidateList);
		generationMap.put(0, gen);
	}

	/*
	 * Method to create Candidates/Individuals of a generation/population
	 */
	/**/
	public Candidate createCandidate() {
		Candidate candidate = new Candidate();
		List<String> chromosomeList = candidate.getChromosomesList();
		List<Integer> machineList = new ArrayList<Integer>(Generator.getMachineMap().keySet());
		List<Integer> jobList = new ArrayList<Integer>(Generator.getJobMap().keySet());
		String s = null;
		createuniqueCandi();
		  
		  machineList = Generator.getInstance().shuffleIntegerList(machineList);
		  jobList = Generator.getInstance().shuffleIntegerList(jobList);

		int k = 0;
		for (int j = 0; j < Constants.TOTAL_OPERATIONS; j++) {

			for (int m = 0; m < jobList.size(); m++) {

				List<String> cm = (List<String>) mcJob.get(jobList.get(m));
				String s1 = cm.get(machineList.get(j));

				String chromosome = String.format("%02d", j % Constants.TOTAL_OPERATIONS) + s1;

				chromosomeList.add(chromosome);
			}
		}

		candidate.setChromosomesList(chromosomeList);
		return candidate;
	}

	public void createuniqueCandi() {
		for (int i = 0; i < Constants.TOTAL_JOBS; i++) {
			List<String> mcJ = new ArrayList<String>();
			for (int j = 0; j < Constants.TOTAL_MACHINES; j++) {
				String a = String.format("%02d", i);
				String b = String.format("%02d", j);
				String x = a + b;
				mcJ.add(x);

			}
			Collections.shuffle(mcJ);
			mcJob.put(i, mcJ);
		}

		

		 /* public Candidate createCandidate1() { Candidate candidate = new Candidate();
		 * List<String> chromosomeList = candidate.getChromosomesList(); List<Integer>
		 * machineList = new ArrayList<Integer>(Generator.getMachineMap().keySet());
		 * List<Integer> jobList = new
		 * ArrayList<Integer>(Generator.getJobMap().keySet());
		 * 
		 * // machineList = Generator.getInstance().shuffleIntegerList(machineList); for
		 * (int i = 0; i < Constants.TOTAL_OPERATIONS; i++) { // machineList =
		 * Generator.getInstance().shuffleIntegerList(machineList); // jobList =
		 * Generator.getInstance().shuffleIntegerList(jobList); int k = 0; for (int j =
		 * 0; j < Constants.TOTAL_JOBS; j++) {
		 * 
		 * // if(j >= machineList.size()-1 ) { // machineList =
		 * Generator.getInstance().shuffleIntegerList(machineList); // }
		 * operationJob[jobList.get(j)][i] = machineList.get(j % machineList.size());
		 * 
		 * // System.out.println("operationJob[i][j]:::::::::::::;"+operationJob[i][j]);
		 * String chromosome = String.format("%02d", i) + String.format("%02d",
		 * jobList.get(j)) + String.format("%02d", operationJob[jobList.get(j)][i]);
		 * 
		 * chromosomeList.add(chromosome); }
		 * 
		 * }
		 * 
		 * candidate.setChromosomesList(chromosomeList); //
		 * System.out.println(chromosomeList);
		 * 
		 * return candidate; }
		 */
//	
//	for(int i  = 0 ; i<Constants.TOTAL_JOBS; i++) {
//		System.out.println("i:::::::::::"+i);
//		List<String> abc = (List<String>) mcJob.get(i);
//		for(int j = 0 ; j<abc.size(); j++) {
//			System.out.println("j::::"+abc.get(j));
//			
//		}
//		
//	}
//	
	}
}
