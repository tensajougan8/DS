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
public class Prb2 {
  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Stack<Character> stk = new Stack();
         Stack<Character> track = new Stack();
         Scanner input = new Scanner(System.in);
         System.out.println("Enter n number of values");
        int number = input.nextInt();
        char c[]= new char[100];
        String[] a=new String[number];
        for(int i=0; i<number;i++)
        {
            a[i] = input.nextLine();            
        }
        char ch;
        for(int i=0; i<number;i++)
        {
            String g=a[i];
            for(int j=0;j<g.length();j++)
                {
                     ch=g.charAt(j);
                     System.out.println("character"+ch);
                     
                
            if(ch=='{' || ch== '(' || ch=='[')
            {
                stk.push(ch);
                track.push(ch);
                System.out.println("chr"+ch);
                
            }
            else
            System.out.println("charr"+ch);
                if(ch==')' || ch=='}' || ch==']')
                {
                  if(ch==stk.peek())
                  {
                    System.out.println("charcter"+ch);    
                    stk.pop();
                  }
                   // System.out.println("No");
                    
                    else
                    {
                        System.out.println("No");
                        break;
                    }
                  break;
                }
                
                
            }
            }
            
        }
       
    }
    

