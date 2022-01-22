class Solution {
public:
    /* DAG based solution - Source nodes O(max(E,N))*/
    vector<int> findSmallestSetOfVertices2(int n, vector<vector<int>>& edges) {
        vector<bool> source(n,true);
        //mark nodes as sink and source
        for (auto x : edges)
            source[x[1]] = false;
        
        vector<int> ans;
        for (int i=0; i<n; i++)//take only source nodes
            if (source[i])
                ans.push_back(i);
        return ans;
    }
    
    /* Union - Find based - General O(EV)*/
    vector<int> findSmallestSetOfVertices(int n, vector<vector<int>>& edges)  {
        int parent[n];bool visited[n];
        
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            visited[i] = false;
        }
        
        for(int i = 0; i < edges.size(); i++) {
            int sv = edges[i][0], ev = edges[i][1];
            
            if(visited[ev]) continue;
            
            int p1 = sv, p2 = ev;
            for (;p1!=parent[p1]; p1 = parent[p1]);
            for (;p2!=parent[p2]; p2 = parent[p2]);
            
            parent[p2] = p1; 
            visited[ev] = true;
        }
        vector<int> ans;
        for(int i = 0; i < n; i++) 
            if(parent[i] == i) 
                ans.push_back(i);
        return ans;
    }
};