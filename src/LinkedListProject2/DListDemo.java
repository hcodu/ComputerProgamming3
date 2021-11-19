package LinkedListProject2;

public class DListDemo {
    public static void main(String[] args) {

        // Create Double Linked List and Display
        DoublyLinkedList dList = new DoublyLinkedList();
        System.out.println("Is Empty?: " + dList.isEmpty() + "\nLength: " + dList.length() + "\n\n");

        // Add elements in the back - Uses DList.insertBefore()
        dList.insertBack("First Element");
        dList.insertBack("Second Element");
        dList.insertBack("Third Element");
        dList.insertBack("Fourth Element");
        dList.insertBack("Fifth Element");
        System.out.println(dList.toString() + "\nIs Empty?: " + dList.isEmpty() + "\nLength: " + dList.length() + "\n");


        // Add elements in the front - Uses DList.insertAfter()
        dList.insertFront("Front Element 3");
        dList.insertFront("Front Element 2");
        dList.insertFront("Front Element 1");
        System.out.println(dList.toString() + "\nIs Empty?: " + dList.isEmpty() + "\nLength: " + dList.length() + "\n");

        // Remove element 2
        System.out.print(dList.head.next.next.getValue() + " !!");
        dList.remove(dList.head.next.next);
        System.out.println(dList.toString() + "\nIs Empty?: " + dList.isEmpty() + "\nLength: " + dList.length() + "\n");

        // Remove element 2 Again
        dList.remove(dList.head.next.next);
        System.out.println(dList.toString() + "\nIs Empty?: " + dList.isEmpty() + "\nLength: " + dList.length() + "\n");

        // Print Front element item
        System.out.println(dList.front().getValue());

        // Print Back element item
        System.out.println(dList.back().getValue());

        // Print next element item
        System.out.println(dList.next(dList.head.next).getValue());

        // Print next element item
        System.out.println(dList.prev(dList.head.next).getValue());

    }

}
