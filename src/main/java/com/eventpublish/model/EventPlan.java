package com.eventpublish.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class EventPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long evnentId;

	private String eventName;
	private String eventDiscription;
	private String eventOrganiser;
	private String eventPlace;
	private LocalDateTime eventStartDate;
	private LocalDateTime eventEndDate;
	private String eventDay;
	private Integer yearOfEvent;
	private String eventFullAddress;
	private String eventGuest;
	private String eventManager;
	private Long eventHelpLine;
	private String eventQueryEmail;

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDiscription() {
		return eventDiscription;
	}

	public void setEventDiscription(String eventDiscription) {
		this.eventDiscription = eventDiscription;
	}

	public String getEventOrganiser() {
		return eventOrganiser;
	}

	public void setEventOrganiser(String eventOrganiser) {
		this.eventOrganiser = eventOrganiser;
	}

	public String getEventPlace() {
		return eventPlace;
	}

	public void setEventPlace(String eventPlace) {
		this.eventPlace = eventPlace;
	}

	public LocalDateTime getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(LocalDateTime eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public LocalDateTime getEventEndDate() {
		return eventEndDate;
	}

	public void setEventEndDate(LocalDateTime eventEndDate) {
		this.eventEndDate = eventEndDate;
	}

	public String getEventDay() {
		return eventDay;
	}

	public void setEventDay(String eventDay) {
		this.eventDay = eventDay;
	}

	public Integer getYearOfEvent() {
		return yearOfEvent;
	}

	public void setYearOfEvent(Integer yearOfEvent) {
		this.yearOfEvent = yearOfEvent;
	}

	public String getEventFullAddress() {
		return eventFullAddress;
	}

	public void setEventFullAddress(String eventFullAddress) {
		this.eventFullAddress = eventFullAddress;
	}

	public String getEventGuest() {
		return eventGuest;
	}

	public void setEventGuest(String eventGuest) {
		this.eventGuest = eventGuest;
	}

	public String getEventManager() {
		return eventManager;
	}

	public void setEventManager(String eventManager) {
		this.eventManager = eventManager;
	}

	public Long getEventHelpLine() {
		return eventHelpLine;
	}

	public void setEventHelpLine(Long eventHelpLine) {
		this.eventHelpLine = eventHelpLine;
	}

	public String getEventQueryEmail() {
		return eventQueryEmail;
	}

	public void setEventQueryEmail(String eventQueryEmail) {
		this.eventQueryEmail = eventQueryEmail;
	}

}
