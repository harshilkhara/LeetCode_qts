def twosum(nums,target):
    complementMap=dict()
    for i in range(len(nums)):
        num=nums[i]
        complement=target-num
        if num in complementMap:
            return[complementMap[num],i]
        else:
            complementMap[complement]=i
                
nums=[1,2,3,4,5]
target=9
twosum(nums,target)
print(twosum(nums,target))
