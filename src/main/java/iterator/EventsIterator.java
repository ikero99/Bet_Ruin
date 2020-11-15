package iterator;

import java.util.Vector;

import domain.Event;

public class EventsIterator implements ExtendedIterator<Event>{
	Vector<Event> events;
	int position=0;
	public EventsIterator(Vector<Event> e) {
		this.events = e;
	}

	public boolean hasNext() {
		// TODO Auto-generated method stub
		return position<events.size();
	}

	public Object next() {
		// TODO Auto-generated method stub
		Event event=events.elementAt(position);
		position++;
		return event;
	}

	public Object previous() {
		// TODO Auto-generated method stub
		Event event =events.elementAt(position);
		position--;
		return event;
	}

	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return position>=0;
	}

	public void goFirst() {
		// TODO Auto-generated method stub
		this.position=0;
	}

	public void goLast() {
		// TODO Auto-generated method stub
		this.position=events.size()-1;
	}

}
