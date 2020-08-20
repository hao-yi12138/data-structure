import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-08-20 18:10
 **/
class Student{
    public String name;
}
public class TestDemo {
    public static void main(String[] args) {
        TestHeap testHeap = new TestHeap();
        int []array = {27,15,19,18,28,34,65,49,25,37};
        testHeap.createHeap(array);
        testHeap.show();
        testHeap.push(80);
        testHeap.show();
        testHeap.pop();
        testHeap.show();
    }
    public static void main2(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(10);
        priorityQueue.offer(2);
        priorityQueue.offer(17);
        priorityQueue.offer(9);
        System.out.println(priorityQueue.peek());
    }
    public static void main1(String[] args) {
        //Queue<Integer> queue =new PriorityQueue<>();
        PriorityQueue<Student> priorityQueue1 = new PriorityQueue<>();
        priorityQueue1.offer(new Student());
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(100);
    }
}
