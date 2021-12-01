//
// Questo file è stato generato dall'Eclipse Implementation of JAXB, v2.3.3 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.11.23 alle 12:20:43 PM CET 
//


package com.ibm.customerdetails;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Classe Java per customer_details complex type.
 * 
 * &lt;p&gt;Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="customer_details"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="service_header"&amp;gt;
 *           &amp;lt;complexType&amp;gt;
 *             &amp;lt;complexContent&amp;gt;
 *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *                 &amp;lt;sequence&amp;gt;
 *                   &amp;lt;element name="brand" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *                 &amp;lt;/sequence&amp;gt;
 *               &amp;lt;/restriction&amp;gt;
 *             &amp;lt;/complexContent&amp;gt;
 *           &amp;lt;/complexType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="personal_details"&amp;gt;
 *           &amp;lt;complexType&amp;gt;
 *             &amp;lt;complexContent&amp;gt;
 *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *                 &amp;lt;sequence&amp;gt;
 *                   &amp;lt;element name="name_details"&amp;gt;
 *                     &amp;lt;complexType&amp;gt;
 *                       &amp;lt;complexContent&amp;gt;
 *                         &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *                           &amp;lt;sequence&amp;gt;
 *                             &amp;lt;element name="first_name"&amp;gt;
 *                               &amp;lt;simpleType&amp;gt;
 *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *                                   &amp;lt;maxLength value="25"/&amp;gt;
 *                                 &amp;lt;/restriction&amp;gt;
 *                               &amp;lt;/simpleType&amp;gt;
 *                             &amp;lt;/element&amp;gt;
 *                             &amp;lt;element name="last_name"&amp;gt;
 *                               &amp;lt;simpleType&amp;gt;
 *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *                                   &amp;lt;maxLength value="25"/&amp;gt;
 *                                 &amp;lt;/restriction&amp;gt;
 *                               &amp;lt;/simpleType&amp;gt;
 *                             &amp;lt;/element&amp;gt;
 *                           &amp;lt;/sequence&amp;gt;
 *                         &amp;lt;/restriction&amp;gt;
 *                       &amp;lt;/complexContent&amp;gt;
 *                     &amp;lt;/complexType&amp;gt;
 *                   &amp;lt;/element&amp;gt;
 *                   &amp;lt;element name="contact_details"&amp;gt;
 *                     &amp;lt;complexType&amp;gt;
 *                       &amp;lt;complexContent&amp;gt;
 *                         &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *                           &amp;lt;sequence&amp;gt;
 *                             &amp;lt;element name="phone"&amp;gt;
 *                               &amp;lt;simpleType&amp;gt;
 *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *                                   &amp;lt;pattern value="[0-9]{3}-[0-9]{7}"/&amp;gt;
 *                                 &amp;lt;/restriction&amp;gt;
 *                               &amp;lt;/simpleType&amp;gt;
 *                             &amp;lt;/element&amp;gt;
 *                             &amp;lt;element name="address"&amp;gt;
 *                               &amp;lt;simpleType&amp;gt;
 *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *                                   &amp;lt;maxLength value="100"/&amp;gt;
 *                                 &amp;lt;/restriction&amp;gt;
 *                               &amp;lt;/simpleType&amp;gt;
 *                             &amp;lt;/element&amp;gt;
 *                           &amp;lt;/sequence&amp;gt;
 *                         &amp;lt;/restriction&amp;gt;
 *                       &amp;lt;/complexContent&amp;gt;
 *                     &amp;lt;/complexType&amp;gt;
 *                   &amp;lt;/element&amp;gt;
 *                 &amp;lt;/sequence&amp;gt;
 *               &amp;lt;/restriction&amp;gt;
 *             &amp;lt;/complexContent&amp;gt;
 *           &amp;lt;/complexType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customer_details", propOrder = {
    "serviceHeader",
    "personalDetails"
})
public class CustomerDetails {

    @XmlElement(name = "service_header", required = true)
    protected CustomerDetails.ServiceHeader serviceHeader;
    @XmlElement(name = "personal_details", required = true)
    protected CustomerDetails.PersonalDetails personalDetails;

    /**
     * Recupera il valore della proprietà serviceHeader.
     * 
     * @return
     *     possible object is
     *     {@link CustomerDetails.ServiceHeader }
     *     
     */
    public CustomerDetails.ServiceHeader getServiceHeader() {
        return serviceHeader;
    }

    /**
     * Imposta il valore della proprietà serviceHeader.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerDetails.ServiceHeader }
     *     
     */
    public void setServiceHeader(CustomerDetails.ServiceHeader value) {
        this.serviceHeader = value;
    }

    /**
     * Recupera il valore della proprietà personalDetails.
     * 
     * @return
     *     possible object is
     *     {@link CustomerDetails.PersonalDetails }
     *     
     */
    public CustomerDetails.PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    /**
     * Imposta il valore della proprietà personalDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerDetails.PersonalDetails }
     *     
     */
    public void setPersonalDetails(CustomerDetails.PersonalDetails value) {
        this.personalDetails = value;
    }


    /**
     * &lt;p&gt;Classe Java per anonymous complex type.
     * 
     * &lt;p&gt;Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * &lt;pre&gt;
     * &amp;lt;complexType&amp;gt;
     *   &amp;lt;complexContent&amp;gt;
     *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
     *       &amp;lt;sequence&amp;gt;
     *         &amp;lt;element name="name_details"&amp;gt;
     *           &amp;lt;complexType&amp;gt;
     *             &amp;lt;complexContent&amp;gt;
     *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
     *                 &amp;lt;sequence&amp;gt;
     *                   &amp;lt;element name="first_name"&amp;gt;
     *                     &amp;lt;simpleType&amp;gt;
     *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
     *                         &amp;lt;maxLength value="25"/&amp;gt;
     *                       &amp;lt;/restriction&amp;gt;
     *                     &amp;lt;/simpleType&amp;gt;
     *                   &amp;lt;/element&amp;gt;
     *                   &amp;lt;element name="last_name"&amp;gt;
     *                     &amp;lt;simpleType&amp;gt;
     *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
     *                         &amp;lt;maxLength value="25"/&amp;gt;
     *                       &amp;lt;/restriction&amp;gt;
     *                     &amp;lt;/simpleType&amp;gt;
     *                   &amp;lt;/element&amp;gt;
     *                 &amp;lt;/sequence&amp;gt;
     *               &amp;lt;/restriction&amp;gt;
     *             &amp;lt;/complexContent&amp;gt;
     *           &amp;lt;/complexType&amp;gt;
     *         &amp;lt;/element&amp;gt;
     *         &amp;lt;element name="contact_details"&amp;gt;
     *           &amp;lt;complexType&amp;gt;
     *             &amp;lt;complexContent&amp;gt;
     *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
     *                 &amp;lt;sequence&amp;gt;
     *                   &amp;lt;element name="phone"&amp;gt;
     *                     &amp;lt;simpleType&amp;gt;
     *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
     *                         &amp;lt;pattern value="[0-9]{3}-[0-9]{7}"/&amp;gt;
     *                       &amp;lt;/restriction&amp;gt;
     *                     &amp;lt;/simpleType&amp;gt;
     *                   &amp;lt;/element&amp;gt;
     *                   &amp;lt;element name="address"&amp;gt;
     *                     &amp;lt;simpleType&amp;gt;
     *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
     *                         &amp;lt;maxLength value="100"/&amp;gt;
     *                       &amp;lt;/restriction&amp;gt;
     *                     &amp;lt;/simpleType&amp;gt;
     *                   &amp;lt;/element&amp;gt;
     *                 &amp;lt;/sequence&amp;gt;
     *               &amp;lt;/restriction&amp;gt;
     *             &amp;lt;/complexContent&amp;gt;
     *           &amp;lt;/complexType&amp;gt;
     *         &amp;lt;/element&amp;gt;
     *       &amp;lt;/sequence&amp;gt;
     *     &amp;lt;/restriction&amp;gt;
     *   &amp;lt;/complexContent&amp;gt;
     * &amp;lt;/complexType&amp;gt;
     * &lt;/pre&gt;
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "nameDetails",
        "contactDetails"
    })
    public static class PersonalDetails {

        @XmlElement(name = "name_details", required = true)
        protected CustomerDetails.PersonalDetails.NameDetails nameDetails;
        @XmlElement(name = "contact_details", required = true)
        protected CustomerDetails.PersonalDetails.ContactDetails contactDetails;

        /**
         * Recupera il valore della proprietà nameDetails.
         * 
         * @return
         *     possible object is
         *     {@link CustomerDetails.PersonalDetails.NameDetails }
         *     
         */
        public CustomerDetails.PersonalDetails.NameDetails getNameDetails() {
            return nameDetails;
        }

        /**
         * Imposta il valore della proprietà nameDetails.
         * 
         * @param value
         *     allowed object is
         *     {@link CustomerDetails.PersonalDetails.NameDetails }
         *     
         */
        public void setNameDetails(CustomerDetails.PersonalDetails.NameDetails value) {
            this.nameDetails = value;
        }

        /**
         * Recupera il valore della proprietà contactDetails.
         * 
         * @return
         *     possible object is
         *     {@link CustomerDetails.PersonalDetails.ContactDetails }
         *     
         */
        public CustomerDetails.PersonalDetails.ContactDetails getContactDetails() {
            return contactDetails;
        }

        /**
         * Imposta il valore della proprietà contactDetails.
         * 
         * @param value
         *     allowed object is
         *     {@link CustomerDetails.PersonalDetails.ContactDetails }
         *     
         */
        public void setContactDetails(CustomerDetails.PersonalDetails.ContactDetails value) {
            this.contactDetails = value;
        }


        /**
         * &lt;p&gt;Classe Java per anonymous complex type.
         * 
         * &lt;p&gt;Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * &lt;pre&gt;
         * &amp;lt;complexType&amp;gt;
         *   &amp;lt;complexContent&amp;gt;
         *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
         *       &amp;lt;sequence&amp;gt;
         *         &amp;lt;element name="phone"&amp;gt;
         *           &amp;lt;simpleType&amp;gt;
         *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
         *               &amp;lt;pattern value="[0-9]{3}-[0-9]{7}"/&amp;gt;
         *             &amp;lt;/restriction&amp;gt;
         *           &amp;lt;/simpleType&amp;gt;
         *         &amp;lt;/element&amp;gt;
         *         &amp;lt;element name="address"&amp;gt;
         *           &amp;lt;simpleType&amp;gt;
         *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
         *               &amp;lt;maxLength value="100"/&amp;gt;
         *             &amp;lt;/restriction&amp;gt;
         *           &amp;lt;/simpleType&amp;gt;
         *         &amp;lt;/element&amp;gt;
         *       &amp;lt;/sequence&amp;gt;
         *     &amp;lt;/restriction&amp;gt;
         *   &amp;lt;/complexContent&amp;gt;
         * &amp;lt;/complexType&amp;gt;
         * &lt;/pre&gt;
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "phone",
            "address"
        })
        public static class ContactDetails {

            @XmlElement(required = true)
            protected String phone;
            @XmlElement(required = true)
            protected String address;

            /**
             * Recupera il valore della proprietà phone.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPhone() {
                return phone;
            }

            /**
             * Imposta il valore della proprietà phone.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPhone(String value) {
                this.phone = value;
            }

            /**
             * Recupera il valore della proprietà address.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAddress() {
                return address;
            }

            /**
             * Imposta il valore della proprietà address.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAddress(String value) {
                this.address = value;
            }

        }


        /**
         * &lt;p&gt;Classe Java per anonymous complex type.
         * 
         * &lt;p&gt;Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * &lt;pre&gt;
         * &amp;lt;complexType&amp;gt;
         *   &amp;lt;complexContent&amp;gt;
         *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
         *       &amp;lt;sequence&amp;gt;
         *         &amp;lt;element name="first_name"&amp;gt;
         *           &amp;lt;simpleType&amp;gt;
         *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
         *               &amp;lt;maxLength value="25"/&amp;gt;
         *             &amp;lt;/restriction&amp;gt;
         *           &amp;lt;/simpleType&amp;gt;
         *         &amp;lt;/element&amp;gt;
         *         &amp;lt;element name="last_name"&amp;gt;
         *           &amp;lt;simpleType&amp;gt;
         *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
         *               &amp;lt;maxLength value="25"/&amp;gt;
         *             &amp;lt;/restriction&amp;gt;
         *           &amp;lt;/simpleType&amp;gt;
         *         &amp;lt;/element&amp;gt;
         *       &amp;lt;/sequence&amp;gt;
         *     &amp;lt;/restriction&amp;gt;
         *   &amp;lt;/complexContent&amp;gt;
         * &amp;lt;/complexType&amp;gt;
         * &lt;/pre&gt;
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "firstName",
            "lastName"
        })
        public static class NameDetails {

            @XmlElement(name = "first_name", required = true)
            protected String firstName;
            @XmlElement(name = "last_name", required = true)
            protected String lastName;

            /**
             * Recupera il valore della proprietà firstName.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFirstName() {
                return firstName;
            }

            /**
             * Imposta il valore della proprietà firstName.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFirstName(String value) {
                this.firstName = value;
            }

            /**
             * Recupera il valore della proprietà lastName.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLastName() {
                return lastName;
            }

            /**
             * Imposta il valore della proprietà lastName.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLastName(String value) {
                this.lastName = value;
            }

        }

    }


    /**
     * &lt;p&gt;Classe Java per anonymous complex type.
     * 
     * &lt;p&gt;Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * &lt;pre&gt;
     * &amp;lt;complexType&amp;gt;
     *   &amp;lt;complexContent&amp;gt;
     *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
     *       &amp;lt;sequence&amp;gt;
     *         &amp;lt;element name="brand" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
     *       &amp;lt;/sequence&amp;gt;
     *     &amp;lt;/restriction&amp;gt;
     *   &amp;lt;/complexContent&amp;gt;
     * &amp;lt;/complexType&amp;gt;
     * &lt;/pre&gt;
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "brand"
    })
    public static class ServiceHeader {

        @XmlElement(required = true)
        protected String brand;

        /**
         * Recupera il valore della proprietà brand.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBrand() {
            return brand;
        }

        /**
         * Imposta il valore della proprietà brand.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBrand(String value) {
            this.brand = value;
        }

    }

}
