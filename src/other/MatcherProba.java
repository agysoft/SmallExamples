/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.util.regex.Pattern;

/**
 *
 * @author laszlo.nagy
 */
public class MatcherProba {
    
    public static class LoggingRecord {//implements Serializable {
        public String message;
                
        LoggingRecord(String mes) {
            message = mes;
        }
        
        public String getMessage() {
		return message;
	}
    }
    
     public static void main(String[] args) {
        //LoggingRecord logrecord = new LoggingRecord("Check Sum Failures.");
        //LoggingRecord logrecord = new LoggingRecord("Valami");
        LoggingRecord logrecord = new LoggingRecord(null);
        Pattern patternCheckSum = Pattern.compile(".*Check Sum Failures.*", Pattern.MULTILINE);
	if (!patternCheckSum.matcher(logrecord.getMessage()).find()) { //"java.lang.NullPointerException" hiba amennyiben a null az üzenet
            System.out.println("Nincs :-(");
        } else {
            System.out.println("Megvan");
        }
                        
    }
    
  
    
}
