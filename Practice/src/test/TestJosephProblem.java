package test;

public class TestJosephProblem {

	static int length = 4;
	
	public static void main(String[] args) {

		//System.out.println(getFinalIndex(4, 2, 0));
		System.out.println(getFinalIndex(6, 2, 0));

	}

	static int getFinalIndex(int n, int k, int current) {

		System.out.println(current+":"+n);
		if (n == 1) {
			return current;
		} else {
			//current = current + 1;
			if(current >= length) {
				current =length-current;
			}
			else {
				current= current+k;
			}
			
			return getFinalIndex(n -1 , k, current);

		}
	}

}
