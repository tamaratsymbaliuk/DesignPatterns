package behavioral.Iterator;

// TreeNode class representing a node in a binary tree
public class TreeNode<T> {
    TreeNode<T> left;
    TreeNode<T> right;
    T value;

    // Constructor to initialize TreeNode with a value
    public TreeNode(T value) {
        this.value = value;
    }
}
