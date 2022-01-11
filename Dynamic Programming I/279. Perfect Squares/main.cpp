class Solution {
public:
    /* BFS Solution */
    int numSquares(int n) {
        queue<int> q;
        int ans = 0;
        vector<bool> visited(n);
        
        q.push(n);
        
        while (!q.empty()) {
            int l = q.size();
            for (int i=0; i<l; i++) {
                
                int x = q.front();
                q.pop();
                
                for (int j=1; j*j <= x; j++) {
                    int id = x - (j*j);
                    
                    if (id == 0) return ans+1;
                    
                    if (!visited[id]) {
                        q.push(id);
                        visited[id] = true;
                    }
                }
            }
            ans++;
        }
        return -1;
    }
    /* DP Solution */
    int numSquares(int n) {
        // cntPerfectSquares[i] = the least number of perfect square numbers which sum to i.
        vector<int> cntPerfectSquares(n + 1, INT_MAX);
        cntPerfectSquares[0] = 0;
        for (int i = 1; i <= n; i++)
            // For each i, it must be the sum of some number (i - j*j) and a perfect square number (j*j).
            for (int j = 1; j*j <= i; j++) 
                cntPerfectSquares[i] = min(cntPerfectSquares[i], cntPerfectSquares[i - j*j] + 1);
        
        return cntPerfectSquares[n];
    }
};