class Solution {
    /*
    public int jump(int[] nums) { //O(n^2) solution
        int[] jumps = new int[nums.length];
        
        for (int i = 0; i<nums.length; i++) jumps[i] = i;
        
        for (int i = 0; i<nums.length; i++)
             for (int j=i+1;j<=i+nums[i] && j<nums.length;j++)
                 jumps[j] = Math.min(jumps[j], jumps[i]+1);
        
        return jumps[nums.length-1];
    }
    
    public int jump(int[] nums) {// Greedy Solution
        int jumps = 0, end = 0, best = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            best = Math.max(best, i + nums[i]);
            if (i == end) {
                jumps++;
                end = best;
            }
        }
        return jumps;
    }
    */
    int jump(int[] nums) {//General solution - BFS
        int i = 0, n = nums.length, step = 0, end = 0, maxend = 0;
        while (end < n - 1) {
        	step++;
            for (;i <= end; i++) {
            	maxend = Math.max(maxend, i + nums[i]);
                if (maxend >= n - 1) return step;
            }
            if(end == maxend) break;
            end = maxend;
        }
        return n == 1 ? 0 : -1;
    }
    
}