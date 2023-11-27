class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private TreeNode insertRec(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public int findLongestPath() {
        return findLongestPathRec(root);
    }

    private int findLongestPathRec(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftPath = findLongestPathRec(root.left);
        int rightPath = findLongestPathRec(root.right);

        return Math.max(leftPath, rightPath) + 1;
    }

    public int findMinValue() {
        return findMinValueRec(root);
    }

    private int findMinValueRec(TreeNode root) {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        if (root.left == null) {
            return root.data;
        }

        return findMinValueRec(root.left);
    }

    public void invertTree() {
        root = invertTreeRec(root);
    }

    private TreeNode invertTreeRec(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTreeRec(root.left);
        TreeNode right = invertTreeRec(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(TreeNode root, int data) {
        if (root == null) {
            return false;
        }

        if (root.data == data) {
            return true;
        }

        if (data < root.data) {
            return searchRec(root.left, data);
        } else {
            return searchRec(root.right, data);
        }
    }


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        
        // Insert values
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        
        // Find the number of nodes in the longest path
        int longestPath = bst.findLongestPath();
        System.out.println("Number of nodes in the longest path: " + longestPath);
        
        // Find the minimum value in the tree
        int minValue = bst.findMinValue();
        System.out.println("Minimum value in the tree: " + minValue);
        
        // Invert the tree
        bst.invertTree();
        
        // Search for a value
        boolean found = bst.search(50);
        System.out.println("Value 40 found in the tree: " + found);
    }
}
