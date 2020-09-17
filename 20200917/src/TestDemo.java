import java.util.ArrayList;
import java.util.HashMap;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-09-17 14:16
 **/
@FunctionalInterface
interface NoParameterNoReturn {
    void test();
}
public class TestDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "hello");
        map.put(2, "bit");
        map.put(3, "hello");
        map.put(4, "lambda");
        map.forEach((k,v)-> System.out.println(k + "=" + v));
    }
    public static void main2(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("bit");
        list.add("hello");
        list.add("lambda");
//调用带有2个参数的方法，且返回长度的差值
        list.sort((str1,str2)-> str1.length()-str2.length());
        System.out.println(list);
    }
    public static void main1(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("bit");
        list.add("hello");
        list.add("lambda");
//表示调用一个，不带有参数的方法，其执行花括号内的语句，为原来的函数体内容。
        list.forEach(s -> {
            System.out.println(s);
        });
    }
}
