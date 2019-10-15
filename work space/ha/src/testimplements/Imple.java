package testimplements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;


public class Imple {
	@Test
	public void checktest() {
		impletest ha=new impletest();
		impletest2 ha2=new impletest2();
		ha2.hoho();
		ha2.hoho();
		
		assertEquals(3, ha2.hohoho());
		assertEquals(5, ha2.hoho());
	}
}
