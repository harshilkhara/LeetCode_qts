function mergeAlternately(word1, word2) {
    let answer = "";
    let m = word1.length;
    let n = word2.length;
    for (let i = 0; i < Math.max(m, n); i++) {
        if (i < m)
            answer += word1[i];
        if (i < n)
            answer += word2[i];
    }
    return answer;
}
let word1 = "abcde";
let word2 = "pqr";
console.log(mergeAlternately(word1, word2));

