/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prb2;

/**
 *
 * @author Student
 */
//Find the maximum possible height of the stacks such that all of the stacks are exactly the same height.
import java.util.Scanner;
import java.util.Stack;

public class Stack4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		int number,sum1=0,sum2=0,sum3=0;
		Stack<Integer> stk1 = new Stack();
		Stack<Integer> stk2 = new Stack();
		Stack<Integer> stk3 = new Stack();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter height of stacks");
	    int a[] = new int [3];
	    for(i=0; i<3;i++)
       	{
           a[i] = input.nextInt();            
       	}	    
	    for(i=0;i<a[0];i++)
	    	{
	    		number = input.nextInt();
	    		sum1=number+sum1;
	    		stk1.push(number);
	    		
	    	}
	    for(i=0;i<a[1];i++)
    	{
    		number = input.nextInt();
    		sum2=number+sum2;
    		stk2.push(number);
    		
    	}
	    for(i=0;i<a[2];i++)
    	{
    		number = input.nextInt();
    		sum3=number+sum3;
    		stk3.push(number);
    		
    	}
	   boolean equal = false;
           int flag=0;
            while(flag!=1)
           {
            
		if(sum1==sum2 && sum2==sum3)
                      {
                          flag=1;
                          System.out.println(""+sum1);
                      }
               if(sum1>sum2 && sum1>sum3) 
		    {
		        
                        
                        sum1=sum1-stk1.pop();
                        
		    	
		    }
                     if(sum2>sum1 && sum2>sum3) 
		    {
		    	
                        
                        sum2=sum2-stk2.pop();
                        
		    	
		    }
                      if(sum3>sum1 && sum3>sum2) 
		    {
		    	 
                        
                        sum3=sum3-stk3.pop();
                        
		    	
		    }
                      
                      
	    
           }
           System.out.println(""+sum1);

	}

}
