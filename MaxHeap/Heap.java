/**
 *Christopher Eduarte
 *CS241 Project2 Heap.java
 *Summer 2016
 *Definition: Max Heap implmentation where the contents of the array
              are heapfied to maintain the parent is greater than child 
	      rule.
 */



public class Heap
{
	private int[] insertAry;
	private int[] heapAry;
	private int length;
	private int lengthOpt;
	private static int swapInsert = 0;
	private static int swapOptimal = 0;
	private static  int position; //number of elements in the array
	private int root;
	private static int replace;

	//empty constructor
	public Heap()
	{
		position = 0;
		length = 0;
		
	}

	/**
	 *	Constructor: sets the values of length, index and array
	 *	@param max and ary[], where max is the length of
	 *	       the array and ary[] is the ary set
	 */
	public Heap(int max, int ary[])
	{
		length = max;
		lengthOpt = max;
		heapAry = new int[max + 1];
		insertAry = new int[max + 1];
		position = 0;
		root = 0;
		heapAry[0] = max;
		heapAry[0] = max;
	}

	//Returns the parent of the current index
	public int parent(int index)
	{
		return (index-1)/2;
	}

	//Returns the left child of the current index
	public int left(int index)
	{
		return (2 * index) + 1;
	}

	//Returns the right child of the current index
	public int right(int index)
	{
		return (2 * index) + 2;
	}

	/**
	 *Swaps the position between num1 and num2
	 *@param: num1 and num2, where num1 is the parent of the node
	 *         and num2 is the child of num1.
	 *@return none
	 */
	public void swap(int num1, int num2)
	{
		int temp = heapAry[num1];
		heapAry[num1] = heapAry[num2];
		heapAry[num2] = temp;
	}

	//Increments swapInsert by one
	public void countSwapInsert()
	{
		swapInsert++;
	}

	//Increments swapOptimal by one
	public void countSwapOptimal()
	{
		swapOptimal++;
	}
	
	/**
	 *Inserts new node into the binary tree
	 *@param node is a newly inserted node in the binary heap
	 */
	public void insertion(int node)
	{
		insertAry[position] = node;
		int cur = position;
		
		while(insertAry[cur] > insertAry[parent(cur)]){
		  	int temp = insertAry[cur];
			insertAry[cur] = insertAry[parent(cur)];
			insertAry[parent(cur)] = temp;

		        countSwapInsert();
			cur = parent(cur);
		
		}

		position++;
	}

	//Doubles the size of the array
	public void doubleSize()
	{
		length = length * 2;
	}

	//Determines whether a tree is empty or not 
	public boolean emptyTree()
	{
		return(position == 0);
	}
	
	/**
	 *Deletes the top node and maintains binary heap rules by
	 *reheapifying the tree
	 *@param none
	 *Delete method for also the insert method
	 */
	public int deleteMax()
	{
		int size = heapAry.length;
		int max = 0;
		int offVal = heapAry[max];
		heapAry[max] = heapAry[size - 1];
		size--;	

		reheapDown(max, heapAry);

		max++;
		return max;

	}
	
	//Delete max for insert method
	public int deleteMax2()
	{
	        int replace = length - 1;	
		int max = 0;
		insertAry[max] = insertAry[replace];
		length--;
		reheapDown(max, insertAry);
		System.out.println(max);
		root++;
		return root;
	}

	/**
	 *Determines whether a node is a leaf
	 *@param index is a node in the binry heap
	 *@return true if index is a leaf, false otherwise
	 */
	public boolean isLeaf(int index)
	{
		return (index >= (length/2) - 2); //&& index <= length);
	}

	/**
	 * From the root, it swaps child and parent if child is greater
	 * than parent.
	 * @param node is the index in the array that represents a
	 *        node in the binary heap.
	 */
	public void reheapDown(int node, int []ary)
	{
        	int l = left(node);
		int r = right(node);
		int max = heapAry.length;

		if(!isLeaf(node))
		{
			if(ary[node] < ary[l] ||
			   ary[node] < ary[r])
			{			  
			   if(ary[l] > ary[r])
			   {    
				swap(node, l);
				countSwapOptimal();
				reheapDown(l, ary);
			   }
			   else
			   {
				swap(node, r);
				countSwapOptimal();
				reheapDown(r, ary);
			   }
			}
		}
		else
		{
			//do nothing
		}
	}

	/**
	 *If the parent is less than the child, swap places
	 *@param node is an index in an array that represents a node in 
	 *       a binary heap
	 */
	 public void reheapUp(int node)
	{
		int par;
		int temp = heapAry[node];

		par = parent(node);
		if(par > 1)
		{    
		     if(heapAry[node] > heapAry[par])
		     {
			 countSwapInsert();				
		  	 swap(node, par);
	         	 reheapUp(par);
		     }
		}
		
	}

	/**
	 *Builds and and rearranges nodes so that every parent is 
	 *greater than the child node
	 *@param: ary is an array of ints 
	 *@return none
	 */
	public void optimal(int[] ary)
	{
		heapAry = ary;
		for(int index = (length/2) - 2; index >= 0; index--)
		{
			int l = left(index);
			int r = right(index);
			
			
			
			reheapDown(heapAry[index], ary);
		}
	}
		
	//Method that prints the output for option1
	public void printOption1()
	{
		System.out.println("Average swaps for series" 
		                    + " of insertions:" + swapInsert);
	        System.out.println("Average swaps for optimal method: "
		                    + swapOptimal);
	}

	//Method that prints the output for the insertion method
	public void printInsert()
	{
		System.out.print("Heap built using " +
		                 "series of insertions: ");
		for(int i = 0; i < 10; i++)
		{
			System.out.print(insertAry[i] + ",");
		}
		
		System.out.print("\n");

		System.out.println("Number of swaps: " + swapInsert);

		System.out.print("Heap after 10 removals: ");
		
		for(int i = 0; i < 10; i++)
		{
			deleteMax2();
		}

		for(int i = 0; i < 10; i++)
		{
			System.out.print(insertAry[i] + ",");
		}
		
		System.out.print("\n");
	}
	
	//Method that prints the output for the optimal method
	public void printOptimal()
	{
		System.out.print("\nHeap built using optimal method: ");
		for(int i = 0; i < 10; i++)
		{
			System.out.print(heapAry[i] + ",");

		}
		
		System.out.print("\nNumber of swaps " + swapOptimal);

		for(int i = 0; i < 10; i++)
		{
			deleteMax();
		}

		System.out.print("\nHeap after 10 removals: ");
		for(int i = 0; i < 10; i++)
		{
			System.out.print(heapAry[i] + ",");
		}

		System.out.println("\n");
	}
}
