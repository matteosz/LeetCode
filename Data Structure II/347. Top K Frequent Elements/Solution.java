class Solution {
    /* Priority queue O(N lnk) */
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length)
            return nums;
        HashMap<Integer,Integer> freq = new HashMap<>();
        
        for (int x : nums) 
            freq.put(x,freq.getOrDefault(x,0)+1);
        
        Queue<Integer> heap = new PriorityQueue<>((k1,k2) -> freq.get(k1) - freq.get(k2));
        for (int x : freq.keySet()) {
            heap.add(x);
            if (heap.size() > k)
                heap.poll();
        }
        
        int[] ans = new int[k];
        for (int i=0; i<k; i++)
            ans[i] = heap.poll();
        
        return ans;
    }
    /* Bucket Sort O(N) */
    public int[] topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int x : nums) 
            freq.put(x,freq.getOrDefault(x,0)+1);
        
        for (int key : freq.keySet()) {
            int frequency = freq.get(key);
            if (bucket[frequency] == null) 
                bucket[frequency] = new ArrayList<>();
            
            bucket[frequency].add(key);
        }

        List<Integer> ans = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && ans.size() < k; pos--) {
            if (bucket[pos] != null) 
                ans.addAll(bucket[pos]);
            
        }
        
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}