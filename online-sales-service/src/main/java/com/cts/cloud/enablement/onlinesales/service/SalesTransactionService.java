package com.cts.cloud.enablement.onlinesales.service;

import java.util.List;

import com.cts.cloud.enablement.onlinesales.domain.SalesTransaction;

/**
 * @author 547991
 *
 */
public interface SalesTransactionService {
	
	List<SalesTransaction> retrieveTransactionsByUser(Long empID);
	
	List<SalesTransaction> retrieveTransactionsByProjID(Long projID);
	
	List<SalesTransaction> retrievePocTransactions(Long pocID);
	
	List<SalesTransaction> retrieveEventTransactions(Long eventID);

	List<SalesTransaction> createTransaction(SalesTransaction salesTransaction) throws Exception;
	
	List<SalesTransaction> updateTransactionStatus(Long eventID);
	
}
