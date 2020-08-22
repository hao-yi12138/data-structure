import java.util.*;
/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-08-22 10:14
 **/

public class TestSort {
    //非递归
    public static void mergeSort2 ( int[] array){
        for (int gap = 1; gap <array.length ; gap*=2) {
            mergeNor(array,gap);
        }
    }
    public static void mergeNor(int[]array,int gap) {
        int[] ret = new int[array.length];
        int k = 0;
        int s1 = 0;
        int e1 = s1 + gap - 1;
        int s2 = e1 + 1;
        int e2 = s2 + gap - 1 < array.length ? s2 + gap - 1 : array.length - 1;
        while (s2 < array.length) {
            while (s1 <= e1 && s2 <= e2) {
                if (array[s1] <= array[s2]) {
                    ret[k++] = array[s1++];
                } else {
                    ret[k++] = array[s2++];
                }
            }
            while (s1 <= e1) {
                ret[k++] = array[s1++];
            }
            while (s2 <= e2) {
                ret[k++] = array[s2++];
            }
            s1 = e2+1;
            e1 = s1+gap-1;
            s2 = e1+1;
            e2 = s2 + gap - 1 < array.length ? s2 + gap - 1 : array.length - 1;
        }
        while (s1<array.length){
            ret[k++] = array[s1++];
        }
        for (int i = 0; i <ret.length ; i++) {
            array[i] = ret[i];
        }
    }
    /**
     * 归并排序
     * 时间复杂度：O(n*logn)
     * 空间复杂度：O(n)
     * 稳定性：稳定
     * @param array
     * @param low
     * @param mid
     * @param high
     */
    //递归
    public static void merge(int[] array, int low, int mid, int high) {
             int s1 = low;
             int s2 = mid+1;
             int len = high-low+1;
             int[]ret = new int[len];
             int i = 0;
             while(s1<=mid&&s2<=high){
                 if(array[s1]<=array[s2]){
                     ret[i++] = array[s1++];
                 }else {
                     ret[i++] = array[s2++];
                 }
             }
             while (s1<=mid){
                 ret[i++] = array[s1++];
             }
            while (s2<=high){
                ret[i++] = array[s2++];
           }
        for (int j = 0; j < ret.length; j++) {
              array[j+low] = ret[j];
        }
    }

    public static void mergeSortInternal(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
            int mid = (low + high) >>> 1;
            mergeSortInternal(array, low, mid);
            mergeSortInternal(array, mid + 1, high);
            merge(array, low, mid, high);
    }
        public static void mergeSort ( int[] array){
        mergeSortInternal(array, 0, array.length - 1);
        }
        /**
         * 非递归快速排序
         * @param array
         */
        public static void quickSort2 ( int[] array){
            Stack<Integer> stack = new Stack<>();
            int left = 0;
            int right = array.length - 1;
            int par = partition(array, left, right);
            if (par > left + 1) {
                stack.push(left);
                stack.push(par - 1);
            }
            if (par < right - 1) {
                stack.push(par + 1);
                stack.push(right);
            }
            while (!stack.empty()) {
                right = stack.pop();
                left = stack.pop();
                par = partition(array, left, right);
                if (par > left + 1) {
                    stack.push(left);
                    stack.push(par - 1);
                }
                if (par < right - 1) {
                    stack.push(par + 1);
                    stack.push(right);
                }
            }
        }
        /**
         * 递归快速排序
         * 时间复杂度：O(n*logn)  最坏情况：1 2 3 4 5 6 7 8 9/9 8 7 6 5 4 3 2 1  O(n^2)
         * 空间复杂度：O(logn)           O(n)
         * 稳定性：不稳定
         * @param array
         * @param left
         * @param right
         * @return
         */
        public static int partition ( int[] array, int left, int right){
            int tmp = array[left];
            while (left < right) {
                while (left < right && array[right] >= tmp) {
                    right--;
                }
                array[left] = array[right];
                while (left < right && array[left] <= tmp) {
                    left++;
                }
                array[right] = array[left];
            }
            array[left] = tmp;
            return left;
        }
        public static void quick ( int[] array, int left, int right){
            if (left >= right) {
                return;
            }
            //当待排序序列的数据个数小于等于一定值时可采用直接插入排序
            if (right - left + 1 <= 100) {
                insert_sort(array, left, right);
                return;
            }
            //三数取中
            three_num_mid(array, left, right);
            int par = partition(array, left, right);
            quick(array, left, par - 1);
            quick(array, par + 1, right);
        }
        public static void insert_sort ( int[] array, int start, int end){
            for (int i = start + 1; i <= end; i++) {
                int tmp = array[i];
                int j;
                for (j = i - 1; j >= start; j--) {
                    if (array[j] > tmp) {
                        array[j + 1] = array[j];
                    } else {
                        break;
                    }
                }
                array[j] = tmp;
            }
        }
        public static void swap ( int[] array, int i, int j){
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
        public static void three_num_mid ( int[] array, int left, int right){
            int mid = (left + right) / 2;
            if (array[left] < array[mid]) {
                swap(array, left, mid);
            }
            if (array[left] > array[right]) {
                swap(array, left, right);
            }
        }
        public static void quickSort ( int[] array){
            quick(array, 0, array.length - 1);
        }
    /*public static int partition(int[]array,int left,int right){
               int tmp = array[left];
               while (left<right){
                   while(left<right&&array[right]>=tmp){
                       right--;
                   }
                   array[left] = array[right];
                   while(left<right&&array[left]<=tmp){
                       left++;
                   }
                  array[right] =array[left];
               }
               array[left] = tmp;
               return left;
    }
    public static void quick(int []array,int left,int right) {
        if(left>=right){
            return;
        }
        int par =partition(array,left,right);
        quick(array,left,par-1);
        quick(array,par+1,right);
    }
    public static void quickSort(int []array){
        quick(array,0,array.length-1);
    }*/
        public static void main2 (String[]args){
            int[] array = new int[10_0000];
            Random random = new Random();
            for (int i = 0; i < array.length; i++) {
                array[i] = i;
                //array[i] = random.nextInt(100000);
            }
            long start = System.currentTimeMillis();
            quickSort(array);
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }
        public static void main (String[]args){
            int[] array = {6, 4, 2, 3, 8, 9, 1, 7, 5};
            System.out.println(Arrays.toString(array));
            mergeSort2(array);
            System.out.println(Arrays.toString(array));
        }
    }
