class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if (hand.length % groupSize != 0)
            return false;
        
        Arrays.sort(hand);
        Map<Integer, Integer> distinct = new HashMap<>();
        
        for (int card : hand)
            distinct.put(card, 1 + distinct.getOrDefault(card, 0));
        
        for (int card : hand) {
            if (distinct.get(card) == 0)
                continue; // already taken in a group
            distinct.put(card, distinct.get(card)-1);
            for (int j=1; j<groupSize; j++) {
                int next = distinct.getOrDefault(card+j, 0);
                if (next == 0)
                    return false;
                distinct.put(card+j, next-1);
            } 
        }
            
        return true;
    }
}