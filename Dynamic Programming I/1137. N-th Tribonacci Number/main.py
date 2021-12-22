def trib(v,n):
    if v[n] != -1:
        return v[n]
    if n < 2:
        v[n] = n
        return n
    if n == 2:
        v[n] = 1
        return 1
    t = trib(v,n-3) + trib(v,n-2) + trib(v,n-1)
    v[n] = t
    return t

class Solution(object):
    def tribonacci(self, n):
        v = [-1] * (n+1)
        return trib(v,n)