class MyQueue {
   ArrayList<Integer>list ;
    public MyQueue() {
        list = new ArrayList<>();
    }
    
    public void push(int x) {
        list.add(x);
    }
    
    public int pop() {
        if(list.isEmpty())
        {
            return -1;
        }
        return list.remove(0);
    }
    
    public int peek() {
        if(list.isEmpty())
        {
            return -1;
        }
        return list.get(0);
    }
    
    public boolean empty() {
        return list.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */