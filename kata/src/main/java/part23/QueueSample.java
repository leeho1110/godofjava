package part23;

import java.util.LinkedList;

public class QueueSample {
    public static void main(String[] args) {
        checkLinkedList();
    }

    public static void checkLinkedList(){
        LinkedList<String> link = new LinkedList<>();

        // add
        link.add("A");
        link.add("B");
        link.add("C");
        link.add("A");
        link.add("D");
        System.out.println("normal: " + link); // [A, B, C, A, D]

        // remove
        link.removeFirstOccurrence("A");
        System.out.println("first A removed : " + link); // [B, C, A, D]

        link.addFirst("A");
        link.removeLastOccurrence("A");
        System.out.println("last A removed : " + link); // [B, C, D]
    }
}
