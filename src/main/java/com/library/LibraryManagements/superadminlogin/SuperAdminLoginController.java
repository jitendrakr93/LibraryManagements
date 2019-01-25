package com.library.LibraryManagements.superadminlogin;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.LibraryManagements.exception.LibraryException;
import com.library.LibraryManagements.superadminvo.SuperAdmin;


@RestController
@RequestMapping("/superadmin")
public class SuperAdminLoginController {
	
	private static final Logger logger = Logger.getLogger(SuperAdminLoginController.class);
    
	@Autowired
	SuperAdminLoginService superAdminLoginService;
	@RequestMapping(value = "/superadminlogin", method = RequestMethod.POST, headers = "Accept=application/json")
	public SuperAdmin validateSuperAdmin(@RequestBody SuperAdmin superAdmin) {
		SuperAdmin superAdminResponse = null;
		try {
			System.out.println("HIII");
			superAdminResponse = superAdminLoginService.validateSuperAdmin(superAdmin);
		} catch (Exception e) {
			throw new LibraryException("Exception Occured While Validating User Admin",e);
		}
		return superAdminResponse;
	}
	
}
