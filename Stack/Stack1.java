/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication17;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Student
 */
public class Stack1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int min=0; 
        Stack<Integer> stk = new Stack();
         Stack<Integer> track = new Stack();
         Scanner input = new Scanner(System.in);
         System.out.println("Enter n number of values");
        int number = input.nextInt();
        for(int i=0; i<number;i++){
            System.out.println("Enter query valuess");
        int qu = input.nextInt();
        switch (qu) {
                case 1:
                    int a = input.nextInt();
                    stk.push(a);
                    if(track.isEmpty())
                    {
                        
                        track.push(a);
                    } 
                    else
                    {
                        if(a>track.peek())
                        {
                            track.push(a);
                        }                    
                    }    
                  
                  break;
                case 2:
                    
                    int b = stk.pop();
                    if(b==track.peek())
                    {
                        track.pop();
                    }
                  System.out.println("The poped value is" +b);
                  break;
                case 3:
                    
                  System.out.println("The maximun is" +track.peek());
                  break;
                }
        // TODO code application logic here
    }
        
     System.out.println("Stack => " + track);
}
}
