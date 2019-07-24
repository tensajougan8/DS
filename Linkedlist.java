/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Student
 */

   class Node
    {
         int data; 
         Node next; 
         Node(int d)
         {
             data=d;
         }
    }



public class Linkedlist {
    static Node head;
    static Node last;
   
     
  static void insert(int e)
  {
      
      Node new_node=new Node(e);
        if (head == null) { 
                head = new_node; 
            } 
            else { 
                // Else traverse till the last node 
                // and insert the new_node there 
                Node last = head; 
                while (last.next != null) { 
                    last = last.next; 
                } 

                // Insert the new_node at last node 
                last.next = new_node; 
  }
  }
   static void display() 
    { 
        Node temp = head; 
        while (temp != null)  
        { 
            System.out.print(temp.data + " "); 
            temp = temp.next; 
        } 
    } 
static void loopdetect()
{
    Node temp=head;
    Node temp1=head;
    {
        while(temp1 != null)
        {
            temp=temp.next;
            temp1=temp1.next.next;
            if(temp1==temp){
                System.out.println("loop detected");
                break;
            }
        }
    }
    
} 
static void createloop()
{ 
    head = new Node(50); 
        head.next = new Node(20); 
        head.next.next = new Node(15); 
        head.next.next.next = new Node(4); 
        head.next.next.next.next = new Node(10); 
         head.next.next.next.next.next = head; 
}
    public static void main(String[] args) {
        // TODO code application logic here
         LinkedList list = new LinkedList(); 
//         int data;
//         
//         Scanner input = new Scanner(System.in);
//         int n = input.nextInt();
//        
  
        
         
       
            createloop();
             
         
        
         
//          display();
          loopdetect();
          
         

          
          
            } 
    }
    

