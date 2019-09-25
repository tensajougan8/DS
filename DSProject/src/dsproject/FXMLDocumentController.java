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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

/**
 *
 * @author VEDANK
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private Button browseid;
    
    @FXML
    private Button supportid;
    
    @FXML
    private ListView filecontent;
    
    @FXML
    private ListView itemcontent;
    
    @FXML
    private ListView freqcontent;
    
    @FXML
    private ListView suppcontent;
    
    @FXML
    private TextField filepath;
    
    @FXML
    private Pane supportpane;
    
    @FXML
    public ObservableList<String> strlist = FXCollections.observableArrayList();
    
    @FXML
    public ObservableList<String> itemlist = FXCollections.observableArrayList();

    
    public void browsebutton(ActionEvent event) throws FileNotFoundException, IOException {
        
       filecontent.getItems().clear();
       filepath.clear();
       FileChooser fc=new FileChooser();
       File selectedFile=fc.showOpenDialog(null);
       
       String fname=selectedFile.getName();
       String fext="";
       int lastindex=fname.lastIndexOf(".");
       int p = Math.max(fname.lastIndexOf('/'),fname.lastIndexOf('\\'));
       
       if (lastindex > p) 
       {
            fext = fname.substring(lastindex+1);
       }
       
       if(fext.equals("txt"))
       {
           if(selectedFile!=null)
       {        
           String fpath=selectedFile.getAbsolutePath();
           filepath.setText(selectedFile.getAbsolutePath());
            System.out.println(fpath);  //print
            BufferedReader in = new BufferedReader(new FileReader(fpath));
            String str = in.readLine();
            while ((str = in.readLine()) != null) {
                System.out.println(str); //print
                strlist.add(str);
            }
             filecontent.setItems(strlist);
       }
       else{
           Alert invalalert=new Alert(AlertType.ERROR);  
           invalalert.setTitle("Error opening file");
           invalalert.setContentText("Could not find file");
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
        System.out.println("fileeee "+fname);
       
        if(strlist.isEmpty())
        {
            Alert invalalert=new Alert(AlertType.ERROR);  
           invalalert.setTitle("Error finding support");
           invalalert.setContentText("Please select a text file");
           invalalert.show();  
        }
        else
        {
//         itemcontent.getItems().clear();
//         freqcontent.getItems().clear();
//         suppcontent.getItems().clear();
         DSProject dsapp=new DSProject();
        int i=0,counttrans=0,freq=0;
        ArrayList< String> items=new ArrayList< String>();                  //Array for items 
        ArrayList< String> linecombi=new ArrayList< String>();              //Array for comb of line 
        ArrayList< String> combof2=new ArrayList< String>();              //Array for comb of 2 
        ArrayList< String> combof3=new ArrayList< String>();              //Array for comb of 3
        ArrayList< String> linecomb2 = new ArrayList< String>();            //Array for line comb os 2
        HashMap< String, Integer> freqmap = new HashMap< String, Integer>(); //Hashmap for items with freq
        HashMap< String, Integer> confmap = new HashMap< String, Integer>(); //Hashmap for confidence
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

            System.out.println("________ID__________");

            int ID = 0;
            String key;

            for (HashMap.Entry< String, Integer> entry : uniqueitem.entrySet()) {
                key = entry.getKey();
                ID = entry.getValue();
                System.out.println(key + " : " + ID);
            }
            
//            for(HashMap.Entry<String, Integer>entry: uniqueitem.entrySet())
//            {
//                String d=entry.getKey().toString()+" : "+entry.getValue();
//                itemlist.add(d);
//            }

             //itemcontent.setItems(itemlist);
             itemcontent.getItems().addAll(uniqueitem.entrySet());

            System.out.println();
            System.out.println("_______Occurance_________");

            int value = 0;

            for (HashMap.Entry< String, Integer> entry : freqmap.entrySet()) {
                key = entry.getKey();
                value = entry.getValue();
                System.out.println(key + " : " + value);
            }
            
            freqcontent.getItems().addAll(freqmap.entrySet());

            System.out.println();

            System.out.println("set: " + items);
            System.out.println("transactions: " + counttrans);

            i = 0;
            int ite = ID;
            int ite2 = ID - 1;
            int ite3 = ID - 2;
            

            for (i = 0; i < ite; i++) {
                for (int k = i + 1; k < ite; k++) {
                    combof2.add(items.get(i) + " " + items.get(k));
                }
            }

            System.out.println("comb of 2: " + combof2);

            for (i = 0; i < ite; i++) {
                for (int k = i + 1; k<ite; k++) {
                    for(int l=k+1;l<ite;l++)
                    {
                        if(!((items.get(k).equals(items.get(l)))))
                    combof3.add(items.get(i) + " " + items.get(k)+ " " + items.get(l));
                    }
                }
            }

            //System.out.println("comb of 333: " + combof3);

            BufferedReader inn = new BufferedReader(new FileReader(fname));

            String str1 = inn.readLine();
            while ((str1 = inn.readLine()) != null) {
                StringTokenizer st1 = new StringTokenizer(str1);

                st1.nextToken();
                String ar12 = st1.nextToken();
                st1 = new StringTokenizer(ar12, ",");
                while (st1.hasMoreTokens()) {
                    String item = st1.nextToken();
                    linecombi.add(item);
                }
                
                //System.out.println("linecombi" + linecombi);
                dsapp.arraycompare(linecombi, combof2);
                linecombi.clear();

            }
            inn.close();
         
            
            
            //support
        int ID1;
        float g=0;  
        HashMap< String, Integer> support = new HashMap< String, Integer>();
         
        for (HashMap.Entry< String, Integer> entry : dsapp.supportmap.entrySet()) { //map2
            key = entry.getKey();
            ID1 = entry.getValue();
           System.out.println(key + " : " + ID1);
            
            //System.out.println(ID1 + " support " + counttrans);
                g =(float)ID1/counttrans*100  ;
                // System.out.println(key + " support " + g);
                if(g>60)
                {
                    support.put(key,(int)g);
                     System.out.println(key + " >60 " + g);
                }

                    
        }
        
        suppcontent.getItems().addAll(support.entrySet());
       
        //conf
        int ID2;
        float ID3=0;
        int countmaps=0;
        for (HashMap.Entry< String, Integer> entry : freqmap.entrySet()) { //occurance deno
             for (HashMap.Entry< String, Integer> entry2 : dsapp.supportmap.entrySet()) //comb num  //map2
        { 
                String key1=entry.getKey();
                String key2=entry2.getKey();
                if(key2.contains(key1))
                {
                ID1 = entry.getValue();  
                ID2 = entry2.getValue();
                ID3=(float)ID2/ID1*100;
                if(ID3>60&&ID3<=100)
                {
                    
                    String item1 = entry2.getKey()+"=>"+entry.getKey();
                    confmap.put(item1, (int)ID3);
                      
                    
                }
                }
               // System.out.println("ID2/ID1=ID3:"+ID2+" "+ID1+" "+ID3);
                
                
        }             
            }
    
        
        
        
        for (HashMap.Entry< String, Integer> entry : confmap.entrySet()) {
            key = entry.getKey();
            ID1 = entry.getValue();
           System.out.println("confmap:"+key + " : " + ID1);
        }

        }
        catch (IOException e) {
            

        }
        }
        
        
         //catch close
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
