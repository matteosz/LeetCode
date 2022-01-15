class MyLinkedList {
    
    class Node {
    public:
        Node *next;
        int val;
    
        Node(Node *n, int v) {
            next = n;
            val = v;
        }
    };
    
    Node *head;
    int num;
    
public:
    MyLinkedList() {
        head = nullptr;
        num = 0;
    }
    /* O(N) */
    int get(int index) {
        
        if (index >= num)
            return -1;
        
        Node *pt = head;
        for (int i=0; i<index; i++, pt = pt->next);
        
        return pt->val;
    }
    /* O(1) */
    void addAtHead(int val) {
        
        head = new Node(head,val);
        num++;
        
    }
    /* O(N) */
    void addAtTail(int val) {
        
        Node *tail = new Node(nullptr,val);
        
        if (head == nullptr)
            head = tail;
        else {
            Node *pt = head;
            for (;pt->next != nullptr; pt = pt->next);
            pt->next = tail;
        }
        
        num++;
    }
    /* O(N) */
    void addAtIndex(int index, int val) {
        if (index > num)
            return;
        
        if (index == 0)
            addAtHead(val);
        else {
            Node *prev = head, *pt = head->next;
            for (int i=1; i<index; i++, prev = pt, pt = pt->next);
            prev->next = new Node(pt,val);
            num++; 
        }  
    }
    /* O(N) */
    void deleteAtIndex(int index) {
        
        if (index >= num)
            return;
        
        if (index == 0) {
            head = head->next;
        }
        else {
            Node *prev = head, *tmp = head->next;
            for(int i=1; i<index; i++, prev = tmp, tmp = tmp->next);
            prev->next = tmp->next;
        }

        num--;
    }
};

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList* obj = new MyLinkedList();
 * int param_1 = obj->get(index);
 * obj->addAtHead(val);
 * obj->addAtTail(val);
 * obj->addAtIndex(index,val);
 * obj->deleteAtIndex(index);
 */