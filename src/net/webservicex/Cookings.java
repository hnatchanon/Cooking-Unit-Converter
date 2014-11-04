
package net.webservicex;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Cookings.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Cookings">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="drop"/>
 *     &lt;enumeration value="dash"/>
 *     &lt;enumeration value="pinch"/>
 *     &lt;enumeration value="milliliterPerCC"/>
 *     &lt;enumeration value="deciliter"/>
 *     &lt;enumeration value="coffeeSpoon"/>
 *     &lt;enumeration value="fluidDram"/>
 *     &lt;enumeration value="teaspoonUS"/>
 *     &lt;enumeration value="teaspoonUK"/>
 *     &lt;enumeration value="tablespoonUS"/>
 *     &lt;enumeration value="tablespoonUK"/>
 *     &lt;enumeration value="fluidOunceUS"/>
 *     &lt;enumeration value="fluidOunceUK"/>
 *     &lt;enumeration value="cupUS"/>
 *     &lt;enumeration value="cubicInch"/>
 *     &lt;enumeration value="gillUS"/>
 *     &lt;enumeration value="gillUK"/>
 *     &lt;enumeration value="pintUS"/>
 *     &lt;enumeration value="pintUK"/>
 *     &lt;enumeration value="quartUS"/>
 *     &lt;enumeration value="liter"/>
 *     &lt;enumeration value="gallonUS"/>
 *     &lt;enumeration value="gallonUK"/>
 *     &lt;enumeration value="TwoPointFiveCan"/>
 *     &lt;enumeration value="TenCan"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Cookings")
@XmlEnum
public enum Cookings {

    @XmlEnumValue("drop")
    DROP("drop"),
    @XmlEnumValue("dash")
    DASH("dash"),
    @XmlEnumValue("pinch")
    PINCH("pinch"),
    @XmlEnumValue("milliliterPerCC")
    MILLILITER_PER_CC("milliliterPerCC"),
    @XmlEnumValue("deciliter")
    DECILITER("deciliter"),
    @XmlEnumValue("coffeeSpoon")
    COFFEE_SPOON("coffeeSpoon"),
    @XmlEnumValue("fluidDram")
    FLUID_DRAM("fluidDram"),
    @XmlEnumValue("teaspoonUS")
    TEASPOON_US("teaspoonUS"),
    @XmlEnumValue("teaspoonUK")
    TEASPOON_UK("teaspoonUK"),
    @XmlEnumValue("tablespoonUS")
    TABLESPOON_US("tablespoonUS"),
    @XmlEnumValue("tablespoonUK")
    TABLESPOON_UK("tablespoonUK"),
    @XmlEnumValue("fluidOunceUS")
    FLUID_OUNCE_US("fluidOunceUS"),
    @XmlEnumValue("fluidOunceUK")
    FLUID_OUNCE_UK("fluidOunceUK"),
    @XmlEnumValue("cupUS")
    CUP_US("cupUS"),
    @XmlEnumValue("cubicInch")
    CUBIC_INCH("cubicInch"),
    @XmlEnumValue("gillUS")
    GILL_US("gillUS"),
    @XmlEnumValue("gillUK")
    GILL_UK("gillUK"),
    @XmlEnumValue("pintUS")
    PINT_US("pintUS"),
    @XmlEnumValue("pintUK")
    PINT_UK("pintUK"),
    @XmlEnumValue("quartUS")
    QUART_US("quartUS"),
    @XmlEnumValue("liter")
    LITER("liter"),
    @XmlEnumValue("gallonUS")
    GALLON_US("gallonUS"),
    @XmlEnumValue("gallonUK")
    GALLON_UK("gallonUK"),
    @XmlEnumValue("TwoPointFiveCan")
    TWO_POINT_FIVE_CAN("TwoPointFiveCan"),
    @XmlEnumValue("TenCan")
    TEN_CAN("TenCan");
    private final String value;

    Cookings(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Cookings fromValue(String v) {
        for (Cookings c: Cookings.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
