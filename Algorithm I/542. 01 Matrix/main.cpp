class Solution {
public:
    /* DP */

    vector<vector<int>> updateMatrix(vector<vector<int>> &mat) {
        int m = mat.size(), n = mat[0].size(), max_dist = m+n;
        //compute distance processing cells from left to right, top to bottom
        //neighbors considered are left and top ones
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (!mat[r][c]) continue;
                int top = max_dist, left = max_dist;
                if (r>0)
                    top = mat[r - 1][c];
                if (c>0)
                    left = mat[r][c - 1];
                mat[r][c] = min(top, left) + 1;
            }
        }
        //compute distance processing cells from right to left, bottom to top 
        //neighbors considered are right and bottom ones
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (!mat[r][c]) continue;
                int bottom = max_dist, right = max_dist;
                if (r<m-1) 
                    bottom = mat[r + 1][c];
                if (c<n-1) 
                    right = mat[r][c + 1];
                mat[r][c] = min(mat[r][c], min(bottom, right) + 1);
            }
        }
        return mat;
    }
    /* BFS optimized 
    vector<vector<int>> updateMatrix(vector<vector<int>>& matrix) {
        int rows = matrix.size(), cols = matrix[0].size();
        vector<vector<int>> dist(rows, vector<int> (cols, rows+cols));
        queue<pair<int, int>> q;
        
        for (int i = 0; i < rows; i++) 
            for (int j = 0; j < cols; j++) 
                if (!matrix[i][j]) {
                    dist[i][j] = 0;
                    q.push({ i, j });//insert zeros pos in the queue
                }
            
        

        int dir[][2] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (!q.empty()) {
            pair<int, int> curr = q.front();q.pop();
            
            for (int i = 0; i < 4; i++) {
                int new_r = curr.first + dir[i][0], new_c = curr.second + dir[i][1];
                if (new_r >= 0 && new_c >= 0 && new_r < rows && new_c < cols) {
                    if (dist[new_r][new_c] > dist[curr.first][curr.second] + 1) {
                        dist[new_r][new_c] = dist[curr.first][curr.second] + 1;
                        q.push({ new_r, new_c });
                    }
                }
            }
        }
        return dist;
    }*/
};