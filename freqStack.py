'''
class freqStack():

	def __init__(self):


	def push(val):


	def pop(self):

'''
import collections
class FreqStack(object): # TC O(1) // SC O(N)
    def __init__(self,obj):
        self.freq = collections.Counter()
        self.group = collections.defaultdict(list)
        self.maxfreq = 0

    def push(self, x):
        f = self.freq[x] + 1
        self.freq[x] = f
        if f > self.maxfreq:
            self.maxfreq = f
        self.group[f].append(x)

    def pop(self):
        x = self.group[self.maxfreq].pop()
        self.freq[x] -= 1
        if not self.group[self.maxfreq]:
            self.maxfreq -= 1

        return x

obj = FreqStack(["FreqStack"])
obj.push(5)
obj.push(7)
obj.push(5)
obj.push(7)
obj.push(4)
obj.push(5)
result=[]
qts=["push","push","push","push","push","push","pop","pop","pop","pop"] 
for qt in qts:
    if qt =="push":
        result.append('null')
    else:
        result.append(obj.pop())
print(result)
print(obj.group)

'''def qt1(op,value):
    for i,j in zip(op,value):
        if i=="push":
            obj.push(j)
        else:
            obj.pop()

print(qt1[["push","push","push","push","push","push","pop","pop","pop","pop"],[5,7,5,7,4,5]])'''










