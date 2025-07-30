import java.util.LinkedList;
import java.util.Queue;

/* 1) in binary tree, we are just going to pass values using method called insert. 
 *    but the insertion operation is going to be done by helper method (eg: insertRec)
 * 
 * 2) same goes for delete operation.
 * 
 */
class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }

}

class BST {
    Node root;

    public BST() {
        root = null;
    }

    public void insert(int val) { // not passing local variable so dont get confused.
        root = insertNode(root, val);
        return;
    }

    public Node insertNode(Node root, int val) { // helper method to insert node in binary tree
        if (root == null) {
            return new Node(val);
        }
        if (val < root.val) {
            root.left = insertNode(root.left, val);
        } else if (val > root.val) {
            root.right = insertNode(root.right, val);
        }
        return root;
    }

    /*
     * 1) this method is to assign a leaf node (with no children) to root node when
     * the node with two children is to be removed
     * 
     * 2) two conditions because what if the root==null. that means there will be no
     * left or right. (leads to null pointer exception)
     * 
     * 3) so i cant only check if minNode.left!=null but instead i should check both
     * node and its left.
     */
    public Node minValueNode(Node root) {
        Node minNode = root;
        while (minNode != null && minNode.left != null) {
            minNode = minNode.left;
        }
        return minNode;
    }

    public void remove(int val) {
        root = removeNode(root, val);
        return;
    }

    public Node removeNode(Node root, int target) { // except removing root value
        if (root == null) {
            return root;
        }
        if (target < root.val) {
            root.left = removeNode(root.left, target);
        } else if (target > root.val) {
            root.right = removeNode(root.right, target);
        } else {
            if (root.left == null && root.right == null) {
                // root = null;
                return null;
            } else if (root.left == null) {
                // root = root.right;
                // return root;
                return root.right;
            } else if (root.right == null) {
                // root = root.left;
                // return root;
                return root.left;
            }
            /*
             * remember that this is not a self balancing tree.
             * so i took from root's right subtree
             * we can also take root.left by taking the maximum value of root's left subtree
             */
            else {
                Node minimumNode = minValueNode(root.right);
                root.val = minimumNode.val; // so far, ive only copied the minimum value to the root node.
                // the below line will remove the desired node
                root.right = removeNode(root.right, minimumNode.val);
            }
        }
        return root; // root node of the tree
    }

    /*
     * ALL THREE ALGORITHMS ARE DEPTH FIRST SEARCH (DFS)
     * 
     * ALL THREE TRAVERSALS WILL REACH LEAF NODE (NODE WITHOUT CHILD) AND ONLY THEN
     * IT GOES TO OTHER NODE.
     * 
     */
    // in order traversal (left, root, right)
    public void inorderTraversalDisplay() {
        System.out.print("Inorder Traversal: ");
        inorderTraversal(root);
    }

    public Node inorderTraversal(Node root) {
        if (root == null) {
            return root;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
        return root;
    }

    // pre order traversal (root,left,right)
    public void preorderTraversalDisplay() {
        System.out.print("Preorder Traversal: ");
        preorderTraversal(root);
    }

    public Node preorderTraversal(Node root) {
        if (root == null) {
            return root;
        }
        System.out.print(root.val + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return root;

    }

    // post order traversal (left, right, root)
    public void postorderTraversalDisplay() {
        System.out.print("Postorder Traversal: ");
        postorderTraversal(root);
    }

    public Node postorderTraversal(Node root) {
        if (root == null) {
            return root;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.val + " ");
        return root;

    }

    // BREADTH FIRST SEARCH
    public void levelOrderTraversalDisplay() {
        levelOrderTraversal(root);
    }

    public void levelOrderTraversal(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int curLevel = 0;
        while (!queue.isEmpty()) {
            /*
             * at first the size of queue is one because it has only one Node which is root.
             * it will decrease and increase based on offer() and poll()
             */
            int len = queue.size();
            System.out.print("Level: " + curLevel);
            for (int i = 0; i < len; i++) {
                /*
                 * similar to pop(), it removes the first element (FIFO).
                 * im assigning root to the node i.e node=root;
                 */
                Node node = queue.poll();
                System.out.print(" -> " + node.val);

                // by offering the node.left and node .right in queue, the size of queue
                // increases dynamically
                /*
                 * at first node.left will be there in queue and then node.right. node.left will
                 * get polled (popped out from the queue)
                 */
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            curLevel++;
            System.out.println();
        }
    }

    /*
     * ONE MISTAKE IVE MADE WHILE TYPING THIS
     * when you want to check using boolean, you need to return the result of called
     * method.
     * 
     * if you type isTargetPresent(root.right,target) instead of
     * return isTargetPresent(root.right, target), even if the element is present
     * and it returns true to the method which called it, to the methods which are
     * CALLED BEFORE wont be able to fetch it.
     * 
     * as a result, the method will return false which is the default value of
     * boolean
     * 
     */
    public void search(int target) {
        if (isTargetPresent(root, target)) {
            System.out.println("The target element: " + target + " is present");
        } else {
            System.out.println("The target element: " + target + " is absent");
        }
    }

    public boolean isTargetPresent(Node root, int target) {
        if (root == null) {
            return false;
        }
        if (target > root.val) {
            return isTargetPresent(root.right, target);
        } else if (target < root.val) {
            return isTargetPresent(root.left, target);
        } else {
            return true;
        }
    }
}

public class BinarySearchTree {
    public static void main(String[] args) {
        BST obj1 = new BST();
        obj1.insert(4);
        obj1.insert(3);
        obj1.insert(2);
        obj1.insert(6);
        obj1.insert(5);
        obj1.insert(7);
        obj1.inorderTraversalDisplay();
        System.out.println("\n");
        obj1.preorderTraversalDisplay();
        System.out.println("\n");
        obj1.postorderTraversalDisplay();
        System.out.println("\n");
        obj1.search(7);
        System.out.println("\n");
        obj1.levelOrderTraversalDisplay();
        obj1.remove(3);
        obj1.inorderTraversalDisplay();
    }
}
