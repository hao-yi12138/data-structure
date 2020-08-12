import java.util.Stack;

/**
 * @program: IntelliJ IDEA
 * @description:用栈实现队列
 * @author: HAOYI
 * @date:2020-08-12 16:25
 **/
public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
      this.stack1 = new Stack<>();
      this.stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
           if(empty()){
               return -1;
           }
           if(stack2.isEmpty()){
               while (!stack1.isEmpty()){
                   stack2.push(stack1.pop());
               }
           }
           return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(empty()){
            return -1;
        }
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
      if(stack1.isEmpty()&&stack2.isEmpty()){
          return true;
      }
      return false;
    }
}
