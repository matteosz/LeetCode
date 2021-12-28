class Solution {
    
    class Coordinates {
        public:
            int r, c;
            Coordinates(int row, int column){
                r = row;
                c = column;
            }
    };
    
    
public:
    /* BFS solution */
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc],m=image.size(),n=image[0].size();
        queue<Coordinates> q;
        int directions[][2] = {{-1,0},{0,1},{1,0},{0,-1}};
        vector<int> flag(m*n);// keep track of elements inserted in queue
        
        q.push(Coordinates(sr,sc));
        flag[sr*n + sc] = 1;
        
        while (!q.empty()){
            
            Coordinates c = q.front();
            q.pop();
            int row = c.r,col = c.c;
            image[row][col] = newColor;// change value
            
            for (int* x : directions)// add neighbors with same color to the queue
                if (x[0]+row>=0 && x[0]+row<m && x[1]+col>=0 && x[1]+col<n)
                    if (image[row+x[0]][col+x[1]] == oldColor && !flag[(row+x[0])*n + col + x[1]]){
                        q.push(Coordinates(row+x[0],col+x[1]));
                        flag[(row+x[0])*n + col + x[1]] = 1;
                    }
        }
        return image;
    }
    /* DFS solution */
    public:
        vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
            if (image[sr][sc] != newColor)
                dfs(image, sr, sc, image[sr][sc], newColor);
            return image;
        }

    private:
        void dfs(vector<vector<int>>& image, int i, int j, int c0, int c1) {
            if (i < 0 || j < 0 || i >= image.size() || j >= image[0].size() || image[i][j] != c0) return;
            image[i][j] = c1;
            dfs(image, i, j - 1, c0, c1);
            dfs(image, i, j + 1, c0, c1);
            dfs(image, i - 1, j, c0, c1);
            dfs(image, i + 1, j, c0, c1);
        }
};