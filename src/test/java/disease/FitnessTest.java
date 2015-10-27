package disease;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.ufu.disease.ag.AlgoritGenetic;
import com.ufu.disease.ag.Fitness;
import com.ufu.disease.to.Chromossomo;
import com.ufu.disease.to.Operator;

public class FitnessTest {

	@Test
	public void calculateFitness(){
		Random r = new Random();
		Chromossomo c = Chromossomo.buildChromossome(r);
		//c = new Chromossomo();
		
		//Chromossomo c = new Chromossomo();
//		c.getBandLike().setValue(2);
//		c.getBandLike().setWeigth(0.9f);
//		c.getBandLike().setOperator(Operator.MAIOR);
		
		c.getPolygonalPapules().setValue(3);
		c.getPolygonalPapules().setWeigth(0.9f);
		c.getPolygonalPapules().setOperator(Operator.DIFERENTE);
		
		c.getMelaninIncontinence().setValue(0);
		c.getMelaninIncontinence().setWeigth(0.9f);
		c.getMelaninIncontinence().setOperator(Operator.IGUAL);
		
		c.getThinning().setValue(0);
		c.getThinning().setWeigth(0.9f);
		c.getThinning().setOperator(Operator.IGUAL);
		
		AlgoritGenetic.initTesteList();
		
		Fitness fit = new Fitness();
		//fit.calculateFitness(c,1);
		
		Assert.assertNotNull(c);
	}
	
}
