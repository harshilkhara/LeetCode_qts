checkEven: checkEven.cpp checkEven_test.cpp
	g++ -std=c++14 -fprofile-arcs -ftest-coverage checkEven.cpp checkEven_test.cpp -lgtest -lgtest_main -pthread -o checkEven

checkEven.gcda: checkEven.gcno
	./checkEven 

checkEven.cpp.gcov: checkEven.gcda
	gcov -r checkEven.gcda
	gcovr -r . 

clean: 
	rm *.gcda
	rm *.gcno
	rm *.cpp.gcov
	rm checkEven
