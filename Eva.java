/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Student
 */
public class Eva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i,j,k;
        int y=0,z=0;
        Stack<Integer> stk = new Stack();
        Stack<Integer> track = new Stack();
        Queue<Integer> q = new LinkedList<>(); 
        Scanner input = new Scanner(System.in);
        boolean result = true;
        boolean result1 = true;
        System.out.println("Enter n number of integers you want to store");
        int n = input.nextInt();
        System.out.println("Enter values");
        for(i=0;i<n;i++)
        {
            int v = input.nextInt();
            stk.push(v);
            q.add(v);
        }
        while(stk.size()>1)//
        {
            j = stk.pop();
            k = stk.pop();
            if(j>k)
            {
             y++;
            }
            else
            {
                
                result1 = false;
                break;
                
            }
            
        }
        
        while(q.size()>1)
        {
            j = q.remove();
            k = q.remove();
            if(j>k)
            {
             z++;
            }
            else
            {
                result = false;
                break;
                
            }
            
        }
        if(result == true)
        {
          System.out.println("decresing order");  
        }
        else if(result1 == true)
        {
             System.out.println("incresing order");
        }
        else
        {
             System.out.println("no sequence");
        }
    }
    
}
