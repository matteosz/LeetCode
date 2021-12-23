class Solution {
    public int[] twoSum(int[] nums, int target) {/* O(n) using HashMap */
        HashMap<Integer,Integer> table = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            Integer x = table.get(target-nums[i]);
            if (x != null)
                return new int[]{i,x.intValue()};
            table.put(nums[i],i);
        }
        return null;
    }
}