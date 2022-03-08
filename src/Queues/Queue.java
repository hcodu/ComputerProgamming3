public interface Queue {
    // postcondition: returns true if queue is empty, false otherwise
  boolean isEmpty();

    // precondition:  queue is [e1, e2, ..., en] with n >= 0
    // postcondition: queue is [e1, e2, ..., en, x]
  void enqueue(Object x);

    // precondition:  queue is [e1, e2, ..., en] with n >= 1
    // postcondition: queue is [e2, ..., en]; returns e1
    //                 throws an unchecked exception if the queue is empty
  Object dequeue();

    // precondition:  queue is [e1, e2, ..., en] with n >= 1
    // postcondition: returns e1
    //                 throws an unchecked exception if the queue is empty
  Object peekFront();
}
