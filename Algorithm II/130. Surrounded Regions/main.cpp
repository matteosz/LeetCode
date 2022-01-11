class Solution {
public:
    void solve(vector<vector<char>>& board) {

        int m = board.size(), n = board[0].size();
        vector<vector<bool>> visited(m,vector<bool>(n,false));

        for (int j=0; j<n; j++) {//first and last row
            if (board[0][j] == 'O')
                dfs(board,0,j,m,n);
            if (board[m-1][j] == 'O')
                dfs(board,m-1,j,m,n);
        }
        for (int i=0; i<m; i++) {//first and last column
            if (board[i][0] == 'O')
                dfs(board,i,0,m,n);
            if (board[i][n-1] == 'O')
                dfs(board,i,n-1,m,n);
        }    
            
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++) {
                if (board[i][j] == '#')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
                
    }
private: 
    void dfs(vector<vector<char>>& mat, int i, int j, int m, int n) {
        if (mat[i][j] != 'O')
            return;

        mat[i][j] = '#';
        if (i>0)
            dfs(mat,i-1,j,m,n);
        if (j<n-1)
            dfs(mat,i,j+1,m,n);
        if (i<m-1)
            dfs(mat,i+1,j,m,n);
        if (j>0)
            dfs(mat,i,j-1,m,n);
    }
};