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
public class BigDecimalProba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String numStr = "1.23E9";
        //numStr = "5 200 123,00";
        System.out.println(numStr); 
        
        //BigDecimal bd = new BigDecimal(numStr);
        //System.out.println(bd.toPlainString());
        //System.out.println(bd);
        numStr = numStr.replaceAll(" ", "").replaceAll(",", ".");

        //numStr = "";
        BigDecimal bd2 = BigDecimal.valueOf(Double.parseDouble(numStr));
        System.out.println(bd2.toPlainString());
        System.out.println(bd2);
    }
    

}
