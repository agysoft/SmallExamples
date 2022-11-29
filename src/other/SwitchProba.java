/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.math.BigDecimal;

/**
 *
 * @author laszlo.nagy
 */
public class SwitchProba {

    public static final String CCC = "ccc";
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        String config = "ccc";
        switch(config) {
            case "bbb": System.out.println("BBB"); break;
             
            case CCC: System.out.println("CCC"); break;
            
            case "ddd": System.out.println("DDD"); break;
            default: System.out.println("default");
        }
        
    }
    

}
