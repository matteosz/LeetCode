class Solution {
public:
    int rangeBitwiseAnd(int left, int right) {
        int ans = 0;
        for (int i=31; i>=0; i--) {
            long tmp = pow(2,i); 
            if (left >= tmp && right < tmp*2) {
                ans += tmp;
                left -= tmp;
                right -= tmp;
            }
                
        }
        return ans;
    }
};