package com.questions.arrays;

public class ProductExceptSelf {

	public static void main(String[] args) {

		int nums[] = { 1, 2, 3, 4 };
		//int nums[] = { -1, 1, 0, -3, 3 };

		//productExceptSelf(nums);
		productExceptSelfWithZeros(nums);
	}

	// Works but zero should not in present in input.
	public static int[] productExceptSelf(int[] nums) {

		int result[] = new int[nums.length];
		int data[] = new int[nums.length];

		//int product = 1;
		data[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			data[i] = nums[i] * data[i - 1];
		}

		for (int i = 0; i < nums.length; i++) {
			System.out.print(data[i] + ": ");
		}

		for (int i = 0; i < nums.length; i++) {

			result[i] = data[nums.length - 1] / nums[i];

		}

		System.out.println();
		for (int i = 0; i < nums.length; i++) {
			System.out.print(result[i] + ": ");
		}

		return result;
	}

	// Working solution 
	public static int[] productExceptSelfWithZeros(int[] nums) {

		int result[] = new int[nums.length];

		int product = 1;
		int zeroCount = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				product = product * nums[i];
			} else {
				zeroCount++;
			}
		}

		System.out.print(product + ": ");

		if (zeroCount == 0) {
			for (int i = 0; i < nums.length; i++) {
				result[i] = product / nums[i];
			}

		} else if (zeroCount == 1) {

			for (int i = 0; i < nums.length; i++) {

				if (nums[i] == 0) {
					result[i] = product;
				} else {
					result[i] = 0;
				}
			}
		}

		System.out.println();
		for (int i = 0; i < nums.length; i++) {
			System.out.print(result[i] + ": ");
		}

		return result;
	}

}
