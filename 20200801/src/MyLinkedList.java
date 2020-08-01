/**
 * @program: IntelliJ IDEA
 * @description:链表
 * @author: HAOYI
 * @date:2020-08-01 08:33
 **/
class Node{
    public int data;
    public Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class MyLinkedList {
    public Node head;
    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
      if(this.head == null) {
          this.head = node;
          return;
      }
          node.next = this.head;
          this.head = node;
    }
    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        Node cur = this.head;
        if(this.head == null){
            this.head = node;
            return;
        }
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
    }
    //得到单链表的长度
    public int size(){
        Node cur = this.head;
        int size = 0;
        while(cur != null){
            size++;
            cur = cur.next;
        }
        return size;
    }
    //任意位置插入,第一个数据节点为0号下标
    private Node searchIndex(int index){
        if(index<0 || index>size()){
            throw new RuntimeException("index位置不合法");
        }
        Node cur = this.head;
        for (int i = 0; i <index-1 ; i++) {
            cur = cur.next;
        }
        return cur;
    }
    public void addIndex(int index,int data){
        if(index == 0){
            addFirst(data);
            return;
        }
        if (index == size()){
            addLast(data);
            return;
        }
        Node node = new Node(data);
        Node cur = searchIndex(index);
        node.next = cur.next;
        cur.next = node;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        Node prev = this.head;
        Node del = prev.next;
        while(del !=null){
            if(del.data == key){
                prev.next = del.next;
                del = del.next;
            }else{
                prev = del;
                del = del.next;
            }
        }
        if(this.head.data == key){
            this.head = this.head.next;
        }
    }
    //反转列表
    public Node reverseList(){
        Node cur = this.head;
        Node prev = null;
        Node newHead = null;
        while(cur!=null){
            Node curNext = cur.next;
            if(curNext == null){
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
       return newHead;
    }
    //给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
    //如果有两个中间结点，则返回第二个中间结点。
    public Node middleNode() {
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //输入一个链表，输出该链表中倒数第k个结点。
    public Node FindKthToTail(int k) {

    }
    //打印单链表
    public void display(){
        Node cur = this.head;
        while (cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    //反转之后打印
    public void display2(Node newHead){
        Node cur = newHead;
        while (cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}
