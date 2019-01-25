package com.library.LibraryManagements.subadmin;

import org.jongo.Jongo;
import org.springframework.stereotype.Component;

import com.library.LibraryManagements.constants.MongoCollectionConstants;
import com.library.LibraryManagements.constants.ResponseConstants;
import com.library.LibraryManagements.exception.LibraryException;
import com.library.LibraryManagements.mongodb.utils.MongoDBUtil;
import com.library.LibraryManagements.subadminvo.SubAdmin;
import com.library.LibraryManagements.utils.CustomResponse;

@Component("subAdminDaoImpl")
public class SubAdminDaoimpl implements SubAdminDao{

	@Override
	public CustomResponse registerSubAdmin(SubAdmin subAdmin) {
		CustomResponse customResponse=new CustomResponse();
		try {
			new Jongo(MongoDBUtil.getDB()).getCollection(MongoCollectionConstants.SUB_ADMIN_DETAILS).insert(subAdmin);
			customResponse.setStatusCode(ResponseConstants.SUCCESS);
			customResponse.setStatusMessage(ResponseConstants.REGISTRATION_SUCCESS);
		}catch (LibraryException e) {
			throw new LibraryException("Getting Exception While Storing Sub Admin Details into db", e);
		}
		return customResponse;
	}
	

}
