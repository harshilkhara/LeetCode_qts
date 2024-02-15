#include <gtest/gtest.h>
//#include "factorial.cpp"

bool checkEven(int);

TEST(checkEven, forOddnumbers){
	ASSERT_EQ(0, checkEven(3));
}

TEST(checkEven, forEvennumbers){
	ASSERT_EQ(1, checkEven(6));
}

int main(int argc, char **argv){
	//Solution::factorial;
    testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}
