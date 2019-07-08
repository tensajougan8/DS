import java.util.Scanner;
public class Valdo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * To change this license header, choose License Headers in Project Properties.
		 * To change this template file, choose Tools | Templates
		 * and open the template in the editor.
		 */
		    /**
		     * @param args the command line arguments
		     */
		  
		        int i,j,rows,cols;
		        Scanner h=new Scanner(System.in); 
		        System.out.println("Number of rows:");
		        rows=h.nextInt();
		        System.out.println("Number of cols:");
		        cols=h.nextInt();
		        int matrix[][] = new int[rows][cols];
		        System.out.println("Enter elements");		      
		        for(i=0; i<rows; i++)
		       {
		           for(j=0; j<cols; j++)
		           {
		               matrix[i][j] = h.nextInt();
		           }
		       }
		        
		         for(i=0; i<rows; i++)
		       {
		           for(j=0; j<cols; j++)
		           {
		               System.out.print(matrix[i][j]+ "  ");
		           }
		           System.out.println();
		       }
		         int c=0;
		         for(i=0; i<rows; i++)//second for loop
			       {
			           for(j=0; j<cols; j++)
			           {
			               if(matrix[i][j]==1)
			               {
			            	   j++;
			            	   if(matrix[i][j]==2)
			            	   {
			            		   j++;
			            		   c++;
			            		   break;
			            	   }
			               }
			               break;
			           }
			       }//closing of second for loop
		         System.out.print(c+ "  ");
		       
		        
		    }
		    
		}


