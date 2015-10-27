package com.ufu.disease.ag;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.ufu.disease.to.Chromossomo;
import com.ufu.disease.to.ChromossomoComparator;
import com.ufu.disease.to.Gene;
import com.ufu.disease.to.Operator;


public class Tournament {

	
	public List<Chromossomo> tournamentBinaryPrimordial(List<Chromossomo> populacao) {
		MomgaSelect m = new MomgaSelect();
		List<Chromossomo> listTournament = new ArrayList<Chromossomo>();
		Random r = new Random();
		int i=0;
		while(i <= populacao.size() / 2) {
			int r1 = r.nextInt((populacao.size() - 1) + 1) ;
			int r2 = r.nextInt((populacao.size() - 1) + 1) ;
			
			Chromossomo c1 = populacao.get(r1);
			Chromossomo c2 = populacao.get(r2);
			
			if(m.dominateOther(c1, c2)) {
				listTournament.add(c1);
			}
			if(m.dominateOther(c2, c1)) {
				listTournament.add(c2);
			}
			i++;
		}
		
		if(listTournament.size() < 49) {
			return populacao;
		}
		
		return listTournament;
	}
	
	public List<Chromossomo> tournamentBinarySharingFitness(List<Chromossomo> populacao, List<Chromossomo> front) {
			List<Chromossomo> chromoSelected = new ArrayList<Chromossomo>();
			Random r = new Random();
			
			
			int r1 = r.nextInt((populacao.size() - 1) + 1) ;
			int r2 = r.nextInt((populacao.size() - 1) + 1) ;
			
			Chromossomo c1 = populacao.get(r1);
			Chromossomo c2 = populacao.get(r2);
			
			Chromossomo chooseOne = npga(c1, c2, front);
			
			r1 = r.nextInt((populacao.size() - 1) + 1) ;
			r2 = r.nextInt((populacao.size() - 1) + 1) ;
			
			c1 = populacao.get(r1);
			c2 = populacao.get(r2);
			
			Chromossomo chooseTwo = npga(c1, c2, front);
			
			chromoSelected.add(chooseOne);
			chromoSelected.add(chooseTwo);

			Collections.sort(chromoSelected, new ChromossomoComparator());
			return chromoSelected;
	}
	
	
	/**
	 * Niched pareto Generic ALgorith (NPGA)
	 * 
	 * @param populacao
	 */
	public Chromossomo npga(Chromossomo c1, Chromossomo c2, List<Chromossomo> setComparation){
		MomgaSelect m = new MomgaSelect();
		
		// elemento eh dominado ou nao dominado
		// se um for non domintaror e o utro sim entar retorna o outro
		boolean chromoOne = false;
		boolean chomeTwo = false;
		
		for(Chromossomo comparationChomo: setComparation ) {
			if(m.dominateOther(c1, comparationChomo)) {
				chromoOne = true;
			} else {
				chromoOne = false;
				break;
			}
		}
		
		for(Chromossomo comparationChomo: setComparation ) {
			if(m.dominateOther(c2,comparationChomo)) {
				chomeTwo = true;
			} else {
				chomeTwo =false;
				break;
			}
		}
		
		if(chromoOne == true && chomeTwo == false) {
			return c2;
		}
		
		if(chromoOne == false && chomeTwo == true) {
			return c1;
		} 
		
		double share1 = m.calculateDistancesFromChromossomo(c1, setComparation);
		double share2 = m.calculateDistancesFromChromossomo(c2, setComparation);
		
		if(share1 < share2) {
			return c1;
		} else {
			return c2;
		}
	}
	
	public List<Chromossomo> tournamentTimesMomga(List<Chromossomo> populacao,List<Chromossomo> front, int vezes) {
		
		List<Chromossomo> torneiosElement = new ArrayList<Chromossomo>();
		for(int k=0;k <=vezes;k++) {
		
			List<Chromossomo> chromoSelected = new ArrayList<Chromossomo>();
			List<Chromossomo> chromoSelected1 = tournamentBinarySharingFitness(populacao, front);
			List<Chromossomo> chromoSelected2 = tournamentBinarySharingFitness(populacao, front);
			
			if(chromoSelected1.size() >0 && chromoSelected1.get(0) != null
					&& chromoSelected2.size()>1 && chromoSelected2.get(1) != null) {
				
			chromoSelected.add(chromoSelected1.get(0));
			if(chromoSelected2.get(0).equals(chromoSelected1.get(0))) {
				chromoSelected.add(chromoSelected2.get(1));
			} else {
				chromoSelected.add(chromoSelected2.get(0));
			}
			CrossOver cross =new CrossOver();
			
			try {
				
				Chromossomo c1 =  cross.crossOver(chromoSelected.get(0), chromoSelected.get(1));
				Chromossomo c2 =  cross.crossOver(chromoSelected.get(1), chromoSelected.get(0));
				
				torneiosElement.add(c1);
				torneiosElement.add(c2);
				
				mutation(c1,30);
				mutation(c2,30);
				
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		
		} else {
			System.out.println("tem gente nulo ai max fit:");
		}
		}
		return torneiosElement;
		
	}
	
	

	private void mutation(Chromossomo c1, int porcentage) throws IllegalAccessException {
		Field[] fiields = c1.getClass().getDeclaredFields();
		
		Random r = new Random();
		for(Field f:fiields) {
			if(f.getName().equals("id")) {
				continue;
			}
			if(f.getName().equals("fitness")) {
				continue;
			}
			if(f.getName().equals("idDermatology")) {
				continue;
			}
			if(f.getName().equals("function1")) {
				continue;
			}
			if(f.getName().equals("function2")) {
				continue;
			}
			if(f.getName().equals("classDisease")) {
				continue;
			}
			
			int p1 = r.nextInt((100 - 1) + 1) + 1;
			int p2 = r.nextInt((100 - 1) + 1) + 1;
			int p3 = r.nextInt((100 - 1) + 1) + 1;
			
			f.setAccessible(true);
			Object obj = f.get(c1);
			Gene geneChromoOne = null;
			if(obj instanceof Gene) {
				geneChromoOne = (Gene) obj;
			} else {
				continue;
			}
			
			if(p1 <= porcentage) {
				geneChromoOne.setOperator(Operator.getRandom());
			}
			
			if(p2 <= porcentage) {
				boolean plus = r.nextBoolean();
				int num = r.nextInt((10 - 1) + 1) + 1;
				
				float sum = (float) (plus == true ? geneChromoOne.getWeigth() +
						(num / 100f) : geneChromoOne.getWeigth() - (num/100f)) ;
				
				if(sum > 1.0) {
					sum = 1.0f;
				}
				if(sum <=0) {
					sum = 0.0f;
				}
				geneChromoOne.setWeigth(sum);
			}
			
			if (p3 <= porcentage) {
				if (f.getName().equals("familyHistory")) {
					geneChromoOne.setValue(r.nextInt((1 - 0) + 1) + 0);
				} else if (f.getName().equals("age")) {
					geneChromoOne.setValue(r.nextInt((79 - 0) + 1) + 0);
				} else if (f.getName().equals("classDisease")) {
					//geneChromoOne.setValue(r.nextInt((6 - 0) + 1) + 0);
				} else {
					geneChromoOne.setValue(r.nextInt((3 - 0) + 1) + 0);
				}
			}
			//System.out.println(geneChromoOne);
		}
	}
	
}
