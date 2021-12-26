class Solution {
public: /* Divide and conquer solution */
    int maxSubArray(vector<int>& nums) {
        return maxSubArray(nums, 0, size(nums)-1);
    }
    int maxSubArray(vector<int>& A, int L, int R){
        if(L > R) return INT_MIN;
        int mid = (L + R) / 2, leftSum = 0, rightSum = 0;
        // leftSum = max subarray sum in [L, mid-1] and starting from mid-1
        for(int i = mid-1, curSum = 0; i >= L; i--)
            curSum += A[i],
            leftSum=max(leftSum, curSum);
        // rightSum = max subarray sum in [mid+1, R] and starting from mid+1
        for(int i = mid+1, curSum = 0; i <= R; i++)
            curSum += A[i],
            rightSum = max(rightSum, curSum);
		// return max of 3 cases
        return max({ maxSubArray(A, L, mid-1), maxSubArray(A, mid+1, R), leftSum + A[mid] + rightSum });
    }
    // This solution is O(N logN). To optimize we need to pre-compute the sum of subarray starting with index i
    // and the ones finishing with index i, changing O(N)->O(1) in the recurrence equation for the merging part.
};
