const capitalize=(word)=>{
	const n=word.length;
	let ans="";
	for(let i=0; i<n; i++){
		if(i%2===0){
			ans+=word[i].toUpperCase();
		} else {
			ans+=word[i].toLowerCase();
		}
	}
	return ans;

}

console.log(capitalize("Hello???"));
console.log(capitalize("yoo eli"));