package permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {
	List<String> list = new ArrayList<>();
	list.add("A");
	list.add("B");
	list.add("C");
	list.add("D");
	
	System.out.println("before:" + list);
	List<List<String>> allLists = computePermutation(list);
	System.out.println("####### Permutation ########");
	for(List<String> singleList: allLists) {
		System.out.println(singleList);
	}
	}
	
	private static List<List<String>> computePermutation(List<String> list) {
		if(list.size() == 1) {
			List<List<String>> newList = new ArrayList<>();
			newList.add(list);
			return newList;
		}
		List<List<String>> newList = new ArrayList<>();
		for(String item: list) {
			List<String> tempList = new ArrayList<>(list);
			tempList.remove(item);
			 List<List<String>>subList = computePermutation(tempList);
			for(List<String> singleList : subList) {
				singleList.add(item);
				newList.add(singleList);
			}
		}
		return newList;
	}

}
