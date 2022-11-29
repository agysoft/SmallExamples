/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

import java.math.BigDecimal;

/**
 *
 * @author laszlo.nagy
 */
public class InstanceOfProba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        String numStr = null; //"I ma a String";
        
        //System.out.println(numStr.length());
        if (numStr instanceof String) {
            System.out.println(numStr); 
        } else {
            System.out.println("Not String"); 
        }
        
    }
    

}

