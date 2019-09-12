import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ReadWord {

    public static void main(String[] args) {
    String ar1[];
    HashMap<String, Integer> map = new HashMap<String, Integer>();
         try {
        BufferedReader in = new BufferedReader(
                               new FileReader("D:\\tr.txt"));
        String str = in.readLine();
        
        while ((str = in.readLine())!= null) {
            //String[] ar =str.split(",");
            StringTokenizer st = new StringTokenizer(str);
            st.nextToken();
            String ar = st.nextToken();
            st = new StringTokenizer(ar,",");
            while(st.hasMoreTokens())
            {
                String item = st.nextToken();
                System.out.println(item);
                if(map.containsKey(item))
                {
                    map.put(item, map.get(item)+1);
                }
                else
                    map.put(item, 1);
            }
           
        }
        in.close();
        
        for(HashMap.Entry<String, Integer> entry : map.entrySet())
        {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key+" : "+value);
        }
        
    } catch (IOException e) {
        System.out.println("File error"); 
       
    }
         


    }
}