class Solution {
    public:
        int deleteAndEarn(vector<int>& nums) {
            int n = 10001;

            vector<int> sum(n, 0);

            for(int num: nums)
                sum[num] += num;//total sum by each number

            //house robbing concept
            int prev=0, best=0;
            for(int i=0; i<n; i++){
                int temp = max(best,sum[i]+prev);
                prev = best;
                best = temp;
            }

            return best;
        }
};