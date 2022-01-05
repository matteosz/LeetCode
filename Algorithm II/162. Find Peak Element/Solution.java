class Solution {
    
    private int divide(int[] nums, int l, int r,int n){
        if (l == r) {
            long nl = Long.MIN_VALUE, nr = Long.MIN_VALUE;
            if (l>0) nl = nums[l-1];
            if (l<n-1) nr = nums[l+1];
            return nums[l]>Math.max(nl,nr)? l : -1;
        }
        int m = l + (r-l)/2;
        
        return Math.max(divide(nums,m+1,r,n), divide(nums,l,m,n));
    }
    
    public int findPeakElement(int[] nums) {
        return divide(nums,0,nums.length-1,nums.length);
    }
}