//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.18 at 06:02:16 PM MEZ 
//


package se.kth.mobdev.ruontime.ws.gen;

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
 *       &lt;all>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="groupName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="meetingId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="authenticationHash" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "CheckinDetails")
public class CheckinDetails {

    @XmlElement(required = true)
    protected String userName;
    @XmlElement(required = true)
    protected String groupName;
    @XmlElement(required = true)
    protected String meetingId;
    @XmlElement(required = true)
    protected String authenticationHash;

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the groupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Sets the value of the groupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupName(String value) {
        this.groupName = value;
    }

    /**
     * Gets the value of the meetingId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeetingId() {
        return meetingId;
    }

    /**
     * Sets the value of the meetingId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeetingId(String value) {
        this.meetingId = value;
    }

    /**
     * Gets the value of the authenticationHash property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthenticationHash() {
        return authenticationHash;
    }

    /**
     * Sets the value of the authenticationHash property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthenticationHash(String value) {
        this.authenticationHash = value;
    }

}
