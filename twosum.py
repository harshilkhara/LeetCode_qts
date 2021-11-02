def twosum(nums,target):     #Optimal method, use hash maps------Time complexity O(n)
    complementMap=dict()
    for i in range(len(nums)):
        num=nums[i]
        complement=target-num
        if num in complementMap:
            return[complementMap[num],i]     # returning dictionary's complement[num]== corresponding value
        else:
            complementMap[complement]=i     #adding into dict()
                

def brute(nums,target):    #brute force method   ---- Time complexity O(n^2)

    for i in range(n):        
        for j in range(1,n):
            sum= nums[i]+nums[j]
            if sum==target:
                if i==j:
                    return
                return [i,j],nums[i],nums[j]

            
nums=[1,2,3,4,5]
target=6
n=len(nums)
print(n)
print(twosum(nums,target))
print(brute(nums,target))