class Solution {
public:
    vector<string> letterCombinations(string digits) {
        vector<string> ans;
        
        if (digits == "")
            return ans;
        
        string curr;
        vector<string> buttons = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        comb(ans,curr,buttons,digits,0,digits.size());
        
        return ans;
    }
private:
    void comb(vector<string>& ans, string curr, vector<string>& buttons, string digits, int pos, int n) {
        
        if (pos == n) {
            ans.push_back(curr);
            return;
        }
        
        for (int i = 0; i < buttons[digits[pos] - '0'].size(); i++)
            comb(ans,curr+buttons[digits[pos] - '0'][i],buttons,digits,pos+1,n);
        
    }
};