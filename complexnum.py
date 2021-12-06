def complexNumberMultiply(num1,num2):  # TC O(1) // SC O(1)
	a,b=num1.split("+")
	c,d=num2.split("+")
	b,d=b[:-1],d[:-1]

	x,y,z=int(a)*int(c),int(b)*int(d),int(a)*int(d)+int(b)*int(c)
	real=x-y
	img=z

	return "{r}+{i}i".format(r=real,i=img)

print(complexNumberMultiply("3+4i","5+3i"))