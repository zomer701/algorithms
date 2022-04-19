package structures; /**
 * 
 */


import org.junit.Before;
import structures.MyBetterMap;
import structures.MyLinearMapTest;

/**
 * @author downey
 *
 */
public class MyBetterMapTest extends MyLinearMapTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		map = new MyBetterMap<String, Integer>();
		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);
		map.put(null, 0);
	}
}
