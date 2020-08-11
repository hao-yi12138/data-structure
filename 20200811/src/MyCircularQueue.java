/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-08-11 21:48
 **/
public class MyCircularQueue {
    public int[]elem;
    public int front;
    public int rear;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
       this.elem = new int[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
     if(isFull()) {
         return false;
     }
     this.elem[this.rear] = value;
     this.rear = (this.rear+1)%this.elem.length;
     return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
      if(isEmpty()){
          return false;
      }
      this.front = (this.front+1)%this.elem.length;
      return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
      if(isEmpty()){
          return -1;
      }
      return this.elem[this.front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
       int index = this.rear==0?this.elem.length-1:this.rear-1;
        return elem[index];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
         return this.rear==this.front;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
         if((this.rear+1)%this.elem.length == front){
             return true;
    }
         return false;
}

}
