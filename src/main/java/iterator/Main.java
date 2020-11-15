package iterator;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import businessLogic.ApplicationLauncherFactory;
import businessLogic.BLFacade;
import configuration.UtilDate;
import dataAccess.DataAccess;
import domain.Event;

public class Main {

	public static void main(String[] args) throws MalformedURLException {
		//boolean isLocal=true;
		//Facade objektua lortu lehendabiziko ariketa erabiliz
		
		ApplicationLauncherFactory appfac = new ApplicationLauncherFactory();
		BLFacade facadeInterface = appfac.createApplicationLauncher("local");
		/*Date d= new Date();
		ExtendedIterator<Event> i=facadeInterface.IteratorEvents(d);
		Event ev;
		i.goLast();
		while (i.hasPrevious()){
			ev=(Event)i.previous();
			System.out.println(ev);
		}
		//Nahiz eta suposatu hasierara ailegatu garela, eragiketa egiten dugu.
		i.goFirst();
		while (i.hasNext()){
			ev=(Event) i.next();
			System.out.println(ev);
		}*/
		DataAccess db= new DataAccess();
		Date date;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
		date = sdf.parse("17/12/2020"); //17 del mes que viene
		System.out.println("Hauek dira dauden events"+ db.getEvents(date));
		ExtendedIterator<Event> i = facadeInterface.IteratorEvents(date);
		Event e;
		System.out.println("_____________________");
		System.out.println("ATZETIK AURRERAKA");
		i.goLast();//Azkeneko elementuan kokatu
		while (i.hasPrevious()) {
			e = (Event) i.previous();
			System.out.println(e.toString());
		}
		System.out.println();
		System.out.println("_____________________");
		System.out.println("AURRETIK ATZERAKA");
		i.goFirst(); // Lehen elem. kokatu
		while (i.hasNext()) {
		e = (Event) i.next();
		System.out.println(e.toString());
		}
		} catch (ParseException e1) {
				System.out.println("errrror");
	}
	}	
}
