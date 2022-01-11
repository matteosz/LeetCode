class Solution {
    /* O(N) solution, "hashing" the frequencies as string */
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            
            char[] freq = new char[26];//trick to transform in string, since char can be treated by int
            for (char c : s.toCharArray())
                freq[c - 'a']++;
            
            String key = new String(freq); //e.g. abd = bda = adb = "110100...0"
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(s);
            map.put(key,value);
        }
        
        return new ArrayList<>(map.values());
    }
    /* O(N^2) solution */
    public List<List<String>> groupAnagrams2(String[] strs) {
        int n = strs.length;
        int[][] maps = new int[n][26];
        List<List<String>> ans = new ArrayList<>();
        
        for (int i=0; i<n; i++)
            for (char c : strs[i].toCharArray())
                maps[i][c - 'a']++;
        
        boolean[] taken = new boolean[n];
        for (int i=0; i<n; i++) 
            if (!taken[i]) {
                taken[i] = true;
                List<String> group = new ArrayList<>();
                group.add(strs[i]);
                for (int j=i+1; j<n;j++)
                    if (!taken[j] && isAnagram(maps[i],maps[j])) {
                        group.add(strs[j]);
                        taken[j] = true;
                    }
                ans.add(group);
            }
        return ans;
    }
    private boolean isAnagram (int[] m1, int[] m2) {
        for (int i=0; i<26; i++)
            if (m1[i] != m2[i])
                return false;
        return true;
    }
}