def complexNumberMultiply(num1,num2):  # TC O(1) // SC O(1)
	a,b=num1.split("+")
	c,d=num2.split("+")
	b,d=b[:-1],d[:-1] # [start:end:step]   [:-1] --> means start from 0, - means start from end of array
	                  # end is excluded in slicing

    # x=a*c=real, y=b*d=real, z=a*d+b*c=img

	x,y,z=int(a)*int(c),int(b)*int(d),int(a)*int(d)+int(b)*int(c) 
	real=x-y
	img=z

	return "{r}+{i}i".format(r=real,i=img)

print(complexNumberMultiply("3+4i","5+3i"))