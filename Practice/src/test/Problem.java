package test;

import java.util.HashMap;
import java.util.Map;

public class Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String mag[] = {"two" ,"times" ,"three" ,"is" ,"not", "four"};
		String note[] = {"two" ,"times" ,"two" ,"is" , "four"};

		checkMagazine(mag, note);
	}
	
	
	static void checkMagazine(String[] magazine, String[] note) {
		 Map<String,Integer> magzMap = new HashMap<>();
	        for(String element : magazine){

	             if(magzMap.get(element)!=null){
	                 magzMap.put(element,magzMap.get(element)+1);
	             }else{
	                 magzMap.put(element,1);
	             }   
	        }
	        boolean flag=true;	
	         for(String element : note){
	        	 if(magzMap.get(element)==null
	    	             || (magzMap.get(element).equals(0)) ){
	    	                flag=false;
	    	                System.out.println("No");
	    	                break;
	    	            }
	    	            else{
	    	               magzMap.put(element, magzMap.get(element)-1);
	    	            }
	    	        }

	    	        if(flag)
	    	        System.out.println("Yes");


	           
	        }
	       

}
