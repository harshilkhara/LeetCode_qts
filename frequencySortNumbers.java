import java.util.*;
// Approach 1- With intermediate list
class Solution{ // TC O(n log n) SC O(n)
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        List<Integer> list=new ArrayList<>(map.keySet());
        Collections.sort(list, (a,b)-> map.get(a)==map.get(b) ? b-a : map.get(a)-map.get(b));
        int[] ans=new int[nums.length];
        int idx=0;
        for (int i=0; i<list.size(); i++){
            int freq=map.get(list.get(i));
            while (freq!=0){
                ans[idx]=list.get(i);
                freq--;
                idx++;
            }
        }
        return ans;
    }
}

// Approach 2- Without any intermediate list
class Solution1{ // TC O(n log n) SC O(n)
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        for(int n: nums){
            list.add(n);
            map.put(n, map.getOrDefault(n,0)+1);
        }
        Collections.sort(list, (a,b)-> map.get(a)==map.get(b) ? b-a : map.get(a)-map.get(b));
        return list.stream().mapToInt(i->i).toArray();
    }
}

class frequencySortNumbers{
    public static void main(String[] args) {
        int[] nums={1,1,2,2,2,3};
        Solution s= new Solution();
        System.out.println(Arrays.toString(s.frequencySort(nums)));
        Solution1 s1= new Solution1();
        System.out.println(Arrays.toString(s1.frequencySort(nums)));
    }
}

