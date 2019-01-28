package com.library.LibraryManagements.subadmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.LibraryManagements.exception.LibraryException;
import com.library.LibraryManagements.subadminvo.SubAdmin;
import com.library.LibraryManagements.utils.CustomResponse;

@CrossOrigin
@RestController
@RequestMapping("subadmin")
public class SubAdminController {

	@Autowired
	SubAdminService subAdminService;

	@RequestMapping(value = "/subadminregister", method = RequestMethod.POST, headers = "Accept=application/json")
	public CustomResponse registerSubAdmin(@RequestBody SubAdmin subAdmin) {
		CustomResponse customResponse=null;
		try {
			customResponse=subAdminService.registerSubAdmin(subAdmin);
		}catch(LibraryException e) {
			throw new LibraryException("Getting Exception While Registering Sub Admin", e);
		}
		return customResponse;
	}
}
