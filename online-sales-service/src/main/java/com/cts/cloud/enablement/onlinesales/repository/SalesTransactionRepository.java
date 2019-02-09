package com.cts.cloud.enablement.onlinesales.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.cloud.enablement.onlinesales.domain.SalesTransaction;

/**
 * @author 547991
 *
 */
public interface SalesTransactionRepository extends JpaRepository<SalesTransaction, Long> {
	
	List<SalesTransaction> findByPocIDOrderByStatusAsc(Long pocID);
	
	List<SalesTransaction> findByEmpIDAndStatus(Long empID, String status);
	
	SalesTransaction findByEmpIDAndEventID(Long empID, Long eventID);
	
	SalesTransaction findByEmpIDAndEventTime(Long empID, String eventTime);
	
	List<SalesTransaction> findByEmpID(Long empID);
	
	List<SalesTransaction> findByProjID(Long ProjID);
	
	List<SalesTransaction> findByEmpIDIn(List<Long> userList);
	
	List<SalesTransaction> findByPocIDInAndStatus(List<Long> userList, String status);
	
	List<SalesTransaction> findByEventIDIn(List<Long> eventList);
	
	List<SalesTransaction> findByEventID(Long eventID);
	
	SalesTransaction findById(int id);
}