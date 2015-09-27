package algorithms;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class StringLib {
	
	public static List<List<Integer>> permute(int[] numbers) {
	    // we use a list of lists rather than a list of arrays 
	    // because lists support adding in the middle
	    // and track current length
	    List<List<Integer>> permutations = new ArrayList<List<Integer>>();
	    // Add an empty list so that the middle for loop runs
	    permutations.add(new ArrayList<Integer>());

	    for ( int i = 0; i < numbers.length; i++ ) {
	        // create a temporary container to hold the new permutations 
	        // while we iterate over the old ones
	        List<List<Integer>> current = new ArrayList<List<Integer>>();
	        for ( List<Integer> permutation : permutations ) {
	            for ( int j = 0, n = permutation.size() + 1; j < n; j++ ) {
	                List<Integer> temp = new ArrayList<Integer>(permutation);
	                temp.add(j, numbers[i]);
	                current.add(temp);
	            }
	        }
	        permutations = new ArrayList<List<Integer>>(current);
	    }

	    return permutations;
	}
		
	public static void main(String[] args){
		int[] i ={1,2,3};
		permute(i);
	}
}