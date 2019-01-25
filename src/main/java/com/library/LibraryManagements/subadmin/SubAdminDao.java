package com.library.LibraryManagements.subadmin;

import com.library.LibraryManagements.subadminvo.SubAdmin;
import com.library.LibraryManagements.utils.CustomResponse;

public interface SubAdminDao {

	CustomResponse registerSubAdmin(SubAdmin subAdmin);

}
