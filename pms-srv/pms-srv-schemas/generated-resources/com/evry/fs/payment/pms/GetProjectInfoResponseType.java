
package com.evry.fs.payment.pms;

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
 *         &lt;element ref="{http://evry.com/fs/payment/pms}ProjectType"/>
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
    "projectType"
})
@XmlRootElement(name = "getProjectInfoResponseType")
public class GetProjectInfoResponseType {

    @XmlElement(name = "ProjectType", required = true)
    protected ProjectType projectType;

    /**
     * Gets the value of the projectType property.
     * 
     * @return
     *     possible object is
     *     {@link ProjectType }
     *     
     */
    public ProjectType getProjectType() {
        return projectType;
    }

    /**
     * Sets the value of the projectType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProjectType }
     *     
     */
    public void setProjectType(ProjectType value) {
        this.projectType = value;
    }

}
