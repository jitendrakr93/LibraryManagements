package com.library.LibraryManagements.superadminvo;

import com.library.LibraryManagements.utils.CustomResponse;

public class SuperAdmin extends CustomResponse{
	private long superAdminId;
	private String superAdminName;
	private long superAdminPhone;
	private String superAdminEmail;
	private String superAdminPassword;
	
	public long getSuperAdminId() {
		return superAdminId;
	}
	public void setSuperAdminId(long superAdminId) {
		this.superAdminId = superAdminId;
	}
	public String getSuperAdminName() {
		return superAdminName;
	}
	public void setSuperAdminName(String superAdminName) {
		this.superAdminName = superAdminName;
	}
	public long getSuperAdminPhone() {
		return superAdminPhone;
	}
	public void setSuperAdminPhone(long superAdminPhone) {
		this.superAdminPhone = superAdminPhone;
	}
	public String getSuperAdminEmail() {
		return superAdminEmail;
	}
	public void setSuperAdminEmail(String superAdminEmail) {
		this.superAdminEmail = superAdminEmail;
	}
	public String getSuperAdminPassword() {
		return superAdminPassword;
	}
	public void setSuperAdminPassword(String superAdminPassword) {
		this.superAdminPassword = superAdminPassword;
	}
	

}
