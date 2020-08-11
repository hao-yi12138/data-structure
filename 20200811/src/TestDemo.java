

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @program: IntelliJ IDEA
 * @description:List
 * @author: HAOYI
 * @date:2020-08-11 09:55
 **/
class Student{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    private String name;
    private String clas;
    private double grade;
    public Student(String name,String clas,double grade){
        this.name = name;
        this.clas = clas;
        this.grade = grade;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", clas='" + clas + '\'' +
                ", grade=" + grade +
                '}';
    }

}
public class TestDemo {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if(numRows==0){
            return ret;
        }
        List<Integer> oneRows = new ArrayList<>();
        ret.add(oneRows);
        ret.get(0).add(1);
        for (int i = 1; i <numRows ; i++) {
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);
            List<Integer> prevRow = ret.get(i-1);//上一行
            for (int j = 1; j < i ; j++) {
                  int x= prevRow.get(j);
                  int y = prevRow.get(j-1);
                  curRow.add(x+y);
            }
            curRow.add(1);
            ret.add(curRow);
        }
        return ret;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();
        List<List<Integer>> ret = generate(numRows);
        System.out.println(ret);
    }
    public static List<Character> func(String str,String str1){
        List<Character> list = new ArrayList<>();
        for (int i = 0; i <str.length() ; i++) {
            char ch = str.charAt(i);
            if(!str1.contains(ch+"")){
                list.add(ch);
            }
        }
      return list;
    }
    public static void main3(String[] args) {
        String str = "welcome to bit";
        String str2 = "come";
        List<Character> list = func(str,str2);
        for (char ch:list) {
            System.out.print(ch);
        }
        System.out.println();
    }
    public static void main2(String[] args) {
        List<Integer> list = new ArrayList<>() ;
        list.add(1);
        list.add(8);
        list.add(4);
        Collections.sort(list);
        System.out.println(list);
    }
    public static void main1(String[] args) {
        Student student1 = new Student("yi","一",66.7);
        Student student2 = new Student("er","二",60.3);
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        System.out.println(list);
    }
}
