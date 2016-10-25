package jeonhwan.data.linked_list;

/**
 * LinkedList Data structure [implement core API]
 *  - void addFirstNode(Object input)
 *  - void addLastNode(Object input)
 *  - void addAfterNode(Object niddel, Object input)
 *  - Node search(Node source, Object input)
 *  - void remove(Object niddel)
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;
    // Node class
    public class Node {
        private Object data;
        private Node next;
        private Node prev;
        public Node(Object input) {
            this.data = input;
            this.next = null;
            this.prev = null;
        }
        public String toString() {
            return String.valueOf(this.data);
        }
    }

    public void traceAll(Node source) {
        System.out.println(source.toString());
        if (source.next != null) {
            traceAll(source.next);
        }
    }

    /**
     * addFirstNode
     * @param input
     */
    public void addFirstNode(Object input) {
        Node newNode = new Node(input);
        // swap new head with prev head
        newNode.next = this.head;
        this.head = newNode;
        size++;
        // check head string
        // System.out.println(this.head.toString() + ',' + this.size);
        // if it was empty list set tail
        if (this.head.next == null) {
            this.tail = this.head;
        }
    }

    /**
     * addLastNode
     * @param input
     */
    public void addLastNode(Object input) {
        Node newNode = new Node(input);
        if (this.size == 0) {
            this.addFirstNode(input);
        } else {
            this.tail.next = newNode; // Set tail's next node to new last Node, So before it refer it self now it reach to new last Node
            this.tail = newNode;      // set New last node on tail
            size++;
            // check last node string
            // System.out.println(this.tail.toString() + ',' + this.size);

        }
    }

    /**
     * search
     * @param source
     * @param input
     * @return
     */
    public Node search(Node source, Object input) {
        Node result = new Node(null);
        Node prev;
        if (source != null) {
            if (source.data == input) {
                //System.out.println("Now we return found Node : " + source.toString() + " ->Compare value with : " + input);
                result = source;
                //System.out.println("prev!!! : " + source.toString());
                return result;
            } else {
                //System.out.println("run again with next node" + source.next.data.toString());
                source.next.prev = source;
                return search(source.next, input);
            }
        }
        //System.out.println("Called outside logic");
        return result;
    }

    /**
     * addAfterNode
     * @param niddel
     * @param input
     */
    public void addAfterNode(Object niddel, Object input) {
        Node newNode = new Node(input);
        Node leftNode = this.search(this.head, niddel); // get target left node

        if (leftNode != null && leftNode.toString() != "null") {
            // If there is only one node, or it's tail
            if (leftNode == tail) {
                this.addLastNode(input);
            } else {
                Node rightNode = leftNode.next;                 // get target's right node
                // 1. set next value from newNode to right Node
                newNode.next = rightNode;
                // 2. set next value from founded left node
                leftNode.next = newNode;
                size++;
            }
        } else {
            System.out.println("Sorry there is no Node, please search proper value");
        }
        // check all array
        //this.traceAll(this.head);
    }

    /**
     * remove
     * @param niddel
     */
    public void remove(Object niddel) {
        Node targetNode = this.search(this.head, niddel); // get target left node

        if (targetNode.prev != null) {
            Node leftNode = targetNode.prev;
            Node rightNode = targetNode.next;

            leftNode.next = rightNode;
            targetNode = null; // remove;
            size--;
        } else {
            targetNode = null; // remove;
            this.head = null;
            this.tail = null;
            size--;
        }
        //System.out.println(size);
        this.traceAll(this.head);

    }


}
