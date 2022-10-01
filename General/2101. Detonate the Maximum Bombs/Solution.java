class Solution {
    
    /* Check if bomb2 lies in bomb1's range */
    private boolean intersection(int[] bomb1, int[] bomb2) {
        // (x-x0)^2 + (y-y0)^2 <= r^2 
        return Math.pow((bomb2[0]-bomb1[0]),2) + Math.pow((bomb2[1]-bomb1[1]),2) <= Math.pow(bomb1[2],2);
    }
    
    private int dfs(int id, int[][] bombs, boolean[] visited, int depth) {
        
        visited[id] = true;
        
        for (int i=0; i < bombs.length; i++)
            if (!visited[i] && intersection(bombs[id],bombs[i]))
                depth = dfs(i,bombs,visited,depth+1);
        
        return depth;
    }
    /* This dfs implementation is O(N^3), we can reduce to O(N^2) by creating the graph as adjacency list */
    public int maximumDetonation(int[][] bombs) {
        
        int ans = 0;
        
        for (int i=0; i < bombs.length; i++) 
            ans = Math.max(ans, dfs(i,bombs,new boolean[bombs.length],1));
        
        return ans;
    }

    /* Dfs implementation with adjacency list O(N^2) */
    
    private int dfs(List<List<Integer>> graph, int id, boolean[] visited, int depth) {
      
        visited[id] = true;
        
        for (int x : graph.get(id))
            if (!visited[x])
                depth = dfs(graph,x,visited,depth+1);
        
        return depth;
    }
    /* This dfs implementation is O(N^3), we can reduce to O(N^2) by creating the graph as adjacency list */
    public int maximumDetonation(int[][] bombs) {
        
        int ans = 0;
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i=0; i < bombs.length; i++) {
            graph.add(new ArrayList<>());
            for (int j=0; j < bombs.length; j++)
                if (i != j && intersection(bombs[i], bombs[j]))
                    graph.get(i).add(j);
        }
        
        for (int i=0; i < bombs.length; i++)
            ans = Math.max(ans, dfs(graph, i, new boolean[bombs.length], 1));
        
        return ans;
    }

}