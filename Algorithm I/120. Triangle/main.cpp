class Solution {
public:
    int minimumTotal(vector<vector<int> > &triangle) {
        int h = triangle.size();
        vector<int> minlen(triangle.back());
        for (int layer = h-2; layer >= 0; layer--) // For each layer

            for (int i = 0; i <= layer; i++)

                // Find the lesser of its two children, and sum the current value in the triangle with it.
                minlen[i] = min(minlen[i], minlen[i+1]) + triangle[layer][i];


        return minlen[0];
    }
};
