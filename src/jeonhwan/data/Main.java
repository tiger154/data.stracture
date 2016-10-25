package jeonhwan.data;

/**
 * Test main
 */
public class Main {

    public static void main(String[] args) {
        LinkedList numbers = new LinkedList();
        System.out.println("test start");
        // something...
        numbers.addFirstNode(30);
        numbers.addFirstNode(20);
        //numbers.addAfterNode(20,25);

        numbers.remove(30);

        System.out.println("test end");
    }
}
