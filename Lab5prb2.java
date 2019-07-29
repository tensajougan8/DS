/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5prb2;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Lab5prb2 {
    Node head;// head of list 
	Node link;
	  
    /* Node Class */
    class Node 
    { 
        int data; 
        Node next; 
           
        // Constructor to create a new node 
        Node(int d) {data = d; next = null; } 
    } 
    public void insert (int a) {
    	Node ent = new Node(a); 
    	ent.next = null;
    	if (head == null) 
        { 
            head = ent; 
            link = ent;
            
        } 
    	else {
    		link.next=ent;
    		link=ent;    		
    	}
    }
    public void printList() 
        { 
            Node tnode = head; 
            while (tnode != null) 
            { 
                System.out.print(tnode.data+" "); 
                tnode = tnode.next; 
            } 
        } 
    public void rotate (int r,int f) {
        
        link=head;
       
            for(int i=0;i<r;i++)
            {
                int c=1;
                while(link.next!=null)
                {
                    link = link.next;
                    c++;
                }
                link.next=head;
                head=link;
                Node plink=head;
                while(c>0)
                {
                    
                    plink = plink.next;
                    c--;
                    
                }
               
                plink.next=null;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Lab5prb2 list = new Lab5prb2(); 
        int n,i,m,c; 
	 Scanner input = new Scanner(System.in);
         System.out.println("how many numbers you want to insert in linked list"); 
         n=input.nextInt();; 
         System.out.println("Enter numricals in linked list "); 
         for (i=0;i<n;i++) 
             { 
                m = input.nextInt(); 
                 list.insert (m); 
             }
         list.printList();
         System.out.println("Enter number of times you want to rotate");
         c=input.nextInt();
         list.rotate(c,n);
         list.printList();
    }
    
}
