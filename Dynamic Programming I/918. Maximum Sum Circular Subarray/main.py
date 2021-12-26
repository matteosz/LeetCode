# We can have two possibilities: either the max subarray is circular or classical.
# If it's circular, the minimum subarray is classical and the max sum will be TOTAL-MIN
# Otherwise if it's classical it's a normal subarray problem
# So we're applying Kadane's algo for both max and min and comparing the two results
# We need only to cover one particular case: all elements are negative
class Solution(object):
    def maxSubarraySumCircular(self, A):
        total, maxSum, curMax, minSum, curMin = 0, A[0], 0, A[0], 0
        for a in A:
            curMax = max(curMax + a, a)
            maxSum = max(maxSum, curMax)
            curMin = min(curMin + a, a)
            minSum = min(minSum, curMin)
            total += a
        return max(maxSum, total - minSum) if maxSum > 0 else maxSum