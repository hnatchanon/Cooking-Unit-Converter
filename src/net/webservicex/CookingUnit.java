
package net.webservicex;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CookingUnit", targetNamespace = "http://www.webserviceX.NET/", wsdlLocation = "http://www.webservicex.net/ConvertCooking.asmx?WSDL")
public class CookingUnit
    extends Service
{

    private final static URL COOKINGUNIT_WSDL_LOCATION;
    private final static WebServiceException COOKINGUNIT_EXCEPTION;
    private final static QName COOKINGUNIT_QNAME = new QName("http://www.webserviceX.NET/", "CookingUnit");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://www.webservicex.net/ConvertCooking.asmx?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        COOKINGUNIT_WSDL_LOCATION = url;
        COOKINGUNIT_EXCEPTION = e;
    }

    public CookingUnit() {
        super(__getWsdlLocation(), COOKINGUNIT_QNAME);
    }

    public CookingUnit(WebServiceFeature... features) {
        super(__getWsdlLocation(), COOKINGUNIT_QNAME, features);
    }

    public CookingUnit(URL wsdlLocation) {
        super(wsdlLocation, COOKINGUNIT_QNAME);
    }

    public CookingUnit(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, COOKINGUNIT_QNAME, features);
    }

    public CookingUnit(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CookingUnit(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CookingUnitSoap
     */
    @WebEndpoint(name = "CookingUnitSoap")
    public CookingUnitSoap getCookingUnitSoap() {
        return super.getPort(new QName("http://www.webserviceX.NET/", "CookingUnitSoap"), CookingUnitSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CookingUnitSoap
     */
    @WebEndpoint(name = "CookingUnitSoap")
    public CookingUnitSoap getCookingUnitSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.webserviceX.NET/", "CookingUnitSoap"), CookingUnitSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (COOKINGUNIT_EXCEPTION!= null) {
            throw COOKINGUNIT_EXCEPTION;
        }
        return COOKINGUNIT_WSDL_LOCATION;
    }

}
