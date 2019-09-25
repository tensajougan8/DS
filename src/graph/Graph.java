/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author MScIT19
 */
public class Graph {
    
    static HashMap<String, List<String>> map1 = new HashMap<String, List<String>>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean Stop = true;
        
        Scanner input = new Scanner(System.in);
        while (Stop) {
            String str = input.next();
            if (str.equals("1")) {
                Stop = false;
                break;
            } else {
                String[] ar = str.split(",");
                if (!map1.containsKey(ar[0])) {
                    List<String> val = new ArrayList<String>();
                    map1.put(ar[0], val);
                    val.add(ar[1]);
                } else {
                    map1.get(ar[0]).add(ar[1]);
                }
                
                if (!map1.containsKey(ar[1])) {
                    List<String> val = new ArrayList<String>();
                    map1.put(ar[1], val);
                    val.add(ar[0]);
                } else {
                    map1.get(ar[1]).add(ar[0]);
                }
            }
            
        }
        for (HashMap.Entry<String, List<String>> entry : map1.entrySet())//Prints the hashmap
        {
            String key = entry.getKey();
            System.out.print(key + " : ");
            
            Iterator it = entry.getValue().iterator();//used to iterator to go through the hashset
            while (it.hasNext()) {
                System.out.print(it.next() + " ");//prints eachh value of the hashset
            }
            System.out.println();
        }
        
    }
}
