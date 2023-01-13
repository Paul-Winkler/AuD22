package lists.trees;

public class TreeNode {
    public TreeNode parent = null;
    public TreeNode left = null;
    public TreeNode right = null;
    public int balance = 0;

    public int key;

    public TreeNode(int key, TreeNode parent) {
        this(key, parent, null, null);
    }

    public TreeNode(int key, TreeNode parent, TreeNode left, TreeNode right) {
        this.key = key;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public boolean hasLeft() {
        return this.left != null;
    }

    public boolean hasRight() {
        return this.right != null;
    }

    public boolean hasParent() {
        return this.parent != null;
    }

    public boolean isLeaf() {
        return !this.hasLeft() && !this.hasRight();
    }
}
