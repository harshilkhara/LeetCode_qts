// Coded up by me 
class Solution { // TC O(n) SC O(n)
    public int maximum69Number(int num) {
        String s= String.valueOf(num);
        StringBuilder sb= new StringBuilder();
        int allowed=1;
        for(char c: s.toCharArray()){
            if (c=='6' && allowed>0){
                sb.append('9');
                allowed--;
            } else {
                sb.append(c);
            }
        }
        return Integer.valueOf(sb.toString());
    }
}

// Approach 1- Convert int to iterable object
// Similar to above what I coded up 
class Solution1{ // TC O(n) SC O(n)
    public int maximum69Number (int num) {
        // Convert the input 'num' to a string builder 'numSB'.
        StringBuilder numSB = new StringBuilder();
        numSB.append(num);
        
        // Iterate over the string builer (from high to low).
        for (int i = 0; i < numSB.length(); ++i) {
            // If we find the first '6', replace it with '9' and break the loop.
            if (numSB.charAt(i) == '6') {
                numSB.setCharAt(i, '9');
                break;
            }
        }
        
        // Convert the modified string builder to integer and return it.
        return Integer.parseInt(numSB.toString());
    }
}

// Approach 2- Built-in Function 
class Solution2{ // TC O(n) SC O(n)
    public int maximum69Number (int num) {
        // Convert the input 'num' to the string 'numString'.
        String numString = "" + num;

        // Use the built-in function to replace the first '6' with '9'.
        // Return the integer converted from the modified 'numString'.
        return Integer.parseInt(numString.replaceFirst("6", "9"));
    }
}

// Approach 3- Check the remainder (most efficient one)
class Solution3{ // TC O(n) SC O(1)
    public int maximum69Number (int num) {
        // Since we start with the lowest digit, initialize currDigit = 0.
        int numCopy = num;
        int indexSix = -1;
        int currDigit = 0;
        
        // Check every digit of 'numCopy' from low to high.
        while (numCopy > 0) {
            // If the current digit is '6', record it as the highest digit of 6.
            if (numCopy % 10 == 6) 
                indexSix = currDigit;

            // Move on to the next digit.
            numCopy /= 10;
            currDigit++;
        }
        
        // If we don't find any digit of '6', return the original number,
        // otherwise, increment 'num' by the difference made by the first '6'.
        return indexSix == -1 ? num : num + 3 * (int)Math.pow(10, indexSix);
    }
}

class maximum69Number{
    public static void main(String[] args) {
        int num=9669;
        Solution s= new Solution();
        System.out.println(s.maximum69Number(num));
        Solution1 s1= new Solution1();
        System.out.println(s1.maximum69Number(num));
        Solution2 s2= new Solution2();
        System.out.println(s2.maximum69Number(num));
        Solution3 s3= new Solution3();
        System.out.println(s3.maximum69Number(num));
    }
}