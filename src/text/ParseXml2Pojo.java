/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

import java.io.File;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author laszlo.nagy
 */
public class ParseXml2Pojo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JAXBException {
        System.out.println("Hello World!");
        
        String xmlSource = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\r\n"+
        "<CPR_ANSWER>"+"\r\n"+
        "  <MessageId>456</MessageId>"+"\r\n"+
        "  <Message_Id>123</Message_Id>"+"\r\n"+
        "</CPR_ANSWER>";
        //Az & jel miatt volt érdekes
        System.out.println(xmlSource); 
        
        JAXBContext jaxbContext = JAXBContext.newInstance( CPRLIQStatus.class );
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        //Overloaded methods to unmarshal from different xml sources
        //StringReader sr = new 
        CPRLIQStatus status = (CPRLIQStatus) jaxbUnmarshaller.unmarshal( new StringReader(xmlSource)  );

        System.out.println("Message Id is: "+status.getMessageId()); 
        
        //--------------------------------------------------------------------
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //StringBuilder out = new StringBuilder();
        File out = new File("status.xml");
        jaxbMarshaller.marshal(status, out);
        

        
        
        
    }
    
}
