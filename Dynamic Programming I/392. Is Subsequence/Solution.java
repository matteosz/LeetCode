class Solution {
    /* O(N) solution for each s -> with k strings O(kN) */
    public boolean isSubsequence2(String s, String t) {
        if (s.length() > t.length())
            return false;
        if (s.length() == 0)
            return true;
        int count = 0;
        for (char c : t.toCharArray()){
            if (c == s.charAt(count))
                count++;
            if (count == s.length())
                return true;
        }
        return false;
    }
    /* Pre-process O(N) and then (MlogN) for each s -> with k strings O(kMlogN) -> better only with M<<N */
    public boolean isSubsequence(String s, String t) {
        List<Integer>[] dict = new List[26];
        int n = t.length(), m = s.length();
        
        /* Pre-processing - to be done once */
        for (int i=0; i<n; i++){
            if (dict[t.charAt(i)] == null)
                dict[t.charAt(i)] = new ArrayList<>();
            dict[t.charAt(i)].add(i);
        }//save char as indices and their position in a sorted array
        
        /* For every s - k times*/
        int pre = 0;
        for (int i=0; i<m; i++){
            if (t[s.charAt(i)] == null) return false; //s[i] not contained in t
            //search between indices of s[i] in t the closest (lower_bound) to prev
            int j = Collections.binarySearch(dict[s.charAt(i)], prev);
            if (j < 0) j = -j - 1;//index prev not found, return -(-j-1)-1 = j
            if (j == dict[s.charAt(i)].size()) return false;//last element
            prev = dict[s.charAt(i)].get(j) + 1;
        }
        return true;
    }
}