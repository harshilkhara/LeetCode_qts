#Most efficent one:      Most optimum found----Time complexity O(n)
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
                

def brute(nums,target):    #brute force method   ---- Time complexity O(n^2)

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