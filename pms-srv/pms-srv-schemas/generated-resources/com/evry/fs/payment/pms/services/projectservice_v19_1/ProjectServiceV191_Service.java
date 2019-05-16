package com.evry.fs.payment.pms.services.projectservice_v19_1;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.2
 * 2019-05-15T15:10:19.203+05:30
 * Generated source version: 3.0.2
 * 
 */
@WebServiceClient(name = "ProjectService_V19_1", 
                  wsdlLocation = "file:/C:/Users/venkata.kuppili/Desktop/pms/Project_Management_System_SOAP/pms-srv/pms-srv-schemas/src/main/resources/wsdl/ProjectService_V19_1.wsdl",
                  targetNamespace = "http://evry.com/fs/payment/pms/services/ProjectService_V19_1/") 
public class ProjectServiceV191_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://evry.com/fs/payment/pms/services/ProjectService_V19_1/", "ProjectService_V19_1");
    public final static QName ProjectServiceV191Port = new QName("http://evry.com/fs/payment/pms/services/ProjectService_V19_1/", "ProjectService_V19_1_Port");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/venkata.kuppili/Desktop/pms/Project_Management_System_SOAP/pms-srv/pms-srv-schemas/src/main/resources/wsdl/ProjectService_V19_1.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ProjectServiceV191_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/venkata.kuppili/Desktop/pms/Project_Management_System_SOAP/pms-srv/pms-srv-schemas/src/main/resources/wsdl/ProjectService_V19_1.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ProjectServiceV191_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ProjectServiceV191_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ProjectServiceV191_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ProjectServiceV191_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ProjectServiceV191_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ProjectServiceV191_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns ProjectServiceV191
     */
    @WebEndpoint(name = "ProjectService_V19_1_Port")
    public ProjectServiceV191 getProjectServiceV191Port() {
        return super.getPort(ProjectServiceV191Port, ProjectServiceV191.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ProjectServiceV191
     */
    @WebEndpoint(name = "ProjectService_V19_1_Port")
    public ProjectServiceV191 getProjectServiceV191Port(WebServiceFeature... features) {
        return super.getPort(ProjectServiceV191Port, ProjectServiceV191.class, features);
    }

}
