package jeonhwan.data;

/**
 * Test main
 */
public class Main {

    private static void runLinkedList() {
        LinkedList numbers = new LinkedList();
        System.out.println("test start");
        // something...
        numbers.addFirstNode(30);
        numbers.addFirstNode(20);
        //numbers.addAfterNode(20,25);
        numbers.addLastNode(40);

        numbers.remove(30);

        System.out.println("test end");
    }

    private static void passByValue(){
        class SomeNode {
            private Object data;
            public SomeNode(Object input) {
                data = input;
            }
        }
        SomeNode first = new SomeNode(1);
        SomeNode second = first;
        second.data = 2;
        first.data = 3;
        System.out.println("first node data :" + first.data + ", second node data : " + second.data);

        int x = 1;
        int y = x;
        y = 2;
        System.out.println("x value : " + x + ", y value : " + y);
        /*  Result */
        // first node data :3, second node data : 3
        // x value : 1, y value : 2
    }


    public static void main(String[] args) {

        runLinkedList();

    }

}
