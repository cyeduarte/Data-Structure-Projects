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
 * Set: array-list implementation of set that has all the specific functions
 * such as add, delete, and contain. Grows larger as more elements are added and 
 * disregards duplicates
 *
 *Christopher Eduarte
 */

import java.util.ArrayList;

public class Set<V> implements SetInterface<V>
{
    ArrayList<Object> array = new ArrayList<Object>();
    private V value;
    
    public Set()
    {
        value = null;
    }
    
    public void setValue(V value)
    {
        this.value = value;
    }
    
    /*
    *Returns the size of the array
    *@param none
    *   no value is neded
    *@precondition
    *      none
    *@return
    *   the length of the array
    */
    public int size()
    {
        return array.size();
    }
    
    /*
    *Adds the item into the array
    *@param item
    *   item is an element of the set
    *@precondition
    *   no duplicates and the value cannot be null
    *@return 
    *   none
    */
    public void add(V item)
    {
        
           for(int i = 0; i < array.size(); i++)
           {
               //ignore duplicate if value already exists
               if(isEmpty())
               {
                   array.add(item);
               }
               
               if(array.get(i).equals(item)) 
               {
                      //do nothing
               }
               else
               {
                   array.add(item);
               }
               
           }
        
    }
    
    /*
    *   Removes the item from the list if it is found
    *   @param item
    *       item is a element of the set
    *   @precondition
    *       the item cannot be null
    *   @return
    *       none
    */
    public void remove(V item)
    {
        for(int i = 0; i < array.size(); i++)
        {
            if(array.get(i).equals(item))
            {
                array.remove(item);
            }
        }
    }
    
    /*
    *    Determines whehter the value is in the list
    *    @param: value
    *       value is an element in the set
    *    @precondition:
    *       the value is not null
    *    @returns a true if the value is in the array.
    *    otherwise, returns a false 
    */
    public boolean contains(V value)
    {
        boolean contains = false;
        int count = 0;
        
        if(value == null)
        {
            //do nothing
        }
        else
        {
            
            for(int i = 0; i < array.size(); i++)
            {
                if(array.get(i).equals(value))
                {
                    contains = true;
                }
                else
                {
                     contains = false;
                }
            }
        }
        
        count++;
        
        return contains;
    }
    
    /*
        Determines whether the list is empty
        @param: no arguement
        The method returns true if the size of the array is zero
        Otherwise, it returns a false
        @return 
            true if there is no elements in the array
            false if there are elements
    */
    public boolean isEmpty()
    {
        if(array.size() == 0)
        {    

            return true;
        }
        else
        {
            return false;
        }
    }

}
