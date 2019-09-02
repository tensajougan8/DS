import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Next Prime number

public class Array2 {

	
		  static long nextprime(long n) 
		    { 
		      BigInteger b=new BigInteger(String.valueOf(n));
		      return Long.parseLong(b.nextProbablePrime().toString());
		    } 
		    
		    public static void main(String[] args) {
		        // TODO code application logic here
		        
		        int n,c,i,j,t=0;
		        
		        Scanner s=new Scanner(System.in);
		        System.out.println("Enter number of names:");
		        n=s.nextInt();
		        System.out.println("Enter number of char:"); 
		        c=s.nextInt();
		        String[] a=new String[n];
		        String b;
		        char[][] x=new char[n][c];
		        int[][] q=new int[n][c];
		        char [] m=new char[c*n];
		        long [] e=new long[c*n];
		        String[][] s1= new String[n][c];
		        
		        BigInteger[][] q2=new BigInteger[n][c];
		        BigInteger qq;
		        System.out.println("Enter names:");
		        
		        for(i=0;i<n;i++)
		        {
		            b=s.next();		            
		            a[i]=b.toUpperCase();
		            t=b.length();
		            Pattern p = Pattern.compile("[^A-Za-z0-9]");
		            Matcher o = p.matcher(b);
		            boolean tr = o.find();
		            if(b.length()>c || tr==true)
		            {
		            	System.out.println("More than"+c );
		            	i--;
		            }
		            if(tr==true)
		            {
		            	System.out.println("Special character added");
		            	i--;
		            }
		           
		        } 
		        if(t==c)
		        {
		         for(i=0;i<n;i++)
		             for(j=0;j<c;j++)
		        {
		             x[i][j]=a[i].charAt(j);
		        } 
		         
		          for(i=0;i<n;i++)
		             for(j=0;j<c;j++)
		        {
		            // System.out.println(x[i][j]); 
		        } 

		         for(i=0;i<n;i++)
		             for(j=0;j<c;j++)
		        {
		             q[i][j]=(int)x[i][j];
		            
		        } 
		         long[] p=new long[c*n];
		         int k=0;
		         
		            for(i=0;i<n;i++)
		             for(j=0;j<c;j++)
		           {
		           p[k]=q[i][j];
		           if(p[k]==89 || p[k]==90)
		           {
		        	   e[k]=67;
		        	   }
		        	   else 
		        	   {
		        		   //System.out.println(nextprime(p[k]));
				           e[k]=nextprime(p[k]);
		        	   }
		           
		           
		           
		           k++;
		        }
		          
		            for(i=0;i<c*n;i++)			             
			        {
			             m[i]=(char)e[i];
			             //System.out.println(m[i]);
			            
			        } 
		            
		           int l=0;
		           for(j=0;j<n;j++)
			            for(i=0;i<c;i++)
			            {
			            	 s1[j][i]=Character.toString(m[l]);
			            	 l++;
			            	 
			            }
		            
		           for(j=0;j<n;j++)
		            {
			            for(i=0;i<c;i++)
			            {
			            	System.out.print(s1[j][i]);
			            }
		              System.out.println(" ");
		            }
		        }
		        
		// TODO Auto-generated method stub
		            

	}

}
