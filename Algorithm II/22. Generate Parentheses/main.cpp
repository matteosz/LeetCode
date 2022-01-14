class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> ans;
        
        comb(ans,"",0,2*n,n,n);
        
        return ans;
    }
private:
    void comb(vector<string>& ans, string curr, int pos, int n, int open, int close) {
        
        if (pos == n) {
            ans.push_back(curr);
            return;
        }
        
        if(open > 0) 
            comb(ans,curr+"(",pos+1,n,open-1,close);
        
        if (close > open)
            comb(ans,curr+")",pos+1,n,open,close-1);
        
    }
};