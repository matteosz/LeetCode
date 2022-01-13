class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] dist = new int[candidates.length], mark = new int[candidates.length];
        int d = 0;        
    
        Arrays.sort(candidates);
        for (int i=0; i<candidates.length; i++) {
            if (i==0 || candidates[i]!=candidates[i-1]) {
                d++;
                dist[d-1] = candidates[i];
            }
            mark[d-1]++;
        }
        
        comb(dist,mark,ans,new LinkedList<Integer>(), target,0,d);
        
        return ans;
    }
    
    private void comb(int[] nums, int[] mark, List<List<Integer>> ans, LinkedList<Integer> curr, int target, int start,int n) {
        
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = start;  i < n; i++)
            if (target - nums[i] >= 0 && mark[i] > 0) {
                mark[i]--;
                curr.add(nums[i]);
                comb(nums,mark,ans,curr,target-nums[i],i,n);
                curr.removeLast();
                mark[i]++;
            }
    }
}