class Solution {
    /* helper function for recursive solution */
    int countOcc(vector<int>& v, int x, int l, int r){
        auto occ = 0;
        for (int i=l;i<=r;i++) if (v[i]==x) occ++;
        return occ;}
    /* Recursive solution,T(n)=2T(n/2)+n --> T(n)=O(nlogn) */
    int majorityR(vector<int>& nums, int l, int r){
        if (l == r) return nums[l];
        int m = l + (r-l)/2;
        int mjr = majorityR(nums,m+1,r), mjl = majorityR(nums,l,m);
        if (mjr == mjl) return mjr;
        int occL = countOcc(nums,mjl,l,r), occR = countOcc(nums,mjr,l,r);
        if (max(occL,occR) > (r-l+1)/2)
            return occL>occR? mjl : mjr;
        return -1;
    }
public:
    /* T(n) = O(n), S(n) = O(1): Boyer-Moore Voting Algorithm */
    int majorityElement(vector<int>& nums) {
        int n = nums.size(), count = 1, candidate = nums[0];

        for (int i=1; i<n; i++){
            if (!count)
                candidate = nums[i];
            if (candidate == nums[i])
                count++;
            else count--;

        }
        return candidate;
    }
};
