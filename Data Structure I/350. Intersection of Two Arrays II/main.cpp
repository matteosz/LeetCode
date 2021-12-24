class Solution1 {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {//O(NlogN) in time, O(1) in space
        int p=0,q=0;
        vector<int> intersection;
        sort(nums1.begin(),nums1.end());
        sort(nums2.begin(),nums2.end());
        for (;;){
            if (p >= nums1.size() || q >= nums2.size())
                break;
            if (nums1[p] == nums2[q]){
                intersection.push_back(nums1[p++]);
                q++;
            }
            else if (nums1[p] < nums2[q])
                p++;
            else q++;
        }
        
        return intersection;
    }
};

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {//O(N+M) in time, O(min(M,N)) in space
        if (nums1.size() > nums2.size())
            return intersect(nums2,nums1);
        
        unordered_map<int,int> counter;
        vector<int> intersection;
        
        for(int i=0;i<nums1.size();i++)
            counter[nums1[i]]++;
        for(int i=0;i<nums2.size();i++)
            if (counter.find(nums2[i]) != counter.end() && --counter[nums2[i]] >= 0)
                intersection.push_back(nums2[i]);
        
        return intersection;
    }
};