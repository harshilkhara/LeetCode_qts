import java.util.*;
class MyClass {

   private Map<String, Integer> map;

   MyClass() {
      map = new HashMap<>();
      map.put("foo", 1);
      map.put("bar", 3);
   }

   public int getValue(String input, int numRetries) throws Exception {
      try {
         return map.get(input);
      }
      catch (Exception e) {
         if (numRetries > 3) {
            throw e;
         }
         return getValue(input, numRetries + 1);
      }
   }
}

class studyDotCom{
   public static void main(String[] args) throws Exception {
      MyClass s=new MyClass();
      System.out.println(s.getValue("foo", 0));
      System.out.println(s.getValue("bar", 2)); 
      System.out.println(s.getValue("baz", 0)); 
      System.out.println(s.getValue("fubar", 1)); 
   }
}