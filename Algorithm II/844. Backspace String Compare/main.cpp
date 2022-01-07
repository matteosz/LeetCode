class Solution {
public:
    /* O(m+n) in space and time */
    bool backspaceCompare(string s, string t) {
        
        stack<char> s1, s2;
        for (char c : s)
            if (c == '#' && !s1.empty())
                s1.pop();
            else if (c != '#')
                s1.push(c);
        for (char c : t)
            if (c == '#' && !s2.empty())
                s2.pop();
            else if (c != '#')
                s2.push(c);
        while (!s1.empty() && !s2.empty()){
            if (s1.top() != s2.top())
                return false;
            s1.pop();
            s2.pop();
        }
        return s1.size()==s2.size();
    }
    /*  O(m+n) in time, O(1) in space */
    bool backspaceCompare(string s, string t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (s[i] == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (t[j] == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && s[i] != t[j])
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }
};