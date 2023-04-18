function mergeAlternately(word1: string, word2: string): string{
    let answer:string ="";
    let m: number=word1.length;
    let n:number=word2.length;
    for(let i=0; i<Math.max(m,n); i++){
        if (i<m)
            answer+=word1[i];
        if (i<n)
            answer+=word2[i];
    }
    
    return answer;
}
let word1: string="abcde";
let word2: string="pqr";
console.log(mergeAlternately(word1,word2));

