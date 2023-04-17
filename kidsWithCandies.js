"use strict";
// Approach 1- Greedy Method
function kidsWithCandies(candies, extraCandies) { // TC O(n) SC O(1)
    let answer = [];
    let maxCandies = Math.max(...candies);
    for (let candy of candies) {
        answer.push(candy + extraCandies >= maxCandies);
    }
    return answer;
}
;
console.log(kidsWithCandies([2, 3, 5, 1, 3], 3));
