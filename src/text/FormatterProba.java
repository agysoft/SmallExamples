/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

import java.math.BigDecimal;
import java.util.Formatter;
import java.util.Locale;

/**
 *
 * @author laszlo.nagy
 */
public class FormatterProba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(Runtime.getRuntime().freeMemory());
        
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.ENGLISH);
        for (int i=0;i<10;i++) {
            for (int j=0;j<3;j++) {
                formatter.format("%1$04d", 500+j);
                formatter.format(" - ");
            //formatter.close();
            }
            System.out.println(formatter);
            sb.setLength(0);
        }
        System.out.println(Runtime.getRuntime().freeMemory());
	System.out.println(formatter.toString().length());
	System.out.println(formatter);
        
        
        
    }
    

}
