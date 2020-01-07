package permutation;

public class StringPermutation {
	
	private static void permuatation1(String str) {
		permuatation1(str, "");
	}

	private static void permuatation1(String str, String prefix) {
		if(str.length() == 0) {
			System.out.println(prefix);
		}else {
			for(int i=0; i < str.length(); i++) {
				String rem = str.substring(0, i) + str.substring(i+1);
				permuatation1(rem, prefix + str.charAt(i));
			}
		}
	}
	
	
      private static void generate(int n, char[] array) {
    	  if(n ==1) {
    		  System.out.println(array);
    	  }else {
    	  
    	  for(int i=0; i <n-1; i++) {
    		  generate(n-1, array);
    		  if(n%2 == 0) {
    			  swap(array, i, n-1);
    		  }else {
    			  swap(array, 0, n-1);
    		  }
    	  }
    	  
    	  generate(n-1, array);
    	  
    	  }
      }

      
      private static void swap(char[] array, int i, int j) {
    	  char temp = array[i];
    	  array[i] = array[j];
    	  array[j] = temp;
      }
	
		
	
	
	
	
	public static void main(String[] args) {
		//permuatation1("d");
		generate(3,new char[] {'a','b', 'c'});
	}

}
