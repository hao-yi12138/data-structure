import java.util.*;

/**
 * @program: IntelliJ IDEA
 * @description:链表练习
 * @author: HAOYI
 * @date:2020-08-03 08:15
 **/
public class TestDemo {
    //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    public static Node mergeTwoLists(Node l1, Node l2) {
           Node newHead = new Node(-1);
           Node tmp = newHead;
           while(l1.next!=null && l2.next!=null){
               if(l1.data<l2.data){
                   tmp.next = l1;
                   tmp = tmp.next;
                   l1 = l1.next;
               }else{
                   tmp.next = l2;
                   tmp = tmp.next;
                   l2 = l2.next;
               }
           }
           if(l1!=null){
               tmp.next=l1;
           }
           if(l2!=null){
               tmp.next = l2;
           }
           return newHead.next;
    }
    public static void createCut(Node headA, Node headB){
        headA.next=headB.next.next;
    }
    //找到两个单链表相交的起始节点。
    public static Node getIntersectionNode(Node headA, Node headB) {
        Node pl = headA;
        Node ps = headB;
        int lenA=0;
        int lenB=0;
        while(pl!=null){
            lenA++;
            pl = pl.next;
        }
        while(ps!=null){
            lenB++;
            ps = ps.next;
        }
        pl = headA;
        ps = headB;
        int len = lenA-lenB;
        if(len<0){
            pl = headB;
            ps = headA;
            len = lenB-lenA;
        }
        for (int i = 0; i <len ; i++) {
            pl = pl.next;
        }
        while(pl!=ps){
            pl = pl.next;
            ps = ps.next;
        }
        if( pl!=null){
            return pl;
        }
        return null;
    }
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(77);
        myLinkedList.addFirst(56);
        myLinkedList.addFirst(35);
        myLinkedList.addFirst(26);
        myLinkedList.addFirst(24);
        myLinkedList.addFirst(12);
        myLinkedList.display();
        System.out.println("========");
        /*System.out.println(myLinkedList.FindKthToTail(4).data);*/
        /*Node ret = myLinkedList.partition(20);
        myLinkedList.display2(ret);*/
        MyLinkedList myLinkedList2 = new MyLinkedList();
        myLinkedList2.addFirst(67);
        myLinkedList2.addFirst(45);
        myLinkedList2.addFirst(17);
        myLinkedList2.addFirst(13);
        myLinkedList2.addFirst(12);
        myLinkedList2.addFirst(11);
        myLinkedList2.display();
        /*reateCut(myLinkedList.head,myLinkedList2.head);
        System.out.println("========");
        Node ret = getIntersectionNode(myLinkedList.head,myLinkedList2.head);
        System.out.println(ret.data);*/
        Node ret = mergeTwoLists(myLinkedList.head,myLinkedList2.head);
        myLinkedList.display2(ret);
    }

}
