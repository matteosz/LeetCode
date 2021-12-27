class Solution {
    public int getMaxLen(int[] nums) {
        
        int best = 0, negative = 0;
        
        for (int i=0, neg_index=-1, zero=-1;i<nums.length;i++){
           
            if (nums[i] < 0){
                negative++;
                if (neg_index == -1)
                    neg_index = i;//first negative element of the sequence
            }
            if (nums[i] == 0){
                negative = 0;
                neg_index = -1;
                zero = i;
                continue;
            }
            
            if (negative % 2 == 0)
               best = Math.max(best, i - zero);
            
            else best = Math.max(best, i - neg_index); 
        }
            
        return best;
    }
    public int getMaxLen(int[] nums) { /* Dry run solution */
        int positive = 0, negative = 0, best = 0;
        
        for(int x : nums) {
            if(x == 0)  {
                positive = 0;
                negative = 0;
            }
            else if(x > 0) {
                positive++;
                negative = negative == 0? 0  : negative+1;
            }
            else {
                int tmp = positive;
                positive = negative == 0? 0  : negative+1;//swap positive with negative
                negative = tmp+1;
            }
            best = Math.max(best, positive);
        }
        return best;
    }
}