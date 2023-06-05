
package text;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author laszlo.nagy
 */

@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "valami", propOrder = {"messageId","message_Id","valamikék"})

@XmlRootElement(name = "CPR_ANSWER")
public class CPRLIQStatus {

    /**
     *
     */
    @XmlElement(name="Message_Id", required = true)
    protected BigDecimal message_Id;

    @XmlElement(name="MessageId", required = true)
    protected BigDecimal messageId;
    
    //@XmlElement(name="MessageId2", required = true)
    public BigDecimal getMessageId() {
        return messageId;
    }

    public void setMessageId(BigDecimal Id) {
        this.messageId = Id;
    }
    
    @XmlElement(name="Valami", required = true)
    public String getValamikék() {
        return "akármi más:"+message_Id;
    }

    
}
