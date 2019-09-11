/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmanencoding;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author MScIT19
 */

public class HuffManEncoding {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        char a,b,p;
        String str,strl;
        int i,j = 0,count = 0;
        boolean ty= false;
        Scanner input = new Scanner(System.in);
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        PriorityQueue<hashcode> q =  new PriorityQueue<hashcode>(new IntComparator());
        str = input.nextLine();
       
        strl = str.toLowerCase();
        for(i=0;i<strl.length();i++)
        {
            p = str.charAt(i);
            if (map.containsKey(p))
            {
                j = map.get(p);
                j=j+1;
                map.put(p, j);
            }
            else
            {
                map.put(p,1);
            }
        }
       Set<Map.Entry<Character,Integer>> s = map.entrySet(); 
          
        for (Map.Entry<Character, Integer> it: s) 
        {
            hashcode h = new hashcode(it.getKey(),it.getValue());
            q.add(h);
        }
        
          while (!q.isEmpty()) { 
                System.out.println(q.poll()); 
                hashcode r=q.poll();
                hashcode t=q.poll();
                hashcode p1=new hashcode();
                p1.c='-';
                p1.freq = r.freq 
        }  
        
        
        
        
        
         
    }
    
}
