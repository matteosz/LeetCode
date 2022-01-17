class MinStack {
    
    class Node {
    public:
        int val, min;
        
        Node(int val, int min) {
            this->val = val;
            this->min = min;
        }
        
    };
    
    vector<Node> base;
    
public:
    MinStack() {}
    
    void push(int val) {
        if (base.size() == 0)
            base.push_back(Node(val,val));
        else base.push_back(Node(val,min(val,base.back().min)));
    }
    
    void pop() {
        base.pop_back();
    }
    
    int top() {
        return base.back().val;
    }
    
    int getMin() {
        return base.back().min;
    }
};