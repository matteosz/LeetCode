public class Solution {
    private int binarySearch(int[] v, int i, int j, int target){
        if (i > j)
            return -1;
        
        int m = (i+j)/2;
        if (v[m] == target)
            return m;
        if (v[m] > target)
            return binarySearch(v,i,m-1,target); // search left
        else
            return binarySearch(v,m+1,j,target); // search right
        
    }
    
    public int search(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }
    public static void main(String[] args){
        Solution s = new Solution();

        int nums[] = {-1,0,3,5,9,12}, target = 9;
        System.out.println(s.search(nums,target));

        target = 2;
        System.out.println(s.search(nums,target));
    }


}
