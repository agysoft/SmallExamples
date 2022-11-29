/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.util.Random;

/**
 *
 * @author laszlo.nagy
 */



public class EnumProba {

    public enum SoundTypes  {
        VOWEL     ('a','e'), 
        S_VOWEL   ('y'),  
        CONSONANT ('b');   


        private final char[] chs;

        SoundTypes(char ...chs) {
            this.chs = chs;
        }
    
        public boolean is(char c) {
            return String.valueOf(chs).contains(String.valueOf(c));
        }
    
    }   
    
    public static void main(String[] args) {
        Random rand = new Random(47);
        for(int i = 0; i < 100; i++) {
            char c = (char)(rand.nextInt(26) + 'a');
 
            for (SoundTypes type : SoundTypes.values()) {
                if (type.is(c)) { 
                    System.out.println(c + ", " + c + ": " + type);
                }
            }
        }
   }

    
}
