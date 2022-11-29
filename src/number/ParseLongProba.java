/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number;

import java.math.BigDecimal;

/**
 *
 * @author laszlo.nagy
 */
public class ParseLongProba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String numStr = "31859191";
        numStr = "01201700000000182 ";
        //numStr = "C057JYM00001";
        System.out.println(numStr); 
        long l = Long.parseLong(numStr.trim());
        
        System.out.println("long: "+l);
    }
    

}
