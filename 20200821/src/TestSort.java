import java.util.Arrays;
import java.util.Random;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-08-21 11:41
 **/
public class TestSort {
    /**
     * 冒泡排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * @param array
     */
    public static void bubbleSort(int []array){
        //boolean flg = false;
        for (int i = 0; i <array.length-1 ; i++) {
            boolean flg = false;
            for (int j = 0; j <array.length-1-i ; j++) {
                if(array[j]>array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;
                }
            }
            if(flg == false){
                return;
            }
        }
    }
    /**
     * 堆排
     * 时间复杂度：O(n*logn)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @param array
     * @param root
     * @param len
     */
    public static void adjustDown(int []array,int root,int len){
          int parent = root;
          int child = 2*parent+1;
          while(child<len){
              if(child+1<len&&array[child]<array[child+1]){
                  child++;
              }
              if(array[child]>array[parent]){
                  int tmp = array[child];
                  array[child] = array[parent];
                  array[parent] = tmp;
                  parent =child;
                  child = 2*parent+1;
              }else {
                  break;
              }
          }
    }
    public static void createHeap(int []array){
        for (int i = (array.length-1-1)/2; i>=0 ; i--) {
            adjustDown(array,i,array.length);
        }
    }
    public static void heapSort(int []array){
                  createHeap(array);
                  int end = array.length-1;
                  while(end>0){
                      int tmp = array[0];
                      array[0] = array[end];
                      array[0] = tmp;
                      adjustDown(array,0,end);
                      end--;
                  }
    }
    /**
     * 选择排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @param array
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length ; i++) {
            for (int j = i+1; j < array.length ; j++) {
                if(array[i]>array[j]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] =tmp;
                }
            }
        }
    }
    public static void shell(int[]array,int gap){
        for (int i = gap; i < array.length ; i++) {
            int j ;
            int tmp = array[i];
            for (j=i-gap; j>=0 ; j-=gap) {
                if(array[j]>tmp){
                    array[j+gap] = array[j];
                }else {
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }
    public static void shellSort(int[]array){
        int []drr={5,3,1};
        for (int i = 0; i <drr.length ; i++) {
            shell(array,drr[i]);
        }
    }
    /**
     * 直接插入排序：
     * 时间复杂度 最坏情况：O(n^2)   最好情况(有序的情况)：O(n)
     * 越有序越快
     * 空间复杂度：O(1)
     * 稳定性：
     * @param array
     */
    public static void insertSort(int[]array){
        for (int i = 1; i < array.length ; i++) {
            int tmp = array[i];
            int j = i-1;
            while(j>-1){
                if(array[j] > tmp){
                    array[j+1] = array[j];
                    j--;
                }else{
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    public static void main(String[] args) {
        int []array = {12,13,3,7,32,4,33,2,6,8,24,77,45};
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void main2(String[] args) {
        int []array = new int[10_0000];
        //Random random = new Random();
        for (int i = 0; i <array.length ; i++) {
            array[i]=i;
            //array[i] = random.nextInt(100000);
        }
        long start = System.currentTimeMillis();
        insertSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    public static void main1(String[] args) {
        int []array = {12,13,3,7,32,4};
        System.out.println(Arrays.toString(array));
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
