class Solution {
    
    bool binary_search(vector<vector<int>> matrix, int l, int r, int target, int size){
        
        if (l > r)
            return false;
        
        int m = l + (r-l)/2, search = matrix[m/size][m%size];
        if (search == target)
            return true;
        if (search < target)
            return binary_search(matrix,m+1,r,target,size);
        
        return binary_search(matrix,l,m-1,target,size);
    }
    
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        return binary_search(matrix, 0, matrix.size()*matrix[0].size() - 1, target, matrix[0].size());
    }
};