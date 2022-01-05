class MyHashMap {
    /* Linear Chaining */
    class Node {
        int key, val;
        Node next;
        public Node(int key, int val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    
    private int M = 5000;
    private Node[] table = new Node[M];//at most 10^4 insertions -> load factor of 2
        
    private int hashU(int key){
        return Integer.hashCode(key) % M;
    }
    
    public void put(int key, int value) {
        int id = hashU(key);
        Node x = table[id];
        while (x != null && x.key != key) x = x.next;
        
        if (x != null) //key still present
            x.val = value;//update value
        else
            //insert in head
            table[id] = new Node(key,value,table[id]);
    }
    
    public int get(int key) {
        int id = hashU(key);
        Node x = table[id];
        while (x != null && x.key != key) x = x.next;
        
        if (x == null)
            return -1;
        return x.val;
    }
    
    public void remove(int key) {
        int id = hashU(key);
        Node x = table[id], p = x;
        
        if(x == null) return;
        
        if (x.key == key){
            table[id] = table[id].next;
            return;
        }
        for (x=x.next; x != null && x.key!=key; p=x, x=x.next);
        p.next = x==null? x : x.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */