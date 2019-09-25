/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl.tree;

import static java.lang.Integer.max;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author MScIT19
 */

   class Node //create nodes
   { 
        int key; 
        Node left, right, parent ; 
        int height = 1;
  
        public Node(int item)
        { 
            key = item; 
            left = right = null; 
        } 
    }
public class AVLTree {
  
   public static Node insert(Node r, int key)
   {
       Node new_node = new Node(key);
       Node x = r;
       Node y = null;
       int balance;
       
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
        
        
        if(r != null){
            r.height = height(r); 
                 //Math.max(height(r.left), height(r.right)) + 1;
            balance = getBalance(r);
            System.out.println(+getBalance(r));
            System.out.println(+height(y));
        } else//y is the root which is yet to be assigned
        {
            y.height = height(y); 
                 //Math.max(height(r.left), height(r.right)) + 1;
            balance = getBalance(y);
            System.out.println(+getBalance(y));
            //System.out.println(+height(y));
        }
        
         
       return y;
   }
   
//  public static int height(Node r)
//   {
//       int left,height;
//       int right;
//       if(r == null)
//        {
//            return 0;
//        }
//        else
//        
//            left = height(r.left);
//            right = height(r.right);
//            height = max(left,right)+1;
//            balance(r,r.key);
//            System.out.println("Balance factor " +balance(r,r.key));
//            return height;
//    }
  public static int height (Node N) {
        if (N == null)
            return 0;
        return Math.max(height(N.left), height(N.right)) + 1;
    }

   public static int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }
//   public static Node rotate(Node x)
//   {
//       
//   }
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
                System.out.println("4.Height");
                System.out.println("5.Stop");

                int n = input.nextInt();

                switch(n){
                case 1:
                    int v = input.nextInt();
                    insert(root,v);
                   break;
                    
               case 2: 
                   int d = input.nextInt();
                   break;
                   
               case 3: 
                   System.out.println(+getBalance(root));
                   break;
                   
               case 4: 
                   System.out.println("The height of the tree is " +height(root));
                   break;
                   
                case 5: 
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
    

