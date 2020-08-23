import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-08-23 15:23
 **/
class MyComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}
public class TopK {
    public static Integer[] topK(int []array,int k){
        MyComparator myComparator = new MyComparator();
        //PriorityQueue<Integer> maxHeap = new PriorityQueue<>(myComparator);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i <array.length ; i++) {
            if(maxHeap.size()<k){
                maxHeap.offer(array[i]);
            }else {
                Integer val = maxHeap.peek();
                if(val !=null &&val>array[i]){
                    maxHeap.poll();
                    maxHeap.offer(array[i]);
                }
            }
        }
         Integer[]ret = new Integer[k];
        for (int i = 0; i < k; i++) {
             int v = maxHeap.poll();
             ret[i] = v;
        }
        return ret;
    }
    public static void main(String[] args) {
      int []array = {12,21,5,8,3,25,43,9};
      Integer[]ret = topK(array,4);
        System.out.println(Arrays.toString(ret));
    }
}
