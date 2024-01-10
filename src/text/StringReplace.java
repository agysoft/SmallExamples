/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

/**
 * Csak egy kis módosítás a letöltés próbájához
 * @author laszlo.nagy
 */
public class StringReplace {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        String str = "OnlyForProduct&Book:ExternalREF";
        //Az & jel miatt volt érdekes
        System.out.println(str.replaceAll("OnlyForProduct&Book:","")); 
        
        System.out.println("NAV_K92".toLowerCase().replaceAll("_","")); 
        
    }
    
}
