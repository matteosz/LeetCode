class Solution {
    /* O(N^2) time, O(1) space */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        
        for (int i=0; i<nums.length; i++){
            int sum = 0;
            for (int j=i; j<nums.length; j++){
                sum += nums[j];
                if (sum == k)
                    count++;
            }
        }
        
        return count;
    }
    /* O(N) time and space */
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i=0; i<nums.length; i++){
            sum += nums[i];
            count += map.getOrDefault(sum-k,0);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}