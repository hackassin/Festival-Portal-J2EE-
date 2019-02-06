package com.accenture.adf.service;
import java.sql.SQLException;
import java.util.ArrayList;
import com.accenture.adf.dao.EventDao;
import com.accenture.adf.dao.VisitorDao;
import com.accenture.adf.entity.Event;
import com.accenture.adf.entity.Visitor;

public class EventService {

	public EventService(){}
    	
	public ArrayList<Event> getAllEvents() throws ClassNotFoundException, SQLException
	{
		System.out.println("Dice");
		EventDao dao = new EventDao();
		
		return dao.getAllEvents();
	}
	
	public boolean CheckRegistration (Visitor visitor, Event event) throws ClassNotFoundException, SQLException
	{
	
		EventDao dao = new EventDao();
		
		boolean checkRegistration = dao.CheckRegistration(visitor,event);
		
		return checkRegistration;	
	}
	
	public String RegisterVisitorToEvent (Visitor visitor, Event event) throws ClassNotFoundException, SQLException
	{
		System.out.println("\nInside RegisterVisitorToEvent Service: EventID = "+event.getEventid());
		
		EventDao dao = new EventDao();
		
		String message = dao.RegisterVisitorToEvent(visitor, event);
		
		return message;
		
	}

	public boolean CheckSeatsAvailability(Event event) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		EventDao dao = new EventDao();
		
		boolean x = dao.CheckSeatsAvailability(event);
		
		return x;
	}

	public void updateSeats(Event event, String SeatsUpdation) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		EventDao dao = new EventDao();
		
		System.out.println("Inside updateSeats service "+ SeatsUpdation);
		
		dao.updateSeats(event, SeatsUpdation);
		
	}

	public ArrayList<Event> getRegisteredEvents(Visitor visitor) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		EventDao dao = new EventDao();
		
		ArrayList<Event> regEventList = (ArrayList<Event>)dao.getRegisteredEvents(visitor);
		
		return regEventList;
	}

	public void Unregister(Visitor visitor, Event event) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		EventDao dao = new EventDao();
		
		dao.Unregister(visitor, event);
		dao.updateSeats(event, "seats_increment");
	}

	public void addEvent(Event event) {
		// TODO Auto-generated method stub
		
		EventDao dao;
		try {
			dao = new EventDao();
			dao.addEvent(event);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void deleteEvent(Event event) {
		// TODO Auto-generated method stub
		
		EventDao dao;
		try {
			dao = new EventDao();
			dao.deleteEvent(event);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public Event getEventDetails(Event event) {
		// TODO Auto-generated method stub
		EventDao dao;
		try {
			dao = new EventDao();
			dao.getEventDetails(event);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	return event;	
	}

	public int UpdateEvent(Event event, String UpdateOp) {
		// TODO Auto-generated method stub
		
		EventDao dao;
		int x = 0;
		System.out.println("Inside UpdateEvent Service");
		System.out.println("UpdateOp"+UpdateOp);
		
		try {
			dao = new EventDao();
			x = dao.UpdateEvent(event, UpdateOp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return x;
	}

}
