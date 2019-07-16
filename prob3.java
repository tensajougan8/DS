package lb4;

import java.util.Scanner;
import java.util.Stack;

public class prob3 {

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
	    		System.out.println("1"+sum1);
	    	}
	    for(i=0;i<a[1];i++)
    	{
    		number = input.nextInt();
    		sum2=number+sum2;
    		stk2.push(number);
    		System.out.println("2"+sum2);
    	}
	    for(i=0;i<a[2];i++)
    	{
    		number = input.nextInt();
    		sum3=number+sum3;
    		stk3.push(number);
    		System.out.println("3"+sum3);
    	}
	    if(sum1==sum2 && sum2==sum3)
	    {
	    	System.out.println("The heights are equal");
	    }
	    else
	    {
		    if(sum1>=sum2 && sum1>=sum3) 
		    {
		    	sum1--;
		    	stk1.pop();
		    }
	    }

	}

}
