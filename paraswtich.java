package lb4;

import java.util.Scanner;
import java.util.Stack;

public class paraswtich {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,m=0,k=0;
		Stack<Character> stk = new Stack();
        Stack<Character> track = new Stack();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter n number of values");
        char b[]=new char[20];
        char c[]=new char[20];
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
                    if(ch=='(' || ch=='[' || ch=='{') {
                    	stk.push(ch);
                    }
                    
                    else if(ch=='}' || ch==']' || ch==')')
                    {
                    	track.push(ch);
                    	if(!stk.isEmpty())
                    	{
	                    	if(ch==']' && stk.peek()=='[' || ch=='}' && stk.peek()=='{' || ch==')' && stk.peek()=='(')
	                        {
	                        	stk.pop();
	                        	track.pop();
	                        }
                    	}
                    }
               }
       	}
       System.out.println("the opening brackets are"+stk);
       System.out.println("the opening brackets are"+track);
       int count=0,count1=0;;
       while(!stk.isEmpty())
       {
          
    	  b[m]=stk.pop();
          count++;
          m++;
       }
       while(!track.isEmpty())
       {
          c[k]=track.pop();
          count1++;
          k++;
       }
       System.out.println(count  +count1);
       
       System.out.println(b);
       System.out.println(c);
	}

}
