import java.util.*;
// Approach 1- Arrays
class Solution{ // TC O(1) SC O(1)

    // Number of empty slots for each type of car
    int[] empty;

    public Solution(int big, int medium, int small) {
        this.empty = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {

        // If space is available, allocate and return True
        if (this.empty[carType - 1] > 0) {
            this.empty[carType - 1]--;
            return true;
        }

        // Else, return False
        return false;
    }
}

// Approach 2- HashMap
class Solution1{ // TC O(1) SC O(1)
    
    Map<Integer, Integer> map=new HashMap<>();
    
    public Solution1(int big, int medium, int small) {
        this.map.put(1, big);
        this.map.put(2, medium);
        this.map.put(3, small);
    }
    
    public boolean addCar(int carType) {
        boolean slot=this.map.get(carType)>0;
        if (slot){
            this.map.put(carType, this.map.get(carType)-1);
            return true;
        }
        return false;
    }
}

class parkingSystem{
    public static void main(String[] args) {
        Solution s=new Solution(1,1,0);
        System.out.println(s.addCar(1));
        System.out.println(s.addCar(2));
        System.out.println(s.addCar(3));
        System.out.println(s.addCar(1));

    }
}
