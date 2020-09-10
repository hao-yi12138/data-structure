import java.util.ArrayList;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-09-10 09:39
 **/
class Generic<T extends Comparable<T>>{
    public T maxNum(T[]elem){
        T max = elem[0];
        for (int i = 1; i <elem.length; i++) {
            if(elem[i].compareTo(max)>0){
                max = elem[i];
            }
        }
        return max;
    }
}
//类型推导：根据实参的类型推导出实参的类型
class Generic2{
    public static <T extends Comparable<T>> T maxNum(T[]elem){
        T max = elem[0];
        for (int i = 1; i <elem.length; i++) {
            if(elem[i].compareTo(max)>0){
                max = elem[i];
            }
        }
        return max;
    }
}

/**
 * 通配符一般用于读取
 * 既有上界(extends)，也有下界(super)
 */
class GenericList{
    public static <T> void printList(ArrayList<T> list){
        for (T val:list) {
            System.out.println(val+" ");
        }
        System.out.println();
    }
    public static void printList2(ArrayList<?> list){
        for (Object val:list) {
            System.out.println(val+" ");
        }
        System.out.println();
    }
}
public class TestDemo {
    public static void main(String[] args) {
       /* Integer []array1 = {1,5,34,6,8,9};
        System.out.println(Generic2.maxNum(array1));*/
        String []array2 = {"ads","hello","e"};
        System.out.println(Generic2.maxNum(array2));
    }
}
