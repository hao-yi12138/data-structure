/**
 * @program: IntelliJ IDEA
 * @description:练习代码
 * @author: HAOYI
 * @date:2020-07-30 14:31
 **/
public class TestDemo {
    public static void main(String[] args) {
        MyArrayList myArrayList1 = new MyArrayList();
        for (int i = 0; i <10 ; i++) {
            myArrayList1.add(i,i);
        }
        myArrayList1.display();
        /*myArrayList1.clear();
        myArrayList1.display();*/
     /*   myArrayList1.add(10,12);
         myArrayList1.display();
        System.out.println(myArrayList1.getPos(5));*/
        /*  System.out.println("==========");
        System.out.println(myArrayList1.contains(5));
        System.out.println(myArrayList1.search(7));*/
       /* myArrayList1.remove(7);
        myArrayList1.display();*/
   }
}

