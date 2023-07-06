from heapq import heappush, heappop, heapify
class Solution:
# Approach 1- Priority Queue
    def totalCost(self, costs, k, candidates): # TC O((k+m) log m) // SC O(m+n)
        # Add the first k workers with section id of 0 and 
        # the last k workers with section id of 1 (without duplication) to pq.
        pq = []
        for i in range(candidates):
            pq.append((costs[i], 0))
        for i in range(max(candidates, len(costs) - candidates), len(costs)):
            pq.append((costs[i], 1))

        heapify(pq)
        
        answer = 0
        next_head, next_tail = candidates, len(costs) - 1 - candidates 

        # Only refill pq if there are workers outside.
        for _ in range(k): 
            cur_cost, cur_section_id = heappop(pq)
            answer += cur_cost
            if next_head <= next_tail: 
                if cur_section_id == 0:
                    heappush(pq, (costs[next_head], 0))
                    next_head += 1
                else:
                    heappush(pq, (costs[next_tail], 1))
                    next_tail -= 1
                    
        return answer

s=Solution()
print(s.totalCost([17,12,10,2,7,2,11,20,8],3,4))
