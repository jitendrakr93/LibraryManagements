package com.library.LibraryManagements.subadmin;

import org.jongo.Jongo;
import org.springframework.stereotype.Component;

import com.library.LibraryManagements.constants.MongoCollectionConstants;
import com.library.LibraryManagements.constants.ResponseConstants;
import com.library.LibraryManagements.exception.LibraryException;
import com.library.LibraryManagements.mongodb.utils.MongoDBUtil;
import com.library.LibraryManagements.subadminvo.SubAdmin;
import com.library.LibraryManagements.utils.AutoIncrement;
import com.library.LibraryManagements.utils.CustomResponse;

@Component("subAdminDaoImpl")
public class SubAdminDaoimpl implements SubAdminDao{

	@Override
	public CustomResponse registerSubAdmin(SubAdmin subAdmin) {
		CustomResponse customResponse=new CustomResponse();
		try {
			SubAdmin subAdminFromDb=new Jongo(MongoDBUtil.getDB()).getCollection(MongoCollectionConstants.SUB_ADMIN_DETAILS).findOne("{subAdminEmail:#}", subAdmin.getSubAdminEmail())
					.as(SubAdmin.class);
			if(subAdminFromDb == null) {
				subAdminFromDb=new Jongo(MongoDBUtil.getDB()).getCollection(MongoCollectionConstants.SUB_ADMIN_DETAILS).findOne("{subAdminMobileNo:#}", subAdmin.getSubAdminMobileNo())
						.as(SubAdmin.class);
				if(subAdminFromDb == null) {
					long subAdminId=AutoIncrement.getNextSequenceForSubAdminId();
					subAdmin.setSubAdminId(subAdminId);
					new Jongo(MongoDBUtil.getDB()).getCollection(MongoCollectionConstants.SUB_ADMIN_DETAILS).insert(subAdmin);
					customResponse.setStatusCode(ResponseConstants.SUCCESS);
					customResponse.setStatusMessage(ResponseConstants.REGISTRATION_SUCCESS);
				}else {
					customResponse.setStatusCode(ResponseConstants.DATA_ALREADY_EXISTS);
					customResponse.setStatusMessage(ResponseConstants.PHONE_EXISTS);
				}
			}else {
				customResponse.setStatusCode(ResponseConstants.DATA_ALREADY_EXISTS);
				customResponse.setStatusMessage(ResponseConstants.EMAIL_EXISTS);
			}
			
		}catch (LibraryException e) {
			throw new LibraryException("Getting Exception While Storing Sub Admin Details into db", e);
		}
		return customResponse;
	}
	

}
