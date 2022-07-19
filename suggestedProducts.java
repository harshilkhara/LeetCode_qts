/* Approach 1- Binary Search 

Intuition

Since the question asks for the result in a sorted order, let's start with sorting products. 
An advantage that comes with sorting is Binary Search, we can binary search for the prefix. 
Once we locate the first match of prefix, all we need to do is to add the next 3 words into the 
result (if there are any), since we sorted the words beforehand.

Algorithm

1. Sort the input products.
2. Iterate each character of the searchWord adding it to the prefix to search for.
3. After adding the current character to the prefix binary search for the prefix in the input.
4. Add next 3 strings from the current binary search start index till the prefix remains same.
5. Another optimization that can be done is reducing the binary search space to current start 
   index (This is due to the fact that adding more characters to the prefix will make the next 
   search result's index be at least > current search's index).

*/
import java.util.*;
class suggestedProducts{

	public static int lower_bound(String [] products, int start, String word){
		int i= start;
		int j = products.length; 
		int mid; 
		while (i < j){

			mid = (i+j)/2;

			if (products[mid].compareTo(word)>=0){
				j=mid; 
			}else{
				i=mid+1;
			}

		}
		return i;
	}
	// TC O (n log n) + O(m log n) n= products.length, m = searchWord.length()
	public static void main(String [] args) {   
		String [] products={"mobile","mouse","moneypot","monitor","mousepad"};
		String searchWord="mouse"; 

		Arrays.sort(products);

		List<List<String>> result = new ArrayList<>();
		int start=0, bsStart=0, n=products.length; 
		String prefix = new String();
		for (char  c: searchWord.toCharArray()){
			prefix+=c;

			// Get the starting index of word starting with 'prefix'
			start= lower_bound(products, bsStart, prefix);

			// Add empty vector to result 
			result.add(new ArrayList<>());

			// Add the words with the same prefix to the result.
            // Loop runs until `i` reaches the end of input or 3 times or till the
            // prefix is same for `products[i]` Whichever comes first.
            for (int i = start; i < Math.min(start + 3, n); i++) {
                if (products[i].length() < prefix.length() || !products[i].substring(0, prefix.length()).equals(prefix))
                    break;
                result.get(result.size() - 1).add(products[i]);
            }

            // Reduce the size of elements to binary search on since we know
            bsStart = Math.abs(start);
        }

        System.out.println(result); 

	}
}
