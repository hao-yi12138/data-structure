import java.util.Arrays;

/**
 * @program: IntelliJ IDEA
 * @description:练习
 * @author: HAOYI
 * @date:2020-07-30 14:47
 **/
public class MyArrayList {
    public int []elem;//数组
    public int usdSize;//有效的数据个数
    public static final int capacity = 10;//初始容量
    public MyArrayList() {
        this.elem = new int[capacity];
        this.usdSize = 0;
    }
    private void checkPos(int pos){
        if(pos<0 || pos>this.usdSize){
          throw new RuntimeException("pos位置不合法");
        }
    }
    // 清空顺序表
    public void clear() {
        this.usdSize = 0;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
       int index = search(toRemove);
       if(index == -1){
           System.out.println("没有删除的数字");
           return;
       }
        for (int i =index; i <this.usdSize-1 ; i++) {
            this.elem[i]=this.elem[i+1];
        }
        this.usdSize--;
    }
    // 获取 pos 位置的元素
    private boolean isEmpty(){
        return this.usdSize == 0;
    }
    public int getPos(int pos){
        if(isEmpty()){
            throw new RuntimeException("顺序表为空");//手动抛出一个异常
        }
        if(pos<0 || pos>this.usdSize){
            throw new RuntimeException("pos位置不合法");
        }
       return this.elem[pos];
    }
        // 获取顺序表长度
        public int size() {
            return this.usdSize;
        }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i <this.usdSize ; i++) {
            if(this.elem[i] == toFind){
                return true;
            }
        }
       return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i <this.usdSize ; i++) {
            if(this.elem[i] == toFind){
                return i;
            }
        }
        return -1;
    }
    //打印顺序表
    public void display(){
        for (int i = 0; i < this.usdSize ; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
    private boolean isFull(){
        /*if(this.usdSize == this.elem.length){
            return true;
        }
        return false;*/
        return this.usdSize == this.elem.length;
    }
    //在pos位置新增元素
    public void add(int pos,int data){
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        this.checkPos(pos);
        for (int i = this.usdSize-1; i>=pos; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usdSize++;
    }
}
