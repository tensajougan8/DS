/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author VEDANK
 */
public class DSProject extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    
    HashMap< String, Integer> supportmap = new HashMap< String, Integer>(); //Hashmap for support
    
    public static void main(String[] args) {
        System.out.println("main order");
        launch(args);
       
    }
    public void arraycompare(ArrayList< String> linecombi, ArrayList< String> arr2) {
        // TODO Auto-generated method stub
        int i = 0;
        int count=0;
        
        
        int ID = 0;
        int ite = ID;

        ArrayList< String> linecomb2 = new ArrayList< String>();
        for (i = 0; i < linecombi.size(); i++) {
            for (int k = i+1; k < linecombi.size(); k++) {
                linecomb2.add(linecombi.get(i) + " " + linecombi.get(k));
               
            }
        }
        
        for (i = linecombi.size()-1; i > 0; i--) {
                for (int k = i - 1; k >= 0; k--) {
                    linecomb2.add(linecombi.get(i) + " " + linecombi.get(k));
                }
            }
        // System.out.println("comb new"+linecomb2);
          
        for (i = 0; i < linecomb2.size(); i++) {
            for (int j = 0; j < arr2.size(); j++) {
//                 System.out.println("comb 3"+linecomb2.get(i));
//                 System.out.println("arr2 "+arr2.get(j));
                if (linecomb2.get(i).equals(arr2.get(j))) {
                    //count++;
                   // System.out.println("comb 3"+linecomb2.get(i));
                   // System.out.println("arr2 "+arr2.get(j));
                    // System.out.println("count"+count);
                    if (supportmap.containsKey(linecomb2.get(i))) { //map2
                        supportmap.put(linecomb2.get(i), supportmap.get(linecomb2.get(i))+ 1);      //map2
                        
                    } else {
                        supportmap.put(linecomb2.get(i), 1); //map2

                    }

                } 

            }
            
        }
//        String key;
//        int ID1;
//
//        for (HashMap.Entry< String, Integer> entry : supportmap.entrySet()) {
//            key = entry.getKey();
//            ID1 = entry.getValue();
//            System.out.println(key + " : " + ID1);
//        }
        
 

    }//Closing bracket for function
    
}
