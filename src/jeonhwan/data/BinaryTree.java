package jeonhwan.data;


public class BinaryTree {

    Node root;

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);
        if (root == null) {
           root = newNode;
        } else {
            Node focusNode = root;
            Node parent;

            while (true) {
                parent = focusNode;
                if (key  < focusNode.key) {
                    focusNode = focusNode.leftChild;
                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;
                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraverseTree(Node focusNode) {

        if (focusNode != null) { // 50, 25, 15
            inOrderTraverseTree(focusNode.leftChild); //15
            System.out.println(focusNode.toString());
            inOrderTraverseTree(focusNode.rightChild);

        }
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.addNode(50,"Boss");
        tree.addNode(25,"Employee 25");
        tree.addNode(15,"Employee 15");
        tree.addNode(30,"Employee 30");
        tree.addNode(75,"Employee 75");
        tree.addNode(85,"85");
        tree.inOrderTraverseTree(tree.root);

    }


}

/**
 * Node class
 */
class Node {

    int key;
    String name;

    Node leftChild;
    Node rightChild;

    Node (int key, String name) {
        this.key = key;
        this.name = name;
    }

    public String toString() {
        return name + "has a " + key;
    }
}
