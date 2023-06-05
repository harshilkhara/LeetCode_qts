class Solution:
# Approach 1- Slope property
    def checkStraightLine(self, coordinates): # TC O(n) // SC O(1)
        if len(coordinates)==2:
            return True
        
        def diffY(a, b):
            return a[1]-b[1]
        
        def diffX(a,b):
            return a[0]-b[0]
        
        deltaY=diffY(coordinates[1], coordinates[0])
        deltaX=diffX(coordinates[1], coordinates[0])
        
        for i in range(2, len(coordinates)):
            if deltaY*diffX(coordinates[i], coordinates[0])!=deltaX*diffY(coordinates[i],
                coordinates[0]):
                return False
            
        return True

s=Solution()
print(s.checkStraightLine([[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]))
