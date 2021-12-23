class Solution {
    public void rotate(int[] nums, int k) {
        int l = nums.length,temp;
        k %= l;
        // Reverse the array
        for (int i=0; i<l/2; i++){
            temp = nums[i];
            nums[i] = nums[l-i-1];
            nums[l-i-1] = temp;
        }
        // Reverse first k elements
        for (int i=0; i<k/2; i++){
            temp = nums[i];
            nums[i] = nums[k-i-1];
            nums[k-i-1] = temp;
        }
        // Reverse l-k elements
        for (int i=0; i<(l-k)/2; i++){
            temp = nums[k+i];
            nums[k+i] = nums[l-i-1];
            nums[l-i-1] = temp;
        }
        
    }
}