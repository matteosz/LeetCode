class Solution {
    
    class Pair {
        int i,j;
        Pair (int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) 
            return -1;
        
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
        int dist=0;
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(0,0));

        while (!q.isEmpty()) {
            int l = q.size();
            for(int i=0;i<l;i++) {
                Pair p = q.remove();
                if(p.i == n-1 && p.j == n-1)
                    return dist+1;
                
                for (int[] d : dir) {
                    int nextX = d[0] + p.i;
                    int nextY = d[1] + p.j;

                    if(nextX>=0 && nextX<n && nextY>=0 && nextY<n && grid[nextX][nextY]==0) {
                        q.add(new Pair(nextX,nextY));
                        grid[nextX][nextY] = 1;
                    }
                }
            }
            dist++;
        }

        return -1;
    }
}