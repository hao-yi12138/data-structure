/**
 * @program: IntelliJ IDEA
 * @description:双向链表练习
 * @author: HAOYI
 * @date:2020-08-04 09:11
 **/
class Node{
    public int data;
    public Node next;
    public Node prev;
    public Node(int data){
        this.data = data;
    }
}
public class MyLinkedList {
      public Node head;
      public Node tail;//标志当前双向链表的尾巴
    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }else {
            this.head.prev = node;
            node.next = head;
            this.head = node;
        }
    }
    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
           this.tail.next = node;
           node.prev = this.tail;
           this.tail =node;
        }
    }
    //任意位置插入,第一个数据节点为0号下标
    private void checkIndex(int index){
         if(index<0 || index>size()){
             throw new RuntimeException("位置不合法");
         }
    }
    private Node searchIndex(int index){
        Node cur = this.head;
        for (int i = 0; i <index ; i++) {
            cur = cur.next;
        }
        return cur;
    }
    public void addIndex(int index,int data){
        checkIndex(index);
        if(index == 0){
            addFirst(data);
            return;
        }
        if(index==size()){
            addLast(data);
            return;
        }
        Node cur = searchIndex(index);
        Node node = new Node(data);
        node.next = cur;
        node.prev = cur.prev;
        cur.prev.next = node;
        cur.prev = node;

    }
    //打印
    public void display(){
        Node cur = this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //得到单链表的长度
    public int size(){
        Node cur = this.head;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    //删除第一次出现关键字为key的节点
    public int remove(int key){
         Node cur =this.head;
         while(cur!=null){
             if(cur.data == key){
                 int oldData = cur.data;
                 if (cur == this.head){
                     this.head = this.head.next;
                     this.head.prev = null;
                 }else {
                     cur.prev.next = cur.next;
                     if(cur.next!=null){
                         cur.next.prev = cur.prev;
                     }else {
                         this.tail = cur.prev;
                     }
                 }
                 return oldData;
             }
         }
       return -1;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        Node cur =this.head;
        while(cur!=null){
            if(cur.data == key){
                if (cur == this.head){
                    this.head = this.head.next;
                    if(this.head!=null) {
                        this.head.prev = null;
                    }
                }else {
                    cur.prev.next = cur.next;
                    if(cur.next!=null){
                        cur.next.prev = cur.prev;
                    }else {
                        this.tail = cur.prev;
                    }
                }
            }
        }
    }
    public void clear(){
        while(this.head!=null){
            Node cur =this.head.next;
            this.head.prev = null;
            this.head.next = null;
            this.head = cur;
        }
        this.tail = null;
    }

}
