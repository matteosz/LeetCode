class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<int> dist, mark, curr;
        int n = nums.size(), d = 0;
        vector<vector<int>> ans;
        
        sort(nums.begin(), nums.end());
        for (int i=0; i<n; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                mark.push_back(1);
                dist.push_back(nums[i]);
                d++;
            }
            else mark[d-1]++;
        }
        
        permutations(ans,dist,mark,curr,d,0,n);
        
        return ans;
    }
private:
    void permutations(vector<vector<int>>& ans,vector<int>& dist,vector<int>& mark,vector<int>& curr,int d,int pos,int n) {
        
        if (pos == n) {
            ans.push_back(curr);
            return;
        }
        
        for (int i=0; i<d; i++)
            if (mark[i] > 0) {
                mark[i]--;
                curr.push_back(dist[i]);
                permutations(ans,dist,mark,curr,d,pos+1,n);
                curr.pop_back();
                mark[i]++;
            }
        
    }
};