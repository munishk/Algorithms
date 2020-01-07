package permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationCombinaton {

	public static void main(String[] args) {
		String[] elements = { "a", "b", "c", "d", "e" };
		int maxLength = 3;
		// combineStringFromElements(elements, "", maxLength);
		/*String[] results = getAllLists(elements, maxLength);
		for (String result : results) {
			System.out.println(result);
		}*/
		
		List<String> result = doIt(Arrays.asList(elements));
		System.out.println("Size:" + result.size());
		
	for(String value: result) {
		System.out.println(value);
	}
		
		
		
	}

	private static List<String> doIt(List<String> elements) {
		if (elements.size() == 1) {
			return elements;
		}

		List<String> resultSubList = new ArrayList<>();
		for (int i = 0; i < elements.size(); i++) {


			List<String> subList = doIt(createNewLList(elements, elements.get(i)));

			for (int j = 0; j < subList.size(); j++) {
				resultSubList.add(elements.get(i) + subList.get(j));
			}

		}
		return resultSubList;

	}

	private static List<String> createNewLList(List<String> elements, String exclude) {
		List<String> newList = new ArrayList<>();
		for (String element : elements) {
			if (element.equals(exclude))
				continue;
			newList.add(element);
		}
		return newList;
	}

	private static void combineStringFromElements(String[] elements, String currentString, int maxLength) {
		if (currentString.length() == maxLength) {
			System.out.println(currentString);
			return;
		}
		for (String element : elements) {
			combineStringFromElements(elements, currentString + element, maxLength);
		}
	}

	public static String[] getAllLists(String[] elements, int lengthOfList) {
		// initialize our returned list with the number of elements calculated
		// above
		String[] allLists = new String[(int) Math.pow(elements.length, lengthOfList)];

		// lists of length 1 are just the original elements
		if (lengthOfList == 1)
			return elements;
		else {
			// the recursion--get all lists of length 3, length 2, all the way
			// up to 1
			String[] allSublists = getAllLists(elements, lengthOfList - 1);

			// append the sublists to each element
			int arrayIndex = 0;

			for (int i = 0; i < elements.length; i++) {
				for (int j = 0; j < allSublists.length; j++) {
					// add the newly appended combination to the list
					allLists[arrayIndex] = elements[i] + allSublists[j];
					arrayIndex++;
				}
			}

			return allLists;
		}
	}

}
