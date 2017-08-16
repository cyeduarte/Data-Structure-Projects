/**Christopher Eduarte
 * Project 1 Node.java
 * CS241 Summer 2016
 * Description: Node implementation for a Binary Search Tree
*/

/**
 *The class's purpose is to createthe structure of a binary tree by 
 *creating a left child, for data smaller than the root, and right child
 *for data that is greater than the root.
 *
 */

public class TreeNode
{
	protected TreeNode left, right, parent;
        private  int value;

	//Constructor that sets all parts of the tree to null
	public TreeNode()
	{
		left = null;
		right = null;
		value = 0;
		parent = null;
	}

	//Constructor that sets the values
	public TreeNode(int val, TreeNode locLeft, TreeNode locRight)
	{
		setValue(val);
		setLeft(locLeft);
		setRight(locRight);
		parent = null;
	}
      
        /**
	 *Sets the left child of the node
	 *@param newLeft is the newly added left child of the current
	 *       node
         *@return none 
	 */
	public void setLeft(TreeNode newLeft)
	{
		left = newLeft;
	}
	
	/**
	 *Sets the right child of the current node
	 *@param newRight is the right child of the current node
	 *@return none
	 */
	public void setRight(TreeNode newRight)
	{
		right = newRight;
	}

	/**
	 *Sets value for the current node
	 *neVal is the new dated inserted into the tree
	 */
	public void setValue(int newVal)
	{
		value = newVal;
	}
	
	/**
	 *Sets parent 
	 *@param locPar is the parent of the current node
	 *@return none
	 */
	public void setParent(TreeNode locPar)
	{
		parent = locPar;
	}

	//Returns the left child of the node
	public TreeNode getLeft()
	{
		return left;
	}

	//Returns the right child of the node
	public TreeNode getRight()
	{
		return right;
	}
	
	/**
	 *Returns the value of the current node
	 */
	public int getValue()
	{
		return value;
	}

	//Returns the value of the parent node
	public TreeNode getParent()
	{
		return parent;
	}

	/**
	 *Returns the leftmost value in the subtree of the 
	 *current node
	 *@param none
	 *@return leftmost value
	 */
	public int getLeftmost()
	{
		if(left == null)
		   return value;
		else
		   return left.getLeftmost();
	}

	//Returns the rightmost value to the given node
	public int getRightmost()
	{
		if(right == null)
		   return value;
		else
		   return right.getRightmost();
	}
	
	//Returns the lefmost node to the given node
	public TreeNode removeLeftmost()
	{
		if(left == null)
		{
			return right;
		}
		else
		{
			left = left.removeLeftmost();
			return this;
		}
	}

	//Removes the rightmost node
	public TreeNode removeRightmost()
	{
		if(right == null)
		{
			return left;
		}
		else
		{
			right = right.removeRightmost();
			return this;
		}
	
	}

	/**
	 * Returns true if the node is a leaf, false if otherwise
	 */
	public boolean isLeaf()
	{
		return (left == null) && (right == null);  
	}

	/**
	 *Traverses the root, the left subtree, and then the right subtree
	 */
	public void preorder()
	{
		System.out.print(value + " ");
		if(left != null)
		  left.preorder();
	        if(right != null)
		  right.preorder();
	}
	
	/**
	 * Traverses the left subtree, the root, and then the right subtree
	 */
	public void inorder()
	{
		if(left != null)
		   left.inorder();
	        System.out.print(value + " ");
		if(right != null)
		   right.inorder();
	}
	
	/**
	 *Traverses the left subtree, the right subtree, and then the root
	 */
	public void postorder()
	{
		if(left != null)
		  left.postorder();
		if(right != null)
		  right.postorder();
		System.out.print(value + " ");
	}

	/**
	 * Compares two generic values
	 * @param val2: generic value containing the data
	 * @return -1, 1 or 0: values that show whether the value
	 *         is less than, greater than, or equal to
	 */
	/*public int compareTo(V val2)
	{
		System.out.println("Compare " + value + " and " + val2);
		if(value.compareTo(val2) > 0)
		{
			return 1;
		}
		else if(value.compareTo(val2) < 0)
		{
			return -1;
		}
		else 
		{
			return 0;
		}
	}*/

	//Prints left subtree
	public void printLeft()
	{
	     System.out.print("Left Subtree: ");
             while(left != null)
	     {
		System.out.print(value);
	     }
	}

	//Print right subtree
	public void printRight()
	{
	    System.out.print("Right Subtree: ");
	    while(right != null)
	    {
	       System.out.print(value);
	    }
	}
}
