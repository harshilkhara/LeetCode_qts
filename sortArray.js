// Approach 1- Merge Sort
var sortArray = function(nums) { // TC O(n log n) SC O(n)
    let tempArr = Array(nums.length).fill(0);
    
    // Function to merge two sub-arrays in sorted order.
    let merge = (left, mid, right) => {
        // Calculate the start and sizes of two halves.
        let start1 = left;
        let start2 = mid + 1;
        let n1 = mid - left + 1;
        let n2 = right - mid;
        
        // Copy elements of both halves into a temporary array.
        for (let i = 0; i < n1; i++) {
            tempArr[start1 + i] = nums[start1 + i];
        }
        for (let i = 0; i < n2; i++) {
            tempArr[start2 + i] = nums[start2 + i];
        }

        // Merge the sub-arrays 'in tempArray' back into the original array 'arr' in sorted order.
        let i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (tempArr[start1 + i] <= tempArr[start2 + j]) {
                nums[k] = tempArr[start1 + i];
                i += 1;
            } else {
                nums[k] = tempArr[start2 + j];
                j += 1;
            }
            k += 1;
        }

        // Copy remaining elements
        while (i < n1) {
            nums[k] = tempArr[start1 + i];
            i += 1;
            k += 1;
        }
        while (j < n2) {
            nums[k] = tempArr[start2 + j];
            j += 1;
            k += 1;
        }
    }

    // Recursive function to sort an array using merge sort
    let mergeSort = (left, right) => {
        if (left >= right) {
            return;
        }
        let mid = Math.floor((left + right) / 2);
        // Sort first and second halves recursively.
        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        // Merge the sorted halves.
        merge(left, mid, right);
    }
    
    mergeSort(0, nums.length - 1);
    return nums;
};

// Approach 2- Heap Sort
var sortArray1 = function(nums) { // TC O(n log n) SC O(log n)
    // Function to heapify a subtree (in top-down order) rooted at index i.
    let heapify = (n, i) => {
        // Initialize largest as root 'i'.
        let largest = i; 
        let left = 2 * i + 1;
        let right = 2 * i + 2; 
        // If left child is larger than root.
        if (left < n && nums[left] > nums[largest]) {
            largest = left;
        }
        // If right child is larger than largest so far.
        if (right < n && nums[right] > nums[largest]) {
            largest = right;
        }
        // If largest is not root swap root with largest element
        // Recursively heapify the affected sub-tree (i.e. move down).
        if (largest != i) {
            [nums[i], nums[largest]] = [nums[largest], nums[i]];
            heapify(n, largest);
        }
    }

    let heapSort = () => {
        let n = nums.length;
        // Build heap; heapify (top-down) all elements except leaf nodes.
        for (let i = Math.floor(n / 2) - 1; i >= 0; i--) {
            heapify(n, i);
        }
        // Traverse elements one by one, to move current root to end, and
        for (let i = n - 1; i > 0; i--) {
            [nums[0], nums[i]] = [nums[i], nums[0]];
            // call max heapify on the reduced heap.
            heapify(i, 0);
        }
    }
    
    heapSort();
    return nums;
};

// Approach 3- Counting Sort
var sortArray2 = function(nums) { // TC O(n+k) SC O(n)
    let countingSort = () => {
        // Create the counting hash map.
        let counts = {};
        // Find the minimum and maximum values in the array.
        let minVal = Math.min(...nums); 
        let maxVal = Math.max(...nums); 

        // Update element's count in the hash map.
        nums.forEach(val => { 
            if (counts[val] == undefined) {
                counts[val] = 0;
            }
            counts[val] += 1 
        });
        
        let index = 0;
        // Place each element in its correct position in the array.
        for (let val = minVal; val <= maxVal; val += 1) {
            // Append all 'val's together if they exist.
            while (counts[val] > 0) {
                nums[index] = val;
                index += 1;
                counts[val] -= 1;
            }
        }
    }
    
    countingSort(nums);
    return nums;
};

// Approach 4- Radix Sort
var sortArray3 = function(nums) { // TC O(d(n+b)) SC O(n+b)
    // Counting sort function for each place value digit.
    let countingSort = placeValue => {
        let mapDigits = {};
        // Store the respective number based on it's digit.
        nums.forEach(val => {
            let digit = Math.floor(Math.abs(val) / placeValue);
            digit = digit % 10;
            
            if (mapDigits[digit] == undefined) {
                mapDigits[digit] = [];
            }
            mapDigits[digit].push(val);
        });

        // Overwrite 'nums' in sorted order of current place digits.
        let index = 0;
        for (let digit = 0; digit < 10; ++digit) {
            if (mapDigits[digit] == undefined) { 
                continue; 
            }
            mapDigits[digit].forEach(val => {
                nums[index] = val;
                index++;
            });
        }
    }
    
    // Radix sort function
    let radixSort = () => {
        // Find the absolute maximum element to find max number of digits.
        let maxElement = nums[0];
        nums.forEach(val => {
            maxElement = Math.max(Math.abs(val), maxElement);
        });
        let maxDigits = 0;
        while (maxElement > 0) {
            maxDigits += 1;
            maxElement /= 10;
        }

        // Radix sort, least significant digit place to most significant.
        let placeValue = 1;
        for (let digit = 0; digit < maxDigits; ++digit) {
            countingSort(placeValue);
            placeValue *= 10;
        }

        // Seperate out negatives and reverse them. 
        let negatives = [];
        let positives = [];
        nums.forEach(val => {
            if (val < 0) {
                negatives.push(val);
            } else {
                positives.push(val);
            }
        });
        negatives.reverse();
        // Final 'nums' will be 'negative' elements, then 'positive' elements.
        nums = [...negatives, ...positives];
    }
    
    radixSort(nums);
    return nums;
};

console.log(sortArray([5,2,3,1,1]))
console.log(sortArray1([5,2,3,1,1]))
console.log(sortArray2([5,2,3,1,1]))
console.log(sortArray3([5,2,3,1,1]))