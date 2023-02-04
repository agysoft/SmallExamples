/*
 *
 */
package text;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laszlo.nagy
 */
public class StringListProba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<String> stringList = new ArrayList<String>();
        
        stringList.add("VERIFIED");
        System.out.println(stringList.toString());
        System.out.println(stringList.toString().substring(1, stringList.toString().length() -1));
        stringList.add("VERIFIED");
        System.out.println(stringList.toString());
        System.out.println(stringList.toString().substring(1, stringList.toString().length() -1));
        
        
        
    }
    

}
