public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0,i = 30;
        if ((n & 1) == 1)
            ans -= Math.pow(2,i+1);//Java uses 2's complement
        n >>= 1;
        
        while (i >= 0){
            if ((n & 1) == 1)
                ans += Math.pow(2,i);
            i--;
            n >>= 1;
        }
        return ans;
    }
}