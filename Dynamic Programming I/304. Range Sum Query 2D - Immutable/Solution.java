class NumMatrix {

    private int[][] dp;
    
    public NumMatrix(int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        dp = new int[m][n];
        
        for (int i=0;i<m;i++)
            for (int j=0;j<n;j++)
                dp[i][j] = matrix[i][j] + (i>0? dp[i-1][j]:0) + (j>0? dp[i][j-1]:0) - (i>0&&j>0 ? dp[i-1][j-1]:0);
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int i = Math.max(row1,row2), j = Math.max(col1,col2), h = Math.abs(row1-row2), w = Math.abs(col1-col2);
        
        return dp[i][j] - (i-h>0? dp[i-h-1][j]:0) - (j-w>0? dp[i][j-w-1]:0) + (i-h>0 && j-w>0 ? dp[i-h-1][j-w-1]:0);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */