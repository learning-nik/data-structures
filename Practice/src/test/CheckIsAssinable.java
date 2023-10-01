package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckIsAssinable {
	
	public static void main(String[] args) {
		
		System.out.println(String.class.isAssignableFrom(HashMap.class));
		
		/*		
		Integer value = 1;
		
		System.out.println(value/2);
		
		
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 2);
		map.put(2, 3);
		
		Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
		
		int sum=0;
		for(Map.Entry<Integer, Integer>  entry : entrySet) {
			sum=sum+(entry.getValue()/2);
		}
		
		System.out.println(sum);*/
		
	//	String s ="1bcds";
		
		//long l=s.length();
		
		//s.substring(0, (int)l);
		
		//System.out.println(s.substring(0,s.length()-1));
		
		String s ="aba";
		long n =10;
		
		 long lengthRequired =  n - s.length();
		// System.out.println(lengthRequired);
	        long noOfBatch = (lengthRequired/ s.length()) ;
	      //  System.out.println(noOfBatch);
	        long  rem = n - (noOfBatch+1)*(s.length());
	    //    System.out.println(rem);
	        int count=0;     

	         String srem= s.substring(0,(int)rem);
	         
	         //System.out.println(s);

	        for(int i=0 ; i< srem.length() ; i++){
	            if(srem.charAt(i) == 'a'){
	                count++;
	            }
	        } 

	      //  System.out.println(count);
	        
	        
	        
		
	}

}
