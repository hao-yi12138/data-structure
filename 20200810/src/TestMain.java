import java.util.*;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-08-10 14:28
 **/
public class TestMain {
    public static void main(String[] args) {
        List<String > list = new ArrayList<>();
        list.add("a");
        list.add(0,"b");
        List<String > list2 = new ArrayList<>();
        list2.add("ab");
        list2.add("cd");
        list.addAll(list2);
        System.out.println(list);
        String  ret = list.remove(0);
        System.out.println(ret);
        list.remove("a");
        System.out.println(list);
        System.out.println("====get====");
        String str = list.get(0);
        System.out.println(str);
        System.out.println("====set====");
          list.set(0,"haha");//更新
         System.out.println(list);
        System.out.println(list.contains("haha"));
        System.out.println(list.indexOf("haha"));
        //从后往前找第一个出现的haha
        System.out.println(list.lastIndexOf("haha"));
        System.out.println("====subList====");
        List<String > retlist = list.subList(0,2);
        System.out.println(retlist);
    }
    public static void main6(String[] args) {
      MyArrayList<Integer> myArrayList = new MyArrayList<>();
      myArrayList.add(2);
      MyArrayList<String > myArrayList2 = new MyArrayList<>();
      myArrayList2.add("abc");
    }
    public static void main5(String[] args) {
        Integer a1 = 127;
        Integer b1 = 127;
        System.out.println(a1==b1);//true
        Integer a2 = 128;
        Integer b2 = 128;
        System.out.println(a2==b2);//false
    }
    public static void main4(String[] args) {
        Integer a = 10;//自动装箱
        int b = a;//自动拆箱
    }
    public static void main3(String[] args) {
        int i = 10;
     // 装箱操作，新建一个 Integer 类型对象，将 i 的值放入对象的某个属性中
        Integer ii = Integer.valueOf(i);
        Integer ij = new Integer(i);
    // 拆箱操作，将 Integer 对象中的值取出，放到一个基本数据类型中
        int j = ii.intValue();
    }
    public static void main2(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("et","ufo");
        map.put("西游记","吴承恩");
        map.put("三国演义","罗贯中");
        System.out.println(map);
        /*String s = map.get("三国演义");
        System.out.println(s);*/
        String s = map.getOrDefault("三国演义1","吕布");
        System.out.println(s);
        //System.out.println(map.containsKey("三国演义"));
        Set<Map.Entry<String ,String >>set = map.entrySet();
        for (Map.Entry<String ,String> entry:set) {
            System.out.println(entry.getKey()+"=>"+entry.getValue());
        }
    }
    public static void main1(String[] args) {
       Collection<String> collation = new ArrayList<>();
       collation.add("abc");
       collation.add("efg");
        collation.add("qwe");
        collation.add("asd");
        collation.add("zxc");
        System.out.println(collation);
        for (String s:collation) {
            System.out.println(s);
        }
        /* collation.clear();
        System.out.println(collation);*/
        //System.out.println(collation.isEmpty());
       /* collation.remove("efg");
        System.out.println(collation);*/
        //System.out.println(collation.size());
        /*Object[]objects = collation.toArray();
        System.out.println(Arrays.toString(objects));*/
    }
}
