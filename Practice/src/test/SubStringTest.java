package test;

import java.util.ArrayList;
import java.util.List;

public class SubStringTest {
	public static void main(String[] args) {

		String s = "zhesvnctfvdspqkuyrjhykpadahbhjbatvsxlngbtxmqrbwqromfqzyabzrcoorbbyklndcqdjzcnsmgmwmpbgjqoykrvnafhqrwfajnfahyqocdbgfnlaozmffvvmoymbmytjvfcgttcijyyljdgwjbztlpswmalgbgpaplqgzqchflxtypttkrpfvxrtkzpzrscwbxqbwfqqvjcukjbsginxqmxryxieyavnzdiludhthpreyelgcnpsoqswsreogbmveofvusdsxcjvdrjkhxkqrqzjbrpljwuzplxczqeevvbvcwhnvzuszqvhlmaptylyufqzyldwwgezlqurzvorxwgdtgjilgydqvpkntwjbgihlwckorgrmxixylxjmlfvhbpoaboylcedyzeayigfagitkrextlipvqqhdmoerchoqxbypihdvpdtjrrkxroowtrexuhucxpiibvmuyarjwqpcoywawqwdmfpwvamisnskbhopoqdsrefjtmnmvkyccremktrniqwoofoeenbzvvlrfcsftapyujmwdupdqikocrdyexjbcxwqeaumqoklsqebuzeziiswzfzgyhvnwjcnshdybjywyaodsywmlmuueocfruntpztlbggsuzctocyilfzpszgrgjsimqypqopfumpmsjvmsbrcfwretbiekoxpmplpcgewmqigymreqevdydvgmuyytguexnycqhwialkbjgzcklmgxgijjyjlplrsxznfkoklxlvpxrbasbznvxasxztwnqbhqultkyfqxsaeqztxbuwpzdpkngnuoayckfykdlarmuwprgtghfxfbgpucqwbihemixqmypjedyedimaanpbdrxpvtoxmxzimgfaouzlteobnadoshnxnufgmypupeikfqrqyexoljhqsaneicvaerqxcngmsidszagpiuiiasrezakiuroadojxmvgqgdodwwjszyeruwnupqgmyrjxigaskpjmzpsbhgokwtfcisjzvepyebwrcpafxzhbdgjykhzemfomgxjphcscuxjnywoiwbdvusywqlsccvsropvrnxtmkgiwfvqfkotpdznjinpobubzbvstkkvubuucilxyhjbcilfldibmyebrlcnvnuuqfvhwxoorbyyiigppuftqswpksfdxicemjbftgoabwrqdoudfbyjutkeqakoarruhwuznnlydivfelxvtggkkkjmxlwbkbklbwfsvrbadvraqovanlsmklnfjxxvzdjlpyurxpjcssebtpznwoytjefobdynaiukctgrzjxzirzosjuncvhfhcnhhrajahitnbkvwtifcoqepqyzwyazzkddxywvgqxofsyxngevsdbatvzmziqpmjewiyorpzsupxoflqpbyzhtvvpjdcqnlvlzrzakvmxzbaeipmwouvpvgtekfkuajjogbxhjiiqisdbplotyakxjvkmxhtmyznhaylqjnqzrwrmgtumbbhflizbpeohsufreefajrcsfoghglucidbnlysamvyatutjdfnvhahxykurbrmmadeaxhghvfacnjxqjathltizloasimpzugutrjfozvgmdakdhaofiephsnuztnpqhdlfrfuyprcrcszmgplszwfndzihegtbxbspaucjbmsamjyqqraszaghzlgnfoasvljxltcnumquohlcgtfjmrmfccjrhfedlievtpieworwhyiucsetdtuquartspkotmxqpnkeluekveljyugrloqczljmwtmfkyvqguqquztpjidglpxqfxvhlftvvimvrozdyywopwyfovdzopwlumocnyuoumehvjqpzkcfcgihicdrdtttiixlhpikbvjgoblttgvmndkqggypgwsibcqahmyyeagklprtvojuwlcblwidhjpugkbuspeynaoocgkzrpcnbqajopjjlfthevbculqsozkndgojnjnxqsoqiazyesldujjlpeedrswybwlfyzphixzluwbtmoxokksbedrqfuizopajzeahvalehdfnrkmnlpimduzgmwszcxmracvelbhjzmiwdnxwruqcugmkscfodjxghwcbmsokdspilajnibp"
				+ "zhesvnctfvdspqkuyrjhykpadahbhjbatvsxlngbtxmqrbwqromfqzyabzrcoorbbyklndcqdjzcnsmgmwmpbgjqoykrvnafhqrwfajnfahyqocdbgfnlaozmffvvmoymbmytjvfcgttcijyyljdgwjbztlpswmalgbgpaplqgzqchflxtypttkrpfvxrtkzpzrscwbxqbwfqqvjcukjbsginxqmxryxieyavnzdiludhthpreyelgcnpsoqswsreogbmveofvusdsxcjvdrjkhxkqrqzjbrpljwuzplxczqeevvbvcwhnvzuszqvhlmaptylyufqzyldwwgezlqurzvorxwgdtgjilgydqvpkntwjbgihlwckorgrmxixylxjmlfvhbpoaboylcedyzeayigfagitkrextlipvqqhdmoerchoqxbypihdvpdtjrrkxroowtrexuhucxpiibvmuyarjwqpcoywawqwdmfpwvamisnskbhopoqdsrefjtmnmvkyccremktrniqwoofoeenbzvvlrfcsftapyujmwdupdqikocrdyexjbcxwqeaumqoklsqebuzeziiswzfzgyhvnwjcnshdybjywyaodsywmlmuueocfruntpztlbggsuzctocyilfzpszgrgjsimqypqopfumpmsjvmsbrcfwretbiekoxpmplpcgewmqigymreqevdydvgmuyytguexnycqhwialkbjgzcklmgxgijjyjlplrsxznfkoklxlvpxrbasbznvxasxztwnqbhqultkyfqxsaeqztxbuwpzdpkngnuoayckfykdlarmuwprgtghfxfbgpucqwbihemixqmypjedyedimaanpbdrxpvtoxmxzimgfaouzlteobnadoshnxnufgmypupeikfqrqyexoljhqsaneicvaerqxcngmsidszagpiuiiasrezakiuroadojxmvgqgdodwwjszyeruwnupqgmyrjxigaskpjmzpsbhgokwtfcisjzvepyebwrcpafxzhbdgjykhzemfomgxjphcscuxjnywoiwbdvusywqlsccvsropvrnxtmkgiwfvqfkotpdznjinpobubzbvstkkvubuucilxyhjbcilfldibmyebrlcnvnuuqfvhwxoorbyyiigppuftqswpksfdxicemjbftgoabwrqdoudfbyjutkeqakoarruhwuznnlydivfelxvtggkkkjmxlwbkbklbwfsvrbadvraqovanlsmklnfjxxvzdjlpyurxpjcssebtpznwoytjefobdynaiukctgrzjxzirzosjuncvhfhcnhhrajahitnbkvwtifcoqepqyzwyazzkddxywvgqxofsyxngevsdbatvzmziqpmjewiyorpzsupxoflqpbyzhtvvpjdcqnlvlzrzakvmxzbaeipmwouvpvgtekfkuajjogbxhjiiqisdbplotyakxjvkmxhtmyznhaylqjnqzrwrmgtumbbhflizbpeohsufreefajrcsfoghglucidbnlysamvyatutjdfnvhahxykurbrmmadeaxhghvfacnjxqjathltizloasimpzugutrjfozvgmdakdhaofiephsnuztnpqhdlfrfuyprcrcszmgplszwfndzihegtbxbspaucjbmsamjyqqraszaghzlgnfoasvljxltcnumquohlcgtfjmrmfccjrhfedlievtpieworwhyiucsetdtuquartspkotmxqpnkeluekveljyugrloqczljmwtmfkyvqguqquztpjidglpxqfxvhlftvvimvrozdyywopwyfovdzopwlumocnyuoumehvjqpzkcfcgihicdrdtttiixlhpikbvjgoblttgvmndkqggypgwsibcqahmyyeagklprtvojuwlcblwidhjpugkbuspeynaoocgkzrpcnbqajopjjlfthevbculqsozkndgojnjnxqsoqiazyesldujjlpeedrswybwlfyzphixzluwbtmoxokksbedrqfuizopajzeahvalehdfnrkmnlpimduzgmwszcxmracvelbhjzmiwdnxwruqcugmkscfodjxghwcbmsokdspilajnibp"
				+ "zhesvnctfvdspqkuyrjhykpadahbhjbatvsxlngbtxmqrbwqromfqzyabzrcoorbbyklndcqdjzcnsmgmwmpbgjqoykrvnafhqrwfajnfahyqocdbgfnlaozmffvvmoymbmytjvfcgttcijyyljdgwjbztlpswmalgbgpaplqgzqchflxtypttkrpfvxrtkzpzrscwbxqbwfqqvjcukjbsginxqmxryxieyavnzdiludhthpreyelgcnpsoqswsreogbmveofvusdsxcjvdrjkhxkqrqzjbrpljwuzplxczqeevvbvcwhnvzuszqvhlmaptylyufqzyldwwgezlqurzvorxwgdtgjilgydqvpkntwjbgihlwckorgrmxixylxjmlfvhbpoaboylcedyzeayigfagitkrextlipvqqhdmoerchoqxbypihdvpdtjrrkxroowtrexuhucxpiibvmuyarjwqpcoywawqwdmfpwvamisnskbhopoqdsrefjtmnmvkyccremktrniqwoofoeenbzvvlrfcsftapyujmwdupdqikocrdyexjbcxwqeaumqoklsqebuzeziiswzfzgyhvnwjcnshdybjywyaodsywmlmuueocfruntpztlbggsuzctocyilfzpszgrgjsimqypqopfumpmsjvmsbrcfwretbiekoxpmplpcgewmqigymreqevdydvgmuyytguexnycqhwialkbjgzcklmgxgijjyjlplrsxznfkoklxlvpxrbasbznvxasxztwnqbhqultkyfqxsaeqztxbuwpzdpkngnuoayckfykdlarmuwprgtghfxfbgpucqwbihemixqmypjedyedimaanpbdrxpvtoxmxzimgfaouzlteobnadoshnxnufgmypupeikfqrqyexoljhqsaneicvaerqxcngmsidszagpiuiiasrezakiuroadojxmvgqgdodwwjszyeruwnupqgmyrjxigaskpjmzpsbhgokwtfcisjzvepyebwrcpafxzhbdgjykhzemfomgxjphcscuxjnywoiwbdvusywqlsccvsropvrnxtmkgiwfvqfkotpdznjinpobubzbvstkkvubuucilxyhjbcilfldibmyebrlcnvnuuqfvhwxoorbyyiigppuftqswpksfdxicemjbftgoabwrqdoudfbyjutkeqakoarruhwuznnlydivfelxvtggkkkjmxlwbkbklbwfsvrbadvraqovanlsmklnfjxxvzdjlpyurxpjcssebtpznwoytjefobdynaiukctgrzjxzirzosjuncvhfhcnhhrajahitnbkvwtifcoqepqyzwyazzkddxywvgqxofsyxngevsdbatvzmziqpmjewiyorpzsupxoflqpbyzhtvvpjdcqnlvlzrzakvmxzbaeipmwouvpvgtekfkuajjogbxhjiiqisdbplotyakxjvkmxhtmyznhaylqjnqzrwrmgtumbbhflizbpeohsufreefajrcsfoghglucidbnlysamvyatutjdfnvhahxykurbrmmadeaxhghvfacnjxqjathltizloasimpzugutrjfozvgmdakdhaofiephsnuztnpqhdlfrfuyprcrcszmgplszwfndzihegtbxbspaucjbmsamjyqqraszaghzlgnfoasvljxltcnumquohlcgtfjmrmfccjrhfedlievtpieworwhyiucsetdtuquartspkotmxqpnkeluekveljyugrloqczljmwtmfkyvqguqquztpjidglpxqfxvhlftvvimvrozdyywopwyfovdzopwlumocnyuoumehvjqpzkcfcgihicdrdtttiixlhpikbvjgoblttgvmndkqggypgwsibcqahmyyeagklprtvojuwlcblwidhjpugkbuspeynaoocgkzrpcnbqajopjjlfthevbculqsozkndgojnjnxqsoqiazyesldujjlpeedrswybwlfyzphixzluwbtmoxokksbedrqfuizopajzeahvalehdfnrkmnlpimduzgmwszcxmracvelbhjzmiwdnxwruqcugmkscfodjxghwcbmsokdspilajnibp";
		substrCount(7,s);
	}

	private static void allSubStrings(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				for (int k = i; k < j; k++) {
					sb.append(s.charAt(k));
				}
				System.out.println(sb.toString());
				sb.setLength(0);
				// System.out.println(s.substring(i, j));
			}

		}
	}

	static long substrCount(int n, String s) {

		List<String> set = new ArrayList<>();
		String sub;
		int i, j = 0;
		StringBuilder sb = new StringBuilder();
		for (i = 0; i < n; i++) {
			for (j = i + 1; j <= n; j++) {
				for (int k = i; k < j; k++) {
					sb.append(s.charAt(k));
				}
				sub = sb.toString();
				sb.setLength(0);
				if (sub.length() == 1) {
					set.add(sub);
				} else {

					if (checkForPalind(sub)) {
						set.add(sub);
					}
				}

			}

		}
		System.out.println(set.size());
		set.forEach(a -> System.out.print(a + " "));

		return set.size();

	}

	private static boolean checkForPalind(String s) {
		boolean flag = true;
		char one = s.charAt(0);

		for (int i = 1; i < s.length(); i++) {
			if (i == (s.length() / 2) && s.length()!=2) {
				continue;
			} else {
				if (!(s.charAt(i) == one)) {
					flag= false;
					break;
				}
			}
		}

		return flag;
	}

}
