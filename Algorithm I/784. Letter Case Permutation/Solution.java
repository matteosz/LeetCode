class Solution {
    
    private void findComb(List<String> comb, String input, int k, String curr){
        if (k >= input.length()){
            comb.add(curr);
            return;
        }
        char c = input.charAt(k);
        if (Character.isDigit(c))
            findComb(comb,input,k+1,curr+c);
        
        else{
            findComb(comb,input,k+1,curr+Character.toLowerCase(c));
            findComb(comb,input,k+1,curr+Character.toUpperCase(c));
        }
    }
    
    public List<String> letterCasePermutation(String s) {
        List<String> combinations = new ArrayList<>();
        
        findComb(combinations,s,0,"");
        
        return combinations;
    }
}