class Solution {
            /* Binary Search + check boundaries -> Worst case O(N),
       Medium case O(log N) if we consider boundaries checks as constant (target_values<<N) */
    vector<int> search(vector<int>& nums, int l, int r, int target){
        if (l > r)
            return vector<int> {-1,-1};
        int m = l + (r-l)/2;
        if (nums[m] == target){
            int i = m-1, j = m+1;
            while (i>=0 && nums[i]==target) i--;
            while (j<nums.size() && nums[j]==target) j++;

            return vector<int> {i+1,j-1};
        }
        if (nums[m] < target)
            return search(nums,m+1,r,target);
        return search(nums,l,m-1,target);
    }

public:
    /* Double binary search: one for first and second for last occurences of target
                       Worst case complexity O(log N) */
    vector<int> searchRange(vector<int>& nums, int target) {
        //return search(nums,0,nums.size()-1,target);
        int l = 0, r = nums.size()-1, first = -1, last = -1;

        while (l <= r){//to search for FIRST occurence we need to modify a bit normal BS
            int m = l + (r-l)/2;
            if (target <= nums[m])//use the equal sign
                r = m-1;
            else l = m+1;

            if (target == nums[m])
                first = m;
        }
        if (first == -1)
            return vector<int> {-1,-1};

        l = 0, r = nums.size()-1;
        while (l <= r){
            int m = l + (r-l)/2;
            if (target >= nums[m])//use the equal sign
                l = m+1;
            else r = m-1;

            if (target == nums[m])
                last = m;
        }

        return vector<int> {first,last};
    }
};
