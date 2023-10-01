package test;

import java.util.PriorityQueue;

public class TestPriorityQueue {

	public static void main(String[] args) {

		// example of heap
		/*PriorityQueue<Patient> queue = new PriorityQueue<>();
		
		queue.add(new Patient("Nik", 20));
		queue.add(new Patient("Anuj", 90));
		queue.add(new Patient("Pankaj", 80));
		
		while (!queue.isEmpty()) {
			System.out.println(queue.poll().name);
		}
		
		}*/
		
		 

		/*PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.add(5);
		queue.add(4);
		queue.add(3);
		queue.add(2);
		queue.add(1);*/

		/*while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}*/
		
		
		int nums [] = { 1, 2 ,3 , 4 , 5};
		System.out.println(findKthLargest(nums, 2));

	}
	
	
	
	 public static int findKthLargest(int[] nums, int k) {

	       PriorityQueue<Integer> queue = new PriorityQueue<>();

			for (int i = 0; i < nums.length; i++) {
				queue.add(nums[i]);
				if (queue.size() > k) {	
					
					System.out.println(queue.poll());
				}

			}
	        
	        return queue.poll();
	    }
}

class Patient implements Comparable<Patient> {
	String name;
	Integer age;

	Patient(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Patient o) {

		return -this.age.compareTo(o.age);
	}

}
