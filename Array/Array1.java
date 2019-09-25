import java.util.Scanner;
//To find Pattern I in matrix
public class Array1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j,rows,cols,ch=0,cv=0,chb=0,cvb=0,cdf=0,cdb=0;
        Scanner h=new Scanner(System.in); 
        System.out.println("Number of rows:");
        rows=h.nextInt();
        System.out.println("Number of col:");
        cols=h.nextInt();
        char matrix[][] = new char[rows][cols];
        System.out.println("Enter elements");
        for(i=0; i<rows; i++)
       {
           for(j=0; j<cols; j++)//Enter characters
           {
               matrix[i][j] = h.next().charAt(0);
           }
       }
        
        for(i=0; i<rows; i++)//horizontal forward count start
        {
            for(j=0; j<cols; j++)
            {
                
                	if(j+3<cols && matrix[i][j]=='s' && matrix[i][j+1] == 'a' && matrix[i][j+2] == 'b' && matrix[i][j+3] == 'a')
                	{
                		ch++;
                	}
                
            }
        }//horizontal count end
        
        for(i=0; i<rows; i++)//vertical forward count start
        {
            for(j=0; j<cols; j++)
            {              
                	if(i+3<rows &&  matrix[i][j]=='s' && matrix[i+1][j] == 'a' && matrix[i+2][j] == 'b' && matrix[i+3][j] == 'a')
                	{
                		cv++;               	
                	}
             }
        }//vertical count end
        
        for(i=0; i<rows; i++)//horizontal backward count start
        {
            for(j=0; j<cols; j++)
            {
                
                	if(j-3>-1 && matrix[i][j]=='s' && matrix[i][j-1] == 'a' && matrix[i][j-2] == 'b' && matrix[i][j-3] == 'a')
                	{
                		chb++;
                	}
                
            }
        }//horizontal count end
        
        for(i=0; i<rows; i++)//vertical backward count start
        {
            for(j=0; j<cols; j++)
            {              
                	if(i-3>-1 &&  matrix[i][j]=='s' && matrix[i-1][j] == 'a' && matrix[i-2][j] == 'b' && matrix[i-3][j] == 'a')
                	{
                		cvb++;               	
                	}
             }
        }//vertical count end
        
        for(i=0; i<rows; i++)//diagonal forward count start
        {
            for(j=0; j<cols; j++)
            {
                
                	if(j+3<cols && i+3<rows && matrix[i][j]=='s' && matrix[i+1][j+1] == 'a' && matrix[i+2][j+2] == 'b' && matrix[i+3][j+3] == 'a')
                	{
                		cdf++;
                	}
                
            }
        }//diagonal count end
        
        for(i=0; i<rows; i++)//diagonal backward count start
        {
            for(j=0; j<cols; j++)
            {
                
                	if(j-3>-1 && i-3>-1 && matrix[i][j]=='s' && matrix[i-1][j-1] == 'a' && matrix[i-2][j-2] == 'b' && matrix[i-3][j-3] == 'a')
                	{
                		cdb++;
                	}
                
            }
        }//diagonal count end
        
         for(i=0; i<rows; i++)
       {
           for(j=0; j<cols; j++)
           {
               System.out.print(matrix[i][j]+ "  ");
           }
           System.out.println();
       }
         System.out.println(ch);
         System.out.println(cv);
         System.out.println(chb);
         System.out.println(cvb);
         System.out.println(cdf);
         System.out.println(cdb);

	}

}
