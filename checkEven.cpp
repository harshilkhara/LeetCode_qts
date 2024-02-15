#include <iostream>

using namespace std;

bool checkEven(int n){
	if(n%2==0){
		return 1;
	} else {
		return 0;
	}
	
}

// int main(){
// 	int res = checkEven(4);
// 	cout << res << endl;
// 	return 0;
// }

/*

First have a program file - example.cpp
	1. It can have it's own main() only when you don't pair it up with it's unit
	test example_ut.cpp file
		
		a.  You can run gcov on it by- 
			g++ -fprofile-arcs -ftest-coverage example.cpp -o example 

			Above will generate .gcno file. Run the following ./example file 
			and this will generate .gcda file. 

			Now run gcov -r example.gcda to generate example.cpp.gcov file 
			This .cpp.gcov file will have all the information 

		b.  You can directly run gcov on source file without it's unit test but
			you need to test the program by calling itself in main func with all possible
			inputs to get better line coverage

	2. It cannot have it's own main() if you are pairing it up with it's unit test
	example_ut.cpp file 

		a.  To compile the UT with gtest and run coverage on it simultaneously -

			g++ -std=c++14 -fprofile-arcs -ftest-coverage example.cpp example_ut.cpp -lgtest
			-lgtest_main -pthread -o example 

			This will generate .gcno for both the files (example.cpp & example_ut.cpp)

		b. 	To run the UT and check if all the test cases are passed or not and also generate 
			.gcda files for both, run the ./example file 

		c.  Now run gcov -r example.gcda to generate example.cpp.gcov file
			This .cpp.gcov file will have all the information

		NOTE- Here, example.cpp cannot directly have gcov as it doesn't have main()

	3. You can also run gcovr -r . on all the source files present for better presentation 

	4. I would recommend use the 2nd method (pairing it up with UT to check for the coverage)

*/