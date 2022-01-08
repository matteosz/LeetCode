class Solution {
    /* O(N^2) dp */
    public int wiggleMaxLength2(int[] nums) {
        int n = nums.length;
        int[] up = new int[n], down = new int[n];
        //up[i] registers the max len of wiggle subseq ending with nums[i] with positive diff
        //down[i]    "     "   "   "   "   "       "      "     "    "       "  negative  "
        for (int i=1; i<n; i++)
            for (int j=0; j<i; j++){
                if (nums[j] < nums[i])
                    down[i] = Math.max(down[i], up[j]+1);
                else if (nums[j] > nums[i])
                    up[i] = Math.max(up[i], down[j]+1);

            }
        return Math.max(up[n-1],down[n-1])+1;
    }
    /* O(N) solution */
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] up = new int[n], down = new int[n];
        //up[i] registers the max len of wiggle subseq ending with nums[i] with positive diff
        //down[i]    "     "   "   "   "   "       "      "     "    "       "  negative  "
        
        for (int i=1; i<n; i++){
            if (nums[i] > nums[i-1]){
                down[i] = down[i-1];
                up[i] = down[i-1] + 1;
            }
            else if (nums[i] < nums[i-1]){
                down[i] = up[i-1] + 1;
                up[i] = up[i-1];
            }
            else{
                down[i] = down[i-1];
                up[i] = up[i-1];
            }
        }
        return Math.max(up[n-1],down[n-1])+1;
    }
}