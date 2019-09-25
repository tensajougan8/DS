//Program to rotate the nodes from last to first
import java.util.InputMismatchException;
import java.util.Scanner;

public class Rotatelist {
	Node head;// head of list 
	Node link;
	  
    /* Node Class */
    class Node 
    { 
        int data; 
        Node next; 
           
        // Constructor to create a new node 
        Node(int d) 
        {
        	data = d; 
        	next = null; 
        	} 
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
    
    public void rotate(int b)
    {
    	Node a = head;
    	Node x = null;
    	
    	for(int i=0;i<b;i++)
    	{
	    	while(a.next!=null)
	    	{
	    		x = a;
	    		a = a.next;
	    	}
	    	x.next = null;
	    	a.next = head;
	    	head = a;	    	
    	}
    }
    	
    
    public void print() {
    	Node curr = head;
    	while (curr != null)
    	{
    		System.out.println("node:" +curr.data);
    		curr = curr.next;
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rotatelist list = new Rotatelist();
		int n,i,m,c=0; 
		boolean st = false;
		Scanner input = new Scanner(System.in);
		while(!st)
		{
			try {
				System.out.println("Press : 1 :: To insert in list"); 
				System.out.println("Press : 2 :: To rotate list"); 
				System.out.println("Press : 3 :: To print list"); 
				System.out.println("Press : 4 :: To stop"); 
		        n=input.nextInt();
		        switch (n) {
					case 1 : 
						System.out.println("Enter numricals in linked list "); 
						m = input.nextInt(); 
			            list.insert (m); 
			            break;
					case 2 :
						System.out.println("Enter number of rotations"); 
						m = input.nextInt(); 
						list.rotate(m);
						break;
					case 3 :
						System.out.println("Printing...."); 
						list.print();
						break;
					case 4 :
						System.out.println("Stoping.......");
						System.out.println("THANK YOU!!!!!");
						st = true;
						break;
					default :
						System.out.println("Choose correct number");
						break;
		        	}
			}
	        catch (InputMismatchException e)
			{
	        	System.out.println("Enter numericals");	
			}
		}
	}
}
		

