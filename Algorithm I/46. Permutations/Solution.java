class Solution {
    
    private void findPermutations(int[] nums, List<List<Integer>> perm, List<Integer> curr, int n, int k, boolean[] taken){
        if (k >= n){
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(curr);
            perm.add(tmp);
            return;
        }
        for (int i=0;i<n;i++)
            if (!taken[i]){
                taken[i] = true;
                curr.add(nums[i]);
                findPermutations(nums,perm,curr,n,k+1,taken);
                taken[i] = false;
                curr.remove(curr.size()-1);
            }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        int n = nums.length;
        boolean[] taken = new boolean[n];
        findPermutations(nums,permutations,new ArrayList<Integer>(),n,0,taken);
        return permutations;
    }
}