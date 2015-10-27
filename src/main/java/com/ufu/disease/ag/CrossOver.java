package com.ufu.disease.ag;

import java.lang.reflect.Field;
import java.util.Random;

import com.ufu.disease.to.Chromossomo;
import com.ufu.disease.to.Gene;

public class CrossOver {

	public Chromossomo crossOver(Chromossomo c1, Chromossomo c2) throws IllegalArgumentException, IllegalAccessException {
		
		Chromossomo novo = new Chromossomo();
		novo.setIdDermatology(AlgoritGenetic.id++);
		
		//System.out.println("idcriado:" +AlgoritGenetic.id);
		Random r = new Random();
		Field[] fieldsChromoOne = c1.getClass().getDeclaredFields();
		Field[] fieldsChromoTwo = c2.getClass().getDeclaredFields();
		
		int p1 = r.nextInt((34 - 1) + 1) + 1;
		
		for(int i=1; i <= p1; i++) {
			//System.out.println("primeiro : " + i);
			Field f = fieldsChromoOne[i];
			f.setAccessible(true);
			Gene geneChromoOne = (Gene) f.get(c1);
			
			Field fNovo = fieldsChromoOne[i];
			fNovo.setAccessible(true);
			Gene g = new Gene();
			g.setOperator(geneChromoOne.getOperator());
			g.setValue(geneChromoOne.getValue());
			g.setWeigth(geneChromoOne.getWeigth());
			
			fNovo.set(novo, g);
			f.setAccessible(false);
		}
		
		for(int i = p1+1 ; i <= 34; i++) {
			Field f = fieldsChromoTwo[i];
			f.setAccessible(true);
			Gene geneChromoOne = (Gene) f.get(c2);
			Field fNovo = fieldsChromoTwo[i];
			fNovo.setAccessible(true);
			Gene g = new Gene();
			g.setOperator(geneChromoOne.getOperator());
			g.setValue(geneChromoOne.getValue());
			g.setWeigth(geneChromoOne.getWeigth());
			fNovo.set(novo, g);
			f.setAccessible(false);
		}
		
		return novo;
	}
	
}
