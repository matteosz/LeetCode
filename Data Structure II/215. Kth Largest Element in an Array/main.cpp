class Solution {
public:
    /* Avg case O(N), worst O(N^2), quick-sort based */
    int findKthLargest(vector<int>& nums, int k) {
        quicksort(nums,0,nums.size()-1,k);
        return nums[nums.size()-k];
    }
    /* O(N ln K) - min-heap */
    int findKthLargest2(vector<int>& nums, int k) {
        
        priority_queue<int, vector<int>, greater<int>> pq;
        
        for (int num : nums) {
            pq.push(num);
            
            if (pq.size() > k) 
                pq.pop();
            
        }
        return pq.top();
    }
private:
    void quicksort(vector<int>& nums, int l, int r, int k) {
        if (l >= r)
            return;
        int id = partition(nums,l,r);
        if (id == nums.size()-k)
            return;
        quicksort(nums,id+1,r,k);
        quicksort(nums,l,id-1,k);
    }
    int partition(vector<int>& nums, int l, int r) {
        int pivot = nums[r], i = l-1, j = r;
        
        for (;;) {
            while (nums[++i] < pivot);
            while (j > l && nums[--j] > pivot);
            
            if (i >= j)
                break;
            
            swap(nums[i],nums[j]);
        }
        swap(nums[i],nums[r]);
        return i;
    }
};