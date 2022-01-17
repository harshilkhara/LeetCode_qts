def duplicateZeros(arr): # TC O(n) // SC O(1)  
    possible_dups = 0
    length_ = len(arr) - 1

    # Find the number of zeros to be duplicated
    for left in range(length_ + 1):

        # Stop when left points beyond the last element in the original list
        # which would be part of the modified list
        if left > length_ - possible_dups:
            break

        # Count the zeros
        if arr[left] == 0:
            # Edge case: This zero can't be duplicated. We have no more space,
            # as left is pointing to the last element which could be included  
            if left == length_ - possible_dups:
                arr[length_] = 0 # For this zero we just copy it without duplication.
                length_ -= 1
                break
            possible_dups += 1

    # Start backwards from the last element which would be part of new list.
    last = length_ - possible_dups

    # Copy zero twice, and non zero once.
    for i in range(last, -1, -1):
        if arr[i] == 0:
            arr[i + possible_dups] = 0
            possible_dups -= 1
            arr[i + possible_dups] = 0
        else:
            arr[i + possible_dups] = arr[i]

    return arr


def duplicateZeros1(arr): # TC O(n^2) // SC O(1)
    i = 0 
    while i < len(arr)-1:   # TC O(n)
        if arr[i]==0:
            arr.insert(i+1,0)   #TC O(n)
            arr.pop()
            i+=2
        else:
            i+=1

    return arr


def duplicateZeros2(arr):  # TC O(n) // SC (1) Fast one and short one 
    zeros,n = arr.count(0),len(arr)
    for i in range(n-1,-1,-1):
        # print(i,zeros,arr)
        if i+zeros<n:
            arr[i+zeros] = arr[i]
        if arr[i] == 0:
            zeros -= 1
            if i+zeros<n:
                arr[i+zeros] = arr[i]
    return arr
   
print(duplicateZeros([1,0,2,3,0,4,5,0]))
print(duplicateZeros1([1,0,2,3,0,4,5,0]))
print(duplicateZeros2([1,0,2,3,0,4,5,0]))