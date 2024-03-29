/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package text;

import static java.lang.System.out;

/**
 *
 * @author laszlo.nagy
 */
public class Similarity {
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        System.out.println("kutya és kutya: "+similarText("Kutya","kutya")+"%"); //100%      
        System.out.println("mama és papa: "+similarText("mama","PAPA")+"%"); //50% 
        System.out.println("cipőfűző és kakas: "+similarText("cipőfűző","kakas")+"%"); //0% 

        System.out.println("Pisti<=>kimegy: "+similarWord("Pisti","kimegy")+"%"); //20%
        System.out.println("Pisti<=>kimegy: "+similarText("Pisti","kimegy")+"%"); //20%
        
        System.out.println("Piroska fát vág <==> piroska fát VÁG: "+similarText("Piroska fát vág","piroska fát VÁG")+"%");   //100%
        System.out.println("Zulu bemegy a konyhába <==> Pisti bemegy a konyhába: "+similarText("Zulu bemegy a konyhába","Pisti bemegy a konyhába")+"%");   //75%
        System.out.println("Bubu gyorsan fut <==> Macska keveset alszik: "+similarText("Bubu gyorsan fut","Macska keveset alszik")+"%");   //0%
        
        
        System.out.println("fát és vág: "+similarWord("fát","vág")+"%");  
     
        
        System.out.println("kutya és kutya: "+similarWord("Kutya","kutya")+"%"); //100%
        System.out.println("mama és papa: "+similarWord("mama","PAPA")+"%"); //50% 
        System.out.println("cipőfűző és kakas: "+similarWord("cipőfűző","kakas")+"%"); //0% 
        
        
    
        
        
        System.out.println("falak és fal: "+similarWord("falak","fal")+"%");  
     
        System.out.println("Internetről két random mondat: "+similarWord(
                "Ez a bicsaklás isteni ürügy arra, hogy az RTL megújuljon.",
                "Megdöbbentő döntést hozott a Momentum: nyilvánosan a terroristák mellé álltak")+"%");
        
        
        System.out.println("Internetről két random mondat: "+similarText(
                "Ez a bicsaklás isteni ürügy arra, hogy az RTL megújuljon.",
                "Megdöbbentő döntést hozott a Momentum: nyilvánosan a terroristák mellé álltak")+"%");
        
        System.out.println("Internetről két random mondat megcserélve: "+similarText(
                "Megdöbbentő döntést hozott a Momentum nyilvánosan a terroristák mellé álltak",
                "Ez a bicsaklás isteni ürügy arra hogy az RTL megújuljon.")+"%");
        
    }
    
    public static byte translationProbability(String a, String b) {
        return 0;
    }
    
    /**
     * 
     * @param a
     * @param b
     * @return százalékosan megadja, hogy két szöveg mennire egyezik 
     * 
     * példák: 
     * Piroska fát vág <==> piroska fát VÁG => 100%
     * Zulu bemegy a konyhába <==> Pisti bemegy a konyhába => 75%
     * Kutya gyorsan fut <==> Macska kevest alszik => 0%
     */
    public static byte similarText(String a, String b) {
        return (byte)((similarTextP(a,b)+similarTextP(b,a))/2);
    }
    
    public static byte similarTextP(String a, String b) {
        String[] as = a.split(" ");
        String[] bs = b.split(" ");
        byte maxI = (byte) as.length;
        byte maxJ = (byte) bs.length;
        int maxSum = 0;
        for (byte i=1; i<=maxI; i++) {
            int maxLocal = 0;
            for (byte j=1; j<=maxJ; j++) {
                byte lM = locationMultiplier(j,i,maxJ,maxI);
                byte sW = similarWord(bs[j-1],as[i-1]);
                byte lmsw = (byte) (lM*sW/100);
                //System.out.print(" "+lM+"x"+sW+"="+lmsw);
                if (lmsw > maxLocal) {
                    maxLocal = lmsw;
                }
            }
            //System.out.println();
            maxSum += maxLocal;
        }
        return (byte) (maxSum/maxI);
    }
    
    /**
     * 
     * @param a
     * @param b
     * @return százalékosan megadja, hogy két szó mennire egyezik
     */
    public static byte similarWord(String a, String b) {
        if (a.equals(b)) return 100;
        int la = a.length();
        int lb = b.length();
        
        if (la<lb) {
            String p=a; a=b; b=p;
            la = a.length();
            lb = b.length();
        }
        int maxssc = 0;
        int h=0; int ka=0; int kb=0;
        for (int i=1; i < la+lb; i++) {
            if (i<=lb) {
                h=i;
                ka=0;
                kb=lb-i;
            }
            if (i>lb && i<=la) {
                h=lb;
                ka=i-lb;
                kb=0;
            }
            if (i>la) {
                h=la+lb-i;
                ka=i-lb;
                kb=0;
            }

            //System.out.println("substring a: "+a.substring(ka, ka+h));
            //System.out.println("substring b: "+b.substring(kb, kb+h));
            
            //különböző betűsorok összehasonlítása
            int ssc =0;
            for (int j=0; j < h; j++) {
                ssc += similarChar(a.charAt(ka+j),b.charAt(kb+j));
            }
            
            if (ssc > maxssc) {
                maxssc = ssc;
            }
        }
        
        return (byte) (maxssc/((la+lb)/2));
    }
    
    /**
     * 
     * @param a
     * @param b
     * @return százalékosan megadja két betű mennyire egyezik
     */
    public static byte similarChar(char a, char b) {
        
        a = Character.toLowerCase(a);
        b = Character.toLowerCase(b);
        
        if (a == b) return 100;
        
        if (a == 'a' && b == 'á') return 25;
        if (a == 'e' && b == 'é') return 25;
        if (a == 'i' && b == 'í') return 25;
        if (a == 'o' && b == 'ó') return 25;
        if (a == 'ö' && b == 'ő') return 25;
        if (a == 'u' && b == 'ú') return 25;
        if (a == 'ü' && b == 'ű') return 25;
        
        if (a == 'á' && b == 'a') return 25;
        if (a == 'é' && b == 'e') return 25;
        if (a == 'í' && b == 'i') return 25;
        if (a == 'ó' && b == 'o') return 25;
        if (a == 'ő' && b == 'ö') return 25;
        if (a == 'ú' && b == 'u') return 25;
        if (a == 'ű' && b == 'ü') return 25;
        
        return 0;
    }
    
    /**
     * 
     * @param posA
     * @param posB
     * @param lenA
     * @param lenB
     * 
     * @return százalékosan megadja két betű mennyire egyezik
     */
    public static byte locationMultiplier(byte posA, byte posB, byte lenA, byte lenB) {
       
        float a = 1;
        if (lenA>1 && lenB>1){
            a = (float)(lenB-1)/(float)(lenA-1);
        }
        
        float b = 1-a;
        
        return (byte) Math.round(Math.max(0, 100-Math.abs((float)posA*a+b-posB)*10));
        
    }
    
    public static byte wordNum(String text) {
       
        return (byte) text.split(" ").length;
        
    }
}


