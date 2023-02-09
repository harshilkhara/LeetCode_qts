function editor1(toAmount){
  if (toAmount!=null){
    let s=toAmount.toString();
    let i=0;
    let index=toAmount.length-1;
    while (index>=0){
      if(i%3==0){
        ans[index]=','
      }
      ans[index]=s[index--];
      i++;
    }
    ans.toString();
    //ans.trim(0);
    return ans;
  } 
}

function editor(number){
  let numberString = number.toString();
  let numberStringReversed = numberString.split('').reverse().join('');
  let numberSeparated = numberStringReversed.match(/.{1,3}/g).join(',');
  return numberSeparated.split('').reverse().join('');
}

console.log(editor(7837237));
//console.log(editor1(7837237));