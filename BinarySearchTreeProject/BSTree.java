/**Christopher Eduarte
 * CS 241 Summer 2016
 * Project 1 BSTree.java
 * Definition: Binary Search Tree implementation where nodes are added or deleted.
*/

public class BSTree
{
	private TreeNode  root, parent;
	private TreeNode foundNode;

	/**
	 * Constructor that sets root and parent to null
	*/
	public BSTree()	
	{	
		root = null;
		parent = null;
	}
	
	/**
	*@param: data: newly inserted node
	* Adds a node into the tree
	*/
	public void add(int data)
	{
		root = add(root, data);
		
	}
	
	/**
	 * Adds the node into the binary tree
	 * @param  cur: current node in the list
	 *         value: the data inside the list
	 * @return cur: newly added nodein the entire tree
	 */
	public TreeNode add(TreeNode cur, int  value)
	{
		
	         //System.out.println("Compare " + cur.getValue() + " with "
		 //                         + value;
		// TreeNode par = null;
	 	 if(cur  == null)
	 	 {
			cur  = new TreeNode(value, null, null);
                        return cur; 			
 		 }
		 else
		 {
                         		      
			TreeNode temp;
		      	//int compare = cur.getValue().compareTo(value);
			if(cur.getValue() > value)
			{
			        temp = add(cur.left, value);
				cur.left = temp;
				temp.parent = cur;
			}
			else if(cur.getValue() == value)
			{
				System.out.println(value + " already" 
						   +	" exists. Ignore");
			}	
			else if(cur.getValue() < value)
			{ 
			        temp = add(cur.right, value);
				cur.right = temp;
				temp.parent = cur;
			}		 	
				
		 }
		
		return cur;
				
	}
       
       	public TreeNode found(int target)
	{
		foundNode = found(root, target);
		return foundNode;
	}

        /**
	 *Checks if the value exist in the Binary Search Tree
	 *@param target: the value that is being searched
	 *       node: the node we are trying to find
	 *@return 
	 */
	public TreeNode found(TreeNode node, int target)
	{
		TreeNode found = null;
                if(node == null)
		   return null;
	        if(node.getValue() < target)
		{
		    found = found(node.left, target);
	        }
	        else if(root.getValue() > target)
		{
 	            found = found(node.right, target);
		}
		else if(root.getValue() == target)
		{
		     return node;
		}	

		return found;
	}
		
	//finds and deletes the node
	public void rm(int target) throws NullPointerException
	{       try
	        {
			if(root == null)
			    System.out.println("Tree is empty");
			else
			{
		            root = rm(root, target);
		  	    System.out.println(target + " was deleted from the tree");
	   	        }
		}
		catch(NullPointerException e)
		{
			System.out.println(target + " was not found.");
		}
	}	
        
	
	/**
	 * deletes the node and replaces it if there are two children
	 *@param cur: the current node in the list
	 *       target: the data value of node
	 *@return cur: the node that is deleted
	 */
	public TreeNode rm(TreeNode cur, int target)
	{
		//int compare = cur.getValue().compareTo(target);
		TreeNode temp1, temp2, node;
	      
		if(cur == null) 
		{	
			throw new NullPointerException("The value was not found");
		}
		else if(target < cur.getValue())
		{
			node  = rm(cur.left, target);
			cur.setLeft(node);

		}
		else if(target > cur.getValue())
		{
			node  = rm(cur.right, target);
			cur.setRight(node);
		}
		else if(target == cur.getValue())
		{
			//case1: node has no children
			if(cur.isLeaf())
			{
				return null;
			} 
			//Case 2:one children and  left is null 
			else if(cur.left == null)
			{
				temp1 = cur.right;
				return temp1;
			}
			//case 3:one children and  right is null
			else if(cur.right == null)
			{
				temp2 = cur.left;
				return temp2;
			}
			//case 4: node has both children
			else
			{
				temp2 = cur.right;
				temp1 = cur.right;
				while(temp1.left != null)
				    temp1 = temp1.left;
			        temp1.setLeft(cur.left);
				return temp2;			 
			}	
		}
		else
		{
			System.out.println(target + " was not found");
		}
		
		return cur;
	}

	//Finds the successor of the node selected 
	//returns the value that will succeed the node 
	public void  findSuccessor(int value)
	{
		int valSuccess;
		//TreeNode node = found(value); does not work
		TreeNode success = findSuccessor(root);
		valSuccess = success.getValue();
		System.out.println(valSuccess);
	}

	/**
	 *Returns the successor of the given node
	 *@param success: the current node in the tree
	 *       value: the data value of the node
	 *@return temp: the inorder successor of node
	 */
	public TreeNode findSuccessor(TreeNode success) // success does not work
	{
		if(success == null)
		   return null;

		if(success.right!= null)
		{
			 return Min(success.left);
		}
		
	        TreeNode temp = success.parent;
		while(temp != null && temp.left == success)
		{
		      success = temp;
		      temp = temp.parent;
		}

		return temp;
	}	
	
	//finds the minimum value in the Binary Tree
	public TreeNode Min(TreeNode node)
	{
		TreeNode temp = node;
		if(temp == null)
		{
			return null;
		}

		while(temp.left != null){
		      temp = temp.left;
		}

		return temp;
	}

	
	//Shows  the predecessor value of a node. 
	public void findPredecessor(int value)
	{
		int predNum;
		TreeNode predecessor;
		predecessor  = pred(root, value);
		predNum = predecessor.getValue();
		System.out.println(predNum);
	}
	
	/**
	  Finds the predecessor of the node and 
	  returns it.
	  @param pred: the node whose predecessor we are currently 
	               finding
	  @return parent 
	*/
	public TreeNode pred(TreeNode pred, int data) //does not give the predecessor
	{
		if(pred == null)
		   return null;

		if(pred.left != null)
		{
			return Max(pred.left);
		}

		TreeNode newPred = null;
		while(pred != null)
		{
			if(pred.getValue() == data)
			   break;
			else if(pred.getValue() < data)
			   pred = pred.left;
			else if( pred.getValue() > data)
			{
                           newPred = pred.right;
			   pred = pred.right;
			}
		}

		return pred;
	}

	//Finds the maximum node in a subtree
	public  TreeNode Max(TreeNode node)
	{
		TreeNode temp = node;
		if(temp == null)
		   return null;
		
		if(temp.right != null)
	           temp = temp.right;

		return temp;
	}

	//Tree Traversals
	
	//prints out the tree preorder
	public void preorderPrint()
	{
		root.preorder();
	}	
	
	//Prints out the tree inorder
	public void inorderPrint()
	{
		root.inorder();
	}
	
	//Prints out the tree in postorder
	public void postorderPrint()
	{
		root.postorder();
	}
	
}

