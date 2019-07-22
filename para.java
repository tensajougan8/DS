/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author Student
 */
import java.util.Scanner;
import java.util.Stack;

public class para {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		Stack<Character> stk = new Stack();
                Stack<Character> track = new Stack();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter n number of values");
	    int number = input.nextInt();
	    int num=number+1;
	    String a[]=new String[num];
       for(i=0; i<num;i++)
       	{
           a[i] = input.nextLine();            
       	}
       char ch;
       for(i=0; i<num;i++)
       	{
           String g=a[i]; 
           OUTER_LOOP:
           for(int j=0;j<g.length();j++)
               {
                    ch=g.charAt(j); 
                    
               
		           if(ch=='{' || ch=='(' || ch=='[')
		           	{
		               stk.push(ch);     		               
		           	}
                           else
                           if(ch=='}' || ch==')' || ch==']')
		        	   {
		        		   track.push(ch); 
		        		   System.out.println(track);
                                           if(!stk.isEmpty()) {
                                               if(ch==']' && stk.peek()=='[' || ch=='}' && stk.peek()=='{' || ch==')' && stk.peek()=='(')
		        	       {
		        		   stk.pop();
                                       }
		        			   
		        			   
		        		   }
                                           
		        		  
		        	   }
                                           
		        	  
		        	   
		           
                        
           
               }
       while(!stk.isEmpty())
       {
          System.out.println("the opening brackets are"+stk);
          stk.pop();
       }
       	}
        }
}
