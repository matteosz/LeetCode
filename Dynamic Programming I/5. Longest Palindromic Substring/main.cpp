class Solution {
public:
    /* DP, O(N^2) space and time */
    string longestPalindrome2(string s) {
        int n = s.size(), best = 0, start = 0;
        vector<vector<bool>> dp(n,vector<bool>(n,false));
        
        for (int i=0; i<n; i++){
            dp[i][i] = true;//single character
            if (i == n-1) break;
            if (s[i] == s[i+1]){//double equal char (aa)
                dp[i][i+1] = true;
                best = 1;
                start = i;
            }
        }
        
        for(int i=n-3; i>=0; i--)
            for (int j=i+2; j<n; j++){
                dp[i][j] = dp[i+1][j-1] && s[i]==s[j];//inner substring is palindrome and corner letters are same
           
                if (dp[i][j] && j-i > best){
                    best = j-i;
                    start = i;
                }
            }
        return s.substr(start,best+1);
    }
    /* DP, O(N^2) time and O(1) space */
    string longestPalindrome(string s) {
        int best = 0, start = 0, n = s.size();
        for (int i=0; i<n; i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);//even substring has as center 2 letters
            int len = max(len1, len2);
            if (len > best) {
                start = i - (len - 1) / 2;
                best = len;
            }
        }
        return s.substr(start, best);
    }
private:
    int expandAroundCenter(string s, int l, int r) {
        while (l >= 0 && r < s.size() && s[l] == s[r]) {
            l--;
            r++;
        }
        return r-l-1;
    }
};