class Solution {
public:
    bool isValid(string s) {
        
        string open = "([{", close = ")]}";
        stack<char> pool;
        
        for(int i=0;i<s.length();i++){
            if (open.find(s[i]) != string::npos)
                pool.push(s[i]);
            else{
                if (!pool.size())
                    return false;
                char c = pool.top();
                pool.pop();
                if (open.find(c) != close.find(s[i]))
                    return false;
            }
                
        }
        return pool.size()? false : true;
    }
};