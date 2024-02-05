/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package text;

/**
 *
 * @author laszlo.nagy
 */
public class SplitErrorTest {
    
    public static void main(String[] args) {
        System.out.println("Split Error Test!");
        String strTradeFilters = null; //"aaa, bbb";
        String[] tradeFilters = ((String) strTradeFilters).split(", ");

        for (String filter : tradeFilters) {
            System.out.println("Trade filter element: "+filter);
        }


    }
    
    
    
}
