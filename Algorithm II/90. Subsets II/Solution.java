class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        
        subset.add(new ArrayList<Integer>());//{}
        Arrays.sort(nums);
        
        int start = 0;
        for (int i=0; i<nums.length; i++) {
            
            if (i == 0 || nums[i] != nums[i-1]) 
                start = 0;
            
            int l = subset.size();
            while (start<l) {
                
                List<Integer> tmp = new ArrayList<>(subset.get(start));
                tmp.add(nums[i]);
                subset.add(tmp);
                
                start++;
            }

        }
        
        return subset;
    }
}