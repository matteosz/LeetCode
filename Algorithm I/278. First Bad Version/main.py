# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool
# def isBadVersion(version):
def isBadVersion(n,k=3):
    if n >= k:
        return True
    return False

class Solution(object):

    def firstBadVersion(self, n):
        l,r = 1,n
        while l < r:
            m = l + (r-l)//2 # safer approach to prevent overflow
            if isBadVersion(m):
                r = m
            else:
                l = m + 1
        return l
        
print(Solution().firstBadVersion(6))