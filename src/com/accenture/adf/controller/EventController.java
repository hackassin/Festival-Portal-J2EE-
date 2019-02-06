package com.accenture.adf.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.adf.entity.Event;
import com.accenture.adf.service.EventService;
import com.accenture.adf.service.VisitorService;
import com.accenture.adf.entity.Visitor;
import com.accenture.adf.controller.VisitorController;


//import com.accenture.adf.service.VisitorService;

@Controller
public class EventController {
	
	public EventController(){}
	
	@RequestMapping("/ViewAllEvents.htm")
	public ModelAndView getAllEvents(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//System.out.println("xyz");
		//System.out.println("xd2");
			
		ArrayList<Event> eventList= new ArrayList<Event>();
		
		
		EventService event_service = new EventService();
		//System.out.println("xdy");
		
		eventList =	(ArrayList<Event>)event_service.getAllEvents();
		HttpSession session = request.getSession(false);
		Visitor visitor = (Visitor)session.getAttribute("user");
		
		//System.out.println("Catching VisitorID inside EventController: "+ visitor.getVisitorId());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("allEvents",eventList);
		
		
		ArrayList<Event> registeredEventList = new ArrayList<Event>();
		
		registeredEventList = (ArrayList<Event>)event_service.getRegisteredEvents(visitor);
		
		mv.addObject("registeredEvents", registeredEventList);
		
		System.out.println("Registered Event List" +registeredEventList);
		
		String message = "Howdy "+visitor.getUsername()+"!";
		
		mv.addObject("howdy_msg", message);
		
		mv.setViewName("ViewAllEvents.jsp");
		return mv;
	}
	
	
	@RequestMapping("/test.htm")
	
	public ModelAndView Display(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	ModelAndView mv = new ModelAndView();
	System.out.println("Inside test display");
	return mv;
	}
	
	@RequestMapping("/EventSignup.htm")
	
	public ModelAndView EventSignup (HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession();
		
		Visitor visitor = (Visitor)session.getAttribute("user");
		
		System.out.println("evids"+request.getParameter("eventid"));
		
		Event event = new Event();
        
		event.setEventid(Integer.parseInt(request.getParameter("eventid")));
		
		EventService eventService = new EventService();
		
		Boolean checkRegistration = eventService.CheckRegistration(visitor,event);
		
		ModelAndView mv2 = new ModelAndView();
		
		System.out.println("checkRegistration (in Event Controller) = " +checkRegistration);
		
	    if (checkRegistration == true)
	    
	    {	    	
	    	String message = "Already Registered Sire!";
	    	
	    	mv2.addObject("Reg_Event_Error", message);
	    	
	    	mv2.setViewName("/ViewAllEvents.htm");
	    }
	    
	    else if(checkRegistration == false) {
	    	
	    	System.out.println("Before checking the availability of seats");
	    	
	    	   boolean checkSeatsAvailable = eventService.CheckSeatsAvailability(event);
	    	   
	    	   if(checkSeatsAvailable == true)
	    	   
	    	   		{ 	
	    		   		System.out.println("Before calling update seats\n");	
	    		   		eventService.updateSeats(event, "seats_decrement");
	    		   
	    		   		System.out.println("Before calling RegisterVisitorToEvent method");
	    		   		
	    		   		String message2 = eventService.RegisterVisitorToEvent(visitor, event);
	    	   
	    	   			mv2.addObject("Reg_Event_Success", message2);
	    	   
	    	   			mv2.setViewName("/ViewAllEvents.htm");
	    	   		}
	    	   
	    	   else 
	    		   
	    	   		{
	    		   		String message2 = "No Seats Available Compadres!";
		    	   
	    		   		mv2.addObject("Reg_Event_Failure", message2);
   	   
	    		   		mv2.setViewName("/ViewAllEvents.htm");
	    	   		}
				

     } return mv2;
	   
} 
	
	@RequestMapping("/Unregister.htm")
	
	public ModelAndView Unregister (HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{	
		HttpSession session = request.getSession();
		
		Visitor visitor = (Visitor)session.getAttribute("user");
		
		EventService eventService = new EventService();
		
		ModelAndView mv = new ModelAndView();
		
		Event event = new Event();
		System.out.println("Inside unregister method of EventController");
		
		event.setEventid(Integer.parseInt(request.getParameter("eventid")));
		
		System.out.println("Inside2 unregister method of EventController");
		
		System.out.println("Visitor ID: "+visitor.getVisitorId()+" EventID: "+event.getEventid());
		
		System.out.println("Before calling Unregister method from EventController");
		
		eventService.Unregister(visitor,event);
		
		String unregisterMsg = "Unregistered";
		
		mv.addObject("UnregisterMessage", unregisterMsg);
		
		mv.setViewName("/ViewAllEvents.htm");
		
		return mv;
		
	}
	
	@RequestMapping("/AddEvent.htm")
	
	public ModelAndView AddEvent (HttpServletRequest request,
			HttpServletResponse response)
	{
		System.out.println("Inside AddEvent MVC Method");
		
		Event event = new Event();
		
		ModelAndView mv = new ModelAndView();
		
		event.setEventid(Integer.parseInt(request.getParameter("eventid")));
		event.setName(request.getParameter("eventname"));
		event.setDescription(request.getParameter("description"));
		event.setPlace(request.getParameter("place"));
		event.setDuration(request.getParameter("duration"));
		event.setEventtype(request.getParameter("eventtype"));
		event.setSeatsavailable(Integer.parseInt(request.getParameter("seats")));
		
		System.out.println("EventName = "+request.getParameter("eventname"));
		
		EventService eventService = new EventService();
		
		eventService.addEvent(event);
		
		String eventAdd = "Event Added";
		
		mv.addObject("eventAdd", eventAdd);
		
		mv.setViewName("AddEvent.jsp");
		
		return mv;
	}
	
	@RequestMapping("/AdminViewEvents.htm")
	
	public ModelAndView AdminViewEvents(HttpServletRequest request,
			HttpServletResponse response)
	{
		System.out.println("Inside AdminViewEvents MVC Method");
		
		ArrayList<Event> eventList= new ArrayList<Event>();
		
		
		EventService event_service = new EventService();
		//System.out.println("xdy");
		
		ModelAndView mv = new ModelAndView();
		
		try {
				System.out.println("Inside try block");
				
				System.out.println("Before calling getAllEvents Service Method");
			 	eventList =(ArrayList<Event>)event_service.getAllEvents();
			 	System.out.println("After calling getAllEvents Service Method");
			 	
				System.out.println(eventList);
				
				/**/
				
				mv.addObject("allEvents",eventList);
				mv.setViewName("AdminViewEvents.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		//System.out.println("Catching VisitorID inside EventController: "+ visitor.getVisitorId());		
		return mv;
	}
	
	@RequestMapping("/DeleteEvents.htm")
	public ModelAndView Delete(HttpServletRequest request,
			HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView();
		
		Event event = new Event();
		
		EventService eventService = new EventService();
		
		System.out.println("Before calling DeleteEvent Service");
		System.out.println(request.getParameter("eventid"));
		
		event.setEventid(Integer.parseInt(request.getParameter("eventid")));
						
		eventService.deleteEvent(event);
		mv.addObject("Delete_Msg","Event Deleted");
		System.out.println("After calling DeleteEvent Service");
		
		mv.setViewName("AdminViewEvents.htm");
		
		return mv;
	}
	
	@RequestMapping("/UpdateEventProfile.htm")
	
	public ModelAndView EventDetails (HttpServletRequest request,
			HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView();
		
		HttpSession session	= request.getSession();
		
		Event event = new Event();
		
		event.setEventid(Integer.parseInt(request.getParameter("eventid")));
		
		EventService eventService = new EventService(); 
		
		event = eventService.getEventDetails(event);
		
		session.setAttribute("eventUpdate", event);
		
		mv.addObject("event",event);
		
		mv.setViewName("UpdateEvents.jsp");
		
		return mv;
	}
	
	@RequestMapping("/UpdateEvents.htm")
	
	public ModelAndView UpdateEvent (HttpServletRequest request,
			HttpServletResponse response)
	{
		System.out.println("Inside UpdateEvent MVC Method");
		
		Event event = new Event();
		
		HttpSession session	= request.getSession(false);
		
	    event = (Event)session.getAttribute("eventUpdate");
	    
	    System.out.println(event.getEventid());
		
		ModelAndView mv = new ModelAndView();
		
		EventService eventService = new EventService();
		
		Enumeration<String> en = request.getParameterNames(); //List of parameter names
		
		String value = null; 
		int x = 0;
		
		while (en.hasMoreElements()) 
		{
			Object param = en.nextElement();
			value = new String((String) param);
			System.out.println("en.nextElement():"+value);
			//System.out.println("Before calling request.getParameter(Username)");
			//System.out.println(request.getParameter("username"));
			//System.out.println("After calling request.getParameter(Username)");
			
			switch (value)
			{
				case "eventname" :  
					
				System.out.println("Before calling visitorService.UpdateVisitor() 1");
				
				System.out.println(request.getParameter("eventname"));
					
				event.setName(request.getParameter("eventname"));
				
				System.out.println("Before calling eventService.UpdateEvent() 2");
									x = eventService.UpdateEvent(event,"UpdateEventname");
				System.out.println("After calling visitorService.UpdateVisitor()");					
									break;
					
				case "description" :event.setDescription(request.getParameter("description"));
									x = eventService.UpdateEvent(event,"UpdateDescription");
									break;
					
				case "place":		event.setPlace(request.getParameter("place"));
									x = eventService.UpdateEvent(event,"UpdatePlace");
									break;
				
				case "duration":	event.setDuration(request.getParameter("duration"));
									x = eventService.UpdateEvent(event,"UpdateDuration");
									break;
				
				case "eventtype":	event.setEventtype(request.getParameter("eventtype")); 
									x = eventService.UpdateEvent(event,"UpdateType");
									break;
					
				case "seats": 		event.setSeatsavailable(Integer.parseInt(request.getParameter("seats")));
									x = eventService.UpdateEvent(event,"UpdateSeats");
									break;
				
				default: System.out.println("Null value/others");				
			} 
		}
		
		System.out.println("Outside while (en.hasMoreElements()): value = " +value);
		
	//Checking the type of update request	
		
		if(x>0)
			{
				String UpdateMessage = "Event Details Updated";
		
				mv.addObject("UpdateMessage", UpdateMessage);
		
				mv.setViewName("/AdminViewEvents.htm");
			}
		
		else {
				String UpdateMessage = "Event Details Updation Error";
			
				mv.addObject("UpdateMessage", UpdateMessage);
	
				mv.setViewName("/AdminViewEvents.htm");
			}
		return mv;
	}
	
}
