/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprime;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Testprime {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        // TODO code application logic here
       int i,j,rows,cols;
		        Scanner h=new Scanner(System.in); 
		        System.out.println("Number of rows:");
		        rows=h.nextInt();		        
		        int matrix[] = new int[rows];
                        
                        Integer matrixf[] = new Integer[rows];
                        int matrixm[] = new int[rows];
		        System.out.println("Enter elements");		      
		        for(i=0; i<rows; i++)
		       {
		          
                               matrix[i] = h.nextInt(); 
                              if (matrix[i]==0)
                               {
                                   matrixf[i] = h.nextInt();                                                             
                                   
                               }
                               else
                               {
                                   matrixm[i]=h.nextInt();
                               }
                                   
		           
		       }
		           Arrays.sort(matrixf, Collections.reverseOrder()); 
                          
                               System.out.printf(Arrays.toString(matrixf)); 
                           
      
                          
                           
                          System.out.printf(Arrays.toString(matrixm)); 
                                                    
                        
                         
    }
    
}
