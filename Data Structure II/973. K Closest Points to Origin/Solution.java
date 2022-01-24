class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        
        Arrays.sort(points, (a,b) -> (getSquareDist(a) - getSquareDist(b)));
        
        for (int i=0; i<k; i++)
            ans[i] = points[i];
        return ans;
    }
    private int getSquareDist(int[] p) {
        return p[0]*p[0] + p[1]*p[1];//sqrt(x) < sqrt(y) => x < y [x>=0 and y>=0]
    }
}