class Solution {
public:
    vector<vector<int>> intervalIntersection(vector<vector<int>>& firstList, vector<vector<int>>& secondList) {
        vector<vector<int>> ans;
        
        int lenA = firstList.size(), lenB = secondList.size();      
        int i = 0, j = 0, left = 0, right = 0;
        
        while (i < lenA && j < lenB){
        
            left = max(secondList[j][0],firstList[i][0]);
            right = min(secondList[j][1],firstList[i][1]);
            if (left <= right)
                ans.push_back(vector<int> {left,right});
            
            if (firstList[i][1] > secondList[j][1])
                j++;
            else i++;
        }
        return ans;
    }
};