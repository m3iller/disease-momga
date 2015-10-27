package com.ufu.disease.to;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

import com.ufu.disease.ag.AlgoritGenetic;
import com.ufu.disease.ag.Fitness;

public class Chromossomo implements Cloneable {
	
	public Chromossomo() {
		this.erythema = new Gene();
		this.scaling= new Gene();
		this.definiteBorders= new Gene();
		this.itching= new Gene();
		this.koebnerPhenomenon= new Gene();
		this.polygonalPapules= new Gene();
		this.follicularPapules= new Gene();
		this.oralMucosalInvolvement= new Gene();
		this.kneeElbowInvolvement= new Gene();
		this.scalpInvolvement= new Gene();
		this.familyHistory= new Gene();
		this.melaninIncontinence= new Gene();
		this.eosinophils= new Gene();
		this.pnlInfiltrate= new Gene();
		this.fibrosis= new Gene();
		this.exocytosis= new Gene();
		this.acanthosis= new Gene();
		this.hyperkeratosis= new Gene();
		this.parakeratosis= new Gene();
		this.clubbing= new Gene();
		this.elongation= new Gene();
		this.thinning= new Gene();
		this.spongiform= new Gene();
		this.munroIcroabcess= new Gene();
		this.focalHypergranulosis= new Gene();
		this.disappearance= new Gene();
		this.vacuolisation= new Gene();
		this.spongiosis= new Gene();
		this.sawYooth= new Gene();
		this.follicular= new Gene();
		this.perifollicular= new Gene();
		this.inflammatory= new Gene();
		this.bandLike= new Gene();
		this.age= new Gene();
		this.classDisease= new Gene();
		
		// spea 2
		this.function1 =  new Float(0.0f);
		this.function2 =  new Float(0.0f);
		this.fitness =  new Float(0.0f);
	}

	private Integer idDermatology;
	private Gene erythema;
	private Gene scaling;
	private Gene definiteBorders;
	private Gene itching;
	private Gene koebnerPhenomenon;
	private Gene polygonalPapules;
	private Gene follicularPapules;
	private Gene oralMucosalInvolvement;
	private Gene kneeElbowInvolvement;
	private Gene scalpInvolvement;
	private Gene familyHistory;
	private Gene melaninIncontinence;
	private Gene eosinophils;
	private Gene pnlInfiltrate;
	private Gene fibrosis;
	private Gene exocytosis;
	private Gene acanthosis;
	private Gene hyperkeratosis;
	private Gene parakeratosis;
	private Gene clubbing;
	private Gene elongation;
	private Gene thinning;
	private Gene spongiform;
	private Gene munroIcroabcess;
	private Gene focalHypergranulosis;
	private Gene disappearance;
	private Gene vacuolisation;
	private Gene spongiosis;
	private Gene sawYooth;
	private Gene follicular;
	private Gene perifollicular;
	private Gene inflammatory;
	private Gene bandLike;
	private Gene age;
	private Gene classDisease;
	
	private Float function1;
	private Float function2;
	private Float fitness;
	
	public Integer getIdDermatology() {
		return idDermatology;
	}
	public void setIdDermatology(Integer idDermatology) {
		this.idDermatology = idDermatology;
	}
	public Gene getErythema() {
		return erythema;
	}
	public void setErythema(Gene erythema) {
		this.erythema = erythema;
	}
	public Gene getScaling() {
		return scaling;
	}
	public void setScaling(Gene scaling) {
		this.scaling = scaling;
	}
	public Gene getDefiniteBorders() {
		return definiteBorders;
	}
	public void setDefiniteBorders(Gene definiteBorders) {
		this.definiteBorders = definiteBorders;
	}
	public Gene getItching() {
		return itching;
	}
	public void setItching(Gene itching) {
		this.itching = itching;
	}
	public Gene getKoebnerPhenomenon() {
		return koebnerPhenomenon;
	}
	public void setKoebnerPhenomenon(Gene koebnerPhenomenon) {
		this.koebnerPhenomenon = koebnerPhenomenon;
	}
	public Gene getPolygonalPapules() {
		return polygonalPapules;
	}
	public void setPolygonalPapules(Gene polygonalPapules) {
		this.polygonalPapules = polygonalPapules;
	}
	public Gene getFollicularPapules() {
		return follicularPapules;
	}
	public void setFollicularPapules(Gene follicularPapules) {
		this.follicularPapules = follicularPapules;
	}
	public Gene getOralMucosalInvolvement() {
		return oralMucosalInvolvement;
	}
	public void setOralMucosalInvolvement(Gene oralMucosalInvolvement) {
		this.oralMucosalInvolvement = oralMucosalInvolvement;
	}
	public Gene getKneeElbowInvolvement() {
		return kneeElbowInvolvement;
	}
	public void setKneeElbowInvolvement(Gene kneeElbowInvolvement) {
		this.kneeElbowInvolvement = kneeElbowInvolvement;
	}
	public Gene getScalpInvolvement() {
		return scalpInvolvement;
	}
	public void setScalpInvolvement(Gene scalpInvolvement) {
		this.scalpInvolvement = scalpInvolvement;
	}
	public Gene getFamilyHistory() {
		return familyHistory;
	}
	public void setFamilyHistory(Gene familyHistory) {
		this.familyHistory = familyHistory;
	}
	public Gene getMelaninIncontinence() {
		return melaninIncontinence;
	}
	public void setMelaninIncontinence(Gene melaninIncontinence) {
		this.melaninIncontinence = melaninIncontinence;
	}
	public Gene getEosinophils() {
		return eosinophils;
	}
	public void setEosinophils(Gene eosinophils) {
		this.eosinophils = eosinophils;
	}
	public Gene getPnlInfiltrate() {
		return pnlInfiltrate;
	}
	public void setPnlInfiltrate(Gene pnlInfiltrate) {
		this.pnlInfiltrate = pnlInfiltrate;
	}
	public Gene getFibrosis() {
		return fibrosis;
	}
	public void setFibrosis(Gene fibrosis) {
		this.fibrosis = fibrosis;
	}
	public Gene getExocytosis() {
		return exocytosis;
	}
	public void setExocytosis(Gene exocytosis) {
		this.exocytosis = exocytosis;
	}
	public Gene getAcanthosis() {
		return acanthosis;
	}
	public void setAcanthosis(Gene acanthosis) {
		this.acanthosis = acanthosis;
	}
	public Gene getHyperkeratosis() {
		return hyperkeratosis;
	}
	public void setHyperkeratosis(Gene hyperkeratosis) {
		this.hyperkeratosis = hyperkeratosis;
	}
	public Gene getParakeratosis() {
		return parakeratosis;
	}
	public void setParakeratosis(Gene parakeratosis) {
		this.parakeratosis = parakeratosis;
	}
	public Gene getClubbing() {
		return clubbing;
	}
	public void setClubbing(Gene clubbing) {
		this.clubbing = clubbing;
	}
	public Gene getElongation() {
		return elongation;
	}
	public void setElongation(Gene elongation) {
		this.elongation = elongation;
	}
	public Gene getThinning() {
		return thinning;
	}
	public void setThinning(Gene thinning) {
		this.thinning = thinning;
	}
	public Gene getSpongiform() {
		return spongiform;
	}
	public void setSpongiform(Gene spongiform) {
		this.spongiform = spongiform;
	}
	public Gene getMunroIcroabcess() {
		return munroIcroabcess;
	}
	public void setMunroIcroabcess(Gene munroIcroabcess) {
		this.munroIcroabcess = munroIcroabcess;
	}
	public Gene getFocalHypergranulosis() {
		return focalHypergranulosis;
	}
	public void setFocalHypergranulosis(Gene focalHypergranulosis) {
		this.focalHypergranulosis = focalHypergranulosis;
	}
	public Gene getDisappearance() {
		return disappearance;
	}
	public void setDisappearance(Gene disappearance) {
		this.disappearance = disappearance;
	}
	public Gene getVacuolisation() {
		return vacuolisation;
	}
	public void setVacuolisation(Gene vacuolisation) {
		this.vacuolisation = vacuolisation;
	}
	public Gene getSpongiosis() {
		return spongiosis;
	}
	public void setSpongiosis(Gene spongiosis) {
		this.spongiosis = spongiosis;
	}
	public Gene getSawYooth() {
		return sawYooth;
	}
	public void setSawYooth(Gene sawYooth) {
		this.sawYooth = sawYooth;
	}
	public Gene getFollicular() {
		return follicular;
	}
	public void setFollicular(Gene follicular) {
		this.follicular = follicular;
	}
	public Gene getPerifollicular() {
		return perifollicular;
	}
	public void setPerifollicular(Gene perifollicular) {
		this.perifollicular = perifollicular;
	}
	public Gene getInflammatory() {
		return inflammatory;
	}
	public void setInflammatory(Gene inflammatory) {
		this.inflammatory = inflammatory;
	}
	public Gene getBandLike() {
		return bandLike;
	}
	public void setBandLike(Gene bandLike) {
		this.bandLike = bandLike;
	}
	public Gene getAge() {
		return age;
	}
	public void setAge(Gene age) {
		this.age = age;
	}
	public Gene getClassDisease() {
		return classDisease;
	}
	public void setClassDisease(Gene classDisease) {
		this.classDisease = classDisease;
	}
	public Float getFunction1() {
		return function1;
	}
	public void setFunction1(Float function1) {
		this.function1 = function1;
	}
	public Float getFunction2() {
		return function2;
	}
	public void setFunction2(Float function2) {
		this.function2 = function2;
	}
	
	public Float getFitness() {
		return fitness;
	}
	public void setFitness(Float fitness) {
		this.fitness = fitness;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idDermatology == null) ? 0 : idDermatology.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chromossomo other = (Chromossomo) obj;
		if (idDermatology == null) {
			if (other.idDermatology != null)
				return false;
		} else if (!idDermatology.equals(other.idDermatology))
			return false;
		return true;
	}
	public static Chromossomo buildChromossome(Random r) {
		Chromossomo c = new Chromossomo();
		
		c.idDermatology = new Integer(AlgoritGenetic.id++);
		c.erythema = new Gene(r,3,0);
		c.scaling= new Gene(r,3,0);
		c.definiteBorders= new Gene(r,3,0);
		c.itching= new Gene(r,3,0);
		c.koebnerPhenomenon= new Gene(r,3,0);
		c.polygonalPapules= new Gene(r,3,0);
		c.follicularPapules= new Gene(r,3,0);
		c.oralMucosalInvolvement= new Gene(r,3,0);
		c.kneeElbowInvolvement= new Gene(r,3,0);
		c.scalpInvolvement= new Gene(r,3,0);
		c.familyHistory= new Gene(r,1,0);
		c.melaninIncontinence= new Gene(r,3,0);
		c.eosinophils= new Gene(r,3,0);
		c.pnlInfiltrate= new Gene(r,3,0);
		c.fibrosis= new Gene(r,3,0);
		c.exocytosis= new Gene(r,3,0);
		c.acanthosis= new Gene(r,3,0);
		c.hyperkeratosis= new Gene(r,3,0);
		c.parakeratosis= new Gene(r,3,0);
		c.clubbing= new Gene(r,3,0);
		c.elongation= new Gene(r,3,0);
		c.thinning= new Gene(r,3,0);
		c.spongiform= new Gene(r,3,0);
		c.munroIcroabcess= new Gene(r,3,0);
		c.focalHypergranulosis= new Gene(r,3,0);
		c.disappearance= new Gene(r,3,0);
		c.vacuolisation= new Gene(r,3,0);
		c.spongiosis= new Gene(r,3,0);
		c.sawYooth= new Gene(r,3,0);
		c.follicular= new Gene(r,3,0);
		c.perifollicular= new Gene(r,3,0);
		c.inflammatory= new Gene(r,3,0);
		c.bandLike= new Gene(r,3,0);
		c.age= new Gene(r,79,0);
		c.classDisease= new Gene(r,6,1);
		
		return c;
	}
	
	public static void printPopulation(List<Chromossomo> list) {
		for(Chromossomo c: list) {
			System.out.println(c);
		}
	}
	
	@Override
	public String toString() {
		return " ID: " + idDermatology +
				" Fitness:" + this.getFitness() +
				" F1:" + this.getFunction1() +
		        " F2:" + this.getFunction2();
	}
	
	public static void printChromossomo(Chromossomo c) {
		try {
			System.out.println("id: " + c.getIdDermatology());
			for (Field field : c.getClass().getDeclaredFields()) {
				field.setAccessible(true); 
											
				Object o = field.get(c);
				if (o instanceof Gene) {
					o = (Gene) o;
					Gene value = (Gene) field.get(c);
					if (value != null && value.getWeigth() != null
							&& value.getWeigth() >= Fitness.threshold) {
						if (field.getName().equals("idDermatology")) {
							System.out.println(field.getName() + " "
									+ value.getOperator() + " "
									+ value.getValue() + "| "
									+ value.getWeigth());
						} else {
							System.out.println(field.getName() + " "
									+ value.getOperator().getNumVal() + " "
									+ value.getValue() + "| "
									+ value.getWeigth());
						}
					}
				}
			}
			System.out.println("Fit:" + c.getFitness()  + "F1:" + c.getFunction1() + "F2:" + c.getFunction2());
			System.out.println("\n ");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public Chromossomo clone() throws CloneNotSupportedException {
        return (Chromossomo) super.clone();
    }
}
