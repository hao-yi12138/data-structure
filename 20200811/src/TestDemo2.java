import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: IntelliJ IDEA
 * @description:栈
 * @author: HAOYI
 * @date:2020-08-11 16:36
 **/
public class TestDemo2 {
    public static void main(String[] args) {

    }
    public static void main4(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());//出队
        System.out.println(myQueue.peek());
    }
    public static void main3(String[] args) {
        Queue<Integer> queue =new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());//出队
        System.out.println(queue.peek());

    }
    public static void main2(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
    }
    public static void main1(String[] args) {
        Stack<Integer> stack =new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.peek());//拿到栈顶元素不删除
        System.out.println(stack.pop());//出栈并且删除栈顶元素
        System.out.println(stack.peek());
        System.out.println(stack.empty());
        System.out.println(stack.search(2));
    }
}
