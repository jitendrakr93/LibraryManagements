package com.library.LibraryManagements.subadmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.LibraryManagements.subadminvo.SubAdmin;
import com.library.LibraryManagements.utils.CustomResponse;

@Service("subAdminService")
public class SubAdminService {

	@Autowired
	SubAdminDao subAdminDaoImpl;

	public CustomResponse registerSubAdmin(SubAdmin subAdmin) {
		return subAdminDaoImpl.registerSubAdmin(subAdmin);
	}
}
