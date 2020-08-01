/**
 * @program: IntelliJ IDEA
 * @description:链表练习
 * @author: HAOYI
 * @date:2020-08-01 08:14
 **/
public class TestDemo {
     public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
         myLinkedList.addFirst(1);
         myLinkedList.addFirst(3);
         myLinkedList.addFirst(5);
         myLinkedList.addFirst(7);
         myLinkedList.display();
         System.out.println("========");
         myLinkedList.addLast(12);
         myLinkedList.display();
         System.out.println("========");
         /*Node ret = myLinkedList.reverseList();
         myLinkedList.display2(ret);
         System.out.println("========");*/
         System.out.println(myLinkedList.middleNode().data);

     }
}
