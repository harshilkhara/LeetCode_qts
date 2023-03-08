var minEatingSpeed = function(piles, h) { // TC O(n log m) SC O(1)
    // Initalize the left and right boundaries 
    let left = 1, right = 1;
    for (const pile of piles) {
        right = Math.max(right, pile);
    }

    while (left < right) {
        // Get the middle index between left and right boundary indexes.
        // hourSpent stands for the total hour Koko spends.
        let middle = Math.floor((left + right) / 2);
        let hourSpent = 0;

        // Iterate over the piles and calculate hourSpent.
        // We increase the hourSpent by ceil(pile / middle)
        for (const pile of piles) {
            hourSpent += Math.ceil(pile / middle);
        }

        // Check if middle is a workable speed, and cut the search space by half.
        if (hourSpent <= h) {
            right = middle;
        } else {
            left = middle + 1;
        }
    }

    // Once the left and right boundaries coincide, we find the target value,
    // that is, the minimum workable eating speed.
    return left;
};

console.log(minEatingSpeed([3,6,7,11],8));

