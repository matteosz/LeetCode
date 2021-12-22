int binary_search(int* v, int i, int j, int x){
    if (i > j)
        return i;
    int m = i + (j-i)/2;
    if (v[m] == x)
        return m;
    if (v[m] > x)
        return binary_search(v,i,m-1,x);
    return binary_search(v,m+1,j,x);
}

int searchInsert(int* nums, int numsSize, int target){
    return binary_search(nums,0,numsSize-1,target);
}