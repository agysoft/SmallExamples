/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

/**
 *
 * @author laszlo.nagy
 */
public class NullPrint {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String po = null;
        System.out.println(emptyInsteadOfNull(po+",null")); 
        
    }
    
    public static String emptyInsteadOfNull(String s) {
        return s == null ? "" : s.replaceAll("null", "");
        
    }
}
