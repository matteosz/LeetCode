class Solution {
public:
    /* O(N) solution */
    int minSubArrayLen(int target, vector<int>& nums) {
        int n = nums.size(), start = 0;
        int ans = n+1, count = 0;
        
        for (int end=0; end<n; end++){
            count += nums[end];
            while (count >= target) {
                ans = min(ans, end-start+1);
                count -= nums[start++];
            }
        }
        return ans==n+1? 0 : ans;
    }
    /* O(NlogN) solution */
    int minSubArrayLen(int target, vector<int>& nums) {
        int n = nums.size(), ans = n+1;
        vector<int> sum(n+1);
        
        for (int i=0; i<n; i++)
            sum[i+1] = sum[i] + nums[i];
        
        for (int i=1; i<=n; i++){
            int search = sum[i-1]+target;
            int id = binarySearch(sum,i,n,search);
            if (id != -1)
                ans = min(ans, id-i+1);
        }
        return ans==n+1? 0 : ans;
    }
private:
    int binarySearch(vector<int>& v, int l, int r, int target){
        if (l > r)
            return -1;
        if (l == r && v[l] >= target)
            return l;
        int m = l + (r-l)/2;
        if (v[m] == target)
            return m;
        if (v[m] > target)
            return binarySearch(v,l,m-1,target);
        return binarySearch(v,m+1,r,target);
    }
};