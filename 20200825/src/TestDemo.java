/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-08-25 15:45
 **/
/**
 * <T>：T占位符表示当前类是泛型类
 * 放数据的时候可以自动进行类型检查
 * 取数据的时候可以自动进行类型转换
 * 泛型是在编译时期的一种机制--》擦除机制,编译的时候按照Object编译,不是替换Object
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
    public T func(T[]elem){
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

}
