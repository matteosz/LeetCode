class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] dict = new String[26];
        String[] words = s.split(" ");
        
        if (words.length != pattern.length())
            return false;
        
        for (int i=0; i<words.length; i++){
            
            boolean registered = false;
            for (String x : dict)
                if (x != null && x.equals(words[i]))
                    registered = true;
            /* another possibility is to map char -> word and word -> char
             but since words cannot reasonably indexed if quite long,
             we need to use HashMaps */
            
            
            if (dict[pattern.charAt(i) - 'a'] == null) {
                if (!registered)
                    dict[pattern.charAt(i) - 'a'] = words[i];
                else return false;
            }
            else if (!dict[pattern.charAt(i) - 'a'].equals(words[i]))
                return false;
        }
        return true;
    }
}