class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int c=0;
        for (int i=0;i<nums.size();i++)
            if (nums[i]){
                if (i != c)
                    nums[c] = nums[i];
                c++;
            }
        for (;c<nums.size();c++)
            nums[c] = 0;
    }
};
