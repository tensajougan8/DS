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
import javafx.scene.control.TextField;
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
    
    HashMap< String, Integer> supportmapof2 = new HashMap< String, Integer>(); //Hashmap for support of 2
    HashMap< String, Integer> supportmapof3 = new HashMap< String, Integer>(); //Hashmap for support of 3
    HashMap< String, Integer> combofreq = new HashMap< String, Integer>(); //Hashmap for freq of comb of 3
    
    public static void main(String[] args) {
        launch(args);
       
    }
    public void findsuppof2(ArrayList< String> linecombi, ArrayList< String> combof2) {
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
          
        for (i = 0; i < linecomb2.size(); i++) {
            for (int j = 0; j < combof2.size(); j++) {
                if (linecomb2.get(i).equals(combof2.get(j))) {
                    if (supportmapof2.containsKey(linecomb2.get(i))) { 
                        supportmapof2.put(linecomb2.get(i), supportmapof2.get(linecomb2.get(i))+ 1);      
                        
                    } else {
                        supportmapof2.put(linecomb2.get(i), 1); 

                    }

                } 

            }
            
        }

    }//Closing bracket for function

    void findsuppof3(ArrayList<String> linecombi, ArrayList<String> combof3) {
         for (int i = 0; i < combof3.size(); i++) {
			String is = combof3.get(i);
			int count = 0;
			for (int j = 0; j < linecombi.size(); j++) {
				String is2 = linecombi.get(j);

				if (is.contains(is2)) {
					count++;

				}
				if (count == 3) {
					if (supportmapof3.containsKey(is)) {
						supportmapof3.put(is, supportmapof3.get(is) + 1);
					} else {
						supportmapof3.put(is, 1);
					}
					break;
				}
			}
		}
        
    }
    
}
