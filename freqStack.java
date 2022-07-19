/*
Intuition

Evidently, we care about the frequency of an element. Let freq be a Map from xx to the number of 
ccurrences of x. Also, we (probably) care about maxfreq, the current maximum frequency of any 
element in the stack. This is clear because we must pop the element with the maximum frequency.
The main question then becomes: among elements with the same (maximum) frequency, 
how do we know which element is most recent? We can use a stack to query this information: 
the top of the stack is the most recent.

To this end, let group be a map from frequency to a stack of elements with that frequency. 
We now have all the required components to implement FreqStack.

Algorithm

Actually, as an implementation level detail, if x has frequency f, 
then we'll have x in all group[i] (i <= f), not just the top. This is because each 
group[i] will store information related to the ith copy of x.

Afterwards, our goal is just to maintain freq, group, and maxfreq as described above.
*/ 

import java.util.*; // TC O(1) // SC O(N)

class xyz {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxfreq;

    public xyz() {
        freq = new HashMap<Integer, Integer>();
        group = new HashMap<Integer, Stack<Integer>>();
        maxfreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        if (f > maxfreq)
            maxfreq = f;

        group.computeIfAbsent(f, z-> new Stack<Integer>()).push(x);
    }

    public int pop() {
        int x = group.get(maxfreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (group.get(maxfreq).size() == 0)
            maxfreq--;
        return x;
    }
 
} 

class freqStack {
    public static void main(String [] args){
        xyz obj = new xyz();
        obj.push(5);
        obj.push(7);
        obj.push(5);
        obj.push(7);
        obj.push(4);
        obj.push(5);
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
        System.out.println(obj.freq);
        System.out.println(obj.group);
        
        
    }
}

