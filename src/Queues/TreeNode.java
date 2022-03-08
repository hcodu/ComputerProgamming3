/**
 *  Description of the Class
 *
 * @author     administrator
 * @created    January 3, 2003
 */
public class TreeNode
{
  private Object value;
  private TreeNode left;
  private TreeNode right;

  /**
   *  Constructor for the TreeNode object
   *
   * @param  initValue  Description of Parameter
   * @param  initLeft   Description of Parameter
   * @param  initRight  Description of Parameter
   */
  public TreeNode(Object initValue, TreeNode initLeft,
          TreeNode initRight)
  {
    value = initValue;
    left = initLeft;
    right = initRight;
  }

  public TreeNode(Object initValue)
  {
    this(initValue, null, null);
  }

  /**
   *  Sets the value attribute of the TreeNode object
   *
   * @param  theNewValue  The new value value
   */
  public void setValue(Object theNewValue)
  {
    value = theNewValue;
  }

  /**
   *  Sets the left attribute of the TreeNode object
   *
   * @param  theNewLeft  The new left value
   */
  public void setLeft(TreeNode theNewLeft)
  {
    left = theNewLeft;
  }

  /**
   *  Sets the right attribute of the TreeNode object
   *
   * @param  theNewRight  The new right value
   */
  public void setRight(TreeNode theNewRight)
  {
    right = theNewRight;
  }

  /**
   *  Gets the value attribute of the TreeNode object
   *
   * @return    The value value
   */
  public Object getValue()
  {
    return value;
  }

  /**
   *  Gets the left attribute of the TreeNode object
   *
   * @return    The left value
   */
  public TreeNode getLeft()
  {
    return left;
  }

  /**
   *  Gets the right attribute of the TreeNode object
   *
   * @return    The right value
   */
  public TreeNode getRight()
  {
    return right;
  }
}

