/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-08-17 09:36
 **/
public class TestDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root =  binaryTree.buildTree();
        binaryTree.preOrderTraversal(root);
        System.out.println();
    }
}
