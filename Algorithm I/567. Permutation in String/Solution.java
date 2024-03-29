class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] frequencies = new int[26];
        for (int i=0;i<s1.length();i++) frequencies[s1.charAt(i) - 'a']++;
        int i=0;
        while (i <= s2.length() - s1.length() ){
            
            int[] subFrequencies = new int[26];
            for (int s=0;s<s1.length();s++) subFrequencies[s2.charAt(i+s) - 'a']++;
            int j = 0;
            for(j=0;j<26;j++)
                if (frequencies[j] != subFrequencies[j])
                    break;
            if (j == 26)
                return true;
            i += 1;
        }
        
        return false;
    }
    /* Sliding Window */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;//first window in s2 with len s1
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1map, s2map))
                return true;
            s2map[s2.charAt(i + s1.length()) - 'a']++;//add next
            s2map[s2.charAt(i) - 'a']--;//remove curr
        }
        return matches(s1map, s2map);
    }
    
    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
    /* Optimized version using Sliding Window */
     public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        
        int count = 0;// counts how many entries are equal
        for (int i = 0; i < 26; i++)
            if (s1map[i] == s2map[i])
                count++;
        
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
            if (count == 26)
                return true;
            s2map[r]++;
            if (s2map[r] == s1map[r])
                count++;
            else if (s2map[r] == s1map[r] + 1)
                count--;
            s2map[l]--;
            if (s2map[l] == s1map[l])
                count++;
            else if (s2map[l] == s1map[l] - 1)
                count--;
        }
        return count == 26;
    }
}