def circularPrinter(s):
	steps = 0
	for pre,nxt in zip('A'+s,s):
		delta = abs(ord(nxt)-ord(pre))
		steps += min(delta,26-delta)
	return steps

print(circularPrinter("BZA"))
print(circularPrinter("ZNMD"))