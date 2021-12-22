class Solution(object):#DYNAMIC PROGRAMMING NEEDED
    def maxSubArray(self, nums):
        count = []
        count.append(nums[0])
        best = count[0]
        for i in range(1,len(nums)):
            count.append(max(count[i-1] + nums[i],nums[i]))
            if count[i] > best:
                best = count[i]
                
        return best
            