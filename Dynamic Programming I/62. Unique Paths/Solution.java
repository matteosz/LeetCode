class Solution {
    public int uniquePaths(int m, int n) {
        /* To reach bottom-right corner the robot
          has to go n-1 times RIGHT and m-1 times DOWN.
          
          This leads to permutations with repetitions of two elements: R,D
          each one repeated n-1 and m-1 times. 
          The number of unique paths are so: (n+m-2)! / (n-1)!(m-1)!
          It's just a matter of computing factorials! */
        
        //we have to keep attention in preventing overflow while using large factorials
        long ans = 1;
        for (int i=Math.max(n,m); i<=(n+m-2); i++)//starting from n because of semplification with (n-1)!
            ans *= i;
        for (int i=2;i<=Math.min(m-1,n-1);i++)
            ans /= i;
        return (int) ans;
    }
}