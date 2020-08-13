/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-08-13 14:48
 **/
public class TestDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
         Node root =  binaryTree.buildTree();
         binaryTree.preOrderTraversal(root);
         System.out.println();
         binaryTree.inOrderTraversal(root);
         System.out.println();
         binaryTree.postOrderTraversal(root);
         System.out.println();
         binaryTree.getSize1(root);
        System.out.println("节点的个数：" + binaryTree.size);
        System.out.println("节点的个数："+binaryTree.getSize2(root));
          binaryTree.getLeafSize1(root);
        System.out.println("叶子节点的个数：" + binaryTree.leafSize);
        System.out.println("叶子节点的个数：" +binaryTree.getLeafSize2(root));
        System.out.println("===K层节点的个数===");
        System.out.println(binaryTree.getKLevelSize(root,3));
        System.out.println("===树的高度===");
        System.out.println(binaryTree.getHeight(root));
        Node ret = binaryTree.find(root,'E');
        System.out.println(ret.val);
    }
}
