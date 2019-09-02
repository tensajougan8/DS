/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prb2;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Student
 */
//Stack push and popping

public class Stack5 {
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
                int ch;
		int number,sum1,sum2,sum3=0;
		Stack<Integer> stk1 = new Stack();
		Stack<Integer> stk2 = new Stack();
		 Scanner input = new Scanner(System.in);
                System.out.println("Enter number of stacks");
                number = input.nextInt();    
                System.out.println("Enter ");
                
                    for(i=0; i<number;i++)
                {
                       sum2 = input.nextInt(); 
                       stk1.push(sum2);
                }
                     for(i=0;i<number;i++)
	    	{
	    		sum1=stk1.pop();
                        System.out.println(""+sum1);
                        stk2.push(sum1);
	    		
	    	}
                     
                     int flag=0;
                     while(flag!=1)
                     {
                         System.out.println("Enter 1 to push, 2 to pop, 3 to stop");
                     ch = input.nextInt();
                     
                     if(ch ==1)
                     {
                        
                         sum2 = input.nextInt();
                         stk1.push(sum2);
                         System.out.println("the number pushed is"+sum2);
                     }
                     if(ch ==2)
                     {
                        int s= stk2.pop();
                         System.out.println("The popped is"+s);
                     }
                     if(stk2.isEmpty())
                     {
                         while(!stk1.isEmpty())
                         {
                             int s =stk1.pop();
                             stk2.push(s);
                         }
                     }
                     if(ch==3)
                     {
                         flag=1;
                     }
                     }
                     
    }
    
}
