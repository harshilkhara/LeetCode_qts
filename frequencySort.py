from collections import Counter 
def frequencySort4(s):    # TC O(n) // SC O(n) Fastest one using bucket sort rest uses comparison sort
    if not s: return s   # Therefore, O(n log n)
    
    # Determine the frequency of each character.
    counts = Counter(s)
    max_freq = max(counts.values())
    
    # Bucket sort the characters by frequency.       #TC O(n) but only when it is uniformly distributed. 
    buckets = [[] for _ in range(max_freq + 1)]      # for setting up the length of bucket sort array
    for c, i in counts.items():
        buckets[i].append(c)
        
    # Build up the string.
    string_builder = []
    for i in range(len(buckets) - 1, 0, -1):
        for c in buckets[i]:
            string_builder.append(c * i)
            
    return "".join(string_builder)

    
def frequencySort(s):  # TC O(n log n) // SC O(n) #this is most fastest in leetcode
    dic=Counter(s) 
    ans=""
    for k, v in dic.most_common() :
        ans+=k*v
    return ans

def frequencySort1(s):
    hash={}
    for i in s:
        if i in hash:
            hash[i]+=1
        else:
            hash[i]=1
    #sort the dictionary in reverse order using the value i.e. no. of times 
    # a char had appeared
    hash=dict(sorted(hash.items(),key=lambda item:item[1], reverse=True))
    result=[]
    for k,v in hash.items():
        result.append(k*v) #k --> key, v --> value
    return "".join(result)  


# using heaps // slowest one on leetcode 

'''
1) Count frequency of letters from string in hash map.
2) Create heap data structure and push there counted letters with frequencies. 
   Heap will keep sorted array with O(logn) time complexity depending from frequency of letters.
3) Pop each item from heap and add letter to append from right side of array to output array
4) Return string from reversed output array. 
   We do reversed array because we popped out from heap small frequency letters first and reqirement
   is most frequent letters should come first.
'''        

from heapq import *
def frequencySort2(s):
    count =Counter(s)      # --> count letters
    min_heap = []
    for character, frequency in count.items():
        heappush(min_heap, (frequency, character))       # --> push combination of letter and frequency to heap
    out = []
    while min_heap:      
        current = heappop(min_heap)          
        for i in range(current[0]):  # --> for evry popped letter and frequence pair we push to new array
            out.append(current[1])
    return ''.join(out[::-1])

'''
Intuition- Arrays and sorting
1) convert string to array.
2) sort the array.
3) group the string in such way that like-characters become one string in the array.
4) sort the new array based on length of strings from longest to shortest.
5) convert that array into string and return.
'''

def frequencySort3(s):    # TC O(n log n) // SC O(n)
    if not s: return s
    
    # Convert s to a list.      # TC O(n)
    s = list(s)
    
    # Sort the characters in s.    # TC O(n log n)
    s.sort()
    
    # Make a list of strings, one for each unique char.    #nothing but grouping 
    all_strings = []                          
    cur_sb = [s[0]]
    for c in s[1:]:
        # If the last character on string builder is different...
        if cur_sb[-1] != c:
            all_strings.append("".join(cur_sb))
            cur_sb = []
        cur_sb.append(c)
    all_strings.append("".join(cur_sb))
    
    # Sort the strings by length from *longest* to shortest.
    all_strings.sort(key=lambda string : len(string), reverse=True)       # TC O(n)
    
    # Convert to a single string to return.
    # Converting a list of strings to a string is often done
    # using this rather strange looking python idiom.
    return "".join(all_strings)


print(frequencySort("tree"))
print(frequencySort1("cccaaa"))
print(frequencySort2("Aabb"))
print(frequencySort3("tree"))
print(frequencySort4("Aabb"))
