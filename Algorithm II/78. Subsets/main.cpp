class Solution {
public:
    /* Using combination */
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ps(1,vector<int>(0));
        vector<int> curr;

        for (int k=1; k<=nums.size(); k++)
            powerset(nums,ps,curr,k,0,0,nums.size());
        return ps;
    }
private:
    void powerset(vector<int>& nums, vector<vector<int>>& ps,vector<int>& curr, int k, int pos, int start, int n) {
        if (pos == k) {
            ps.push_back(curr);
            return;
        }
        for (int i=start; i<n; i++) {
            curr.push_back(nums[i]);
            powerset(nums,ps,curr,k,pos+1,i+1,n);
            curr.pop_back();
        }
    }
};