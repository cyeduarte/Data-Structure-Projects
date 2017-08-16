/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cpp.cs.cs241.prog_assgmnt_2;

/**
 * CS 241: Data Structures and Algorithms II
 * Professor: Edwin Rodríguez
 *
 * Programming Assignment #3
 *
 * Hash Function 
 *
 *Christopher Eduarte
 */

public interface SetInterface <V>
{
     public void add(V value);
     public void remove(V value);
     public boolean contains(V value);
     public int size();
     public boolean isEmpty();
}
