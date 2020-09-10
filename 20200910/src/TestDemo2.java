import java.util.*;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-09-10 15:41
 **/
public class TestDemo2 {
    //10万个数据，统计重复数字及出现次数
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i <10_0000 ; i++) {
            arrayList.add(random.nextInt(6000));
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer key:arrayList) {
           if(map.get(key)==null){
               map.put(key,1);
           }else{
               Integer val = map.get(key);
               map.put(key,val+1);
           }
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            System.out.println(entry.getKey()+"这个数字出现了"+entry.getValue()+"次");
        }
    }
    public static void main4(String[] args) {
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i <10_0000 ; i++) {
            arrayList.add(random.nextInt(6000));
        }
        Set<Integer> set = new HashSet<>();
        for (Integer val:arrayList) {
            set.add(val);//去重
        }
    }
    public static void main3(String[] args) {
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i <10_0000 ; i++) {
            arrayList.add(random.nextInt(6000));
        }
        Set<Integer> set = new HashSet<>();
        for (Integer val:arrayList) {
            if(set.contains(val)){
                System.out.println("找到了第一个重复的数据"+val);
            }else{
            set.add(val);
            }
        }
    }
    public static void main2(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(2);
        set.add(3);
        set.add(10);
        Iterator<Integer> it = set.iterator();//迭代器
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
    public static void main1(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"yi");
        map.put(2,"er");
        map.put(3,"san");
        for (Map.Entry<Integer,String> entry:map.entrySet()) {
            System.out.println(entry.getKey()+" "+ entry.getValue());
        }
    }
}
