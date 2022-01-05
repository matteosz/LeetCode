class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(x -> x[0]));
        LinkedList<int[]> ans = new LinkedList<>();
        
        for (int[] ival : intervals){
            int[] last;
            try {
                last = ans.getLast();
            } 
            catch (Exception e){
                ans.add(ival);
                continue;
            }
            if (last[1] >= ival[0])
                last[1] = Math.max(last[1],ival[1]);
            else ans.add(ival);
        }
        
        return ans.toArray(new int[ans.size()][]);
    }
}