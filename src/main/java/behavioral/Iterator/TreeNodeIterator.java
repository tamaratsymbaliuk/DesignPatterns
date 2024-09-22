package behavioral.Iterator;

import java.util.ArrayList;
import java.util.Stack;

// TreeNodeIterator class implementing the Iterator interface
public class TreeNodeIterator<T> implements Iterator<T> {
    private final Stack<TreeNode<T>> stack = new Stack<>();

    // Constructor initializing the iterator with the root of the tree
    public TreeNodeIterator(TreeNode<T> root) {
        // Use leftmost traversal to add initial nodes to the stack
        pushLeftmostNodes(root);
    }

    // Helper method to push the leftmost nodes onto the stack
    private void pushLeftmostNodes(TreeNode<T> node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    // Check if there are more nodes to visit
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Return the next node value in the tree traversal
    @Override
    public T next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements");
        }

        // Pop the node from the stack
        TreeNode<T> node = stack.pop();
        T value = node.value;

        // If the node has a right child, push the leftmost nodes of the right subtree
        if (node.right != null) {
            pushLeftmostNodes(node.right);
        }

        return value;
    }
}