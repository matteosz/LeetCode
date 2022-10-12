class Solution {
    
    private List<String> recursion(String s, List<String> wordDict, Map<String, List<String>> memo) {
        
        if (memo.containsKey(s))
            return memo.get(s);
        
        List<String> ans = new ArrayList<>();
        
        if (s.equals("")) {
            ans.add("");
            return ans;
        }
            
        for (String word : wordDict) 
            if (s.indexOf(word) == 0) {
                List<String> substrings = recursion(s.substring(word.length()), wordDict, memo);
                for (String substring : substrings) {
                    String space = substring.equals("")? "" : " ";
                    ans.add(word + space + substring);
                }
            }
        
        memo.put(s, ans);
        return ans;
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> memo = new HashMap<>();
        
        return recursion(s, wordDict, memo);
    }
}