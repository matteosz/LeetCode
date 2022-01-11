class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<Integer>();
        curr.add(0);
        dfs(graph,0,graph.length-1,ans,curr);
        
        return ans;
    }
    private void dfs(int[][] graph, int i, int n, List<List<Integer>> ans, List<Integer> curr) {
        
        if (i == n) {
            ans.add(new ArrayList<>(curr));//deep copy
            return;
        }
        for (int j : graph[i]) {
            curr.add(j);
            dfs(graph,j,n,ans,curr);
            curr.remove(curr.size()-1);
        }        
        
    }
}