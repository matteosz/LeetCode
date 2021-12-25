class Solution {

    void reverseString(string &s,int p,int q){
        for(int i=0;i <= (q-p)/2;i++){
            int tmp = s[p+i];
            s[p+i] = s[q-i];
            s[q-i] = tmp;
        }
    }

public:
    string reverseWords(string s) {
        int i=0,j=0,l=s.length();

        while (i < l){
            if (s[i] == ' '){
                reverseString(s,j,i-1);
                j = i + 1;
            }
            else if (i == l - 1)
               reverseString(s,j,i);
            i++;
        }
        return s;
    }
};
