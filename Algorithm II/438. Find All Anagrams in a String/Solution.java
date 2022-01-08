class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        
        if (p.length() > s.length())
            return ans;
        
        int[] dict = new int[26];
        
        for (char c : p.toCharArray())
            dict[c-'a']++;
        
        int count = p.length();
        int start = 0, end = 0;
        
        while (end < s.length()){
               
            if (dict[s.charAt(end)-'a'] > 0)
                count--;
            
            dict[s.charAt(end)-'a']--;
            end++;
            
            if (count == 0)
                ans.add(start);
            
            if (end-start == p.length()){//max substring len reached, shift start ahead
                
                if (dict[s.charAt(start)-'a'] >= 0)
                    count++;
                
                dict[s.charAt(start)-'a']++;
                start++;
            }
            
        }
        return ans;
    }
}