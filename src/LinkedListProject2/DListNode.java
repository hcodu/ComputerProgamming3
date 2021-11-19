/* DListNode.java */

package LinkedListProject2;

import LinkedListProject1.ListNode;

/**
 *  A DListNode is a node in a DList (doubly-linked list).
 */

public class DListNode {

  /**
   *  item references the item stored in the current node.
   *  prev references the previous node in the DList.
   *  next references the next node in the DList.
   *
   *  DO NOT CHANGE THE FOLLOWING FIELD DECLARATIONS.
   */

  public Object value;
  protected DListNode next;
  protected DListNode prev;

  /**
   *  Constructs a new element with object initValue,
   *  followed by next element
   *
   * @param  initValue  New element object
   * @param  initNext   Reference to next element
   */
  public DListNode(Object initValue, DListNode initNext, DListNode initPrev)
  {
    value = initValue;
    next = initNext;
    prev = initPrev;
  }

  /**
   *  Constructs a new tail of a list with object initValue
   *
   * @param  initValue  New element object
   */
  public Object getValue() {
    return value;
  }


}
