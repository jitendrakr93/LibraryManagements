package com.library.LibraryManagements.superadminlogin;

import org.jongo.Jongo;
import org.springframework.stereotype.Component;

import com.library.LibraryManagements.constants.MongoCollectionConstants;
import com.library.LibraryManagements.constants.ResponseConstants;
import com.library.LibraryManagements.mongodb.utils.MongoDBUtil;
import com.library.LibraryManagements.superadminvo.SuperAdmin;

@Component("superAdminLoginDaoImpl")
public class SuperAdminLoginDaoImpl implements SuperAdminLoginDao {

	@Override
	public SuperAdmin validateSuperAdmin(SuperAdmin superAdmin) {
		System.out.println("YESSS");
		SuperAdmin login = new Jongo(MongoDBUtil.getDB()).getCollection(MongoCollectionConstants.SUPER_ADMIN_CREDENTIAL)
				.findOne("{superAdminEmail:#,superAdminPassword:#}",
						superAdmin.getSuperAdminEmail(),
						superAdmin.getSuperAdminPassword())
				.as(SuperAdmin.class);
		if (login == null) {
			login=new SuperAdmin();
			login.setStatusCode(ResponseConstants.INVALID);
			login.setStatusMessage(ResponseConstants.INVALID_CREDENTIAL);
		} else {
			login.setStatusCode(ResponseConstants.SUCCESS);
			login.setStatusMessage(ResponseConstants.LOGIN_SUCCESS);
		}
		return login;

	}

}
