class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        
        int n = matrix.size(), ans = INT_MAX;
        if (n==1) return matrix[0][0];
        vector<int> old_path(matrix.back());
        
        for (int i=n-2; i>=0; i--){
            vector<int> curr_path(old_path);
            for (int j=0; j<n; j++){
                
                curr_path[j] = matrix[i][j] + min({old_path[max(0,j-1)], old_path[j], old_path[min(n-1,j+1)]});
                
                if (i == 0 && curr_path[j]<ans)
                    ans = curr_path[j];
            }
            old_path = curr_path;
        }
        return ans;
    }
};