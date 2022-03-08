public class ListQueue implements Queue {
    private java.util.LinkedList list;
  
    public ListQueue() { 
      list = new java.util.LinkedList(); 
    }
    public boolean isEmpty() { 
      return list.size() == 0; 
    }
        // Or: ... isEmpty() { return list.isEmpty(); }
    public void enqueue(Object obj) { 
      list.addLast(obj); 
    }
    public Object dequeue() { 
      return list.removeFirst(); 
    }
    public Object peekFront() { 
      return list.getFirst(); 
    }
  }
  
  