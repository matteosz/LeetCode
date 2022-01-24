class Solution {
public:
    /* O(N) */
    string frequencySort(string s) {
        vector<pair<char,int>> freq(75);//letters and digits
        string ans;
        
        for (char c : s)
            freq[c - '0'] = {c,freq[c - '0'].second + 1};
        
        sort(freq.begin(),freq.end(),compare);/* O(1) because 75 is a constant */
        
        for (auto x : freq) {
            if (x.second == 0)
                break;
            for (int i=0; i<x.second; i++)
                ans.push_back(x.first);
        }
            
        return ans;
    }
private:
    static bool compare(pair<char,int> p1, pair<char,int> p2) {
        return p1.second > p2.second;
    }
};