/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author laszlo.nagy
 */
public class Binding{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Binding project!");
        String txt1 = "a b c d e f g h i j";
        String txt2 = "1 2 3 4 5 6 7 8 9 0";
        
        HashMap<String, String> dictionary = new HashMap<String, String>();
        dictionary.put("d", "6");
        
        String find1 = (String) dictionary.keySet().toArray()[0];//"e";
        String find2 = (String) dictionary.get(find1);           //"5";
        int found1 = txt1.indexOf(find1);
        System.out.println(found1); 
        int found2 = txt2.indexOf(find2);
        System.out.println(found2); 
        
        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
        if (found1>=0 && found2>=0) {
            result.put(found1, found2);
            result.put(found1+find1.length(), found2+find2.length());
        }
        
        System.out.println(result.toString());
        
        HashMap<String, String> txtResult = new HashMap<String, String>();
        Integer begin1 = 0;
        Integer begin2 = 0;
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            Integer end1 = entry.getKey();
            Integer end2 = entry.getValue();
            
            String subTxt1 = txt1.substring(begin1, end1);
            String subTxt2 = txt2.substring(begin2, end2);
            System.out.println(subTxt1.trim());
            System.out.println(subTxt2.trim());
            
            begin1 = end1;
            begin2 = end2;
        }
        String subTxt1 = txt1.substring(begin1, txt1.length());
        String subTxt2 = txt2.substring(begin2, txt2.length());
        System.out.println(subTxt1.trim());
        System.out.println(subTxt2.trim());    
        
    }
    

}
