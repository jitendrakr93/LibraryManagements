package com.library.LibraryManagements.superadminlogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.LibraryManagements.superadminvo.SuperAdmin;

@Service("superAdminLoginService")
public class SuperAdminLoginService {

	@Autowired
	SuperAdminLoginDao superAdminLoginDaoImpl;
	
	public SuperAdmin validateSuperAdmin(SuperAdmin superAdmin) {
		return superAdminLoginDaoImpl.validateSuperAdmin(superAdmin);
	}

}
