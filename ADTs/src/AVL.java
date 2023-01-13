import lists.trees.TreeNode;

public class AVL {
    private TreeNode top = null;

    public AVL() {}

    public void insert(int x) {
        // hanlde first element
        if (this.top == null) {
            this.top = new TreeNode(x, null);
            return;
        }

        TreeNode parent = search(x, true);

        if (x == parent.key) throw new IllegalArgumentException(); // key already exists

        TreeNode child = new TreeNode(x, parent);
        if (x < parent.key) {
            parent.left = child;

            // update balance
            if (parent.balance == +1) {
                parent.balance = 0;
            } else {
                parent.balance = -1;
                upIn(parent);
            }
        } else {
            parent.right = child;

            // update balance
            if (parent.balance == -1) {
                parent.balance = 0;
            } else {
                parent.balance = +1;
                upIn(parent);
            }
        }
    }

    private void upIn(TreeNode node) {
        if (node == node.parent.left) {
            if (node.parent.balance == +1) {
                node.parent.balance = 0;
                return;
            } else if (node.parent.balance == 0) {
                node.parent.balance = -1;
                upIn(node.parent);
            } else {
                if (node.balance == -1) {
                    rotateRight(node.parent);
                } else {
                    // node.balance == +1
                }
            }
        }

        while (node.parent != null) {
            if (node == node.parent.left) {
                if (node.parent.balance >= 0) {
                    node.parent.balance -= 1;
                } else {
                    // TODO: shift tree right
                }
            } else {
                if (node.parent.balance <= 0) {
                    node.parent.balance += 1;
                } else {
                    // TODO: shift tree left
                }
            }

            if (node.parent.balance == 0) break;
        }
    }

    private void rotateRight(TreeNode anchor) {
        TreeNode p = anchor.left;
        TreeNode B = p.right;

        // reposition p
        this.sync(anchor.parent, p, anchor == anchor.parent.left);
        // reposition B
        this.sync(anchor, B, true);
        // reposition anchor
        this.sync(p, anchor, false);
    }

    private void rotateLeft(TreeNode anchor) {
        TreeNode p = anchor.left;
        TreeNode B = p.right;

        // reposition p
        this.sync(anchor.parent, p, anchor == anchor.parent.left);
        // reposition B
        this.sync(anchor, B, true);
        // reposition anchor
        this.sync(p, anchor, false);
    }
    
    public TreeNode search(int x) {
        return this.search(x, false);
    }

    private TreeNode search(int x, boolean returnClosest) {
        if (this.isEmpty()) return null;

        TreeNode node = this.top;
        while (!node.isLeaf()) {
            if (node.key == x) return node;

            if (node.hasLeft() && node.hasRight()) {
                if (x < node.key) node = node.left;
                else node = node.right;
            } else if (node.hasLeft()) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        if (returnClosest) return node;

        if (node.key == x) return node;
        else return null;
    }



    public TreeNode remove(int x) {
        TreeNode target = search(x, false);

        if (target == null) throw new IllegalArgumentException();

        return remove(target);
    }

    private TreeNode remove(TreeNode target) {
        if (target.isLeaf()) {
            if (target == this.top) this.top = null;
            else if (target == target.parent.left) target.parent.left = null;
            else target.parent.right = null;
            
        } else if (target.hasLeft() && !target.hasRight()) {
            if (target == this.top) this.top = target.left;
            else this.sync(target.parent, target.left, target == target.parent.left);

        } else if (!target.hasLeft() && target.hasRight()) {
            if (target == this.top) this.top = target.right;
            else this.sync(target.parent, target.right, target == target.parent.left);

        } else {
            TreeNode successor = getSymmetricSuccessor(target);

            // remove successor
            remove(successor);

            // replace target with successor
            if (this.top == target) this.top = successor;
            else this.sync(target.parent, successor, target == target.parent.left);

            // replace children
            this.sync(successor, target.left, true);
            this.sync(successor, target.right, false);
        }

        return target;
    }

    private boolean isEmpty() {
        return this.top == null;
    }

    private TreeNode getSymmetricSuccessor(TreeNode node) {
        TreeNode target = node.right;

        while (target.hasLeft()) target = target.left;

        return target;
    }

    private void sync(TreeNode parent, TreeNode child, boolean isLeft) {
        if (isLeft) parent.left = child;
        else parent.right = child;
        
        child.parent = parent;
    }
}
