/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;


/**
 *
 * @author laszlo.nagy
 */
public class IFKiertekeles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Start If kiértékelés");
        if (false || (true || true) && false) {
        //if ("valami".equals(null)) {
            System.out.println("Az állítás IGAZ!");
        } else {
            System.out.println("Az állítás HAMIS!!!");
        }
            
        System.out.println("Start If kiértékelés 2.");
        
        if ( false || false && true ){
        //if ("valami".equals(null)) {
            System.out.println("Az állítás IGAZ!");
        } else {
            System.out.println("Az állítás HAMIS!!!");
        }
        
        System.out.println("Start If kiértékelés 3.");
        
        if ( false || false && true ){
        //if ("valami".equals(null)) {
            System.out.println("Az állítás IGAZ!");
        } else {
            System.out.println("Az állítás HAMIS!!!");
        }
        
    }
    

}
