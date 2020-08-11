import sun.font.CreatedFontTracker;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-08-11 20:40
 **/
class Node{
    public int data;
    public Node next;
    public Node(int data){
        this.data =data;
    }
}
public class MyQueue {
    public int usedSize;
    public Node front;
    public Node rear;
    public boolean offer(int val){
        Node node = new Node(val);
        if(this.rear == null){
            this.front=node;
            this.rear = node;
        }else {
            this.rear.next = node;
            this.rear = node;
        }
        usedSize++;
        return true;
    }
    public int poll(){
          if(isEmpty()){
              throw new RuntimeException("队列为空！");
          }
          int data = this.front.data;
          this.front = this.front.next;
          return data;
    }
    public boolean isEmpty(){
        return this.usedSize==0;
    }
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        return this.front.data;
    }
    public int size(){
        return usedSize;
    }
}
