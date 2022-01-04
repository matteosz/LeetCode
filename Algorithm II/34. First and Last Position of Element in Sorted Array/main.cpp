class Solution {

    int bs(vector<int>& nums, int l, int r, int target, int pivot){
        if (l > r)
            return -1;
        int m = l + (r-l)/2;
        if (nums[m] == target)
            return m;
        //looking at the first element, all elements after the previous last element are smaller
        if (nums[m] > target){
            if (pivot > target && nums[m] >= pivot)
                return bs(nums,m+1,r,target,pivot);
            return bs(nums,l,m-1,target,pivot);
        }
        if (target < pivot)
            return bs(nums,m+1,r,target,pivot);
        if (nums[m] >= pivot)
            return bs(nums,m+1,r,target,pivot);
        return bs(nums,l,m-1,target,pivot);
    }

public:
    int search(vector<int>& nums, int target) {
        int pivot = nums[0];

        return bs(nums,0,nums.size()-1,target,pivot);
    }
};
