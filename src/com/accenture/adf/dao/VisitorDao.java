package com.accenture.adf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.accenture.adf.entity.Event;
import com.accenture.adf.entity.Visitor;
import com.accenture.adf.utility.FERSDataConnection;

public class VisitorDao {
	
	Connection connection; 
	
	//private ResultSet res;
	private int status = 0;
	
	public VisitorDao () throws ClassNotFoundException, SQLException
	{
		//new FERSDataConnection();
		connection = FERSDataConnection.getConnection();
	}

	public Visitor ValidateLogin(Visitor visitor) 	
	{
	 ResultSet res;	
		try{
			String sql = "SELECT * from VISITOR where USERNAME=? and PASSWORD=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			System.out.println(visitor.getUsername());
			System.out.println(visitor.getPassword());
			
			ps.setString(1, visitor.getUsername());
			ps.setString(2, visitor.getPassword());
			
			System.out.println(connection);
			System.out.println("Before result-set derivation");
			res = ps.executeQuery();
			System.out.println("After result-set derivation");
			if(res.next())
			{
			visitor.setVisitorId(res.getInt("visitorid"));
			visitor.setUsername(res.getString("username"));
			visitor.setPassword(res.getString("password"));
			visitor.setFirstname(res.getString("firstname"));
			visitor.setLastname(res.getString("lastname"));
			visitor.setEmail(res.getString("email"));
			visitor.setPhonenumber(res.getString("phonenumber"));
			visitor.setRole(res.getString("role"));
			}else{
				visitor = null;
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return visitor;
		// TODO Auto-generated method stub
		
	}

	public boolean RegisterVisitor(Visitor visitor) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO VISITOR VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(sql);
	
	    ps.setString(1, visitor.getUsername());
	    ps.setString(2, visitor.getPassword());
	    ps.setString(3, visitor.getFirstname());
	    ps.setString(4, visitor.getLastname());
	    ps.setString(5, visitor.getEmail());
	    ps.setString(6, visitor.getPhonenumber());
	    ps.setString(7, visitor.getAddress());
	    ps.setString(8, visitor.getRole());
		ps.execute();
		
		return true;
	}

	public Visitor getVisitorDetails(Visitor visitor) {
		
		String sql = "SELECT * FROM VISITOR WHERE VISITORID = ?";
		
		try {
				PreparedStatement ps = connection.prepareStatement(sql);
			
				ps.setInt(1, visitor.getVisitorId());
			
				ResultSet res = ps.executeQuery();
			
			if(res.next())
			{
				visitor.setUsername(res.getString("username"));
				visitor.setPassword(res.getString("password"));
				visitor.setFirstname(res.getString("firstname"));
				visitor.setLastname(res.getString("lastname"));
				visitor.setEmail(res.getString("email"));
				visitor.setPhonenumber(res.getString("phonenumber"));
				visitor.setAddress(res.getString("address"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return visitor;
	}

	

	public int UpdateVisitor(Visitor visitor, String UpdateOp) {
		// TODO Auto-generated method stub
	
	//String sql = null;
		
		System.out.println("UpdateOp: " +UpdateOp);
		int x = 0;
		
		switch(UpdateOp)
		{
			case "UpdateUsername": System.out.println("Case UpdateUsername");
				
			String sql = "UPDATE VISITOR SET USERNAME = ?  WHERE VISITORID = ?";
			
			try {
				PreparedStatement ps = connection.prepareStatement(sql);
				
				ps.setString(1, visitor.getUsername());
				ps.setInt(2, visitor.getVisitorId());
				
				x = ps.executeUpdate();//Used for DML statements used to update/modify database
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			break;
			
			case "UpdatePassword": System.out.println("Case: UpdatePassword");
				
			sql = "UPDATE VISITOR SET PASSWORD = ?  WHERE VISITORID = ?";
			
			try {
				PreparedStatement ps = connection.prepareStatement(sql);
				
				ps.setString(1, visitor.getPassword());
				ps.setInt(2, visitor.getVisitorId());
				
				x = ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			break;
			
			case "UpdateFirstname": System.out.println("Case: UpdateFirstname");
				
			sql = "UPDATE VISITOR SET FIRSTNAME = ?  WHERE VISITORID = ?";
			
			try {
				PreparedStatement ps = connection.prepareStatement(sql);
				
				ps.setString(1, visitor.getFirstname());
				ps.setInt(2, visitor.getVisitorId());
				
				x = ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			break;
			
			case "UpdateLastname": System.out.println("Case: UpdateLastname");
				
			sql = "UPDATE VISITOR SET LASTNAME = ?  WHERE VISITORID = ?";
			
			try {
				PreparedStatement ps = connection.prepareStatement(sql);
				
				ps.setString(1, visitor.getLastname());
				ps.setInt(2, visitor.getVisitorId());
				
				x = ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			break;
			
			case "UpdateEmail": System.out.println("Case: Update Email");
				
			sql = "UPDATE VISITOR SET EMAIL = ?  WHERE VISITORID = ?";
			
			try {
				PreparedStatement ps = connection.prepareStatement(sql);
				
				System.out.println("Email-id to be updated"+visitor.getEmail());
				ps.setString(1, visitor.getEmail());
				ps.setInt(2, visitor.getVisitorId());
				
				x = ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			break;
			
			case "UpdatePhonenumber": System.out.println("Case: UpdatePhonenumber");
				
			sql = "UPDATE VISITOR SET PHONENUMBER = ?  WHERE VISITORID = ?";
			
			try {
				PreparedStatement ps = connection.prepareStatement(sql);
				
				ps.setString(1, visitor.getPhonenumber());
				ps.setInt(2, visitor.getVisitorId());
				
				x = ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			break;		
			
			case "UpdateAddress": System.out.println("Case: UpdateAddress");
				
				sql = "UPDATE VISITOR SET ADDRESS = ?  WHERE VISITORID = ?";
				
				try {
					PreparedStatement ps = connection.prepareStatement(sql);
					
					ps.setString(1, visitor.getAddress());
					ps.setInt(2, visitor.getVisitorId());
					
					x = ps.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				break;		
			
		} return x;
	}

	public boolean CheckUser(Visitor visitor) {
		// TODO Auto-generated method stub
		System.out.println("Inside CheckUser Dao");
		
		String sql = "SELECT *FROM VISITOR where USERNAME = ?";
		boolean x = false;
		try {
				PreparedStatement ps = connection.prepareStatement(sql);
			
				ps.setString(1, visitor.getUsername());
				System.out.println(visitor.getUsername()); 
				
				System.out.println("Before executing query");
				ResultSet res = ps.executeQuery();
				System.out.println("After executing query");
				
				if(res.next())
				{
					System.out.println("res.next()");  
					System.out.println("res.getString(username):" +res.getString("username")); 
					if (visitor.getUsername().equals(res.getString("username")))				
						x = true; 
				}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} System.out.println("Boolean x value = "+x);
		return x;
	}

	public ArrayList<Visitor> getAllVisitors() {
		// TODO Auto-generated method stub
		ArrayList<Visitor> visitors = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();

			String sql = "SELECT * FROM VISITOR";
			ResultSet resultSet = statement.executeQuery(sql);

			Visitor visitor = null;
			
			while (resultSet.next()) {
				visitor = new Visitor();
				
				visitor.setVisitorId(resultSet.getInt("visitorid"));
				//System.out.println("print");
				visitor.setUsername(resultSet.getString("username"));
				visitor.setPassword(resultSet.getString("password"));
				visitor.setFirstname(resultSet.getString("firstname"));
				visitor.setLastname(resultSet.getString("lastname"));
				visitor.setAddress(resultSet.getString("address"));
				visitor.setEmail(resultSet.getString("email"));
				visitor.setPhonenumber(resultSet.getString("phonenumber"));				
				visitors.add(visitor);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return visitors;		
	}


}