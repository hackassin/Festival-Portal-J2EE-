package com.hackassin.fsd.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hackassin.fsd.dao.EventDao;
import com.hackassin.fsd.dao.VisitorDao;
import com.hackassin.fsd.entity.Visitor;

public class VisitorService {
	
	public Visitor ValidateLogin(Visitor visitor) throws ClassNotFoundException, SQLException
	{
		
		VisitorDao dao = new VisitorDao();
		
		visitor = dao.ValidateLogin(visitor);
		
		return visitor;				
	}

	public boolean RegisterVisitor(Visitor visitor) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		VisitorDao dao = new VisitorDao();
		
		boolean res = dao.RegisterVisitor(visitor);
		
		return res;
	}

	public Visitor getVisitorDetails(Visitor visitor) {
		// TODO Auto-generated method stub
		
		try {
			   VisitorDao dao = new VisitorDao();
			   
			   visitor = dao.getVisitorDetails(visitor);						
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return visitor;
	}

	public int UpdateVisitor(Visitor visitor, String UpdateOp) {
		// TODO Auto-generated method stub
		
		VisitorDao dao;
		int x = 0;
		System.out.println("Inside UpdateVisitor Service");
		System.out.println("UpdateOp"+UpdateOp);
		
		try {
			dao = new VisitorDao();
			x = dao.UpdateVisitor(visitor, UpdateOp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return x;
	}

	public boolean CheckUser(Visitor visitor) {
		// TODO Auto-generated method stub
		VisitorDao dao;
		System.out.println("Inside CheckUser Service");
		boolean checkUser = false;
		try {
				dao = new VisitorDao();
				checkUser = dao.CheckUser(visitor);
				System.out.println("checkUser service value: "+checkUser);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return checkUser;
	}

	public ArrayList<Visitor> getAllVisitors() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		VisitorDao dao = new VisitorDao();
		
		return dao.getAllVisitors();
	}

}
