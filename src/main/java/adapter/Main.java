package adapter;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import businessLogic.*;
import dataAccess.DataAccess;
import domain.Bezero;
import domain.Erabiltzaile;

public class Main {
	public static void main(String[] args) {
		/*BLFacadeInterfaceWS i = new FacadeImplementationWS(); //MainTable soilik
		Erabiltzaile e1= new Bezero();
		Erabiltzaile user = i.getUser(e1);
		WindowTable vt = new WindowTable(user);
		vt.setVisible(true);*/
		DataAccess db= new DataAccess();
		Erabiltzaile e1= new Bezero("Mariane","Menath",21,"marianee@mail.com","12345678");
		db.storeUser(e1);
		ErabiltzaileAdapter model = new ErabiltzaileAdapter(e1);
		JFrame j=new JFrame();
		JTable table = new JTable(model);
		 j.add(new JScrollPane(table));
	     j.setTitle("Table of:" + e1.getIzena());
	     j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
	     j.pack();
	     j.setVisible(true);
	}
}
