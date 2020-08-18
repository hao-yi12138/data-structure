/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-08-18 15:59
 **/
public class TestDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root =  binaryTree.buildTree();
        System.out.println("是不是完全二叉树：");
        System.out.println(binaryTree.isCompleteTree(root));
        binaryTree.preOrderTraversal(root);
        System.out.println();
        System.out.println("====非递归前序======");
        binaryTree.preOrderTraversalNor(root);
        System.out.println();
        binaryTree.inOrderTraversal(root);
        System.out.println();
        System.out.println("====非递归中序======");
        binaryTree.inOrderTraversalNor(root);
        System.out.println();
        binaryTree.postOrderTraversal(root);
        System.out.println();
        System.out.println("====非递归后序======");
        binaryTree.postOrderTraversalNor(root);
    }
}
