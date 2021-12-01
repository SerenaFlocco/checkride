//
// Questo file è stato generato dall'Eclipse Implementation of JAXB, v2.3.3 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.11.23 alle 12:20:43 PM CET 
//


package com.ibm.customerdetails;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ibm.customerdetails package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ibm.customerdetails
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CustomerDetails }
     * 
     */
    public CustomerDetails createCustomerDetails() {
        return new CustomerDetails();
    }

    /**
     * Create an instance of {@link CustomerDetails.PersonalDetails }
     * 
     */
    public CustomerDetails.PersonalDetails createCustomerDetailsPersonalDetails() {
        return new CustomerDetails.PersonalDetails();
    }

    /**
     * Create an instance of {@link CustomerDetailsRequest }
     * 
     */
    public CustomerDetailsRequest createCustomerDetailsRequest() {
        return new CustomerDetailsRequest();
    }

    /**
     * Create an instance of {@link CustomerDetailsResponse }
     * 
     */
    public CustomerDetailsResponse createCustomerDetailsResponse() {
        return new CustomerDetailsResponse();
    }

    /**
     * Create an instance of {@link CustomerDetails.ServiceHeader }
     * 
     */
    public CustomerDetails.ServiceHeader createCustomerDetailsServiceHeader() {
        return new CustomerDetails.ServiceHeader();
    }

    /**
     * Create an instance of {@link CustomerDetails.PersonalDetails.NameDetails }
     * 
     */
    public CustomerDetails.PersonalDetails.NameDetails createCustomerDetailsPersonalDetailsNameDetails() {
        return new CustomerDetails.PersonalDetails.NameDetails();
    }

    /**
     * Create an instance of {@link CustomerDetails.PersonalDetails.ContactDetails }
     * 
     */
    public CustomerDetails.PersonalDetails.ContactDetails createCustomerDetailsPersonalDetailsContactDetails() {
        return new CustomerDetails.PersonalDetails.ContactDetails();
    }

}
