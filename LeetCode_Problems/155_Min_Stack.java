/**
155. Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

Methods pop, top and getMin operations will always be called on non-empty stacks.
*/
class MinStack {

    /** initialize your data structure here. */
    int[] a;
    int i;
    int min;
    int size = 10;
    public MinStack() {
        a = new int[size];
        i = -1;
        min = Integer.MAX_VALUE;   
    }
    
    public void push(int x) {
        if(min > x) this.min = x;
        if(i == size-1){
            int n = this.size * 10;
            int[] s = new int[n];
            for(int k =0; k<size;k++){
                s[k] = this.a[k];
            }
            this.size = n;
            this.a = s;
        }
        this.a[++i] = x;
        //System.out.println(this.i);
    }
    
    public void pop() {
        
        //System.out.println(this.i);
        if(i < 0) return;
        int d = this.i;
        if(min == a[d]){
            //calculate min
            int newMin = this.a[0];
            for(int j=1; j<= d - 1; j++){
                if(newMin > this.a[j])
                    newMin = this.a[j];
            }
            this.min = newMin;
        }
        this.i--;
        //System.out.println(this.i);
        if(this.i < 0) this.min = Integer.MAX_VALUE;
    }
    
    public int top() {
        return this.a[i];
    }
    
    public int getMin() {
        return this.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */