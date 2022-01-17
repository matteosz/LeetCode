class Solution {
    public int findTheWinner(int n, int k) {
        
        List<Integer> friends = new LinkedList<>();
        for (int i=1; i<=n; i++)
            friends.add(i);
        
        for (int id = 0, times=1, size; times<n; times++, id = (id+k-1)%size) {
            size = friends.size();
            friends.remove((id+k-1)%size);
        } 
            
        return friends.get(0);
    }
}