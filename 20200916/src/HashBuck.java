import java.util.Objects;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-09-16 14:18
 **/
class Person{
    public int id;
    public Person(int id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
public class HashBuck<K,V> {
    static class Node<K,V>{
       public K key;
       public V val;
       public Node<K,V> next;
       public Node(K key,V val){
           this.key = key;
           this.val = val;
       }
    }
    public Node<K,V> []array =(Node<K,V>[]) new Node[10];
    public int usedSize;
    public void put(K key,V val){
        int hash = key.hashCode();
        int index = hash%array.length;
        for (Node<K,V> cur = array[index];cur!=null;cur = cur.next) {
                 if(cur.key.equals(key)){
                     cur.val = val;
                     return;
                 }
        }
        Node<K,V> node = new Node<>(key,val);
          node.next = array[index];
          array[index]= node;
          this.usedSize++;
        if(loadFactor() > 0.75){
            resize();
        }
    }
    public double loadFactor(){
        return this.usedSize*1.0/array.length;
    }
    public void resize(){
        Node<K,V> []newArray =(Node<K,V>[]) new Node[2*array.length];
        for (int i = 0; i <array.length ; i++) {
            Node<K,V> cur = array[i];
             while (cur!=null){
                 Node<K,V> curNext = cur.next;
                 int hash = cur.key.hashCode();
                 int index = hash%newArray.length;
                  cur.next = newArray[index];
                  newArray[index] = cur;
                  cur = curNext;
             }
        }
        array = newArray;
    }
    public V get(K key){
        int hash = key.hashCode();
        int index = hash%array.length;
        for (Node<K,V> cur = array[index];cur!=null;cur = cur.next) {
             if(cur.key.equals(key)){
                 return cur.val;
             }
        }
        return null;
    }
    public static void main1(String[] args) {
        Person person1 = new Person(11);
        Person person2 = new Person(11);
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
        System.out.println(person1.equals(person2));
    }
}
