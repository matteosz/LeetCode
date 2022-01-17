class Solution {
public:
    string minRemoveToMakeValid(string s) {
        int n = s.size(), p = 0;
        string ans = "";
        
        for (int i=0; i<n; i++){
            
            if (s[i] == '(')
                p++;
            
            else if (s[i] == ')'){
                
                if (p == 0)
                    s[i]='*';
                
                else p--;
            }
        }
        p = 0;
        for (int i=n-1; i>=0; i--){
            
            if (s[i] == ')')
                p++;
            
            else if (s[i]=='('){
                
                if (p == 0)
                    s[i]='*';
                
                else p--;
            }
        }
        
        for (auto c : s)
            if (c != '*')
                ans.push_back(c);
        
        return ans;
    }
};