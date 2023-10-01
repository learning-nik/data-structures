package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Candies {

	public static void main(String[] args) throws IOException {

		int arr[] = new int[16387];
		String line = "";

		// parsing a CSV file into BufferedReader
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\npandita\\Desktop\\testcase.csv"));
		while ((line = br.readLine()) != null) {
			{
				String[] num = line.split("\\,"); // use | as separator
				for(int i=0;i<num.length;i++) {
				 arr[i]=Integer.parseInt(num[i]);
				}
			}
		}
		
		System.out.println(arr.length);
		
		candies(arr.length, arr);
		
		candies2(arr.length, arr);

	}

	static long candies(int n, int[] arr) {

		int temp[] = new int[n];
		temp[0]=1;
			for (int i = 1; i < n; i++) {
				if (arr[i] <= arr[i-1]) {
					temp[i] = 1;
				}

				else {
					temp[i] = temp[i-1] + 1;
				}
			}

		for (int i = n - 1; i > 0; i--) {
			if (arr[i - 1] > arr[i]) {
				if (temp[i - 1] <= temp[i]) {
					temp[i - 1] = temp[i - 1] + 1;
				}
			}

			else if (arr[i - 1] < arr[i]) {
				if (temp[i - 1] >= temp[i] && temp[i - 1] != 1) {
					temp[i - 1] = temp[i - 1] - 1;
				}
			}
		}

		long sum = 0L;
		for (int i = 0; i < n; i++) {
			sum += temp[i];
		}
		System.out.println(sum);
		return sum;
	}
	
	static long candies2(int n, int[] arr) {
		
		int left[] = new int[n];
		int right[] = new int[n];
		
		left[0]=1;
		
		for (int i = 1; i< n; i++) {
			if (arr[i] <= arr[i-1]) {
				left[i] = 1;
			}

			else {
				left[i] = left[i-1] + 1;
			}
		}
		
		right[n-1]=1;
		
		for (int i = n-1; i>0; i--) {
			if (arr[i-1] <= arr[i]) {
				right[i-1] = 1;
			}

			else {
				right[i-1] = right[i] + 1;
			}
		}
		
		long sum = 0L;
		for (int i = 0; i < n; i++) {
			sum += Math.max(left[i], right[i]);
		}
		System.out.println(sum);
		return sum;
		
	}
		

}
