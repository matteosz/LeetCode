class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m];
        int l = m + n;
        for(int i=0;i<m;i++)
            tmp[i] = nums1[i];
        int id1=0,id2=0;
        for(int i=0;i<l;i++){
            if (id1 >= m)
                nums1[i] = nums2[id2++];
            else if (id2 >= n)
                nums1[i] = tmp[id1++];
            else if (tmp[id1] <= nums2[id2])
                nums1[i] = tmp[id1++];
            else nums1[i] = nums2[id2++];
        }
    }
}