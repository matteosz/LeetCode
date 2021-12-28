class Solution {
public:
    int maxScoreSightseeingPair(vector<int>& values) {
    
        int left=values[0],left_id=0,ans=1;//lef stores the max val[i]+i
        
        for (int j=1;j<values.size();j++){ 
            ans = max(ans,values[left_id]+left_id+values[j]-j); 
            left_id = values[left_id]+left_id<values[j]+j ? j : left_id;
                  
        }
        
        return ans;
    }
};