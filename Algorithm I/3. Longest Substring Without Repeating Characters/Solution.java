class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> substring = new HashSet<>();
        int i = 0, j = 0, best = 0;
        while ( j < s.length() ){
            
            if (!substring.add(s.charAt(j)))
                substring.remove(s.charAt(i++));
            else j++;
            
            if (substring.size() > best)
                best = substring.size();
            
        }
        return best;
    }
    /* Using a dictionary that maps the value to the index 
       Values are in the interval [0,256]                  */
    public int lengthOfLongestSubstring(String s) {
        int[] dictionary = new int[256];
        int max=0;
        for (int i=0, j=0; i<s.length(); i++){
            if (dictionary[s.charAt(i)] > 0)
                j = Math.max(j,dictionary[s.charAt(i)]);
            
            dictionary[s.charAt(i)] = i + 1;
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}