/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stairs2;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Stairs2 {

      static int count;
    
    public static int count(int n)
    {
        if(n<=1)
        {
            return 1;
        }
        else
        {
            
             if(n==2)
             {
                 return count(n-1)+count(n-2);
             }
             else
             {
           return count(n-1)+count(n-2)+count(n-3); 
             }
           
        }
        
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int n,steps=0;
        Stairs2 st=new Stairs2();
        System.out.println("Enter number of stairs:");
        Scanner s=new Scanner(System.in);
        n=s.nextInt();
        System.out.println(count(n));
        
    }
    
}
