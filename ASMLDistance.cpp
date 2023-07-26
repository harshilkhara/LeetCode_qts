// Coding exercise: given input on one line of coordinates of 2 points e.g. (25, -1) (6, 7) 
// output the distance between these 2 points


// int distance(int a[], int b[]){
// 	for()
// }

// #include <iostream>
// using namespace std;

// int main(){
// 	float a[2], b[2];
// 	a[0]=25, a[1]=-1;
// 	b[0]=6, b[1]=7;

// 	float distance= sqrt (pow((b[1]-a[1]),2) + pow((b[0]-a[0]),2));

// 	cout << distance << endl;

// 	return 0;
// }

#include <iostream>
#include <cmath>

struct Point {
    double x;
    double y;
};

double calculateDistance(const Point& p1, const Point& p2) {
    double deltaX = p2.x - p1.x;
    double deltaY = p2.y - p1.y;
    return std::sqrt(deltaX * deltaX + deltaY * deltaY);
}

int main() {
    Point p1, p2;

    std::cout << "Enter coordinates of the first point (x y): ";
    std::cin >> p1.x >> p1.y;

    std::cout << "Enter coordinates of the second point (x y): ";
    std::cin >> p2.x >> p2.y;

    double distance = calculateDistance(p1, p2);
    std::cout << "Distance between the two points: " << distance << std::endl;

    return 0;
}
