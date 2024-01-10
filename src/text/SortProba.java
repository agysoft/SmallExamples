/*
 *
 */
package text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author laszlo.nagy
 */
public class SortProba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Sort Próba!");

        
        
        ArrayList<Long> numbers = new ArrayList<Long>();
        //Set<Long> numbers = new HashSet<>();
        numbers.add(Long.valueOf(200));
        numbers.add(Long.valueOf(100));
        numbers.add(Long.valueOf(400));
        numbers.add(Long.valueOf(500));
        //numbers.add(Long.valueOf(400));
        
        
        
        Collections.sort(numbers);
        
         for (Long element : numbers) {
            System.out.println("Element : "+element);
        }
        
       
        Map<String,ArrayList<Long>> map = new HashMap<String,ArrayList<Long>>();
        map.put("b",numbers);
        map.put("c",numbers);
        map.put("a",numbers);
        map.put("b",numbers);
        
        
        
        for (Map.Entry<String,ArrayList<Long>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
         
       
        
               
        
        
    }
    

}
