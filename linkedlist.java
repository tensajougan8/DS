package lb4;

import java.util.LinkedList;
import java.util.Scanner;

public class linkedlist {
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
    
public void loop() {
	Node last=head;
	while(last.next != null) {
		last=last.next;
	}
	last.next=head.next;
}
public void loopdetect() {
	
	Node temp1 = head;
	Node temp2 = head;
	while(temp2.next.next != null) {
		temp1=temp1.next;
        temp2=temp2.next.next;
        if(temp1==temp2){
            System.out.println("loop detected");
            removeloop(temp1);
            break;
        }
	}
}
public void removeloop(Node slow) {
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		linkedlist list = new linkedlist();
		 int n,i,m,c=0; 
		 Scanner input = new Scanner(System.in);
         System.out.println("how many numbers you want to insert in linked list"); 
         n=input.nextInt();; 
         System.out.println("Enter numricals in linked list "); 
         for (i=0;i<n;i++) 
             { 
                m = input.nextInt(); 
                 list.insert (m); 
             }
         list.loop();
         list.loopdetect();
         
         

	}

}
