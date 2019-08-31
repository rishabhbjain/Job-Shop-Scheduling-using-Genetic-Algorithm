package psa.helper;

import psa.model.Job;
import psa.model.Machine;

public class ResetEntities {
	Generator g = Generator.getInstance();

	public void resetJobs() {
		// int jobCount = Constants.jobCount;
		int jobCount = 10;
//		String job = "j";
		for (int i = 1; i < jobCount; i++) {

			g.getJobMap().get(i).setEndTime(0);
			g.getJobMap().get(i).setStartTime(0);
			g.getJobMap().get(i).setIsActive(false);

		}

	}

	public void resetMachines() {

		int machineCount = 10;
		// String machine = "j";
		for (int i = 0; i < machineCount; i++) {
			g.getMachineMap().get(i).setCurrentTime(0);
			g.getMachineMap().get(i).setIsActive(false);

		}
	}
}
