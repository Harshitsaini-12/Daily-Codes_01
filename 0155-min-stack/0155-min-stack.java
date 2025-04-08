class MinStack {
    Stack<Long> st;
    long min;
    public MinStack() {
        st=new Stack<>();
        min=-1;
    }
    public void push(int val) {
        long x=val;
        if(st.isEmpty()){
            st.push(x);
            min=x;
        }else if(x<min){
            st.push(2*x-min); // fake value pushed.
            min=x;
        }else st.push(x);
    } 
    
    public void pop() {
        if(st.peek()>=min)
            st.pop();
        else 
        {
        min=2*min-st.peek(); // prev min restoration
        st.pop();
        }
    }
    public int top() {
      if(st.peek()<min)
      return (int)min;

      long q=st.peek();
      return (int)(q);
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */