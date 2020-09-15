import java.util.Arrays;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-09-15 10:15
 **/
class HashBuck{
    static class Node{
        public int key;
        public int val;
        public Node next;
        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    public Node[]array = new Node[10];
    public int usedSize;
    public void put(int key,int val){
        int index = key % array.length;
        for (Node cur = array[index]; cur!=null ; cur = cur.next) {
            if(cur.key == key){
                cur.val = val;
                return;
            }
        }
        Node node = new Node(key,val);
        node.next = array[index];
        array[index] = node;
        this.usedSize++;
        if(loadFactor() > 0.75){
            resize();
        }
    }
    public double loadFactor(){
         return this.usedSize*1.0/array.length;
    }
    private void resize(){
        Node []newArray = new Node[2*array.length];
        for (int i = 0; i < array.length ; i++) {
            Node cur = array[i];
            while (cur!=null){
                Node curNext = cur.next;
                int index1 = cur.key%newArray.length;
                cur.next = newArray[index1];
                newArray[index1] = cur;
                cur = curNext;
            }
        }
        array = newArray;
    }
    public int get(int key){
        int index2 = key%array.length;
        Node cur = array[index2];
        while (cur!=null){
            if(cur.key == key){
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }
}

public class TestDemo {
    public static void main(String[] args) {
          HashBuck hashBuck = new HashBuck();

    }
}
