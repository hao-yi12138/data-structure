import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-08-23 10:49
 **/
class Card {
    public int rank; // 数值
    public String suit; // 花色
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj==null||!(obj instanceof Card)) {
              return false;
        }
        Card tmp = (Card)obj;
        if(this.rank == tmp.rank&&this.suit.equals(tmp.suit)){
            return true;
        }
        return false;
    }
}
class Student implements Comparable<Student>{
    public String name;
    public int age;
    public int score;
    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return this.score-o.score;
    }
}
class Person {
    public String name;
    public int age;
    public int score;
    public Person(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
class OuterClass{
    public int data1 = 1;
    public int data2 = 2;
    public void func(){
        System.out.println("func");
    }
    class InnerClass{
        public int data1 = 4;
        public int data3 = 2;
        public void func(){
            System.out.println(data1);
            System.out.println(OuterClass.this.data1);
            System.out.println(data2);
        }
    }
}

public class TestDemo {
    public static void main(String[] args) {
       OuterClass outerClass = new OuterClass();
       OuterClass.InnerClass innerClass = outerClass.new InnerClass();
    }
    public static void main5(String[] args) {
        AgeComparator ageComparator = new AgeComparator();
        PriorityQueue<Person>  priorityQueue = new PriorityQueue<>(ageComparator);
        priorityQueue.offer(new Person("yi",15,77));
        priorityQueue.offer(new Person("er",17,67));
        System.out.println(priorityQueue);
    }
    //比较器
    public static void main4(String[] args) {
        Person person1 = new Person("yi",15,77);
        Person person2 = new Person("er",17,67);
        Person person3 = new Person("san",20,97);
        Person[]people = new Person[3];
        people[0] = person1;
        people[1] = person2;
        people[2] = person3;
        AgeComparator ageComparator = new AgeComparator();
        Arrays.sort(people,ageComparator);
        System.out.println(Arrays.toString(people));
    }
    public static void main3(String[] args) {
          Person person1 = new Person("yi",15,77);
          Person person2 = new Person("er",17,67);
          AgeComparator ageComparator = new AgeComparator();
        System.out.println(ageComparator.compare(person1,person2));
    }
    public static void main2(String[] args) {
        Student student1 = new Student("yi",15,77);
        Student student2 = new Student("er",17,67);
             if(student1.compareTo(student2)>0){
                 System.out.println("student1>student2");
             }
    }
    public static void main1(String[] args) {
        Card card1 = new Card(5,"♥");
        Card card2= new Card(5,"♥");
        System.out.println(card1 == card2);
        System.out.println(card1.equals(card2));
    }
}
