class Solution {/* Kadane's Algorithm */
public:
    int maxProfit(vector<int>& prices) {
        int local_max=0, global_max=0;
        for (int i = 1; i < prices.size(); i++){
            local_max = max(0, local_max + prices[i]-prices[i-1]);
            global_max = max(local_max,global_max);
        }
        
        return global_max;
    }
};

class Solution {/* Alternative version */
public:
    int maxProfit(vector<int> &prices) {
        int maxPro = 0;
        int minPrice = INT_MAX;
        for(int i = 0; i < prices.size(); i++){
            minPrice = min(minPrice, prices[i]);
            maxPro = max(maxPro, prices[i] - minPrice);
        }
        return maxPro;
    }
};