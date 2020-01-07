package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Brute force pattern search.
 * Time Complexity: O(n)
 * Space complexity: O(1)
 */
public class BruteForcePatternSearch {

    /**
     * Search pattern in text and return all indexes of pattern.
     */
    public List<Integer> search(char[] text, char[] pattern) {
       List<Integer>  result = new ArrayList<>();
       for(int i=0; i<= text.length-pattern.length; i++) {
            if(isMatch(pattern, text, i)) {
                result.add(i);
            }
       }
       return result;
    }

    /**
     * Method to check if pattern matches with text starting from startIndex.
     */
    private boolean isMatch(char[] pattern, char[] text, int startIndex) {
        for(int i=0; i<pattern.length; i++) {
            if(pattern[i] != text[i+startIndex]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
       BruteForcePatternSearch patternSearch = new BruteForcePatternSearch();
       String pattern = "manish";
       String text = "manish";
       List<Integer> result  = patternSearch.search(text.toCharArray(), pattern.toCharArray());
       System.out.println("Index:" + result);

    }
}
