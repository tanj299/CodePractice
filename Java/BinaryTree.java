import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root; 

    /**
     * Insertion, deletion, contains 
     */
    public void add(int value) {
        root = addRecursive(root, value);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    public Node findNode(Node root, int value) {
        if (containsNodeRecursive(root, value)) {
            return root; 
        } 
        return null;
    }

    /**
     * Tree Traversal 
     */

    // Left, Node, Right
    public void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println("In Order: " + node.value);
            inOrderTraversal(node.right);
        }
    }

    // Node, Left, Right
    public void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.println("Pre Order: " + node.value);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

        // Left, Right, Node
        public void postOrderTraversal(Node node) {
            if (node != null) {
                postOrderTraversal(node.left);
                postOrderTraversal(node.right);
                System.out.println("Post Order: " + node.value);
            }
        }
    

        // Breadth-first search | Level order traversal
        public void levelOrderTraversal(Node root) {
            if (root == null) {
                return;
            }

            Queue<Node> nodes = new LinkedList<>(); 
            nodes.add(root);

            while (!nodes.isEmpty()) {
                Node current = nodes.poll();
                System.out.println("Level Order: " + current.value);

                if (current.left != null) {
                    nodes.add(current.left);
                }

                if (current.right != null) {
                    nodes.add(current.right);
                }
            }
        }

    /**
     * @param:  current: node to start traversal
     *          value: value to attach to new node 
    **/
    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value); 
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value); 
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current; 
        }

        return current; 
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null; 
        }

        if (value == current.value) {
            // Node is a leaf
            if (current.left == null && current.right == null) {
                return null; 
            }

            // Node has a single child 
            if (current.right == null) {
                return current.left; 
            }

            if (current.left == null) {
                return current.right;
            }

            // Node has two children  
            // Find the inorder successor
            int smallestValue = findSmallestValue(current.right); 
            current.value = smallestValue; 

            // Delete the inorder successor
            current.right = deleteRecursive(current.right, smallestValue);
            return current; 
        }

        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current; 
        }

        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false; 
        }

        if (value == current.value) {
            return true;
        }

        return value < current.value 
        ? containsNodeRecursive(current.left, value) 
        : containsNodeRecursive(current.right, value);
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

}