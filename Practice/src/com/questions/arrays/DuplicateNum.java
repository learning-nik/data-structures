package com.questions.arrays;
/*https://leetcode.com/problems/find-the-duplicate-number/
*/
public class DuplicateNum {

	public static void main(String[] args) {

		int nums[]= {1,3,4,2,2};
		System.out.println(findDuplicate(nums));
		
	}
	   public static int findDuplicate(int[] nums) {
		     
	        int n=nums.length-1;
	        int sum = ((n)*(n+1))/2;
	        
	        System.out.println(sum);
	        
	       /* HashSet<Integer> set = new HashSet<>();
	        
	        for(int i=0;i<n;i++){
	            set.add(nums[i]);
	        }
	        
	        int finalSum=0;
	        for(Integer element : set){
	            finalSum = finalSum + element;
	        }
	        System.out.println(finalSum);*/
	        
	        int finalSum=0;
	        for(Integer element : nums) {
	        	finalSum = finalSum + element;
	        }
	        
	        return finalSum- sum;
	        
	    }

}
