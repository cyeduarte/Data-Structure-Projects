package edu.cpp.cs.cs241.prog_assgmnt_2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * CS 241: Data Structures and Algorithms II
 * Professor: Edwin Rodríguez
 *
 * Programming Assignment #3
 *
 * The project is an array based implementation of a set and a map.
 * The program tests the various functions and compares the running time
 * of the function between the hash based and array list based set and map.
 *
 *Christopher Eduarte
 */

import edu.cpp.cs.cs241.prog_assgmnt_2.Set;
import edu.cpp.cs.cs241.prog_assgmnt_2.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Random;



public class SetMap
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int sizeCount;
        HashSet<Integer> set = new HashSet<Integer>();
        HashMap<Integer, Integer> map  = new HashMap<Integer, Integer>();
        Set setList = new Set();
        Map mapList = new Map();
                
        Random rand = new Random();
        int size = 999999;
        
        long initialTime = System.currentTimeMillis();
        
        for(int i = 0;i < size;i++)
        {
           int randNum = rand.nextInt(1000000);
           //set.add(randNum);
           setList.add(randNum);
           //map.put(i, null);
           //mapList.add(i, null);
        }
        
        /*for(int i = 0; i < 99999; i++)
        {
            int randNum2 = rand.nextInt(100000);
            setList.contains(randNum2);
            //mapList.get(randNum2);
        }*/
         
       
        long finalTime = System.currentTimeMillis();
 
        
        System.out.println(finalTime - initialTime);
    }
    
}
