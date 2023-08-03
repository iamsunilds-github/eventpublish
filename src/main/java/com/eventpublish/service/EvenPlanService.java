package com.eventpublish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventpublish.model.EventPlan;
import com.eventpublish.repositories.EventPlanRepository;

/**
 * 
 * @author
 *
 */
@Service
public class EvenPlanService {

	@Autowired
	private EventPlanRepository eventPlanRepo;

	@Autowired
	private EmailNotificationService emailNotificationService;

	/**
	 * 
	 * @param eventData
	 * @return
	 */
	public EventPlan createEventPlan(EventPlan eventData) {
		try {
			eventPlanRepo.save(eventData);
			/* try catch block within another try block */
			try {
				emailNotificationService.sendEmail(eventData.getEventName(), eventData.getEventDiscription());
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return eventData;
	}

}
