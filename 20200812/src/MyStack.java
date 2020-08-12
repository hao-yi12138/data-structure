import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: IntelliJ IDEA
 * @description:使用队列实现栈
 * @author: HAOYI
 * @date:2020-08-12 15:05
 **/
public class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    /** Initialize your data structure here. */
    public MyStack() {
      queue1 = new LinkedList<>();
      queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(!queue1.isEmpty()){
            queue1.offer(x);
        }else if(!queue2.isEmpty()){
            queue2.offer(x);
        }else {
            queue1.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int x = 0;
        int qSize1 = queue1.size();
        int qSize2 = queue2.size();
        if(empty()){
           return -1;
       }else if(!queue1.isEmpty()){
           for (int i = 0; i <qSize1-1 ; i++) {
               queue2.offer(queue1.poll());
           }
           x = queue1.poll();
       }else {
           for (int i = 0; i <qSize2-1 ; i++) {
               queue1.offer(queue2.poll());
           }
           x = queue2.poll();
       }
       return x;
    }

    /** Get the top element. */
    public int top() {
        int x = 0;
        int qSize1 = queue1.size();
        int qSize2 = queue2.size();
        if(empty()){
            return -1;
        }else if(!queue1.isEmpty()){
            for (int i = 0; i < qSize1 ; i++) {
                x = queue1.poll();
                queue2.offer(x);
            }
        }else {
            for (int i = 0; i < qSize2 ; i++) {
                x = queue2.poll();
                queue1.offer(x);
            }
        }
        return x;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
     if(queue1.isEmpty()&&queue2.isEmpty()){
         return true;
     }
     return false;
    }
}
