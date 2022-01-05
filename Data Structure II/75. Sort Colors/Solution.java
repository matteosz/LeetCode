class Solution {
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = nums.length-1;
        
        while (white <= blue){
            if (nums[white] == 0){//RED
                int tmp = nums[red];
                nums[red] = nums[white];
                nums[white] = tmp;
                red++;white++;
            }
            else if (nums[white] == 1)//WHITE
                white++;
            else {//BLUE
                int tmp = nums[blue];
                nums[blue] = nums[white];
                nums[white] = tmp;
                blue--;
            }
        }
    }
}