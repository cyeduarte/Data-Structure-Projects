/**Christopher Eduarte
*  CS 241 Project2.java 
*  Summer 2016
*  Description: main program for the binary heap implmementation which tests
*               several arrays.
*/

import java.util.Scanner;
import java.util.Random;
import java.util.Collections;

public class Project2
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int  option;
		int ary[] = new int[100]; //array for insertion for option2
		int optimalAry[] = new int[100]; //option2 optimal array
		int ary2[] = new int[100]; //array for random insertion
		int optimalAry2[] = new int[100]; //array for random optimal
		Random rand = new Random();
		int ranNum;
                int count = 0;
		int size  = ary.length;
		final int numSets = 20;
		Heap heap1 = new Heap(size, ary); //heap for option 2
 	        Heap heap2 = new Heap(size, ary); //heap for option 1

		//array for 1-100
		for(int i = 0; i < 100; ++i)
		{
			ary[i] = i;
			optimalAry[i] = i;
			count++;
		}
		
		//shuffles the array and Prevents duplicates
		shuffle(ary2);

		//Arrays for option 2
		//Heap heap1 = new Heap(size, ary); 

  		//Arrays for option 1
		//Heap heap2 = new Heap(size, ary2);
		//Heap optHeap2 = new Heap(size, optimalAry2);}

		System.out.println("Please select how to test the program:");
		System.out.println("1) 20 sets of 100 randomly generated " 
					+ "integers");
		System.out.println("2) Fixed integer values 1-100 "
					+ "\n Enter choice: ");
		option = input.nextInt();
		
		if(option == 1)
		{	
			//for(int i = 0; i < 20; i++)
		        //{	
				for(int j = 0; j < 100; ++j)
				{
					ranNum = rand.nextInt(100);	
					ary2[j] = ranNum;
					optimalAry2[j] = ranNum;
					//Methods used to try to stop 
					//duplicates
					shuffle(ary2); 
					//shuffle(optimalAry2);
					heap2.insertion(ary2[j]);
					
				}
				//heap2.optimal(optimalAry2);
			//}

			heap2.optimal(optimalAry2);
			heap2.printOption1();
		}	
		else if(option == 2)
		{
			for(int i = 0; i < 100; i++)
			{
				heap1.insertion(i);
			}
			heap1.printInsert();
			heap1.optimal(optimalAry);		
			heap1.printOptimal();
		}

		else
		{
			System.out.println("Entered Wrong choice. "
						+ "Please choose again.");
		} 
	}

	public static void shuffle(int[] ary)
	{
		Random rand = new Random();
		for(int i = 0; i < ary.length; i++)
		{
			int index = rand.nextInt(ary.length);
			int index2 = rand.nextInt(ary.length);
			ary[index] = ary[index2];
			ary[index2] = ary[index];
			ary[index] = ary[index2];
		}
	}
}
