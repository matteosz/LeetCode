class Solution {
    
    private int dfs(int i, int j, int[][] matrix, int[][] moves, int[][] memo) {
        
        if (memo[i][j] != 0)
            return memo[i][j];

        int max = 0;
        
        for (int[] move : moves) 
            if (i+move[0]>=0 && i+move[0]<matrix.length &&
                            j+move[1]>=0 && j+move[1]<matrix[0].length && 
                            matrix[i+move[0]][j+move[1]] > matrix[i][j]) 
            {
                max = Math.max(max, dfs(i+move[0], j + move[1], matrix, moves, memo));
            }
        
        memo[i][j] = max+1;
        return max+1;
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        
        int m = matrix.length, n = matrix[0].length, pathMax = 0;
        int[][] memo = new int[m][n], moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                pathMax = Math.max(pathMax, dfs(i,j,matrix,moves,memo));
            
        return pathMax;
    }
}