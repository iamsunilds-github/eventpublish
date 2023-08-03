package com.eventpublish.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eventpublish.model.EventPlan;
import com.eventpublish.service.EmailNotificationService;
import com.eventpublish.service.EvenPlanService;

@RestController
@RequestMapping("api")
public class EventController {

	private static final Logger log = LoggerFactory.getLogger(EventController.class);

	@Autowired
	private EvenPlanService evenplanService;

	@Autowired
	private EmailNotificationService emailNotificationService;

	/**
	 * 
	 * @return
	 */
	@GetMapping("")
	public ResponseEntity<?> eventDefaultResourse() {
		log.info("welcome to event publishing system");
		return new ResponseEntity<>("welcome to event publishing system", HttpStatus.OK);
	}

	/**
	 * 
	 * @param eventdata
	 * @return
	 */
	@PostMapping("eventplan")
	public ResponseEntity<?> createEvent(@RequestBody EventPlan eventdata) {

		try {
			return new ResponseEntity<>(evenplanService.createEventPlan(eventdata), HttpStatus.CREATED);
		} catch (Exception eventException) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * 
	 * @param emailSubject
	 * @param emailBody
	 * @return
	 */
	@PostMapping("event-notify")
	public ResponseEntity<?> sendEmailNotification(@RequestParam String emailSubject, @RequestParam String emailBody) {
		try {
			emailNotificationService.sendEmail(emailSubject, emailBody);
			return new ResponseEntity<>("Email Send Successfully", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
