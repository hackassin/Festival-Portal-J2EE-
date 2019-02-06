package com.hackassin.fsd.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hackassin.fsd.controller.EventController;
import com.hackassin.fsd.entity.Event;
import com.hackassin.fsd.entity.Visitor;
import com.hackassin.fsd.service.EventService;
import com.hackassin.fsd.service.VisitorService;

@Controller

public class VisitorController {

	ModelAndView mv;
	public VisitorController() {
		 mv = new ModelAndView();
	}
	
	@RequestMapping("/ValidateLogin.htm" )
	
	public ModelAndView ValidateLogin(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Visitor visitor = new Visitor();
		
		HttpSession session = request.getSession();
		
		ModelAndView mv = new ModelAndView();
			
		visitor.setUsername(request.getParameter("Username"));
		visitor.setPassword(request.getParameter("Password"));
		
		VisitorService visitorService= new VisitorService();
		
		 visitor = visitorService.ValidateLogin(visitor);
		 session.setAttribute("user", visitor);
		 
		 
		//session.getAttribute("user");
		
		//Test statement
				
		if(visitor == null)
		{
			String message = "Invalid Credentials "+":(";
			
			mv.addObject("login_error",message);
			mv.setViewName("Login_Home.jsp");
		}
		
		System.out.println("User role = "+visitor.getRole());
		
		if (visitor.getRole().equals("admin"))
		{
			String admin_msg = "Welcome " + visitor.getUsername() + " ^__^";
			mv.addObject("Welcome_Admin", admin_msg);
			mv.setViewName("AdminHome.jsp");
		}
		
		else
		{
			//String message = "Welcome"+" "+request.getParameter("Username");
			
			//mv.addObject("login_success", message);
		    //mv.setViewName("VisitorHome.jsp");
			mv.setViewName("/ViewAllEvents.htm");
			
		}
		
		return mv;
		
	}
	
	
	@RequestMapping("/RegisterUser.htm")
	public ModelAndView RegisterUser (HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException
	{
		
		HttpSession session = request.getSession();
		
		Visitor visitor = new Visitor();
		
		ModelAndView mv = new ModelAndView();
		
		System.out.println("Inside RegisterUser MVC Method");
		
		visitor.setUsername(request.getParameter("Username"));
		visitor.setPassword(request.getParameter("Password"));
		visitor.setFirstname(request.getParameter("Firstname"));
		visitor.setLastname(request.getParameter("Lastname"));
		visitor.setEmail(request.getParameter("Email"));
		visitor.setPhonenumber(request.getParameter("Phonenumber"));
		visitor.setAddress(request.getParameter("Address"));
		visitor.setRole("user");
		VisitorService visitorService = new VisitorService();
		
		System.out.println("Before calling CheckUser Service");
		boolean checkUser = visitorService.CheckUser(visitor);
		System.out.println("After calling CheckUser Service");
		
		if (checkUser == false) //If user doesn't exist then register
		{	
			System.out.println("Before calling RegistorVisitorService");
			boolean res = visitorService.RegisterVisitor(visitor);
			System.out.println("After calling RegistorVisitorService");
			
			System.out.println("User Role = "+visitor.getRole());
			
			if(res == true)
		
			{	String message = "User Registered " + ":)";
		
				mv.addObject("User_Reg_Success", message);
				mv.setViewName("Login_Home.jsp");
			}
		
		}
		
		else if (checkUser == true) //If user exists
		{
			String message = "Username already exists" + " :|";
			mv.addObject("User_Reg_Error", message);
			mv.setViewName("Login_Home.jsp");
		}
		return mv;		
	}
	
	@RequestMapping("/Logout.htm")
	public ModelAndView logOut(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		HttpSession session=request.getSession();
		
		ModelAndView mv=new ModelAndView();
		
		session.invalidate();
		mv.setViewName("Login_Home.jsp");
		return mv;
	}
	
	
	@RequestMapping("/UpdateVisitor.htm")
	public ModelAndView UpdateVisitor (HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		System.out.println("Inside UpdateVisitor MVC Method");
		
		Visitor visitor = new Visitor();
		
		HttpSession session	= request.getSession(false);
		
		ModelAndView mv = new ModelAndView();
		
		visitor = (Visitor)session.getAttribute("user");
		
		VisitorService visitorService = new VisitorService();
		
		Enumeration<String> en = request.getParameterNames(); //List of parameter names
		
		String value = null; 
		int x = 0;
		
		while (en.hasMoreElements()) 
		{
			Object param = en.nextElement();
			value = new String((String) param);
			System.out.println(value);
			//System.out.println("Before calling request.getParameter(Username)");
			//System.out.println(request.getParameter("username"));
			//System.out.println("After calling request.getParameter(Username)");
			
			switch (value)
			{
				case "username" :  
					
				System.out.println("Before calling visitorService.UpdateVisitor() 1");
				
				System.out.println(request.getParameter("username"));
					
				visitor.setUsername(request.getParameter("username"));
				
				System.out.println("Before calling visitorService.UpdateVisitor() 2");
									visitorService.UpdateVisitor(visitor,"UpdateUsername");
				System.out.println("After calling visitorService.UpdateVisitor()");					
									break;
					
				case "password" :	visitor.setPassword(request.getParameter("password"));
									x = visitorService.UpdateVisitor(visitor,"UpdatePassword");
									break;
					
				case "firstname":	visitor.setFirstname(request.getParameter("firstname"));
									visitorService.UpdateVisitor(visitor, "UpdateFirstname");
									break;
				
				case "lastname":	visitor.setLastname(request.getParameter("lastname"));
									visitorService.UpdateVisitor(visitor, "UpdateLastname");
									break;
				
				case "email":		visitor.setEmail(request.getParameter("email")); 
									visitorService.UpdateVisitor(visitor, "UpdateEmail");
									break;
					
				case "phonenumber": visitor.setPhonenumber(request.getParameter("phonenumber"));
									visitorService.UpdateVisitor(visitor, "UpdatePhonenumber");
									break;
				
				case "address":		visitor.setAddress(request.getParameter("address"));
									visitorService.UpdateVisitor(visitor, "UpdateAddress");
									break;
				default: System.out.println("Null value/others");				
			} 
		}
		
		System.out.println("Outside while (en.hasMoreElements()): value = " +value);
		
	//Checking the type of update request	
		
		if(x>0)
			{
				String UpdateMessage = "Account Info Updated";
		
				mv.addObject("UpdateMessage", UpdateMessage);
		
				mv.setViewName("/ViewProfile.htm");
				
				return mv;
			}
		
		return mv;
	}
		
				
	@RequestMapping("/ViewProfile.htm")
	
	public ModelAndView getVisitorDetails (HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		
		Visitor visitor = new Visitor();
		
		visitor = (Visitor) session.getAttribute("user");
		//System.out.println("In getVisitorDetails method of Visitor controller");
		//System.out.println("VisitorID: "+visitor.getVisitorId());
		
		
		VisitorService visitorService = new VisitorService();
		
		System.out.println("Before calling VisitorServie");
		visitor = visitorService.getVisitorDetails(visitor);
		System.out.println("After calling VisitorServie");
		
		//System.out.println("Visitor Email: "+visitor.getEmail());
		
		mv.addObject("visitor", visitor);
		
		String profile_message = visitor.getUsername()+"'s"+" Profile";
		
		mv.addObject("ProfileName", profile_message);
		
		mv.setViewName("VisitorProfile.jsp");
		
		return mv;
		
	}
	
@RequestMapping("/ViewAllVisitors.htm")
	
	public ModelAndView VisitorsList(HttpServletRequest request,
			HttpServletResponse response) throws ClassNotFoundException, SQLException
	{
		System.out.println("Inside ViewAllVisitors MVC Method");
		
		ArrayList<Visitor> visitorList= new ArrayList<Visitor>();
		
		
		VisitorService visitorService = new VisitorService();
		//System.out.println("xdy");
		
		ModelAndView mv = new ModelAndView();
		
		System.out.println("Inside try block");
		
		System.out.println("Before calling getAllEvents Service Method");
		visitorList =(ArrayList<Visitor>)visitorService.getAllVisitors();
		System.out.println("After calling getAllEvents Service Method");
		
		System.out.println(visitorList);
		
		/**/
		
		mv.addObject("visitor",visitorList);
		mv.setViewName("ViewAllVisitors.jsp");
			
		//System.out.println("Catching VisitorID inside EventController: "+ visitor.getVisitorId());		
		return mv;
	}

}
