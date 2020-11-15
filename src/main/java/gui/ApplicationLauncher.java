package gui;

import java.awt.Color;
import java.net.URL;
import java.util.Locale;

import javax.swing.UIManager;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import businessLogic.ApplicationLauncherFactory;
import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import configuration.ConfigXML;
import dataAccess.DataAccess;

public class ApplicationLauncher {

	public static void main(String[] args) {
		/*ConfigXML c=ConfigXML.getInstance();
		
		System.out.println(c.getLocale());
		
		Locale.setDefault(new Locale(c.getLocale()));
		
		System.out.println("Locale: "+Locale.getDefault());
		
		index a=new index();
		a.setVisible(true);*/
		
		ConfigXML c=ConfigXML.getInstance();
		System.out.println(c.getLocale());
		Locale.setDefault(new Locale(c.getLocale()));
		System.out.println("Locale: "+Locale.getDefault());
		index a=new index();
		a.setVisible(true);
		try {
		BLFacade appInterface;
		ApplicationLauncherFactory appFactory = new ApplicationLauncherFactory();
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		if (c.isBusinessLogicLocal()) {
			appInterface = appFactory.createApplicationLauncher("local");
		}
		else { //If remote
			appInterface = appFactory.createApplicationLauncher("remote");
		}
		MainGUI.setBussinessLogic(appInterface);
		}catch (Exception e) {

		System.out.println("Error in ApplicationLauncher: "+e.toString());
		}
	}

}
