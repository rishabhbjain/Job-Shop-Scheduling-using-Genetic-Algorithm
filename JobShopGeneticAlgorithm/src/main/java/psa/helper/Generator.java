package psa.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import psa.model.Constants;
import psa.model.Job;
import psa.model.Machine;

public class Generator {

	private static Generator generator = null;
	public static Map<Integer, Machine> machineMap = new HashMap<Integer, Machine>();
	public static Map<Integer, Job> jobMap = new HashMap<Integer, Job>();

	private Generator() {

		generateJobs();
		generateMachines();
		timeArray();
	}

	public static Map<Integer, Machine> getMachineMap() {
		return machineMap;
	}

	public static void setMachineMap(Map<Integer, Machine> machineMap) {
		Generator.machineMap = machineMap;
	}

	public static Map<Integer, Job> getJobMap() {
		return jobMap;
	}

	public static void setJobMap(Map<Integer, Job> jobMap) {
		Generator.jobMap = jobMap;
	}

	public static Generator getInstance() {
		if (generator == null) {
			generator = new Generator();
		}
//	else {
//			
//			return generator;
//		}
		return generator;
	}

	public void generateJobs() {
		
		int jobCount = 10;
		for (int i = 0; i < Constants.TOTAL_JOBS; i++) {

			jobMap.put(i, new Job());

		}

	}

	public void generateMachines() {

		for (int i = 0; i < Constants.TOTAL_MACHINES; i++) {

			machineMap.put(i, new Machine());

		}
	}

	public void resetJobs() {
		for (int i = 0; i < Constants.TOTAL_JOBS; i++) {

			jobMap.get(i).setEndTime(0);
			jobMap.get(i).setStartTime(0);
			jobMap.get(i).setIsActive(false);

		}

	}

	public void resetMachines() {
		int machineCount = 10;
		// String machine = "j";
		for (int i = 0; i <Constants.TOTAL_MACHINES  ; i++) {
			machineMap.get(i).setCurrentTime(0);
			machineMap.get(i).setIsActive(false);

		}
	}

	public void  timeArray() {
		System.out.println("--------------------------Time Array[Start]      [JOB * MACHINE]   -----------------------");
		System.out.println();
		for (int i = 0; i < Constants.TOTAL_JOBS; i++) {
			//System.out.print("i"+i+"\t");
			for (int j = 0; j < Constants.TOTAL_MACHINES; j++) {
				Constants.JMEXECUTIONTIME[i][j] = (new Random().nextInt(100) + 1) * 10;
				System.out.print(Constants.JMEXECUTIONTIME[i][j]+"\t");
			//System.out.print(i+":::"+j+":::"+Constants.JMEXECUTIONTIME[i][j]);
			//System.out.println(i+":::"+j+":::"+Constants.JMEXECUTIONTIME[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("--------------------------Time Array[End]-----------------------");
		System.out.println();
	}
	
	
//	public void  timeArray() {
//		for (int i = 0; i < Constants.TOTAL_JOBS; i++) {
//			for (int j = 0; j < Constants.TOTAL_MACHINES; j++) {
//				Constants.JMEXECUTIONTIME[i][j] = (new Random().nextInt(100) + 1) * 10;
//			//System.out.println(i+":::"+j+":::"+Constants.JMEXECUTIONTIME[i][j]);
//			//System.out.println(i+":::"+j+":::"+Constants.JMEXECUTIONTIME[i][j]);
//			}
//		}
//	}
	
	
	public List<Integer> shuffleIntegerList(List<Integer> intList){
		
		for(int i = 0; i<Constants.SHUFFLE_REPEAT; i++) {
			Collections.shuffle(intList);
		}
		return intList;
	}
}
