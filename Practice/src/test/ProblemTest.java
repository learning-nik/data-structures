package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProblemTest {

	public static void main(String[] args) {
		
		System.out.println(1/2);
		
		List<Long> list = new ArrayList<>();
		//list.add(1L);list.add(3L);list.add(9L);list.add(9L);list.add(27L);list.add(81L);
		list.add(1L);list.add(2L);list.add(1L);list.add(2L);list.add(4L);
		//list.add(1L);list.add(1L);list.add(1L);list.add(1L);list.add(1L);
		
		System.out.println(countTriplets(list, 2));

		/*int arr[] = { 1, 2, 3, 4, 5 };
		arr = rotateArray(arr, 1);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
*/
	}

	private static int[] rotateArray(int[] arr, final int noOfTimes) {

		int[] temp = new int[noOfTimes];

		for (int i = 0; i < noOfTimes; i++) {
			temp[i] = arr[i];
		}
		int k = 0;
		for (int i = noOfTimes; i < arr.length; i++) {
			arr[k++] = arr[i];
		}

		int a = arr.length - noOfTimes;
		for (int i = 0; i < noOfTimes; i++) {
			arr[a++] = temp[i];
		}
		return arr;
	}

	static long countTriplets(List<Long> arr, long r) {
		
		
/*		  long count =0;
	       for(long i=0;i<arr.size();i++){
	        for(long j=i+1;j<arr.size();j++){
	            if(arr.get((int)j)/arr.get((int)i) == r){
	                for(long k=j+1;k<arr.size();k++){
	                    if(arr.get((int)k)/arr.get((int)j) == r){
	                        count++;
	                    }
	                }
	            }
	            

	        }
	        }
	            return count;*/
		
		 long count=0;
	        Map<Long, Long> rightMap = new HashMap<>();
	        Map<Long, Long> leftMap = new HashMap<>();
	        for(Long element : arr) {
	            if(rightMap.get(element)==null) {
	                rightMap.put(element, 1L);
	            }
	            else {
	                rightMap.put(element, rightMap.get(element)+1L);
	            }
	        }
	        
	        for(Long element : arr) {

	            rightMap.put(element, rightMap.get(element)-1L);

	            Long v1 = leftMap.get(element/r);
	            Long v2 = rightMap.get(element*r);
	            if(v1!=null && v2!=null && (element%r==0)){
	                count=count +(v1*v2);
	            }

	            if(leftMap.get(element)!=null){
	            leftMap.put(element,leftMap.get(element)+1L);
	            }
	            else{
	                leftMap.put(element,1L);
	            }
	        
	        }
	        return count;
		
	}
	
	 
		
		  
}
