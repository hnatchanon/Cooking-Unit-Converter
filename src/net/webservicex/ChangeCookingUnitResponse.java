
package net.webservicex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ChangeCookingUnitResult" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "changeCookingUnitResult"
})
@XmlRootElement(name = "ChangeCookingUnitResponse")
public class ChangeCookingUnitResponse {

    @XmlElement(name = "ChangeCookingUnitResult")
    protected double changeCookingUnitResult;

    /**
     * Gets the value of the changeCookingUnitResult property.
     * 
     */
    public double getChangeCookingUnitResult() {
        return changeCookingUnitResult;
    }

    /**
     * Sets the value of the changeCookingUnitResult property.
     * 
     */
    public void setChangeCookingUnitResult(double value) {
        this.changeCookingUnitResult = value;
    }

}
