package lb4;
import java.util.Scanner;
import java.util.Stack;
//To find the missing parenthisis in a string of brackets

public class Stack3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		Stack<Character> stk = new Stack();
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
                    System.out.println("u"+ch);
               
		           if(ch=='{' || ch=='(' || ch=='[')
		           	{
		               stk.push(ch);     		               
		           	}
		           else
		           {
		        	   if(ch==']' && stk.peek()=='[' || ch=='}' && stk.peek()=='{' || ch==')' && stk.peek()=='(')
		        	   {
		        		   stk.pop();
		        		   if(stk.isEmpty()) {
		        			   System.out.println("balanced");
		        			   
		        		   }
		        		   
		        	   }
		        	   else 
		        	   {
		        		   stk.clear(); 
		        		   System.out.println("unbalanced");
		        		   break OUTER_LOOP;
		        	   }
		        	   
		           }
		        	
		           }
           
               }
       	}
	}




