/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-08-10 20:49
 **/

import com.sun.org.apache.xpath.internal.objects.XObject;

/**
 * <T> 只是一个占位符，表示当前类是泛型类
 * 泛型的意义：1可以自动进行类型的检查 2可以自动进行类型的转换
 * 不能new泛型类型的数组 T t = new T[10]
 * 简单类型不能作为泛型的参数
 * 泛型类型的参数不参与类型的组成
 * 泛型到底是怎么编译的？
 *泛型只是编译时的一种机制（擦除机制），在运行时不存在泛型这种说法了，所有处理均在编译阶段已经处理
 * 擦除机制：在编译的时候，泛型被擦除为object
 * @param <T>
 */
public class MyArrayList <T>{
    public T []elem;
    public int usedSize;
    public MyArrayList(){
        this.elem =(T[]) new Object[10];
        this.usedSize = 0;
    }
    public void  add(T val){
        this.elem[this.usedSize] = val;
        this.usedSize++;
    }
    public T getVal(int pos){
        return this.elem[pos];
    }
}
