
//package edu.cpp.cs.cs241.prog_assgmnt_2;

/**
 * Programming Assignment #3
 *
 * Map: arraylist implemenation of the map. Adds both the key and its corresponding 
 * value to the map. Deletes when the element is found
 *
 *Christopher Eduarte
 *
 */

import java.util.ArrayList;



public class Map<K,V> implements MapInterface<K, V>
{
    private ArrayList<K> keyAry = new ArrayList<K>();
    private ArrayList<V> valAry = new ArrayList<V>();
    private K key;
    private V value;

    /*
        Initializes the key and value to null
        @param 
            none
        @precondition
            none
        @return 
            none
    */ 
    public Map()
    {;
        key = null;
        value = null;;
    }
    
    /*
        @param
            key is the value that sets the value into the array
        @result
            none
    */
    public void setKey(K key)
    {
        this.key = key;
        keyAry.add(this.key);
    }
   
    /*
        Returns the key
        @param
            none
        @return
            key is where the value is found
    */
    public K getKey()
    {   
        return key;
    }    

    /*
        Sets the value
        @param value
        @precondition
            value is null
        @return
            none
    */
    public void setValue(V value)
    {
        this.value = value; 
        valAry.add(this.value);
    }
    
    /*
        Returns the value
        @param
            none
        @precondition
            none
        @return
            value is an element in the map
    */
    public V getValue()
    {
        return value;
    }
    
    /*
        Returns the size of the array
        @param
            none
        @precondition
            none
        @return 
            size is the length of the array
    */
    public int size()
    {    

        return keyAry.size();
    }
    
    
    /*
        Adds the key and value into the map
        @param
            key is where the value is found
            value is an element in the map
        @preconditon
            value is not a duplicate
        @return
            none
    */
    public void add(K key, V value)
    {
        int count = 0;
        
        this.key = key;
        this.value = value;
        
        if(keyAry.isEmpty())
        {
            keyAry.add(key);
            valAry.add(value);
        }
        else
        {
             //for(int i = 0; i < ary.length; i++)
             //{
                if(keyAry.get(count).equals(value))
                {
                    //do nothing to the map
                }
                else
                {
                     keyAry.add(key);
                     valAry.add(value);
            
                 }
             //}
        } 
        
        count++;
            
    }
    
    /*
        Removes an item if the key is found and returns null if it 
        is note found
        @param
            key is where the value is found in the map
        @precondition
            none
        @return 
            key the key that is found and to be removed from
            the map     
    */
    public V remove(K key)
    {            

        
        for(int i = 0; i < keyAry.size(); i++)
        {
            if(keyAry.get(i).equals(key))
            {
                keyAry.remove(key);
                valAry.remove(i);
                
                return valAry.get(i);
            }
        }
        
        return null;
    }
    
    /*
    *If the key is found return the value in that specific index
    *@param
    *   key is the index where the value is placed
    *@precondition
    *   none
    *@result
    *   the value of that specific key is returned
    *   if not, then a null is returned
    */
    public V get(K key)
    {
        //has key
        for(int i = 0; i < keyAry.size(); i++)
        {
            if(keyAry.get(i).equals(key))
            {
               return valAry.get(i);
            }
            else
            {
                return null;
            }
        }
        
        return value;
    }
    
    /*
    *Determines whether the array is empty
    *@param
    *   none
    *@precondition
        none
    *@result
    *    if empty, return true
    *    else, return false
    *
    */
    public boolean isEmpty()
    {
        if(keyAry.size() == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
   
}
