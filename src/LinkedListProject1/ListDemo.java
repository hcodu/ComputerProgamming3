package LinkedListProject1;

/**
 *  Demonstrates the use of the SinglyLinkedList class.
 *
 * @author     G. Peck

 */
public class ListDemo {
  static SinglyLinkedList myList;

  public ListDemo()
  {
    myList = new SinglyLinkedList();
  }

  /**
   *  Creates a SinglyLinkedList of 5 Integer nodes
   */
  public void createList()
  {
    for (int k = 20; k > 0; k--)
    {
      myList.addFirst(new Integer(k));
    }
  }

  /**
   *  Display the first element of the list
   */
  public void displayFirst()
  {
    System.out.println("First Element: " + myList.getFirst());
  }

  public void displayLast() {
    System.out.println("Last Element: " + myList.getLast());
  }

  /**
   *  Print the contents of myList
   */
  public void print()
  {
    myList.printList();
    System.out.println();
  }

  public void printSize() {
    System.out.print("Nodes " + myList.size());
  }


  /**
   *  Demostrates the use of the SinglyLinkedList class.
   *  Creates and prints a list of 5 consecutive Integer ojects.
   *
   * @param  args  The command line arguments (not used)
   */
  public static void main(String[] args) {
    ListDemo sList = new ListDemo();

    sList.createList();
    sList.displayFirst();
    sList.displayLast();
    sList.print();
    sList.printSize();

  }
}
