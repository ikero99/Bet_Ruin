package businessLogic;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import configuration.ConfigXML;
import dataAccess.DataAccess;

public class ApplicationLauncherFactory {
		BLFacade appInterface;
	
		public BLFacade createApplicationLauncher(String string) throws MalformedURLException{
			ConfigXML c = ConfigXML.getInstance();
			if (string == "local") {
				DataAccess da= new DataAccess(c.getDataBaseOpenMode().equals("initialize"));
				appInterface= new BLFacadeImplementation(da);
			} else{ //"remote"
				String serviceName= "http://"+c.getBusinessLogicNode() +":"+ c.getBusinessLogicPort()+"/ws/"+c.getBusinessLogicName()+"?wsdl";
				URL url = new URL(serviceName);
				QName qname = new QName("http://businessLogic/", "BLFacadeImplementationService");
				Service service = Service.create(url, qname);
				appInterface = service.getPort(BLFacade.class);
			}
			return appInterface;
		}
}
