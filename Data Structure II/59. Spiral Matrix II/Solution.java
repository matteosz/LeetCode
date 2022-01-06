class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        
        int count = 1;
        
        for (int l=0; l<(n+1)/2; l++){
            int i = l, j = l;
            while (j < n-l)
                mat[i][j++] = count++;
            i++;j--;
            while (i < n-l)
                mat[i++][j] = count++;
            i--;j--;
            while (j >= l)
                mat[i][j--] = count++;
            i--;j++;
            while (i > l)
                mat[i--][j] = count++;
        }
        return mat;
    }
}