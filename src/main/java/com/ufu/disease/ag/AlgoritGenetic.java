package com.ufu.disease.ag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.ufu.disease.dao.DermatologyDAO;
import com.ufu.disease.to.Chromossomo;
import com.ufu.disease.to.ChromossomoComparator;

public class AlgoritGenetic {

	private static Integer generation = 50;
	private static Integer elementos = 50;
	public static Integer id = 1000;
	private static DermatologyDAO dao = new DermatologyDAO();
	
	public static List<Chromossomo> trainingDiseae;
	public static List<Chromossomo> validateDiseae;
	
	public static List<Chromossomo> classOne;
	public static List<Chromossomo> classTwo;
	public static List<Chromossomo> classThree;
	public static List<Chromossomo> classFour;
	public static List<Chromossomo> classFive;
	public static List<Chromossomo> classSix;
	
	public void randomElements() {
	}
	
	public static List<Chromossomo> createPopulation() {
		
		List<Chromossomo> pop = new ArrayList<Chromossomo>();
		Random random = new Random();
		for (int i = 0; i < elementos; i++) {
			pop.add(Chromossomo.buildChromossome(random));
		}
		
		return pop;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Long init = 0l;
		Long end = 0l;
		initTesteList();
		createValidateList();
		for (int classAg = 1; classAg <= 6; classAg++) {
			
			Float tempo = ((end - init) / 1000f);
			init = System.currentTimeMillis();
			System.out.println("Tempo Execucao:" + tempo);
			List<Chromossomo> populacao = createPopulation();
			
			Fitness f = new Fitness();
			MomgaSelect momga = new MomgaSelect();
			Tournament t = new Tournament();
			
			List<Chromossomo> nextGeneration = new ArrayList<Chromossomo>();
			
			for(Chromossomo c:populacao) {
				f.calculateFitness(c, classAg,trainingDiseae);
			}
			
			for (int j = 1; j <= generation; j++) {
				
				//primordial phase
				populacao = t.tournamentBinaryPrimordial(populacao);
				
				// juxtapositional phase
				nextGeneration = momga.momgaSelection(populacao, nextGeneration);
				for(Chromossomo c:nextGeneration) {
					f.calculateFitness(c, classAg,trainingDiseae);
				}
				//List<Chromossomo> tourElements = tournament.tournamentTimesMomga(populacao, 24);
				populacao.addAll(nextGeneration);
			}
			
			Collections.sort(populacao,new ChromossomoComparator());
			
			System.out.println("Classe: " + classAg);
			Chromossomo.printChromossomo(populacao.get(0));
			validateClass(populacao.get(0), classAg);
			end = System.currentTimeMillis();
		}
	}
	
	
	public static void validateClass(Chromossomo winner, Integer classAg) {
		Fitness f = new Fitness();
		
		f.calculateFitness(winner, classAg, validateDiseae);
		System.out.println("Testando Fit: f1:" + winner.getFunction1() + " f2:" + winner.getFunction2()) ;
		
	}
	
	public static void createValidateList() {
		validateDiseae = new ArrayList<Chromossomo>();
		validateDiseae.addAll(dao.searchDermtologyNotIn(1,classOne));
		validateDiseae.addAll(dao.searchDermtologyNotIn(2,classTwo));
		validateDiseae.addAll(dao.searchDermtologyNotIn(3,classThree));
		validateDiseae.addAll(dao.searchDermtologyNotIn(4,classFour));
		validateDiseae.addAll(dao.searchDermtologyNotIn(5,classFive));
		validateDiseae.addAll(dao.searchDermtologyNotIn(6,classSix));
	}
	
	public static void initTesteList() {
		
		classOne = dao.searchDermtology(74, 1);
		classTwo = dao.searchDermtology(40, 2);
		classThree = dao.searchDermtology(49, 3);
		classFour = dao.searchDermtology(32, 4);
		classFive = dao.searchDermtology(35, 5);
		classSix = dao.searchDermtology(14, 6);
		
		trainingDiseae = new ArrayList<Chromossomo>();
		
		trainingDiseae.addAll(classOne);
		trainingDiseae.addAll(classTwo);
		trainingDiseae.addAll(classThree);
		trainingDiseae.addAll(classFour);
		trainingDiseae.addAll(classFive);
		trainingDiseae.addAll(classSix);
	}
	
}
