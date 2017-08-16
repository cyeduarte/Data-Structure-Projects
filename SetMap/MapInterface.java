/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cpp.cs.cs241.prog_assgmnt_2;

/**
 *
 * @author BlackDragon92
 */

public interface MapInterface <K,V>
{
     public void add(K key, V value);
     public V remove(K key);
     public V get(K key);
     public int size();
     public boolean isEmpty();

}
