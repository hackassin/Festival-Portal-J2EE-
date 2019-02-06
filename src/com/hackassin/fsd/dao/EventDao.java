package com.hackassin.fsd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import com.hackassin.fsd.entity.Event;
import com.hackassin.fsd.entity.Visitor;
import com.hackassin.fsd.utility.FERSDataConnection;

import java.util.ArrayList;

public class EventDao {
	
	Connection connection;

	
	public EventDao() throws ClassNotFoundException, SQLException 
	{
		new FERSDataConnection();
		connection = FERSDataConnection.getConnection();
	}
	
	public ArrayList<Event> getAllEvents()
	{
		
		ArrayList<Event> events = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();

			String sql = "SELECT * FROM EVENT";
			ResultSet resultSet = statement.executeQuery(sql);

			Event event = null;
			
			while (resultSet.next()) {
				event = new Event();
				
				event.setEventid(resultSet.getInt("eventid"));
				//System.out.println("print");
				event.setName(resultSet.getString("name"));
				event.setDescription(resultSet.getString("description"));
				event.setDuration(resultSet.getString("duration"));
				event.setPlace(resultSet.getString("places"));
				event.setEventtype(resultSet.getString("eventtype"));
				event.setSeatsavailable(resultSet.getInt("seatsavailable"));				
				events.add(event);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return events;		
	}
	
	public boolean CheckRegistration (Visitor visitor, Event event) throws SQLException
	{
		boolean res = false;
		System.out.println("Inside CheckRegistrationDao: EventID = "+event.getEventid()+" VisitorID "+visitor.getVisitorId());
		
		System.out.println("Before checking for events of visitor");
		
		String sql = "SELECT *from EVENTSIGNUP where VISITORID = ? AND EVENTID=?";
		PreparedStatement ps = connection.prepareStatement(sql);		
		
		ps.setInt(1, visitor.getVisitorId());
		ps.setInt(2, event.getEventid());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			res = true;
		}
		return res;
		
	}

	public String RegisterVisitorToEvent(Visitor visitor, Event event) throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("Inside RegisterVisitorToEvent: EventID = "+event.getEventid());
		
		String sql = "INSERT INTO EVENTSIGNUP VALUES (NULL, ? , ?)";
		PreparedStatement ps = connection.prepareStatement(sql);
	
		ps.setInt(1, event.getEventid());
		ps.setInt(2, visitor.getVisitorId());
		
		boolean rs = ps.execute();
		
		return "Registered";
	}



	public boolean CheckSeatsAvailability(Event event) throws SQLException 
	
	{
		// TODO Auto-generated method stub
		
		boolean check = false;
		
		String sql = "SELECT SEATSAVAILABLE from event where eventid = ? ";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1, event.getEventid());
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{
			event.setSeatsavailable(rs.getInt("seatsavailable"));
		}
		
		if(event.getSeatsavailable()>0)
		{
			check = true;
		}
			
		else check = false;
		
		return check;
		
	}

	public void updateSeats(Event event, String SeatsUpdation) throws SQLException 
	{
		// TODO Auto-generated method stub
		boolean res;
		
		System.out.println("Inside UpdateSeats method: EventID = "+event.getEventid());
		
		if (SeatsUpdation == "seats_decrement") //if seats are available
		{
			String sql = "UPDATE Event SET Seatsavailable = Seatsavailable - 1 where EventID = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, event.getEventid());
			
			System.out.println("Before executing query in updateSeatsDao");
			
			res = ps.execute();
			
			System.out.println(sql);		
		}
		
		else if (SeatsUpdation == "seats_increment")
		{
			String sql = "UPDATE Event SET Seatsavailable = Seatsavailable + 1 where EventID = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, event.getEventid());
			
			res = ps.execute();
		}		
		
	}
	
	public ArrayList<Event> getRegisteredEvents(Visitor visitor)
	{
		
		ArrayList<Event> events = new ArrayList<>();
	try {
			String sql = "SELECT *from EVENT where EVENTID in (SELECT EVENTID from EVENTSIGNUP where VISITORID = ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, visitor.getVisitorId());		
			
			ResultSet resultSet = ps.executeQuery();

			Event event1 = null;
			
			while (resultSet.next()) {
				event1 = new Event();
				
				event1.setEventid(resultSet.getInt("eventid"));
				//System.out.println("print");
				event1.setName(resultSet.getString("name"));
				event1.setDescription(resultSet.getString("description"));
				event1.setDuration(resultSet.getString("duration"));
				event1.setPlace(resultSet.getString("places"));
				event1.setEventtype(resultSet.getString("eventtype"));
				event1.setSeatsavailable(resultSet.getInt("seatsavailable"));				
				events.add(event1);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return events;		
	}

	public void Unregister(Visitor visitor, Event event) throws SQLException 
	
	{
		// TODO Auto-generated method stub
		
		String sql = "DELETE FROM EVENTSIGNUP WHERE VISITORID = ? AND EVENTID = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1, visitor.getVisitorId());
		ps.setInt(2, event.getEventid());
		
		ps.execute();
		
	}

	public void addEvent(Event event) {
		// TODO Auto-generated method stub
		
		try {
			String sql = "INSERT INTO EVENT VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, event.getEventid());
			ps.setString(2, event.getName());
			ps.setString(3, event.getDescription());
			ps.setString(4, event.getPlace());
			ps.setString(5, event.getDuration());
			ps.setString(6, event.getEventtype());
			ps.setInt(7, event.getSeatsavailable());
			
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void deleteEvent(Event event) {
		// TODO Auto-generated method stub
		try {
			String sql = "DELETE FROM EVENTSIGNUP WHERE EVENTID = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, event.getEventid());
			
			ps.execute();
			
			sql = "DELETE FROM EVENT WHERE EVENTID = ?";
			
			ps = connection.prepareStatement(sql);
			
			ps.setInt(1, event.getEventid());
			
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
	}
	
}

	public Event getEventDetails(Event event) {
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT *FROM EVENT WHERE EVENTID = ?";
			
			ResultSet res = null;
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, event.getEventid());
			
			res = ps.executeQuery();
			
			if (res.next())
			{
				event.setName(res.getString("name"));
				event.setDescription(res.getString("description"));
				event.setPlace(res.getString("places"));
				event.setDuration(res.getString("duration"));
				event.setEventtype(res.getString("eventtype"));
				event.setSeatsavailable(res.getInt("seatsavailable"));
			}
			
		} 
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
			} return event;
	}

	public int UpdateEvent(Event event, String UpdateOp) {
		// TODO Auto-generated method stub
		
		System.out.println("UpdateOp: " +UpdateOp);
		int x = 0;
		
		switch(UpdateOp)
		{
			case "UpdateEventname": System.out.println("Case UpdateEventname");
				
			String sql = "UPDATE EVENT SET NAME = ?  WHERE EVENTID = ?";
			
			try {
				PreparedStatement ps = connection.prepareStatement(sql);
				
				ps.setString(1, event.getName());
				ps.setInt(2, event.getEventid());
				
				x = ps.executeUpdate();//Used for DML statements used to update/modify database
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			break;
			
			case "UpdateDescription": System.out.println("Case: UpdateDescription");
				
			sql = "UPDATE EVENT SET DESCRIPTION = ?  WHERE EVENTID = ?";
			
			try {
					PreparedStatement ps = connection.prepareStatement(sql);
				
					ps.setString(1, event.getDescription());
					ps.setInt(2, event.getEventid());
					
					System.out.println(event.getDescription());
				
					x = ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			break;
			
			case "UpdatePlace": System.out.println("Case: UpdatePlace");
				
			sql = "UPDATE EVENT SET PLACES = ?  WHERE EVENTID = ?";
			
			try {
				PreparedStatement ps = connection.prepareStatement(sql);
				
				ps.setString(1, event.getPlace());
				ps.setInt(2, event.getEventid());
				
				x = ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			break;
			
			case "UpdateDuration": System.out.println("Case: UpdateDuration");
				
			sql = "UPDATE EVENT SET DURATION = ?  WHERE EVENTID = ?";
			
			try {
				PreparedStatement ps = connection.prepareStatement(sql);
				
				ps.setString(1, event.getDuration());
				ps.setInt(2, event.getEventid());
				
				x = ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			break;
			
			case "UpdateSeats": System.out.println("UpdateSeats");
				
			sql = "UPDATE EVENT SET SEATSAVAILABLE = ?  WHERE EVENTID = ?";
			
			try {
				PreparedStatement ps = connection.prepareStatement(sql);
				
				System.out.println("Seats available "+event.getSeatsavailable());
				ps.setInt(1, event.getSeatsavailable());
				ps.setInt(2, event.getEventid());
				
				x = ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			break;
			
			case "UpdateType": System.out.println("Case: UpdateType");
				
			sql = "UPDATE EVENT SET EVENTTYPE = ?  WHERE EVENTID = ?";
			
			try {
				PreparedStatement ps = connection.prepareStatement(sql);
				
				ps.setString(1, event.getEventtype());
				ps.setInt(2, event.getEventid());
				
				x = ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			break;		
			
		} return x;
	}
}
