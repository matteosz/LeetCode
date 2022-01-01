class Solution {
    
    private void generateCombinations(int n, int k, int j, int start, List<List<Integer>> comb, List<Integer> curr){
        if (j >= k){
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(curr);
            comb.add(tmp);
            return;
        }
        
        for(int i=start;i<n+1;i++){
            curr.add(i);
            int id = curr.size()-1;
            generateCombinations(n,k,j+1,i+1,comb,curr);
            curr.remove(id);
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        generateCombinations(n,k,0,1,combinations,curr);
        
        return combinations;
    }
}