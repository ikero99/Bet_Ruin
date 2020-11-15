package adapter;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import domain.Apustua;
import domain.Erabiltzaile;

public class ErabiltzaileAdapter extends AbstractTableModel{
	
	private String[] colNames = new String[] {"Event", "Question", "EventDate", "Bet(€)"};
	private Erabiltzaile e;
	private final Vector<Apustua> apustuak;
	
	public ErabiltzaileAdapter(Erabiltzaile e) {
		apustuak=new Vector<Apustua>(e.getApustua());
		this.e=e;
		
	}
	public int getRowCount() {
		// TODO Auto-generated method stub
		return apustuak.size();
		
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
		  switch(columnIndex) {
			  case 0: return ((Object)apustuak.elementAt(rowIndex).getKuota().get(rowIndex).getQuestion().getEvent());
	          case 1: return ((Object) apustuak.elementAt(rowIndex).getKuota().get(rowIndex).getQuestion());
	          case 2: return ((Object) apustuak.elementAt(rowIndex).getKuota().get(rowIndex).getQuestion().getEvent().getEventDate());
	          case 3: return ((Object) apustuak.elementAt(rowIndex).getDirua());
		  }
           return null;
	}
	

    @Override
    public String getColumnName(int col) {
        return colNames[col];
    }

}
