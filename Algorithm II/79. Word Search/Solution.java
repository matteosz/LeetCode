class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                if (dfs(board,word,i,j,0,word.length(),m,n))
                    return true;
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int pos, int n, int r, int c) {
        
        if (pos == n)
            return true;
        
        if (i<0 || i>=r || j<0 || j>=c || word.charAt(pos) != board[i][j])
            return false;
        
        char tmp = board[i][j];
        board[i][j] = '#'; //flag as visited
        boolean up    = dfs(board,word,i-1,j,pos+1,n,r,c),
                right = dfs(board,word,i,j+1,pos+1,n,r,c),
                down  = dfs(board,word,i+1,j,pos+1,n,r,c),
                left  = dfs(board,word,i,j-1,pos+1,n,r,c);
        
         board[i][j] = tmp;
        
        return up || right || down || left;
    }
}