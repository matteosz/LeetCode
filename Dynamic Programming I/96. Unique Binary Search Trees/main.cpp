class Solution {
    //Solution explained in the readme
    int B(int n, vector<int>&  memo){
        if (memo[n] != -1)
            return memo[n];
        int sum = 0;
        for (int i=1;i<=n;i++)
            sum += B(i-1,memo)*B(n-i,memo);
        memo[n] = sum;
        return memo[n];
    }

public:
    int numTrees(int n) {
        vector<int> memo(n+1,-1);
        memo[0] = memo[1] = 1;
        return B(n,memo);
    }
};
