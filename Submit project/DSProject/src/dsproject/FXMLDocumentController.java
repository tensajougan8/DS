/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.StringTokenizer;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

/**
 *
 * @author VEDANK
 */
public class FXMLDocumentController implements Initializable {
    
    HashMap< String, Integer> support2 = new HashMap< String, Integer>(); //HashMap for Support of 2
    HashMap< String, Integer> support3 = new HashMap< String, Integer>(); //HashMap for Support of 3
    
    @FXML
    private Label label;   
    @FXML
    private Button browseid;  
    @FXML
    private Button supportid;   
    @FXML
    private Button predictid;      
    @FXML
    private ListView filecontent;   
    @FXML
    private ListView itemcontent;    
    @FXML
    private ListView freqcontent;    
    @FXML
    private ListView suppcontent;    
    @FXML
    private ListView confcontent;    
    @FXML
    private ListView predcontent;    
    @FXML
    private TextField filepath;    
    @FXML
    private TextField itemin;    
    @FXML
    private Pane predictpane;        
   
    @FXML
    public ObservableList<String> strlist = FXCollections.observableArrayList();    
    @FXML
    public ObservableList<String> itemlist = FXCollections.observableArrayList();
    @FXML
    public ObservableList<String> predictof2 = FXCollections.observableArrayList();
    
     ArrayList< String> items=new ArrayList< String>();                  //Array for items 

    public void browsebutton(ActionEvent event) throws FileNotFoundException, IOException {
        
       filecontent.getItems().clear();
       filepath.clear();
       FileChooser fc=new FileChooser();
       File selectedFile=fc.showOpenDialog(null);
       
       String fname=selectedFile.getName();
       String fext="";
       int lastindex=fname.lastIndexOf(".");
       int p = Math.max(fname.lastIndexOf('/'),fname.lastIndexOf('\\'));
       
       if(lastindex>p) 
       {
            fext = fname.substring(lastindex+1);
       }
       
       if(fext.equals("txt"))
       {
           if(selectedFile!=null)
       {  
         itemcontent.getItems().clear();
         freqcontent.getItems().clear();
         suppcontent.getItems().clear();
         confcontent.getItems().clear();
         predcontent.getItems().clear();
           
           String fpath=selectedFile.getAbsolutePath();
           filepath.setText(selectedFile.getAbsolutePath());
            BufferedReader in = new BufferedReader(new FileReader(fpath));
            String str = in.readLine();
            while ((str = in.readLine()) != null) {
                str=str.toLowerCase();
                strlist.add(str);
            }
             filecontent.setItems(strlist);
             
       }
       else{
           Alert invalalert=new Alert(AlertType.ERROR);  
           invalalert.setTitle("Error opening file");
           invalalert.setContentText("Could not find file");
           invalalert.show();  
       }
       }else{
           Alert invalalert=new Alert(AlertType.ERROR);  
           invalalert.setTitle("Error opening file");
           invalalert.setContentText("Please select a text file");
           invalalert.show();  
    }         
    }
    
     public void supportbutton(ActionEvent event) {
         
        String fname=filepath.getText();
       
        if(strlist.isEmpty())
        {
            Alert invalalert=new Alert(AlertType.ERROR);  
           invalalert.setTitle("Error finding support");
           invalalert.setContentText("Please select a text file");
           invalalert.show();  
        }
        else
        {
         itemcontent.getItems().clear();
         freqcontent.getItems().clear();
         suppcontent.getItems().clear();
         confcontent.getItems().clear();
         predcontent.getItems().clear();
         DSProject dsapp=new DSProject();
        int i=0,counttrans=0,freq=0;
       
        ArrayList< String> linecombi=new ArrayList< String>();              //Array for comb of line 
        ArrayList< String> combof2=new ArrayList< String>();              //Array for comb of 2 
        ArrayList< String> combof3=new ArrayList< String>();              //Array for comb of 3
        HashMap< String, Integer> freqmap = new HashMap< String, Integer>(); //Hashmap for items with freq
        HashMap< String, Integer> confmapof2 = new HashMap< String, Integer>(); //Hashmap for confidence of 2
        HashMap< String, Integer> confmapof3 = new HashMap< String, Integer>(); //Hashmap for confidence of 3
        LinkedHashMap< String, Integer> uniqueitem = new LinkedHashMap< String, Integer>(); //Hashmap for unique items 
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(fname));

            String str = in.readLine();
            while ((str = in.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(str);

                st.nextToken();
                String ar = st.nextToken();
                st = new StringTokenizer(ar, ",");
                while (st.hasMoreTokens()) {
                    String item = st.nextToken();
                    item=item.toLowerCase();
                    if (uniqueitem.containsKey(item)) {
                        freqmap.put(item, freqmap.get(item) + 1);
                    } else {
                        uniqueitem.put(item, i + 1);
                        freqmap.put(item, 1);
                        items.add(item);
                        i++;
                    }
                }
                counttrans++;
            }
            in.close();
            int ID = 0;
            String key;

            for (HashMap.Entry< String, Integer> entry : uniqueitem.entrySet()) {
                key = entry.getKey();
                ID = entry.getValue();
            }
            
            for(HashMap.Entry<String, Integer>entry: uniqueitem.entrySet())
            {
                String d=entry.getKey();
                itemlist.add(d);
            }
          
             itemcontent.getItems().addAll(uniqueitem.entrySet());

            int value = 0;

            for (HashMap.Entry< String, Integer> entry : freqmap.entrySet()) {
                key = entry.getKey();
                value = entry.getValue();
            }
            
            freqcontent.getItems().addAll(freqmap.entrySet());

            i = 0;
            int ite = ID;
            int ite2 = ID - 1;
            int ite3 = ID - 2;
            

            for (i = 0; i < ite; i++) {
                for (int k = i + 1; k < ite; k++) {
                    combof2.add(items.get(i) + " " + items.get(k));
                }
            }


            for (i = 0; i < ite; i++) {
                for (int k = i + 1; k<ite; k++) {
                    for(int l=k+1;l<ite;l++)
                    {
                        if(!((items.get(k).equals(items.get(l)))))
                    combof3.add(items.get(i) + " " + items.get(k)+ " " + items.get(l));
                    }
                }
            }

            BufferedReader inn = new BufferedReader(new FileReader(fname));

            String str1 = inn.readLine();
            while ((str1 = inn.readLine()) != null) {
                StringTokenizer st1 = new StringTokenizer(str1);

                st1.nextToken();
                String ar12 = st1.nextToken();
                st1 = new StringTokenizer(ar12, ",");
                while (st1.hasMoreTokens()) {
                    String item = st1.nextToken();
                    item=item.toLowerCase();
                    linecombi.add(item);
                }
                
                dsapp.findsuppof2(linecombi, combof2);
                dsapp.findsuppof3(linecombi, combof3);
                linecombi.clear();

            }
            inn.close();

            //support
        int ID1;
        float g=0;  
        
        for (HashMap.Entry< String, Integer> entry : dsapp.supportmapof2.entrySet()) { //map2
            key = entry.getKey();
            ID1 = entry.getValue();
            
                g =(float)ID1/counttrans*100  ;
                if(g>60)
                {
                    support2.put(key,(int)g);
                }

                    
        }
        
        for (HashMap.Entry<String, Integer> entry : dsapp.supportmapof3.entrySet()) {
				key = entry.getKey();
				ID1 = entry.getValue();
				g = (float) ID1 / counttrans * 100;
				if (g > 60) {
					support3.put(key, (int) g);
				}

			}
        
        suppcontent.getItems().addAll(support2.entrySet());
        suppcontent.getItems().addAll(support3.entrySet());
       
        //conf
        int ID2;
        float ID3=0;
        int countmaps=0;
        for (HashMap.Entry< String, Integer> entry : freqmap.entrySet()) { //occurance deno
             for (HashMap.Entry< String, Integer> entry2 : dsapp.supportmapof2.entrySet()) //comb num  //map2
        { 
                String key1=entry.getKey();
                String key2=entry2.getKey();
                if(key2.contains(key1))
                {
                ID1 = entry.getValue();  
                ID2 = entry2.getValue();
                String[] splitStr = key2.split("\\s+");
                ID3=(float)ID2/ID1*100;
                if(ID3>60&&ID3<=100)
                {
                 for (i = 0; i < splitStr.length; i++) {
                     if(key1.contains(splitStr[i])){
                         
                     }
                     else{
                         String item1 = entry.getKey() + "=>" + splitStr[i];
			 confmapof2.put(item1, (int) ID3);
                     }
                 }   
        
                }
                }
        }             
            }

        for (HashMap.Entry< String, Integer> entry : confmapof2.entrySet()) {
            key = entry.getKey();
            ID1 = entry.getValue();
        }

        for (HashMap.Entry<String, Integer> entry : dsapp.supportmapof3.entrySet()) { // occurance deno
            for (HashMap.Entry<String, Integer> entry2 : dsapp.supportmapof2.entrySet()) // comb num
		{
		String key1 = entry2.getKey();
		String key2 = entry.getKey();
		if (key2.contains(key1)) {
		ID1 = entry2.getValue();
		ID2 = entry.getValue();
                String[] splitStr = key2.split("\\s+");
		ID3 = (float) ID2 / ID1 * 100;
		if (ID3 >60 && ID3 <= 100) {
                    for (i = 0; i < splitStr.length; i++) {
                         if (key1.contains(splitStr[i])) {
					} 
                         else {
                             String item1 = entry2.getKey() + "=>" + entry.getKey();
                             confmapof3.put(item1, (int) ID3);
                         }
                    }
                    
                                            }
                                           }
		}
                        }
			for (HashMap.Entry<String, Integer> entry : confmapof3.entrySet()) {
				key = entry.getKey();
				ID1 = entry.getValue();
			}
                                               
        confcontent.getItems().addAll(confmapof2.entrySet());
        confcontent.getItems().addAll(confmapof3.entrySet());
 
       predictpane.setVisible(true);  
       itemin.setVisible(true); 
       predictid.setVisible(true);
       predcontent.setVisible(true);
   
        }
   
        catch (IOException e) {
        }
        }
   
    }
     
     public void predict2button(ActionEvent event) {
         
          try{
         String idcheck;
         idcheck=itemin.getText();
         predcontent.getItems().clear();
         
         if(idcheck.isEmpty()){
           Alert invalalert=new Alert(AlertType.ERROR);  
           invalalert.setTitle("Error finding prediction");
           invalalert.setContentText("Enter item ID");
           invalalert.show();  
          
         }else{
             
             
          int readid;
          readid=Integer.parseInt(itemin.getText())-1;
    		
		predict(items, readid);
		for (int i = 0; i < predictof2.size(); i++) {
		}
                predcontent.setItems(predictof2);
                }
          }
          catch (IndexOutOfBoundsException f) {
              
            Alert invalalert=new Alert(AlertType.ERROR);  
           invalalert.setTitle("Error in ID");
           invalalert.setContentText("Enter valid item ID");
           invalalert.show();  
				
			}
             catch(NumberFormatException e){
                 
           Alert invalalert=new Alert(AlertType.ERROR);  
           invalalert.setTitle("Error in ID");
           invalalert.setContentText("Enter valid item ID");
           invalalert.show(); 
          }
	
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        predictpane.setVisible(false);
        itemin.setVisible(false);
        predictid.setVisible(false);
        predcontent.setVisible(false);
       
        
    }    

    public void predict(ArrayList<String> items, int num) {
       String al = items.get(num);
		for (HashMap.Entry<String, Integer> entry : support2.entrySet()) {
			String key = entry.getKey();

			if (key.contains(al)) {
				String[] splitStr = key.split("\\s+");
				for (int i = 0; i < splitStr.length; i++)
					if (splitStr[i].equals(al) && splitStr[i].equals(al)) {

					} else {
						predictof2.add(splitStr[i]);
					}
			}
		}
    }
    
}
