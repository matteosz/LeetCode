class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        
        for (int i=0;i<s.length();i++)
            if (map[s.charAt(i) - 'a'] == 0)
                map[s.charAt(i) - 'a'] = i+1;
            else map[s.charAt(i) - 'a'] = -1;
        
        int min = s.length();
        for(int i=0;i<26;i++)
           if (map[i] > 0 && map[i]<min+1)
               min = map[i]-1;

        return min==s.length()? -1 : min;
    }
}