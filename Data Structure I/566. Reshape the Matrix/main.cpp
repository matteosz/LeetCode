class Solution {
public:
    vector<vector<int>> matrixReshape(vector<vector<int>>& mat, int r, int c) {
        
        int m=mat.size(), n=mat[0].size();
        if (r*c != m*n) return mat;
        vector<vector<int>> new_matrix(r,vector<int>(c));
        int i=0,j=0;
        for (int k=0;k<m;k++)
            for (int t=0;t<n;t++){
                new_matrix[i][j++] = mat[k][t];
                if (j == c){
                    i++;
                    j = 0;
                }
            }
        
        return new_matrix;
    }
};