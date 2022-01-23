class Solution {
    
    vector<int> original;
public:
    
    Solution(vector<int>& nums) {
        original = vector<int>(nums); 
    }
    
    vector<int> reset() {
        return original;
    }
    /* Fisher-Yates Algorithm */
    vector<int> shuffle() {
        vector<int> shuffled(original);
        int n = original.size();
        
        for (int i=0; i<n; i++) 
            swap(shuffled[i],shuffled[i + rand()%(n-i)]);
        
        return shuffled;
    }
    /* O(N^2) solution - remove takes O(N) */
    vector<int> shuffle() {
        vector<int> shuffled, tmp(original);
        
        while (!tmp.empty()) {
            int id = rand() % tmp.size();
            shuffled.push_back(tmp[id]);
            tmp.erase(tmp.begin() + id);
        }
        
        return shuffled;
    }
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution* obj = new Solution(nums);
 * vector<int> param_1 = obj->reset();
 * vector<int> param_2 = obj->shuffle();
 */