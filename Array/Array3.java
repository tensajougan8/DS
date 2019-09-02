/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patternsum;

/**
 *
 * @author 
 */
//To Find the largest sum in a pattern
import java.util.*;
public class Array3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] a=new int[6][6];
        int i,j,temp=0,max=0,min=Integer.MIN_VALUE;
        Scanner s=new Scanner(System.in);
        System.out.println("Enter elements:");
        for(i=0;i<6;i++)
            for(j=0;j<6;j++)
            {
             a[i][j]=s.nextInt();
            }
       /* min=a[1][1]+a[1][2]+a[1][3]+a[2][3]+a[3][1]+a[3][2]+a[3][3];
        if(min<=0)
        {
            max=min;
            
        }*/
        
        for(i=0;i<4;i++)
        {
             for(j=0;j<4;j++)
             {
                
                    temp=a[i][j]+a[i][j+1]+a[i][j+2]+a[i+1][j+1]+a[i+2][j]+a[i+2][j+1]+a[i+2][j+2];
                    System.out.println("ans"+temp);
                  min=Math.max(min, temp);
                }
        }  
             
        System.out.println(min);
        
    }
    
}
