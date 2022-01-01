class Solution {
    public int nthUglyNumber(int n) {
        int factor2=0, factor3=0, factor5=0;
        int[] dp = new int[n];
        dp[0]=1;//first ugly number by definition
        
        for (int i=1;i<n;i++){
            dp[i] = Math.min(2*dp[factor2],Math.min(3*dp[factor3],5*dp[factor5]));
            if (dp[i] == 2*dp[factor2])
                    factor2++;
            if (dp[i] == 3*dp[factor3])
                    factor3++;
            if (dp[i] == 5*dp[factor5])
                factor5++;
        }
        return dp[n-1];
    }
}