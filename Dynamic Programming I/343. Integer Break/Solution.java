class Solution {
    public int integerBreak(int n) {
        if (n==2) return 1;
        if (n==3) return 2;
        
        /* pick as many 3s as we can */
        int threes = n/3;
        int reminder = n%3;
        
        if (reminder == 1) { 
            reminder = 4;/* better 2+2 than 3+1 */
            threes--;
        }
        else if (reminder == 0)
            reminder = 1;//neutral for multiplication
        
        return (int) Math.pow(3,threes) * reminder;
    }
}