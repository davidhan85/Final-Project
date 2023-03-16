package com.bean;

import java.io.Serializable;
import java.sql.Date;

public class Memberbean implements Serializable  {
private static final long serialVersionUID = 1L;
private int m_number;
private String m_account;
private String m_password;
private String m_name;
private String m_phone;
private String m_address;
private String m_email;
private Date m_birth;
private Date m_creatdate;
private int m_points;
private String m_id;
private String m_verify;

//全部的欄位
public Memberbean(int m_number, String m_account,String m_password,String m_name,String m_phone,String m_address,String m_email,Date m_birth,Date m_creatdate,int m_points,String m_id) {
	super();
	this.m_number = m_number;
	this.m_account = m_account;
	this.m_password = m_password;
	this.m_name = m_name;
	this.m_phone = m_phone;	 
	this.m_address = m_address;
	this.m_email = m_email;
	this.m_birth = m_birth;
	this.m_creatdate = m_creatdate;
	this.m_points = m_points;
	this.m_id = m_id;
		
}
//除去m_number的欄位
public Memberbean( String m_account,String m_password,String m_name,String m_phone,String m_address,String m_email,Date m_birth,Date m_creatdate,int m_points,String m_id) {
	super();
	this.m_account = m_account;
	this.m_password = m_password;
	this.m_name = m_name;
	this.m_phone = m_phone;	 
	this.m_address = m_address;
	this.m_email = m_email;
	this.m_birth = m_birth;
	this.m_creatdate = m_creatdate;
	this.m_points = m_points;
	this.m_id = m_id;
		
}


public int getM_number() {
	return m_number;
}
public void setM_number(int m_number) {
	this.m_number = m_number;
}
public String getM_account() {
	return m_account;
}
public void setM_account(String m_account) {
	this.m_account = m_account;
}
public String getM_password() {
	return m_password;
}
public void setM_password(String m_password) {
	this.m_password = m_password;
}
public String getM_name() {
	return m_name;
}
public void setM_name(String m_name) {
	this.m_name = m_name;
}
public String getM_phone() {
	return m_phone;
}
public void setM_phone(String m_phone) {
	this.m_phone = m_phone;
}
public String getM_address() {
	return m_address;
}
public void setM_address(String m_address) {
	this.m_address = m_address;
}
public String getM_email() {
	return m_email;
}
public void setM_email(String m_email) {
	this.m_email = m_email;
}
public Date getM_birth() {
	return m_birth;
}
public void setM_birth(Date m_birth) {
	this.m_birth = m_birth;
}
public Date getM_creatdate() {
	return m_creatdate;
}
public void setM_creatdate(Date m_creatdate) {
	this.m_creatdate = m_creatdate;
}
public int getM_points() {
	return m_points;
}
public void setM_points(int m_points) {
	this.m_points = m_points;
}
public String getM_id() {
	return m_id;
}
public void setM_id(String m_id) {
	this.m_id = m_id;
}
public String getM_verify() {
	return m_verify;
}
public void setM_verify(String m_verify) {
	this.m_verify = m_verify;
}

}
