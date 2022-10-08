class Solution{
  public String lexicographicalMaxSubstring(String s){
    String maxi="";
    for (int i=0; i<s.length(); i++){
      //System.out.println(maxi.compareTo(s.substring(i)) <= 0);
      if (maxi.compareTo(s.substring(i)) <= 0) { 
          maxi = s.substring(i); 
            } 
    }
    return maxi;
  }
}
  
class lexicographicalMaxSubstring{
  public static void main(String[]args){
    String x= "baca";
    Solution s= new Solution();
    System.out.println(s.lexicographicalMaxSubstring(x));
  }
  
}