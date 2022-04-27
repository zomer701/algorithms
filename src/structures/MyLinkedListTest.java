package structures; /**
 * 
 */


import java.util.ArrayList;

import org.junit.Before;
import structures.MyArrayListTest;


/**
 * @author downey
 *
 */
public class MyLinkedListTest extends MyArrayListTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);

		mylist = new MyLinkedList<>();
		mylist.addAll(list);
	}
}
