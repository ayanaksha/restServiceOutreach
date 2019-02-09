package com.cts.cloud.enablement.onlinesales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.cloud.enablement.onlinesales.domain.SalesUser;

/**
 * @author 547991
 *
 */
public interface EventRepository extends JpaRepository<Event, Long> {
	
	Event findByID(Long eventID);
	
	List<Event> findByTypeOrderByEventTimeAsc(String eventType);
	
	List<Event> findByStatusOrderByEventTimeAsc(String status);
	
	List<Event> findByLocationOrderByEventTimeAsc(String location);
	
	List<Event> findByLocationAndStatusOrderByEventTimeAsc(String location, String Status);
	
	List<Event> findByPocIDAndStatusOrderByEventTimeAsc(Long pocID, String Status);
	
}