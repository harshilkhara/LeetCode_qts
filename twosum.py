#Time complexity O(n)  SC O(N)
#in terms of understanding it is easy
def twosum1(nums,target):
    h={}         #nothing but creating dict()
    for i in range(len(nums)):
        complement=target-nums[i]
        if complement in h:          
            return [h[complement],i]
        h[nums[i]]=i                      #here it does not create complement map but duplicates 
                                          #the list
 

def twosum(nums,target):     #Optimal method, use hash maps------Time complexity O(n)
    complementMap=dict()
    for i in range(len(nums)):
        num=nums[i]
        complement=target-num
        if num in complementMap:
            return[complementMap[num],i]     # returning dictionary's complement[num]== corresponding value
        else:
            complementMap[complement]=i     #adding complement into dict()
                

def brute(nums,target):    #brute force method   ---- Time complexity O(n^2)    //SC O(n)

    for i in range(n):        
        for j in range(i+1,n):
            sum= nums[i]+nums[j]
            if sum==target:
                if i==j:
                    return
                return [i,j],nums[i],nums[j]

nums=[1,2,3,4,5]
target=8
n=len(nums)
print(n)
print(twosum1(nums,target))
print(twosum(nums,target))
print(brute(nums,target))
#<------------------------- When array is sorted ------------------------------------------->
#when the array is sorted 
#this the most optimized one #here we use two pointer approach
  
def twosum2(numbers,target1): #TC O(n)    //SC O(1)--> because no hash table used   
    left,right=0,len(numbers)-1
    while left<right:
        sum=numbers[left]+numbers[right]
        if sum==target1:
            return [left,right]
        elif sum<target1:
            left+=1
        else:
            right-=1
    return

def twoSum3(numbers,target1):  
    for i in range(len(numbers)):    # TC O(n logn)     iterating through loop and finding the key with binary search     //SC O(1)
        complement=target1-numbers[i]
        l,r=0,len(nums)-1
        while l<=r:
            mid=l+(r-l)//2
            if numbers[mid]==complement:
                return[i,mid]
            elif numbers[mid]<complement:
                l=mid+1
            else:
                r=mid-1
    return

numbers=[2,7,11,15]
target1=9
print(twosum2(numbers,target1))
print(twoSum3(numbers,target1))



