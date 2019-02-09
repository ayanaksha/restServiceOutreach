package com.cts.cloud.enablement.onlinesales.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cts.cloud.enablement.onlinesales.domain.SalesTransaction;
import com.cts.cloud.enablement.onlinesales.domain.SalesUser;
import com.cts.cloud.enablement.onlinesales.service.SalesTransactionService;
import com.cts.cloud.enablement.onlinesales.service.SalesUserService;
import com.cts.cloud.enablement.onlinesales.service.SecurityTokenGenerator;

/**
 * @author 547991
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1")
public class SalesController {

	@Autowired
	SalesUserService salesUserService;
	
	@Autowired
	SalesTransactionService salesTransactionService;
	
	@Autowired
	private SecurityTokenGenerator tokenGenerator;
	
	@GetMapping("/testApi")
    public String testApi(){
        return "Testing App Success";
    }
	
	/**
	 * method to retrieve a user object from database by its username
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping(path = "/login")
	public ResponseEntity<?> retrieveUserByUsername(@RequestBody final SalesUser user, final HttpServletRequest request,
			final HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		Map<String, Object> map = new HashMap<String, Object>(); 
		SalesUser thisUser = null;
		try {
			thisUser = salesUserService.retrieveUserByEmpIDAndPassword(user);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		if(thisUser != null) {
			map = tokenGenerator.generateToken(thisUser);
		}
		map.put("loggedInUser", thisUser);
		responseEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		return responseEntity;
	}
	
	/**
	 * method to create a user object
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping(path = "/online-sales-service/registerUser")
	public ResponseEntity<?> createUser(@RequestBody final SalesUser user, final HttpServletRequest request,
			final HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		SalesUser thisUser = null;
		try {
			thisUser = salesUserService.createNewUser(user);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		responseEntity = new ResponseEntity<SalesUser>(thisUser, HttpStatus.OK);
		return responseEntity;
	}
	
	/**
	 * method to retrieve transactions from database by username
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping(path = "/online-sales-service/retrieveTransactions")
	public @ResponseBody ResponseEntity<?> retrieveTransactionDetails(@RequestBody final SalesUser user, final HttpServletRequest request,
			final HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		List<SalesTransaction> salesTransactionList = null;
		try {
			salesTransactionList = salesTransactionService.retrieveTransactionsByUser(user.getUsername());
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<SalesTransaction>>(salesTransactionList, HttpStatus.OK);
	}
	
	/**
	 * method to retrieve transaction for relationmanager from database by user details
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping(path = "/online-sales-service/retrieveRMTransactions")
	public @ResponseBody ResponseEntity<?> retrieveRelationshipManagerTransactionDetails(@RequestBody final SalesUser user, final HttpServletRequest request,
			final HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		List<SalesTransaction> salesRelationshipManagerTransactionList = null;
		try {
			salesRelationshipManagerTransactionList = salesTransactionService.retrieveRelationshipManagerTransactions(user.getUserEmailId());
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<SalesTransaction>>(salesRelationshipManagerTransactionList, HttpStatus.OK);
	}
	
	/**
	 * method to create a transaction
	 * @param salesTransactionDetails
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping(path = "/online-sales-service/submitTransaction")
	public @ResponseBody ResponseEntity<?> createTransactionDetails(@RequestBody final SalesTransaction salesTransactionDetails, final HttpServletRequest request,
			final HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		List<SalesTransaction> salesTransactionList = null;
		SalesUser requestedSalesUser = new SalesUser();
		try {
			requestedSalesUser.setUserEmailId(salesTransactionDetails.getRequestedBy());
			requestedSalesUser = salesUserService.retrieveUserByEmailId(requestedSalesUser);
			if(requestedSalesUser == null) {
				throw new Exception("Couldn't find user");
			}

			Optional<SalesUser> relationManager = salesUserService.retrieveRMByUser(requestedSalesUser).stream().findFirst();
			relationManager.orElseThrow(() -> new Exception("Couldn't find RM with user email id"));
			
			salesTransactionDetails.setRequestedBy(requestedSalesUser.getUserEmailId());
			salesTransactionDetails.setRmEmailId(relationManager.get().getUserEmailId());
			salesTransactionList = salesTransactionService.createTransaction(salesTransactionDetails);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<SalesTransaction>>(salesTransactionList, HttpStatus.OK);
	}
	
	
	/**
	 * method to save approval of a transaction
	 * @param salesTransactionDetails
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping(path = "/online-sales-service/submitTransactionApproval")
	public @ResponseBody ResponseEntity<?> submitTransactionApproval(@RequestBody final List<SalesTransaction> salesTransactionDetails, final HttpServletRequest request,
			final HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		List<SalesTransaction> salesTransactionList = null; 
		try {
			salesTransactionList = salesTransactionService.updateTransaction(salesTransactionDetails);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return new ResponseEntity<List<SalesTransaction>>(salesTransactionList, HttpStatus.OK);
	}
	
	/**
	 * method to submit payment for a transaction
	 * @param salesTransactionDetails
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping(path = "/online-sales-service/submitPaidTransaction")
	public @ResponseBody ResponseEntity<?> submitPaidTransaction(@RequestBody final SalesTransaction salesTransactionDetails, final HttpServletRequest request,
			final HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		List<SalesTransaction> salesTransactionList = null; 
		salesTransactionList = salesTransactionService.updateTransaction(salesTransactionDetails); 
		return new ResponseEntity<List<SalesTransaction>>(salesTransactionList, HttpStatus.OK);
	}
}