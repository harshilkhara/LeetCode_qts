class ParkingSystem:
# Approach 1- Arrays
    def __init__(self, big, medium, small): # TC O(1) // SC O(1)

        # Number of empty slots for each type of car
        self.empty = [big, medium, small]

    def addCar(self, carType):

        # If space is available, allocate and return True
        if self.empty[carType - 1] > 0:
            self.empty[carType - 1] -= 1
            return True

        # Else, return False
        return False

ps=ParkingSystem(1,1,0)
print(ps.addCar(1))
print(ps.addCar(2))
print(ps.addCar(3))
print(ps.addCar(1))