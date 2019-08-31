package psa.system;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Candidate {

	
	private List<String> chromosomesList;
	private double fitness;
	private int tMax;
	
	public Candidate() {
		chromosomesList = new ArrayList<String>();
	}
	
	
	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	public int gettMax() {
		return tMax;
	}

	public void settMax(int tMax) {
		this.tMax = tMax;
	}

	public List<String> getChromosomesList() {
		return chromosomesList;
	}

	public void setChromosomesList(List<String> chromosomesList) {
		this.chromosomesList = chromosomesList;
	}
	
	




	public static Comparator<Candidate> CanComparator = new Comparator<Candidate>() {
		public int compare(Candidate c1, Candidate c2) {
			double Fit1 = c1.getFitness();
			double Fit2 = c2.getFitness();
			return Double.compare(Fit2,Fit1);
		}
	};
	
}
