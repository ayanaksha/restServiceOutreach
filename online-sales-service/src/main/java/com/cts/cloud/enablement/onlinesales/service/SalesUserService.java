package com.cts.cloud.enablement.onlinesales.service;

import java.util.List;

import com.cts.cloud.enablement.onlinesales.domain.SalesUser;

/**
 * @author 547991
 *
 */
public interface SalesUserService {

	SalesUser retrieveUserByEmpID(SalesUser user);
	
	SalesUser retrieveUserByEmailId(SalesUser user);
	
	SalesUser retrieveUserByEmpIDAndPassword(SalesUser user);
	
	SalesUser retrieveUserByEmpEmailIdAndPassword(SalesUser user);
	
	SalesUser createNewUser(SalesUser user);
	
	SalesUser updateUserRole(SalesUser user);
	
	List<SalesUser> retrieveEmpByProj(SalesUser user);
	
}