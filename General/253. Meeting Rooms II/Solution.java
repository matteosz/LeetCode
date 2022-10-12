class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Queue<int[]> pQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        
        pQueue.offer(intervals[0]);
        int rooms = 1;
        
        for (int i=1; i<intervals.length; i++) {
            if (pQueue.peek()[1] <= intervals[i][0])
                pQueue.poll();
            
            pQueue.offer(intervals[i]);
            rooms = Math.max(rooms, pQueue.size());
        }
        
        return rooms;
    }
}