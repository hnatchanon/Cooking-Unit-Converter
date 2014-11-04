
package net.webservicex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="CookingValue" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fromCookingUnit" type="{http://www.webserviceX.NET/}Cookings"/>
 *         &lt;element name="toCookingUnit" type="{http://www.webserviceX.NET/}Cookings"/>
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
    "cookingValue",
    "fromCookingUnit",
    "toCookingUnit"
})
@XmlRootElement(name = "ChangeCookingUnit")
public class ChangeCookingUnit {

    @XmlElement(name = "CookingValue")
    protected double cookingValue;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Cookings fromCookingUnit;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Cookings toCookingUnit;

    /**
     * Gets the value of the cookingValue property.
     * 
     */
    public double getCookingValue() {
        return cookingValue;
    }

    /**
     * Sets the value of the cookingValue property.
     * 
     */
    public void setCookingValue(double value) {
        this.cookingValue = value;
    }

    /**
     * Gets the value of the fromCookingUnit property.
     * 
     * @return
     *     possible object is
     *     {@link Cookings }
     *     
     */
    public Cookings getFromCookingUnit() {
        return fromCookingUnit;
    }

    /**
     * Sets the value of the fromCookingUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cookings }
     *     
     */
    public void setFromCookingUnit(Cookings value) {
        this.fromCookingUnit = value;
    }

    /**
     * Gets the value of the toCookingUnit property.
     * 
     * @return
     *     possible object is
     *     {@link Cookings }
     *     
     */
    public Cookings getToCookingUnit() {
        return toCookingUnit;
    }

    /**
     * Sets the value of the toCookingUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cookings }
     *     
     */
    public void setToCookingUnit(Cookings value) {
        this.toCookingUnit = value;
    }

}
