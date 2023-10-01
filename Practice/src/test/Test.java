package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	
	 public static int fewestCoins(String coins) {
		    
	        Map<Character, Integer> map = new HashMap<>();
	        
	        for(int i=0;i<coins.length();i++){

	            if(map.get(coins.charAt(i))==null){
	                map.put(coins.charAt(i), 1);
	            }
	            else{
	                map.put(coins.charAt(i), map.get(coins.charAt(i))+1);
	            }
	        }

	        System.out.println(map.size());

	    
	        // 
	         List<String> list = new ArrayList<>();
	         String sub;
	       for (int i = 0; i < coins.length(); i++)  {
	           for (int j = i+1; j <= coins.length(); j++) {
	                sub=coins.substring(i, j);
	                boolean flag= true;
	               if(sub.length() >= map.size()){
	            	   
	            	   for(Character char1: map.keySet()) {
	            	    if(!sub.contains(char1.toString())){
	            	    	flag=false;
	            	    }
	            	   }
	            	   if(flag)
	                   list.add(sub);
	               }
	           }
	       }
	       
	       System.out.println(list.toString());

	        String minString="";
	       for(Character element : map.keySet()){
	           minString = minString.toString() + element;
	       }
	       
	       System.out.println(minString + " min");

	        int min=coins.length();    
	       for(String element: list){
	    	   
	        	   System.out.println("yes");
	               if(min >= element.length()){
	                min=element.length();
	           }
	       
	                
	    } 
	    return min;

	    }
	
	public static void main(String[] args) {
		
		String s="zhesvnctfvdspqkuyrjhykpadahbhjbatvsxlngbtxmqrbwqromfqzyabzrcoorbbyklndcqdjzcnsmgmwmpbgjqoykrvnafhqrwfajnfahyqocdbgfnlaozmffvvmoymbmytjvfcgttcijyyljdgwjbztlpswmalgbgpaplqgzqchflxtypttkrpfvxrtkzpzrscwbxqbwfqqvjcukjbsginxqmxryxieyavnzdiludhthpreyelgcnpsoqswsreogbmveofvusdsxcjvdrjkhxkqrqzjbrpljwuzplxczqeevvbvcwhnvzuszqvhlmaptylyufqzyldwwgezlqurzvorxwgdtgjilgydqvpkntwjbgihlwckorgrmxixylxjmlfvhbpoaboylcedyzeayigfagitkrextlipvqqhdmoerchoqxbypihdvpdtjrrkxroowtrexuhucxpiibvmuyarjwqpcoywawqwdmfpwvamisnskbhopoqdsrefjtmnmvkyccremktrniqwoofoeenbzvvlrfcsftapyujmwdupdqikocrdyexjbcxwqeaumqoklsqebuzeziiswzfzgyhvnwjcnshdybjywyaodsywmlmuueocfruntpztlbggsuzctocyilfzpszgrgjsimqypqopfumpmsjvmsbrcfwretbiekoxpmplpcgewmqigymreqevdydvgmuyytguexnycqhwialkbjgzcklmgxgijjyjlplrsxznfkoklxlvpxrbasbznvxasxztwnqbhqultkyfqxsaeqztxbuwpzdpkngnuoayckfykdlarmuwprgtghfxfbgpucqwbihemixqmypjedyedimaanpbdrxpvtoxmxzimgfaouzlteobnadoshnxnufgmypupeikfqrqyexoljhqsaneicvaerqxcngmsidszagpiuiiasrezakiuroadojxmvgqgdodwwjszyeruwnupqgmyrjxigaskpjmzpsbhgokwtfcisjzvepyebwrcpafxzhbdgjykhzemfomgxjphcscuxjnywoiwbdvusywqlsccvsropvrnxtmkgiwfvqfkotpdznjinpobubzbvstkkvubuucilxyhjbcilfldibmyebrlcnvnuuqfvhwxoorbyyiigppuftqswpksfdxicemjbftgoabwrqdoudfbyjutkeqakoarruhwuznnlydivfelxvtggkkkjmxlwbkbklbwfsvrbadvraqovanlsmklnfjxxvzdjlpyurxpjcssebtpznwoytjefobdynaiukctgrzjxzirzosjuncvhfhcnhhrajahitnbkvwtifcoqepqyzwyazzkddxywvgqxofsyxngevsdbatvzmziqpmjewiyorpzsupxoflqpbyzhtvvpjdcqnlvlzrzakvmxzbaeipmwouvpvgtekfkuajjogbxhjiiqisdbplotyakxjvkmxhtmyznhaylqjnqzrwrmgtumbbhflizbpeohsufreefajrcsfoghglucidbnlysamvyatutjdfnvhahxykurbrmmadeaxhghvfacnjxqjathltizloasimpzugutrjfozvgmdakdhaofiephsnuztnpqhdlfrfuyprcrcszmgplszwfndzihegtbxbspaucjbmsamjyqqraszaghzlgnfoasvljxltcnumquohlcgtfjmrmfccjrhfedlievtpieworwhyiucsetdtuquartspkotmxqpnkeluekveljyugrloqczljmwtmfkyvqguqquztpjidglpxqfxvhlftvvimvrozdyywopwyfovdzopwlumocnyuoumehvjqpzkcfcgihicdrdtttiixlhpikbvjgoblttgvmndkqggypgwsibcqahmyyeagklprtvojuwlcblwidhjpugkbuspeynaoocgkzrpcnbqajopjjlfthevbculqsozkndgojnjnxqsoqiazyesldujjlpeedrswybwlfyz"
				+ "zhesvnctfvdspqkuyrjhykpadahbhjbatvsxlngbtxmqrbwqromfqzyabzrcoorbbyklndcqdjzcnsmgmwmpbgjqoykrvnafhqrwfajnfahyqocdbgfnlaozmffvvmoymbmytjvfcgttcijyyljdgwjbztlpswmalgbgpaplqgzqchflxtypttkrpfvxrtkzpzrscwbxqbwfqqvjcukjbsginxqmxryxieyavnzdiludhthpreyelgcnpsoqswsreogbmveofvusdsxcjvdrjkhxkqrqzjbrpljwuzplxczqeevvbvcwhnvzuszqvhlmaptylyufqzyldwwgezlqurzvorxwgdtgjilgydqvpkntwjbgihlwckorgrmxixylxjmlfvhbpoaboylcedyzeayigfagitkrextlipvqqhdmoerchoqxbypihdvpdtjrrkxroowtrexuhucxpiibvmuyarjwqpcoywawqwdmfpwvamisnskbhopoqdsrefjtmnmvkyccremktrniqwoofoeenbzvvlrfcsftapyujmwdupdqikocrdyexjbcxwqeaumqoklsqebuzeziiswzfzgyhvnwjcnshdybjywyaodsywmlmuueocfruntpztlbggsuzctocyilfzpszgrgjsimqypqopfumpmsjvmsbrcfwretbiekoxpmplpcgewmqigymreqevdydvgmuyytguexnycqhwialkbjgzcklmgxgijjyjlplrsxznfkoklxlvpxrbasbznvxasxztwnqbhqultkyfqxsaeqztxbuwpzdpkngnuoayckfykdlarmuwprgtghfxfbgpucqwbihemixqmypjedyedimaanpbdrxpvtoxmxzimgfaouzlteobnadoshnxnufgmypupeikfqrqyexoljhqsaneicvaerqxcngmsidszagpiuiiasrezakiuroadojxmvgqgdodwwjszyeruwnupqgmyrjxigaskpjmzpsbhgokwtfcisjzvepyebwrcpafxzhbdgjykhzemfomgxjphcscuxjnywoiwbdvusywqlsccvsropvrnxtmkgiwfvqfkotpdznjinpobubzbvstkkvubuucilxyhjbcilfldibmyebrlcnvnuuqfvhwxoorbyyiigppuftqswpksfdxicemjbftgoabwrqdoudfbyjutkeqakoarruhwuznnlydivfelxvtggkkkjmxlwbkbklbwfsvrbadvraqovanlsmklnfjxxvzdjlpyurxpjcssebtpznwoytjefobdynaiukctgrzjxzirzosjuncvhfhcnhhrajahitnbkvwtifcoqepqyzwyazzkddxywvgqxofsyxngevsdbatvzmziqpmjewiyorpzsupxoflqpbyzhtvvpjdcqnlvlzrzakvmxzbaeipmwouvpvgtekfkuajjogbxhjiiqisdbplotyakxjvkmxhtmyznhaylqjnqzrwrmgtumbbhflizbpeohsufreefajrcsfoghglucidbnlysamvyatutjdfnvhahxykurbrmmadeaxhghvfacnjxqjathltizloasimpzugutrjfozvgmdakdhaofiephsnuztnpqhdlfrfuyprcrcszmgplszwfndzihegtbxbspaucjbmsamjyqqraszaghzlgnfoasvljxltcnumquohlcgtfjmrmfccjrhfedlievtpieworwhyiucsetdtuquartspkotmxqpnkeluekveljyugrloqczljmwtmfkyvqguqquztpjidglpxqfxvhlftvvimvrozdyywopwyfovdzopwlumocnyuoumehvjqpzkcfcgihicdrdtttiixlhpikbvjgoblttgvmndkqggypgwsibcqahmyyeagklprtvojuwlcblwidhjpugkbuspeynaoocgkzrpcnbqajopjjlfthevbculqsozkndgojnjnxqsoqiazyesldujjlpeedrswybwlfyz"
				+ "a";
		
		char []arr=s.toCharArray();
		
	
		System.out.println(s.length());
	    System.out.println(s.substring(0,2000));
	    System.out.println(s.substring(2000,s.length()-1));
		
		//System.out.println(Test.fewestCoins(""));
}
	
}
