//import javax.swing.tree.TreeNode;
//import javax.swing.tree.TreeNode;

/**
 *  Description of the Class
 *
 * @author     G. Peck
 * @created    July 18, 2002
 */

//  bTree.cpp
//  Binary tree lab, Lesson 36-38

public class BinarySearchTree
{
  private TreeNode myRoot;

  public BinarySearchTree()
  {
    myRoot = null;
  }

  public void clearTree()
  {
    myRoot = null;
  }

  public void insert(Comparable next)
  // post: next added to tree so as to preserve binary search tree
  {
    myRoot = insert(next, myRoot);
  }

  private TreeNode insert (Comparable next, TreeNode root)
  // pre : root points to a binary search tree
  // post: next added to tree so as to preserve binary search tree
  {
    if (root == null)
      root = new TreeNode(next, null, null);
    else if(next.compareTo(root.getValue()) <= 0 )
      root.setLeft(insert(next, root.getLeft()));
    else
      root.setRight(insert(next, root.getRight()));
    return root;
  }

  public Object find(Comparable target)
  {
    return find(myRoot, target);
  }

  private Object find(TreeNode root, Comparable target)
  {
    if (root == null)
      return null;

    int compareResult = target.compareTo(root.getValue());

    if (compareResult == 0)
      return root.getValue();
    else if (compareResult < 0)
      return find(root.getLeft(), target);
    else
      return find(root.getRight(), target);
  }

  public int countNodes ()
  {
    return countNodes(myRoot);
  }

  private int countNodes (TreeNode root)
  {
    if (root == null)
      return 0;
    else
      return  countNodes(root.getLeft()) + 1 + countNodes(root.getRight());
  }

  public int countLeaves()
  {
    return countLeaves(myRoot);
  }

  private int countLeaves (TreeNode root)
  {
    if (root == null)
      return 0;
    else if ((root.getRight() == null) && (root.getLeft() == null))
  		return 1;
  	else
      return countLeaves(root.getLeft()) + countLeaves (root.getRight());
  }

  public int height()
  {
    return height(myRoot);
  }

  private int height (TreeNode root)
  {
    if (root == null)
      return 0;
    else
      return (max(1 + height(root.getLeft()), 1 + height(root.getRight())));
  }

  public int width()
  {
    return width(myRoot);
  }

  private int width (TreeNode root)
  {
    int temp;

    if (root == null)
      return 0;
    temp = height(root.getLeft()) + 1 + height(root.getRight());
    temp = max (temp, width(root.getLeft()));
    return max (temp, width(root.getRight()));
  }

  private int max (int a, int b)
  {
    if (a > b)
      return a;
    else
      return b;
  }

  public void interchange()
  // post:
  {
    interchange(myRoot);
  }

  private void interchange(TreeNode root)
  {
    if (root != null)
    {
      TreeNode temp = root.getLeft();
      root.setLeft(root.getRight());
      root.setRight(temp);

      interchange(root.getLeft());
      interchange(root.getRight());
    }
  }

  public void printLevel(int level)
  // post: prints the data fields of the tree, one per line
  {
    printLevel(myRoot, level);
  }

  private void printLevel(TreeNode root, int level)
  {
    if ( (root != null) && (level >= 0))
    {
      if (level == 0)
        System.out.print(root.getValue() + " ");
      else
      {
        printLevel(root.getLeft(), level - 1);
        printLevel(root.getRight(), level - 1);
      }
    }
  }

  private TreeNode findPtr(TreeNode root, Comparable target)
  {
    if (root == null)
      return null;
    if (target.equals(root.getValue()))
      return root;
    if (target.compareTo(root.getValue()) < 0)
      return findPtr(root.getLeft(), target);
    else
      return findPtr(root.getRight(), target);
  }

  public boolean isAncestor(Comparable ancestor, Comparable descendant)
  // post: prints the data fields of the tree, one per line
  {
    return isAncestor(myRoot, ancestor, descendant);
  }

  boolean isAncestor(TreeNode root, Comparable a, Comparable d)
  {
    if (findPtr(findPtr(root, a), d) != null)
      return true;
    else
      return false;
  }

  public void printInorder()
  // post: prints the data fields of the tree, one per line
  {
    printInorder(myRoot);
  }

  private void printInorder (TreeNode root)
  // pre : root points to a binary search tree
  // post: prints the data fields of the tree using an inorder traversal
  {
    if (root != null)
    {
      printInorder(root.getLeft());
      System.out.print(root.getValue());
      printInorder(root.getRight());
    }
  }

  public void printPreorder()
  // post: prints the data fields of the tree, one per line
  {
    printPreorder(myRoot);
  }

  private void printPreorder (TreeNode root)
  // pre : root points to a binary search tree
  // post: prints the data fields of the tree using an inorder traversal
  {
    if (root != null)
    {
      System.out.print(root.getValue());
      printPreorder(root.getLeft());
      printPreorder(root.getRight());
    }
  }

  public void printPostorder()
  // post: prints the data fields of the tree, one per line
  {
    printPostorder(myRoot);
  }

  private void printPostorder (TreeNode root)
  // pre : root points to a binary search tree
  // post: prints the data fields of the tree using an inorder traversal
  {
    if (root != null)
    {
      printPostorder(root.getLeft());
      printPostorder(root.getRight());
      System.out.print(root.getValue());
   }
  }

  public Object findMin()
  // post: returns the minimum value in the tree (null if tree is empty)
  {
      if (myRoot == null)
          return null;
      else
          return findMin(myRoot);
  }

  private Object findMin(TreeNode root)
  // pre : root points to a nonempty binary search tree
  // post: returns the minimum value stored in the tree
  {
      if (root.getLeft() == null)
        return root.getValue();
      else
        return findMin(root.getLeft());
  }

  public Object findMax()
  // post: returns the maximum value in the tree (null if tree is empty)
  {
      if (myRoot == null)
          return null;
      else
          return findMax(myRoot);
  }

  private Object findMax(TreeNode root)
  // pre : root points to a nonempty binary search tree
  // post: returns the maximum value stored in the tree
  {
      if (root.getRight() == null)
        return root.getValue();
      else
        return findMax(root.getRight());
  }

  public void remove(Comparable target)
  // post: removes a node with data equal to target, if present,
  //       preserving binary search tree property
  {
      myRoot = remove(target, myRoot);
  }
/*
  private TreeNode remove(Comparable target, TreeNode root)
  // pre : root points to a binary search tree
  // post: removes a node with data equal to target, if present,
  //       preserving binary search tree property
  {
    if (root != null)
    {
      if (target.compareTo(root.getValue()) < 0)
        root.setLeft( remove(target, root.getLeft()) );
      else if (target.compareTo(root.getValue()) > 0)
        root.setRight( remove(target, root.getRight()) );
      else if (root.getLeft() == null)
        root = root.getRight();
      else if (root.getRight() == null)
        root = root.getLeft();
      else
      {
        root.setValue( findMax(root.getLeft()) );
        root.setLeft( remove((Comparable)root.getValue(), root.getLeft()) );
      }
    }
    return root;
  }
*/
  private TreeNode remove(Comparable target, TreeNode root)
  // pre : root points to a binary search tree
  // post: removes a node with data equal to target, if present,
  //       preserving binary search tree property
  {
    if (root != null)
    {
      if (target.compareTo(root.getValue()) < 0)
        root.setLeft( remove(target, root.getLeft()) );
      else if (target.compareTo(root.getValue()) > 0)
        root.setRight( remove(target, root.getRight()) );
      else if (root.getLeft() == null)
        root = root.getRight();
      else if (root.getRight() == null)
        root = root.getLeft();
      else
      {
        root.setValue( findMin(root.getRight()) );
        root.setRight( remove((Comparable)root.getValue(), root.getRight()) );
      }
    }
    return root;
  }
}