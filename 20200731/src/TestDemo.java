/**
 * @program: IntelliJ IDEA
 * @description:单链表练习
 * @author: HAOYI
 * @date:2020-07-31 08:50
 **/
public class TestDemo {
    public static void main(String[] args) {
    MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(4);
        myLinkedList.display();
        System.out.println("========");
        myLinkedList.addLast(8);
        myLinkedList.display();
        System.out.println("========");
        System.out.println(myLinkedList.size());
        System.out.println(myLinkedList.contains(6));
        System.out.println("========");
        myLinkedList.addIndex(1,66);
        myLinkedList.addIndex(3,66);
        myLinkedList.addIndex(5,66);
        myLinkedList.display();
        System.out.println("========");
        /*myLinkedList.remove(8);
        myLinkedList.display();*/
        myLinkedList.removeAllKey(66);
        myLinkedList.display();

    }
}
