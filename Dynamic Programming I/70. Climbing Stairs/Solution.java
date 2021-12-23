class Solution { /* very similar to DP Fibonacci */
    
    public int explore_states(int[] tot,int i, int n){
        if(i > n)
            return 0;
        if (i == n)
            return 1;
            
        if (tot[i] != -1)
            return tot[i];
        
        tot[i] = explore_states(tot,i+1,n) + explore_states(tot,i+2,n);
        return tot[i];
    }
    
    public int climbStairs(int n) {
        int[] stairs = new int[n];
        for (int i=0;i<n;i++)
            stairs[i] = -1;
        return explore_states(stairs,0,n);
    }
}