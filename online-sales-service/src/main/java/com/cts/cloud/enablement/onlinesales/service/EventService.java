package com.cts.cloud.enablement.onlinesales.service;

import java.util.List;

import com.cts.cloud.enablement.onlinesales.domain.SalesTransaction;

/**
 * @author 547991
 *
 */
public interface EventService {
	
	List<Event> retrieveEventByPoc(Long pocID);
	
	List<Event> retrieveEventByLocation(String location);
	
	List<Event> createEvent(Event event) throws Exception;
	
	Event updateEventStatus(Long eventID);
	
}
