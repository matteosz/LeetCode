class Solution {
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        int n = isConnected.size();
        //it's equivalent to find the number of connected components
        //isConnected is the Adjacency Matrix of the graph
        //the graph is undirected
        int cc = 0;
        vector<int> visited(n);
        
        for (int i=0; i<n; i++)
            if (!visited[i]){
                dfs(isConnected,i,n,visited);
                cc++;
            }
        
        return cc;
    }
private:
    void dfs(vector<vector<int>>& mat, int i, int n, vector<int>& visited){
        if (visited[i])
            return;
        visited[i] = 1;
        for (int j=0; j<n; j++)
            if (mat[i][j] == 1)
                dfs(mat,j,n,visited);
    }
};