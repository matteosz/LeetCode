class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        pascal = []
        pascal.append([1])
        for i in range(2,numRows+1):
            row = []
            for j in range(1,i+1):
                if j == 1 or j == i:
                    row.append(1)
                else: row.append(pascal[i-2][j-2] + pascal[i-2][j-1])
            pascal.append(row)
        
        return pascal