package structures; /**
 * 
 */


import org.junit.Before;
import structures.MyHashMap;
import structures.MyLinearMapTest;

/**
 * @author downey
 *
 */
public class MyHashMapTest extends MyLinearMapTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		map = new MyHashMap<String, Integer>();
		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);
		map.put(null, 0);
	}
}
