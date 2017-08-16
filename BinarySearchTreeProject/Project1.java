/**Christopher Eduarte
*  CS 241 Summer 2016 
*  Project 1 Project1.java
*  Description: Menu program where the user can add and remove node as well
*               as find the successor and predecessor
*/

import java.util.*;
public class Project1
{
	public static void main(String[] args)
	{
		char  option;
		BSTree  node = new BSTree();
		Integer[] ary  = new Integer[]{51,29, 68, 90, 36, 40, 22, 59, 44, 99,
			    	          77, 60, 27, 83, 15, 75, 3};
		int value;
		Scanner input = new Scanner(System.in);

		//System.out.print("Inserted values: ");
		for(int index = 0; index < ary.length; index++)
		{
			node.add(ary[index]);
		       //System.out.print(ary[index] + " ");
		}

		System.out.print("Preorder: ");			
		node.preorderPrint();
		System.out.print("\nInorder: ");
		node.inorderPrint();
		System.out.print("\nPostorder: \n");
		node.postorderPrint();
		System.out.print("\n");
			
		do
		{	
			System.out.println("\nCommand? Press H or h to see menu.");
			option = input.next().charAt(0);

			switch(option)
			{
			   case 'H':
			   case 'h':
				System.out.println(" I Insert a value\n" +
						   " D - Delete a value\n" +
						   " P- Find predecessor\n" +
						   " S Find successor\n" +
						   " E Exit the program\n" 
					  	+ " H Display this message");	
			
				break;
			   case 'I':
			   case 'i':
				System.out.println("Insert value: ");
				value = input.nextInt();
				node.add(value);
				node.inorderPrint();
				break;
			   case 'D':
			   case 'd':
				System.out.println("Delete value: ");
				value = input.nextInt();
				node.rm(value);
				node.inorderPrint();
				break;
			   case 'P':
			   case 'p':
			      	System.out.println("Find predecessor: ");
				value = input.nextInt();	
				node.findPredecessor(value);
				break;
			   case 'S':
			   case 's':
				System.out.println("Find successor: ");
				value = input.nextInt();
				node.findSuccessor(value);
				break;
			
			   case 'E': 
			   case 'e':
				System.out.println("Thanks for using the program.");
				break;
			   default:
				System.out.println("Entered wrong " + 
							"choice");
				break;
		       }
		}while(option != 'E' && option != 'e');
	}		
}
