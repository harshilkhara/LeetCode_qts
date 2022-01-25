def searchRange(nums,target): # TC O(log n) // SC (1)

    lower_bound =findBound(nums, target, True)
    if (lower_bound == -1):
        return [-1, -1]

    upper_bound =findBound(nums, target, False)

    return [lower_bound, upper_bound]
def findBound(nums,target,isFirst):
    N = len(nums)
    begin, end = 0, N - 1
    while begin <= end:
        mid = int((begin + end) / 2)    

        if nums[mid] == target:

            if isFirst:
                # This means we found our lower bound.
                if mid == begin or nums[mid - 1] < target:
                    return mid

                # Search on the left side for the bound.
                end = mid - 1
            else:

                # This means we found our upper bound.
                if mid == end or nums[mid + 1] > target:
                    return mid

                # Search on the right side for the bound.
                begin = mid + 1

        elif nums[mid] > target:
            end = mid - 1
        else:
            begin = mid + 1

    return -1

def searchRange1(nums,target): # TC O(log n) // SC (1)
    def binarySearchLeft(A, x):
        left, right = 0, len(A) - 1
        while left <= right:
            mid = (left + right) // 2
            if x > A[mid]: left = mid + 1
            else: right = mid - 1
        return left

    def binarySearchRight(A, x):
        left, right = 0, len(A) - 1
        while left <= right:
            mid = (left + right) // 2
            if x >= A[mid]: left = mid + 1
            else: right = mid - 1
        return right

    left, right = binarySearchLeft(nums, target), binarySearchRight(nums, target)
    return [left, right] if left <= right else [-1, -1]

print(searchRange([5,7,7,8,8,10],8))
print(searchRange1([3,3,3,3,3],3))