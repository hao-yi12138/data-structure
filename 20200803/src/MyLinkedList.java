/**
 * @program: IntelliJ IDEA
 * @description:链表练习
 * @author: HAOYI
 * @date:2020-08-03 08:16
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
    //打印单链表
    public void display(){
        Node cur = this.head;
        while (cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void display2(Node newHead){
        Node cur = newHead;
        while (cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    //输入一个链表，输出该链表中倒数第k个结点。
    public Node FindKthToTail(int k) {
        if(head == null){
            return null;
        }
        if(k<=0){
            System.out.println("k不合法");
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        /*for (int i = 1; i <k-1 ; i++) {
            fast = fast.next;
        }*/
        while (k-1>0){
            if(fast.next != null){
                fast =fast.next;
                k--;
            }else {
                System.out.println("没有这个节点");
                return null;
            }
        }
        while (fast.next != null) {
            fast =fast.next;
            slow =slow.next;
        }
        return slow;
    }
    //编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public Node partition( int x) {
        Node as = null;
        Node ae = null;
        Node bs = null;
        Node be = null;
        Node cur = this.head;
        while(cur != null){
            if(cur.data<x){
                if(bs==null){
                   bs=cur;
                   be=cur;
                }else{
                    be.next = cur;
                    be = be.next;
                }
            }else{
                if(as==null){
                   as = cur;
                   ae = cur;
                }else{
                  ae.next = cur;
                  ae = ae.next;
                }
            }
            cur = cur.next;
        }
       if(bs == null ){
             return as;
       }
           be.next = as;
           if(ae !=null){
               ae.next = null;
           }
       return bs;
    }
    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
    // 重复的结点不保留，返回链表头指针。
    public Node deleteDuplication() {
        Node cur = this.head;
        Node newHead = new Node(-1);
        Node tmp = newHead;
        while(cur != null){
            if(cur.next!=null && cur.data == cur.next.data){
                while(cur.next!=null && cur.data == cur.next.data){
                    cur=cur.next;
                }
                cur = cur.next;
            }else{
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        tmp.next=null;
        return newHead.next;
    }
    //链表的回文结构
    public boolean chkPalindrome() {
        if(this.head == null){
            return false;
        }
        if(this.head.next == null){
            return true;
        }
        //找中间节点
       Node fast = this.head;
       Node slow = this.head;
       while(fast!=null && fast.next!=null ){
           fast = fast.next.next;
           slow = slow.next;
       }
       //反转后面的
       Node cur = slow.next;
       while(cur != null){
           Node curNext = cur.next;
           cur.next = slow;
           slow = cur;
           cur = curNext;
       }
       //一头一尾判断
        while(this.head!=slow){
            if(this.head.data != slow.data){
                return false;
            }
            if(this.head.next == slow){
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
    //给定一个链表，判断链表中是否有环。
    public boolean hasCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
              if(slow == fast){
                  return true;
              }
        }
        return false;
    }
    //给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    public Node detectCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                  slow = this.head;
                  while(slow!=fast){
                      fast=fast.next;
                      slow=slow.next;
                  }
                  return slow;
            }
        }
        return null;
    }
}
