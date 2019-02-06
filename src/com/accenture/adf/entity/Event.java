package com.accenture.adf.entity;

public class Event {
	
	private int eventid;
	private String name="";
	private String description="";
	private String places="";
	private String duration;
	private String eventtype="";
	private int seatsavailable;
	
	
	public Event(){};
	public int getEventid() {
		return eventid;
	}
	public void setEventid(int eventid) {
		this.eventid = eventid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPlace() {
		return places;
	}
	public void setPlace(String places) {
		this.places = places;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getEventtype() {
		return eventtype;
	}
	public void setEventtype(String eventtype) {
		this.eventtype = eventtype;
	}
	public int getSeatsavailable() {
		return seatsavailable;
	}
	public void setSeatsavailable(int seatsavailable) {
		this.seatsavailable = seatsavailable;
	}
	public Event(int eventid, String name, String description, String places, String duration, String eventtype,
			int seatsavailable) {
		super();
		this.eventid = eventid;
		this.name = name;
		this.description = description;
		this.places = places;
		this.duration = duration;
		this.eventtype = eventtype;
		this.seatsavailable = seatsavailable;
	}
	@Override
	public String toString() {
		return "Event [eventid=" + eventid + ", name=" + name + ", description=" + description + ", places=" + places
				+ ", duration=" + duration + ", eventtype=" + eventtype + ", seatsavailable=" + seatsavailable + "]";
	}
	
	

}
