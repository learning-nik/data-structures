package test;

public class SquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 9 // 16

		// 10 --> 9 --> 1 

		int n = 10;

		for (int i = 1; i < n / 2; i++) {
			if ((i * i) == n) {
				System.out.println(i);
				break;
			} else if ((i * i) < n) {
				continue;
			} else {

				binarySearch(i - 1, i, n);
			}

		}

	}

	private static void binarySearch(int left, int right, int n) {

		// left = 3 // right = 4
		// left = 300 // right = 400

		//int a[] = {

		int factor = 1000000000;

		left = left * factor;
		right = right * factor;

		while (left < right) {

			int mid = (left + right) / 2;

			if ((mid / factor) * (mid / factor) == n) {
				System.out.println(mid);
				break;
			}

			else if ((mid / factor) * (mid / factor) > n) {
				left = mid + 1;
			}

			else {
				right = mid - 1;
			}
		}

	}

}
