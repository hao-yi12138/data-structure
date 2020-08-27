/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-08-27 17:03
 **/
/**
 * <T>：T占位符表示当前类是泛型类
 * 放数据的时候可以自动进行类型检查
 * 取数据的时候可以自动进行类型转换
 * 泛型是在编译时期的一种机制--》擦除机制,编译的时候按照Object编译,不是替换Object
 * T extends Comparable<T>
 *     T一定是实现了Comparable接口
 */
class MyStack<T>{
    public T[]elem;
    public int top;

    public MyStack() {
        this.elem = (T[])new Object[10];
    }
    public void push(T val){
        this.elem[this.top] = val;
        this.top++;
    }
    public T peek(){
        return this.elem[this.top-1];
    }
}
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
//类型推导：根据实参的类型推导出形参的类型
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
public class TestDemo {
    public static void main(String[] args) {
        Integer[]array = {1,2,3,4,5};
        System.out.println(Generic2.maxNum(array));
        String []strings = {"ac","vcbn","sdf"};
    }
}
