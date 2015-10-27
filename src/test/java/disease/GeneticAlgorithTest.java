package disease;

import org.junit.Test;

import com.ufu.disease.to.Operator;

public class GeneticAlgorithTest {

	@Test
	public void testRandomEnum() {
		for(int i=0; i<=10; i++) {
			System.out.println(Operator.getRandom());
		}
	}
	
}
