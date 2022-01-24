class Solution {
    
    class Rect {
        
        double m = 0,q = 0;
        boolean horizontal = false;
        int x = 0;
        
        Rect(int[] x1, int[] x2) {
            coeff(x1,x2);
            if (!horizontal)
                shift(x2);
        }
        
        /*public boolean pass(int[] x) {
            if (horizontal)
                return x[0] == this.x;
            
            return isClose(x[1],m*x[0] + q);
        }*/
        
        @Override
        public boolean equals(Object obj) {
            Rect r2 = (Rect) obj;
            if (!isClose(m,r2.m) || !isClose(q,r2.q) || horizontal != r2.horizontal || x != r2.x)
                return false;
            return true;
        }
        @Override
        public int hashCode() {
            if (horizontal)
                return Objects.hash(x);
            return Objects.hash(m,q);
        }
        
        private void coeff(int[] x1, int[] x2) {
            if (x2[0] == x1[0]) {
                horizontal = true;
                x = x2[0];
                return;
            }
            m = (x2[1]-x1[1]) / (double)(x2[0]-x1[0]);
        }
        private void shift(int[] x2) {
            q = x2[1] - x2[0] * m;
        }
        private boolean isClose(double x1, double x2) {
            double eps = 0.001;
            return Math.abs(x1 - x2) < eps;
        }
    }
    
    public int maxPoints(int[][] points) {
        int n = points.length, ans = n==0? 0 : 1;
        
        for (int i=0; i<n-1; i++) {
            HashMap<Rect,Integer> rects = new HashMap<>();
            for (int j=i+1; j<n; j++) {
                Rect r = new Rect(points[i],points[j]);
                int p = rects.getOrDefault(r,1) + 1;
                rects.put(r,p);
                ans = Math.max(ans, p);
            }
        }
        return ans;
    }
}