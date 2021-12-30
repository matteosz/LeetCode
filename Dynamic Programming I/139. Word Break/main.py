class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        d, l = set(wordDict), len(s)
        dp = [False] * (l+1)
        dp[0] = True
        
        for i in range(1,l+1):
            for j in range(i-1,-1,-1):
                if dp[j]:
                    word = s[j:i]
                    if word in d:
                        dp[i] = True
                        break
        
        return dp[l]