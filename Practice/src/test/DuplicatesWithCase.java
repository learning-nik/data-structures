package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DuplicatesWithCase {

	public static void main(String[] args) {

		List<String> oldCustomAttrs = Arrays.asList("NIKHIL", "PANDITA");
		
		//List<String> newCustomAttrs = Arrays.asList("NIKHIL", "Pandita");

		//List<String> oldCustomAttrs = Collections.emptyList();

		List<String> newCustomAttrs = Arrays.asList("NikHIL", "Pandita", "NIKHIL", "Nikhil","ViKaS", "VIKAS","Vikas");

		//List<String> newCustomAttrs = Collections.emptyList();

		final Set<String> newCustomAttrsSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
		newCustomAttrsSet.addAll(newCustomAttrs);
		//newCustomAttrs.forEach(a -> newCustomAttrsSet.add(a));

		final Set<String> finalUpdatedSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
		oldCustomAttrs.stream().filter(a -> newCustomAttrsSet.contains(a)).forEach(a -> finalUpdatedSet.add(a));

		newCustomAttrs.forEach(a -> finalUpdatedSet.add(a));

		final List<String> finalUpdatedList = new ArrayList<>(finalUpdatedSet);
		
		finalUpdatedList.forEach(a->System.out.println(a));

		//List<String> oldCustomAttrs = Collections.emptyList();
		//List<String> newCustomAttrs = Collections.emptyList();

		/*List<String> newCustomAttrsWithoutDup = new ArrayList<>();
		for(int i=0;i<newCustomAttrs.size();i++) {
			boolean isPresent = false;
			for(int j=0;j<newCustomAttrsWithoutDup.size();j++) {
				if(newCustomAttrs.get(i).equalsIgnoreCase(newCustomAttrs.get(j))) {
					isPresent = true;
					break;
				}
			}
			if(!isPresent) {
				
			}
		}*/

		//Set<String> updatedAttrs = newCustomAttrs.stream().map(a -> a.toLowerCase()).collect(Collectors.toSet());

		//withoutDuplicates.forEach(a->System.out.println(a));

		//set.forEach(e->System.out.println(e));

		//System.out.println(set.contains("NIKHIL"));

		/*CaseInsensitiveHashSet hashSet = new CaseInsensitiveHashSet();
		newCustomAttrs.forEach(a -> hashSet.add(a));*/

		//List<String> withoutDuplicates = new ArrayList<>();

		/*for (final String newAttribute : hashSet) {
			boolean isPresent = false;
			for (String oldAttribute : oldCustomAttrs) {
				if (newAttribute.equalsIgnoreCase(oldAttribute)) {
					withoutDuplicates.add(oldAttribute);
					isPresent = true;
					break;
				}
		
			}
			if (!isPresent) {
				withoutDuplicates.add(newAttribute);
			}
		
		}*/

		//withoutDuplicates.forEach(a -> System.out.println(a));

	}

}

class CaseInsensitiveHashSet extends HashSet<String> {

	/** 
	 */
	private static final long serialVersionUID = -3188008825938713990L;

	@Override
	public boolean add(String e) {
		if (this.stream().anyMatch(element -> element.equalsIgnoreCase(e))) {
			return false;
		}

		return super.add(e);
	}

}
