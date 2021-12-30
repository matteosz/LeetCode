class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int fresh = 0, m = grid.size(), n = grid[0].size();
        queue<pair<int,int>> q;
        vector<vector<int>> minutes(m,vector<int>(n));
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    fresh++;
                if(grid[i][j]==2)
                    q.push({i,j});
            }
        if(!fresh) return 0; //speed-up
        
        int tot_min = 0;
        int directions[4][2] = {{-1,0},{0,1},{1,0},{0,-1}};
        
        while(!q.empty()){
            pair<int,int> p = q.front(); q.pop();
            int r = p.first, c = p.second;
            for (int i=0;i<4;i++){
                int nr = r+directions[i][0], nc = c+directions[i][1];
                if(nr<0 || nr>=m || nc<0 || nc>=n || grid[nr][nc]!=1) continue;
                fresh--;
                grid[nr][nc] = 2;
                minutes[nr][nc] = minutes[r][c]+1;
                tot_min = max(tot_min, minutes[nr][nc]);
                q.push({nr,nc});
            }
        }
        return !fresh? tot_min:-1;
    }
};