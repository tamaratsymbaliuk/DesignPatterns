package behavioral.Iterator;

public class Main {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(4);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(5);
        root.left.left = new TreeNode<>(1);
        root.left.right = new TreeNode<>(3);

        // Traverse tree using TreeNodeIterator
        Iterator<Integer> treeNodeIterator = new TreeNodeIterator<>(root);
        while (treeNodeIterator.hasNext()) {
            System.out.println(treeNodeIterator.next() + " ");
        }

    }
}
