from collections import deque
class Solution:
# Approach 1- Two Queues 
    def predictPartyVictory(self, senate: str): # TC O(n) // SC O(n)
        n=len(senate)
        rQueue=deque()
        dQueue=deque()
        for i, c in enumerate(senate):
            if c=="R":
                rQueue.append(i)
            else:
                dQueue.append(i)
        
        while rQueue and dQueue:
            rTurn=rQueue.popleft()
            dTurn=dQueue.popleft()
            
            if dTurn<rTurn:
                dQueue.append(dTurn+n)
            else:
                rQueue.append(rTurn+n)
        
        return "Radiant" if rQueue else "Dire"
            

s=Solution()
print(s.predictPartyVictory("RDDR"))