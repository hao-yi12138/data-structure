import java.util.Stack;

/**
 * @program: IntelliJ IDEA
 * @description:最小栈
 * @author: HAOYI
 * @date:2020-08-12 16:51
 **/
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
         stack.push(x);
         if(minStack.isEmpty()){
             minStack.push(x);
         }else {
             if(x<=minStack.peek()){
                 minStack.push(x);
             }
        }
    }

    public void pop() {
          if(!stack.isEmpty()){
              int tmp = stack.pop();
              if(tmp == minStack.peek()){
                  minStack.pop();
              }
          }
    }

    public int top() {
         if(stack.empty()){
             return -1;
         }
         return stack.peek();
    }

    public int getMin() {
        if(minStack.empty()){
            return -1;
        }
        return minStack.peek();
    }
}
