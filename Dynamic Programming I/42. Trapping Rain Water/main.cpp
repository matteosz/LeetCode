class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size(), ans=0, l=0, r=n-1;
        int left_max = height[0], right_max = height[n-1];
        
        while (l < r){
            
            if(height[l] < height[r]){
                l++;
                left_max = max(left_max,height[l]);
                ans += left_max-height[l];
            }
            else {
                r--;
                right_max = max(right_max,height[r]);
                ans += right_max-height[r];
            }
        
        }
        return ans;
    }
    /* Brute force approach */
    int trap(vector<int>& height) {
        int n = height.size();
        int ans = 0;

        for (int i=0;i<n;i++) {
            int left_max = 0, right_max = 0;
            for(int j=i;j>=0;j--)
                left_max = max(left_max,height[j]);

            for(int j=i;j<n;j++)
                right_max = max(right_max,height[j]);

            ans += min(left_max,right_max) - height[i];
        }

        return ans;
    }
};