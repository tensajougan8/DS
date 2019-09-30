/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialnetwork;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class SocialNetwork {
    static HashMap<String, LinkedHashSet<String>> Database = new HashMap<String, LinkedHashSet<String>>();
    static String LoginName = "";
    static LinkedHashSet<String> friendSuggestion = new LinkedHashSet<String>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean Stop = false;
        boolean Input = false;
        Scanner input = new Scanner(System.in);
        try
        {
           
            while(!Stop)
            {
               System.out.println("Enter the names in pair:");
               System.out.println("Press 1 to stop");

               String Names = input.nextLine();
               if(Names.equals("1"))
               {
                   Stop = true;
               }
               else
               {
                 
                   String UserNames = Names.toLowerCase();
                   String[] Split = UserNames.split(",");
                    //inserting the values into the hashmap
                    
                    if(!Database.containsKey(Split[0])){
                        LinkedHashSet<String> values = new LinkedHashSet<String>();
                        Database.put(Split[0], values);
                        values.add(Split[1]);
                        Database.get(Split[0]).add(Split[1]);
                    }else{
                    Database.get(Split[0]).add(Split[1]);
                }

                    if(!Database.containsKey(Split[1])){
                        LinkedHashSet<String> values = new LinkedHashSet<String>();
                        Database.put(Split[1], values);
                        values.add(Split[0]);
                    }else{
                        Database.get(Split[1]).add(Split[0]);
                    }

            
               }
            }
             for(HashMap.Entry<String, LinkedHashSet<String>> entry : Database.entrySet())//Prints the hashmap
            {
                String key = entry.getKey();
                System.out.print(key+" : ");
                
                Iterator it = entry.getValue().iterator();//used to iterator to go through the hashset
                while(it.hasNext())
                    System.out.print(it.next() + " ");//prints eachh value of the hashset
                System.out.println();
            }
            try{
                while(!Input)
                {
                    System.out.println("Enter your user name");
                    String User = input.nextLine();
                    LoginName = User.toLowerCase();
                    if(Database.containsKey(LoginName))
                    {
                    System.out.println("Press 1 to see your Suggested friends names");
                    System.out.println("Press 2 to see your Friend chain");
                    int Function = input.nextInt();
                    switch (Function) 
                            { 
                                case 1: 
                                    SuggestFriends(); 
                                    break; 
                                case 2: 
                                    FriendsChain(); 
                                    break; 
                                default: 
                                    System.out.println("You have Entered the wrong input"); 
                                    break;  
                            }
                    Input = true;
                    }
                    else
                    {
                        System.out.println("Please check your User name");
                    }
                }
            }
            catch(InputMismatchException e)
            {
                 System.out.println("Use comma");
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Use comma , to separate two names ");
        }
    }
    public static void SuggestFriends(){
        friendSuggestion.clear();
        
        if(Database.containsKey(LoginName)){
            LinkedHashSet<String> friendList = Database.get(LoginName);
            Iterator<String> friendListit = friendList.iterator();
            while(friendListit.hasNext())
            {
                String friendName = friendListit.next();
                
                Iterator<String> friendListit2 = Database.get(friendName).iterator();
                while(friendListit2.hasNext())
                {
                    String friendFriendName = friendListit2.next(); 
                    if(!friendFriendName.equals(LoginName) && !friendName.equals(friendFriendName))
                    {
                        //remove entry where my name pops up in my friend's friend list
                        //if friendName is present in both list ie my friend list and my friend's friend list has same person dont include them in final string
                        friendSuggestion.add(friendFriendName);
                    }  
                }
            }
        }
        System.out.println("Your suggested friends are:");
        Iterator it = friendSuggestion.iterator();
        while(it.hasNext())
            System.out.print(it.next() + " ");
        System.out.println();
    }

    public static void FriendsChain() {
         //To change body of generated methods, choose Tools | Templates.
        LinkedHashSet<String> Chaining = Database.get(LoginName);
      
            Iterator<String> i = Chaining.iterator();

            while (i.hasNext()) {
               System.out.println(i.next() + " ");
            }
        
                
                 
    
    }
    
    
}
