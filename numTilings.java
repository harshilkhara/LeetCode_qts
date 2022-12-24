import java.util.*;
// Approach 1- Top Down Approach 
class Solution{ // TC O(n) SC O(n)
    int MOD = 1_000_000_007;
    Map<Integer, Long> f_cache = new HashMap<>();  
    Map<Integer, Long> p_cache = new HashMap<>();  

    public long p(int n) { 
        if (p_cache.containsKey(n)) {
            return p_cache.get(n);
        }
        long val;
        if (n == 2) {
            val = 1L;
        } else {
            val = (p(n - 1) + f(n - 2)) % MOD;
        }
        p_cache.put(n, val);
        return val;

    }

    public long f(int n) {  
        if (f_cache.containsKey(n)) {
            return f_cache.get(n);
        }
        long val;
        if (n == 1) {
            val = 1L;
        } else if (n == 2) {
            val = 2L;
        } else {
            val = (f(n - 1) + f(n - 2) + 2 * p(n - 1)) % MOD;
        }
        f_cache.put(n, val);
        return val;
    }

    public int numTilings(int n) {
        return (int) (f(n));  
    }
}

// Approach 2- Bottom Up DP 
class Solution1{ // TC O(n) SC O(n)
    public int numTilings(int n) {
        int MOD = 1_000_000_007;
        // handle base case scenarios
        if (n <= 2) {  
            return n;
        }
        // f[k]: number of ways to "fully cover a board" of width k
        long[] f = new long[n + 1];  
        // p[k]: number of ways to "partially cover a board" of width k
        long[] p = new long[n + 1];  
        // initialize f and p with results for the base case scenarios
        f[1] = 1L;
        f[2] = 2L;
        p[2] = 1L;
        for (int k = 3; k < n + 1; ++k) {
            f[k] = (f[k - 1] + f[k - 2] + 2 * p[k - 1]) % MOD;
            p[k] = (p[k - 1] + f[k - 2]) % MOD;
        }
        return (int) (f[n]);
    }
}

// Approach 3- Bottom Up DP Space optimized 
class Solution2{ // TC O(n) SC O(1)
    public int numTilings(int n) {
        int MOD = 1_000_000_007;
        if (n <= 2) {
            return n;
        }
        long fPrevious = 1L;
        long fCurrent = 2L;
        long pCurrent = 1L;
        for (int k = 3; k < n + 1; ++k) {
            long tmp = fCurrent;
            fCurrent = (fCurrent + fPrevious + 2 * pCurrent) % MOD;
            pCurrent = (pCurrent + fPrevious) % MOD;
            fPrevious = tmp;
        }
        return (int) (fCurrent);
    }
}

// Approach 4- Matrix Exponentiation
class Solution3{ // TC O(n) SC O(1)
    int MOD = 1_000_000_007;
    long[][] SQ_MATRIX = { // Initialize the square matrix.
            {1, 1, 2},
            {1, 0, 0},
            {0, 1, 1},
    };
    int SIZE = 3; // Width/Length of the square matrix.
    
    /** Return product of 2 square matrices. */
    public long[][] matrixProduct(long[][] m1, long[][] m2) {  
        // Result matrix `ans` will also be a 3x3 square matrix.
        long[][] ans = new long[SIZE][SIZE];  
        for (int row = 0; row < SIZE; ++row) {
            for (int col = 0; col < SIZE; ++col) {
                long curSum = 0;
                for (int k = 0; k < SIZE; ++k) {
                    curSum = (curSum + m1[row][k] * m2[k][col]) % MOD;
                }
                ans[row][col] = curSum;
            }
        }
        return ans;
    }
    
    /** Return answer after `n` times matrix multiplication. */
    public int matrixExpo(int n) {  
        long[][] cur = SQ_MATRIX;
        for (int i = 1; i < n; ++i) {
            cur = matrixProduct(cur, SQ_MATRIX);
        }
        // The answer will be cur[0][0] * f(2) + cur[0][1] * f(1) + cur[0][2] * p(2) 
        return (int) ((cur[0][0] * 2 + cur[0][1] * 1 + cur[0][2] * 1) % MOD);
    }
    
    public int numTilings(int n) {
        // Handle base cases.
        if (n <= 2) { 
            return n;
        } 
        return matrixExpo(n - 2);
    }
}

// Approach 5- Matrix exponentiation (Time optimization, space-time trade off)
class Solution4{ // TC O(log n) SC O(log n)
    int MOD = 1_000_000_007;
    Long[][] SQ_MATRIX = {  // Initialize the square matrix
            {1L, 1L, 2L},
            {1L, 0L, 0L},
            {0L, 1L, 1L},
    };
    int SIZE = 3;  // Width/Length of square matrix
    Map<Integer, Long[][]> cache = new HashMap<>();

    /** Return product of 2 square matrices */
    public Long[][] matrixProduct(Long[][] m1, Long[][] m2) {  
        // Result matrix `ans` will also be a square matrix with same dimension
        Long[][] ans = new Long[SIZE][SIZE];  
        for (int row = 0; row < SIZE; ++row) {
            for (int col = 0; col < SIZE; ++col) {
                Long sum = 0L;
                for (int k = 0; k < SIZE; ++k) {
                    sum = (sum + m1[row][k] * m2[k][col]) % MOD;
                }
                ans[row][col] = sum;
            }
        }
        return ans;
    }

    /** Return pow(SQ_MATRIX, n) */
    public Long[][] matrixExpo(int n) {  
        // Use cache is `n` is already calculated
        if (cache.containsKey(n)) {  
            return cache.get(n);
        }
        Long[][] cur;
        if (n == 1) {  // base case
            cur = SQ_MATRIX;
        } else if (n % 2 == 1) {  // When `n` is odd
            cur = matrixProduct(matrixExpo(n - 1), SQ_MATRIX);
        } else {  // When `n` is even
            cur = matrixProduct(matrixExpo(n / 2), matrixExpo(n / 2));
        }
        cache.put(n, cur);
        return cur;
    }

    public int numTilings(int n) {
        if (n <= 2) {  // Handle base cases
            return n;
        }
        // The answer will be cur[0][0] * f(2) + cur[0][1] * f(1) + cur[0][2] * p(2) 
        Long[] ans = matrixExpo(n - 2)[0];
        return (int) ((ans[0] * 2 + ans[1] * 1 + ans[2] * 1) % MOD);
    }
}

// Approach 6- Math Optimization (Fibonacci sequence like)
class Solution5{ // TC O(n) SC O(1)
    public int numTilings(int n) {
        int MOD = 1_000_000_007;
        if (n <= 2) {
            return n;
        }
        long fCurrent = 5L;
        long fPrevious = 2;
        long fBeforePrevious = 1;
        for (int k = 4; k < n + 1; ++k) {
            long tmp = fPrevious;
            fPrevious = fCurrent;
            fCurrent = (2 * fCurrent + fBeforePrevious) % MOD;
            fBeforePrevious = tmp;
        }
        return (int) (fCurrent % MOD);
    }
}

class numTilings{
    public static void main(String[] args) {
        int n=3; 
        Solution s= new Solution();
        System.out.println(s.numTilings(n));
        Solution1 s1= new Solution1();
        System.out.println(s1.numTilings(n));
        Solution2 s2= new Solution2();
        System.out.println(s2.numTilings(n));
        Solution3 s3= new Solution3();
        System.out.println(s3.numTilings(n));
        Solution4 s4= new Solution4();
        System.out.println(s4.numTilings(n));
        Solution5 s5= new Solution5();
        System.out.println(s5.numTilings(n));
    }
}