class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusty = new int[n], trusted = new int[n];
        for (int[] x : trust) {
            trusty[x[0]-1]++;
            trusted[x[1]-1]++;
        }
        for (int i=0; i<n; i++) 
            if (trusty[i] == 0 && trusted[i] == n-1)
                return i+1;
        return -1;
    }
}