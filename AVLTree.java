/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl.tree;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author MScIT19
 */
public class AVLTree {
   static class Node //create nodes
   { 
        int key; 
        Node left, right; 
  
        public Node(int item)
        { 
            key = item; 
            left = right = null; 
        } 
    } 
   public static Node insert(Node r, int key)
   {
       Node new_node = new Node(key);
       Node x = r;
       Node y = null;
       
       while(x != null)
       {
           y = x;
           if(key>x.key)
           {
               x = x.right;
           }
           else
           {
               x = x.left;
           }
       }
       
        if (y == null)  
        {
            y = new_node;
        }  
        else if(key>y.key)
        {
            y.right = new_node;
        }
        else
        {
            y.left = new_node;
        }
       return y;
   }
   
   public static Node balance(Node r)
   {
    Node x = r;
    Node right = null;
    Node left = null;
    
    while(x.right != null || x.left != null)
    {
        x.right = right;
        x.left = left;
        if(right.right == null || right.left == null)
        {
            
        }
    }
   }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Node root = null;
         boolean in = false;
         Scanner input = new Scanner(System.in);
         System.out.println("Insert root node");
         while(in != true)
         {
            try{
            int r = input.nextInt();
            root = insert(root, r);
            in = true;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Not an integer");
                input.next();
            }
         }
         boolean swt = false;
         while(!swt)
         {
            try
            {
                System.out.println("1.Insert");
                System.out.println("2.Delete");
                System.out.println("3.Print");
                System.out.println("4.Stop");

                int n = input.nextInt();

                switch(n){
                case 1:
                    int v = input.nextInt();
                    insert(root,v);
                    balance(root);
                   break;
                    
               case 2: 
                   int d = input.nextInt();
                   break;
                   
               case 3: 

                   break;
                   
               case 4: 
                   swt = true;
                   break;
                   
               default: 
                   System.out.println("Incorrect input"); 
                   break; 
               } 
            }
            catch(InputMismatchException e)
            {
                System.out.println("Not an integer");
                input.next();
            }
         }
        }
    }
    

