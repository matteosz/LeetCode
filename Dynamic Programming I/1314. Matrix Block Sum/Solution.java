class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] answer = new int[m][n], dp = new int[m][n];
        
        /* Initialize dp -> each cell dp[i,j] represents the sum of a rectangle from (0,0) to (i,j) */
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                dp[i][j] = mat[i][j] + (j>0? dp[i][j-1] : 0) + (i>0? dp[i-1][j] : 0) - ((i>0 && j>0)? dp[i-1][j-1] : 0);
                
        /* Find the ans using overlapping rectangles */
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                answer[i][j] = dp[Math.min(m-1,i+k)][Math.min(n-1,j+k)] 
                                - (i-k>0? dp[i-k-1][Math.min(n-1,j+k)] : 0)
                                - (j-k>0? dp[Math.min(m-1,i+k)][j-k-1] : 0)
                                + (j-k>0 && i-k>0? dp[i-k-1][j-k-1] : 0);
                
        return answer;
    }
}