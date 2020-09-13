import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-09-13 10:28
 **/
public class TestDemo {
    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        int []array = {7,2,9,18,56,15,3};
        for (int s:array) {
            bsTree.insert(s);
        }
        bsTree.preOrder(bsTree.root);
        System.out.println();
        bsTree.inOrder(bsTree.root);
        System.out.println();
        System.out.println(bsTree.search(18).val);
        System.out.println("==========删除============");
        bsTree.remove(18);
        bsTree.preOrder(bsTree.root);
        System.out.println();
        bsTree.inOrder(bsTree.root);
        System.out.println();
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expected = scanner.nextLine();
        String actual = scanner.nextLine();
        HashSet<Character> hashSet = new HashSet<>();
        HashSet<Character> hashSet2 = new HashSet<>();
        for (char a:actual.toUpperCase().toCharArray()) {
            hashSet.add(a);
        }
        for (char e:expected.toUpperCase().toCharArray()) {
            if(!hashSet.contains(e)&&!hashSet2.contains(e)){
                System.out.print(e+" ");
                hashSet2.add(e);
            }
        }
    }
}
