package com.cts.cloud.enablement.onlinesales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.cloud.enablement.onlinesales.domain.SalesUser;

/**
 * @author 547991
 *
 */
//public interface SalesUserRepository extends JpaRepository<SalesUser, Long> {
//	
//	SalesUser findByUsername(String username);
//	
//	SalesUser findByUserEmailId(String userEmailId);
//	
//	SalesUser findByUsernameAndPassword(String username, String password);
//	
//	SalesUser findByUserEmailIdAndPassword(String userEmailId, String password);
//	
//	SalesUser findById(long id);
//	
//	List<SalesUser> findByRole(String role);
//	
//	List<SalesUser> findByRoleAndLocation(String role, String location);
//	
//	List<SalesUser> findByLocation(String location);
//}


public interface SalesUserRepository extends JpaRepository<SalesUser, Long> {
	
	SalesUser findByEmpID(Long empid);
	
	SalesUser findByUserEmailId(String userEmailId);
	
	SalesUser findByEmpIDAndPassword(Long EmpID, String password);
	
	SalesUser findById(long id);
	
	List<SalesUser> findByRole(String role);
	
	List<SalesUser> findByRoleAndLocation(String role, String location);
	
	List<SalesUser> findByLocation(String location);
	
	List<SalesUser> findByProjID(Long projID);
	
	List<SalesUser> findByProjName(Long projname);
}