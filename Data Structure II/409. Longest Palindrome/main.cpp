class Solution {
public:
    int longestPalindrome(string s) {
        vector<int> dict(58);//'A' - 'z' is 57
        int ans = 0;
        
        for (char c : s)
            dict[c-'A']++;
        
        for (int x : dict) 
            if (x > 1)
                ans += x/2 * 2;
                
        if (ans < s.size())
            ans++;
        
        return ans;
    }
};