package com.ufu.disease.ag;

import java.util.ArrayList;
import java.util.List;

import com.ufu.disease.to.Chromossomo;

/**
 * classe responsavel para selecionar elemntos do algoritmo spea2
 * 
 * @author miller
 *
 */
public class MomgaSelect {

	
	public static Integer TOURNAMNET_SIZE = 2;
	
	public Double calculateDistancesFromChromossomo(Chromossomo ind,
			List<Chromossomo> inds) {
		double[] d = new double[inds.size() + 1];
		int i = 0;
		Double sum = 0.0d;
		for (Chromossomo c1 : inds) {
			Double d1 = (double) ((ind.getFunction1() - c1.getFunction1()) * (ind
					.getFunction1() - c1.getFunction1()));
			Double d2 = (double) ((ind.getFunction2() - c1.getFunction2()) * (ind
					.getFunction2() - c1.getFunction2()));
			d[i++] = (double) Math.sqrt(d1 + d2);
			sum = sum + d[i];
		}
		
		return sum;
	}

	public List<Chromossomo> momgaSelection(List<Chromossomo> populacao, List<Chromossomo> nextGeneration) throws CloneNotSupportedException {

		Tournament t = new Tournament();
		
		List<Chromossomo> front = new ArrayList<Chromossomo>();
		List<Chromossomo> nonFront = new ArrayList<Chromossomo>();
		
		partitionIntoParetoFront(populacao, front, nonFront);
		
		nextGeneration = t.tournamentTimesMomga(populacao, front, 24);
		
		return nextGeneration;
	}


	public List<Chromossomo> partitionIntoParetoFront(
			List<Chromossomo> popupation, List<Chromossomo> front,
			List<Chromossomo> nonFront) {
		if (front == null) {
			front = new ArrayList<Chromossomo>();
		}
		// pega o elite
		front.add(popupation.get(0));
		int aux = 0;
		for (Chromossomo ind : popupation) {

			if (aux++ == 0) {
				continue;
			}
			boolean noOneWasBetter = true;
			int frontSize = front.size();

			for (int j = 0; j < frontSize; j++) {
				Chromossomo frontmember = (Chromossomo) (front.get(j));

				if (dominateOther(frontmember, ind)) {
					nonFront.add(ind);
					noOneWasBetter = false;
					break; // falha nao esta no front
				}

				if (dominateOther(ind, frontmember)) {
					removeAndShift(j, front);
					frontSize--;
					j--;
					nonFront.add(frontmember);
				}
			}
			if (noOneWasBetter)
				front.add(ind);
		}
		return front;
	}

	public boolean dominateOther(Chromossomo c1, Chromossomo c2) {
		if (c1.getFunction1() > c2.getFunction1()
				|| c1.getFunction2() > c2.getFunction2()) {
			return true;
		}
		return false;
	}
	
	void removeAndShift(int val, List<Chromossomo> list) {
		int size = list.size();
		list.set(val, list.get(size - 1));
		list.remove(size - 1);
	}


}
