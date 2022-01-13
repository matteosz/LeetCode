class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        combRep(candidates,ans,new ArrayList<Integer>(),target,0); 
        
        return ans;
    }
    
    private void combRep(int[] nums, List<List<Integer>> ans, List<Integer> curr, int target, int start) {
        
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i=start; i<nums.length; i++) {
            if (target - nums[i] >= 0) {
                curr.add(nums[i]);
                combRep(nums,ans,curr,target-nums[i],start);
                curr.remove(curr.size()-1);
            }
            start++;   
        }         
    }
}