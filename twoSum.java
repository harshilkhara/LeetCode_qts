import java.util.*;
public class twoSum{
    public static ArrayList<Integer> twoSum(int [] nums, int target){
        HashMap <Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return  new ArrayList<Integer>(Arrays.asList(map.get(complement),i));
            }
            map.put(nums[i], i);
        }
        // In case there is no solution, we'll just return null
        return null;
    }

    public static void main(String[] args){
        int []nums={1,2,3,4,5};
        int target=9;
        ArrayList<Integer> ans= new ArrayList<>();
        ans=twoSum(nums,target);
        System.out.println(ans);
        }
    }
// TC O (N) SC O(N)