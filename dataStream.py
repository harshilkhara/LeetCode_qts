# Very similar to zeroFilledSubarray.java & .py
# Approach 1- Count the no. of consecutive numbers at each index
class DataStream:
    def __init__(self, value, k):
        self.value=value
        self.k=k
        self.count=0

    def consec(self, num: int) -> bool:
        if num==self.value:
            self.count+=1
        else:
            self.count=0
        
        return self.count>=self.k


s=DataStream(4, 3)
print(s.consec(4))
print(s.consec(4))
print(s.consec(4))
print(s.consec(3))
