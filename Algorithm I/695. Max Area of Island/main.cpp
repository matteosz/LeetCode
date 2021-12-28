class Solution {
public:
    /* DFS solution */
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int ans = 0;
        for(int i = 0; i < grid.size(); i++)
            for(int j = 0; j < grid[0].size(); j++)
                if(grid[i][j])
                    ans = max(ans, AreaOfIsland(grid, i, j));
        return ans;
    }
    
    int AreaOfIsland(vector<vector<int>>& grid, int i, int j){
        if( i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size() || !grid[i][j]) return 0;
        
        grid[i][j] = 0;//mark as seen
        return 1 + AreaOfIsland(grid, i+1, j) + AreaOfIsland(grid, i-1, j) + AreaOfIsland(grid, i, j-1) + AreaOfIsland(grid, i, j+1);
    }
};