class Solution {
    public boolean isAnagram(String s, String t) {
        
        int lenS = s.length(), lenT = t.length();
        if (lenS != lenT)
            return false;
        
        int charactersNumber = 26; // should be set to 144,697 for Unicode
        int[] map = new int[charactersNumber];
        
        for(int i=0;i<lenS;i++) map[s.charAt(i) - 'a']++;// no need to subtract 'a' in case of Unicode
        
        for(int i=0;i<lenT;i++)
            if (--map[t.charAt(i) - 'a'] < 0)
                return false;
        return true;
        
    }
}