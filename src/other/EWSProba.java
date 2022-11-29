/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

      
import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;

/**
 *
 * @author laszlo.nagy
 */
public class EWSProba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
            System.out.println("Start Sending email via Exchange WebServices Java API");
            
            ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2010_SP2);
            //ExchangeService service = new ExchangeService();
            ExchangeCredentials credentials = new WebCredentials("laszlo.nagy", "password");
            service.setCredentials(credentials);
        try {
            //service.setUrl(new URI("<ews_url>"));
            service.setUrl(new URI("https://valid_server/ews/Exchange.asmx"));   
            //service.autodiscoverUrl("laszlo.nagy@capsys.hu");
            
        } catch (Exception ex) {
            Logger.getLogger(EWSProba.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         System.out.println("Finished Sending email...");
    }
    

}
