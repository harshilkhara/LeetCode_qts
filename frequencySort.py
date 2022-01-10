from collections import Counter     # TC O(n) // SC O(n) #this is most fastest in leetcode
def frequencySort(s):
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
1) Count frequency of letters from string in hash map.
2) Create heap data structure and push there counted letters with frequencies. 
   Heap will keep sorted array with O(logn) time complexity depending from frequency of letters.
3) Pop each item from heap and add letter to append from right side of array to output array
4) Return string from reversed output array. 
   We do reversed array because we popped out from heap small frequency letters first and reqirement is 
   most frequent letters should come first.
'''        

print(frequencySort("tree"))
print(frequencySort1("cccaaa"))
print(frequencySort2("Aabb"))
