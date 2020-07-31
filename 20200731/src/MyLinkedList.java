/**
 * @program: IntelliJ IDEA
 * @description:单链表练习
 * @author: HAOYI
 * @date:2020-07-31 09:10
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
    public Node head;//保存单链表头节点的引用
    //头插法
    public void addFirst(int data){
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            return;
        }
        node.next = head;
        head = node;
    }
    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            return;
        }
        Node cur = this.head;
        while(cur.next!=null){
            cur = cur.next;
        }
          cur.next = node;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == this.size()){
            addLast(data);
            return;
        }
        Node cur = searchIndex(index);
        Node node = new Node(data);
        node.next = cur.next;
        cur.next = node;
    }
    private Node searchIndex(int index){
        if(index<0 || index>this.size()){
            throw new RuntimeException("index位置不合法");
        }
        Node cur = this.head;
        for (int i = 0; i <index-1 ; i++) {
            cur = cur.next;
        }
        return cur;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        Node cur = this.head;
        while(cur != null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
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
    //删除第一次出现关键字为key的节点
    private Node searchPrev(int key){
        Node prev = this.head;
        while (prev.next != null) {
            if (prev.next.data == key) {
              return prev;
            } else {
                prev = prev.next;
            }
        }
        return null;
    }
    public void remove(int key) {
        if(this.head == null){
            return;
        }
        //判断删除的是不是头节点
        if(this.head.data == key){
            this.head =this.head.next;
            return;
        }
        //找到删除节点的前驱
        Node prev=searchPrev(key);
        if(prev == null){
            System.out.println("没有这个节点！");
            return;
        }
        Node del = prev.next;
        prev.next = del.next;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
      Node prev = this.head;
      Node cur = prev.next;
      while (cur != null){
          if(cur.data == key){
              prev.next = cur.next;
              cur = cur.next;
          }else{
              prev=cur;
              cur=cur.next;
          }
      }
      if(this.head.data == key){
          this.head = this.head.next;
      }
    }
    //释放内存
    public void clear(){
      this.head=null;
    }
    //打印单链表
    public void display(){
        Node cur = this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}
