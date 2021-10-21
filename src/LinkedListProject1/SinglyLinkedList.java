package LinkedListProject1;

import java.util.*;

/**
 *  Implementation of lists, using singly linked elements.
 *
 * @author     G. Peck
 
 */
public class SinglyLinkedList {
  private static ListNode first;  // first element
  private ListNode last; //last element

  /**
   *  Constructor for the SinglyLinkedList object
   *  Generates an empty list.
   */
  public SinglyLinkedList()
  {
    first = null;
    last = null;
  }

  /**
   *  Returns the first element in this list.
   *
   * @return  the first element in the linked list.
   */
  public Object getFirst()
  {
    if (first == null)
    {
      throw new NoSuchElementException();
    }
    else
      return first.getValue();
  }

  public Object getLast() {
    ListNode temp = first;

    while(temp.getNext() != null) { //Gets to node before the one without a next reference
      last = temp;
      temp = temp.getNext();
    }

    return last.getNext().getValue();
  }

  /**
   *  Inserts the given element at the beginning of this list.
   *
   * @param  value  the element to be inserted at the beginning of this list.
   */
  public void addFirst(Object value)
  {
    // note the order that things happen:
    // head is parameter, then assigned
    first = new ListNode(value, first);
  }

  public void addLast(Object value) {
// Takes in value, creates a new node, adds the new node
// at the end of the list.
    ListNode newNode = new ListNode(value);
    if(size() == 0)   { //    an empty list then
      first = new ListNode(value);
      last = new ListNode(value);
    }
    else {       //    set both first and last to reference the newly constructed node
      ListNode current = first;
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(new ListNode(value));
    }
  }

  public static int size() {
    ListNode temp = first;
    int counter = 0;

    while (temp != null) {
     counter++;
     temp = temp.getNext();
    }
    return counter;
  }

  /**
   *  Print the contents of the entire linked list
   */
  public void printList()
  {
    ListNode temp = first;// start from the first node
    while (temp != null)
    {
      System.out.print(temp.getValue() + " ");
      temp = temp.getNext();// go to next node
    }
  }

  /**
   *  Returns a string representation of this list. The string
   *  representation consists of the list's elements in order,
   *  enclosed in square brackets ("[]"). Adjacent elements are
   *  separated by the characters ", " (comma and space).
   *
   * @return    string representation of this list
   */
  public String toString() {
    String s = "[";

    ListNode temp = first;  // start from the first node
    while (temp != null)
    {
      s += temp.getValue(); // append the data
      temp = temp.getNext();      // go to next node
      if (temp != null)
        s += ", ";
    }
    s += "]";
    return s;
  }
}
