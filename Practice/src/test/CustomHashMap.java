package test;

public class CustomHashMap {

	Node[] table;

	public static void main(String[] args) {

		CustomHashMap map = new CustomHashMap();
		map.put(1, 30);
		map.put(2, 50);
		map.put(3, 60);
		map.put(1, 70);

		System.out.println(map.get(1));

	}

	public CustomHashMap() {
		table = new Node[16];
	}

	public void put(Integer key, int value) {

		//TODO: this does not override same key but created one more node
		// ideally it should update that node.

		int rowNumber = getTableNum(key.hashCode());
		if (table[rowNumber] == null) {
			// No entry is there in this row
			Node node = new Node(key, value, null);
			table[rowNumber] = node;
		}

		else {
			Node head = table[rowNumber];
			Node temp = head;
			Node node = new Node(key, value, temp);

			// add the node to the head.
			head = node;

			//System.out.println(head.key);
			//System.out.println(head.next.key);

			table[rowNumber] = head;
		}

	}

	public Integer get(Integer key) {

		int rowNum = getTableNum(key.hashCode());
		Node head = table[rowNum];

		Node temp = head;

		while (temp != null) {
			if (temp.key.equals(key)) {
				return temp.value;
			}
			temp = temp.next;

		}

		return null;

	}

	private int getTableNum(int hashCode) {
		//TODO: Custom hashing logic
		// return custom logic

		return 1;

	}

	class Node {

		Integer key;
		int value;
		Node next;

		public Node(Integer key, int value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;

		}
	}

}
