package structures;

/**
 * @author downey
 *
 */
public class ListNodeInt {

	public int data;
	public ListNodeInt next;

	public ListNodeInt() {
		this.data = 0;
		this.next = null;
	}

	public ListNodeInt(int data) {
		this.data = data;
		this.next = null;
	}

	public ListNodeInt(int data, ListNodeInt next) {
		this.data = data;
		this.next = next;
	}
	
	public String toString() {
		return "ListNode(" + data + ")";
	}
}
