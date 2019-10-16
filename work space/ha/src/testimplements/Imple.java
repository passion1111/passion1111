package testimplements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Iterator;

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
	
	@Test
	public void iter() {
		HashMap<String, String> hash=new HashMap<String, String>();
		hash.put("1", "2");
		hash.put("2","3");
		Iterator<?> ha=hash.keySet().iterator();
		int i=1;
		while(ha.hasNext()) {
			assertEquals("¸Â´Ï", hash.get(Integer.toString(i)), hash.get(ha.next()));
			i+=1;
		}
	}
	public HashMap<String, String> ha(){
		HashMap<String, String> ha=new HashMap<String, String>();
		return new HashMap<String, String>();
	}
	@Test
	public void hashmethod() throws NoSuchMethodException, SecurityException {
		System.out.println(ha().getClass());
	}
	
}
