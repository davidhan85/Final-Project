package com.topic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bean.Memberbean;
import com.bean.connectionbean;

public class memberdaopractice implements memberdao {
	//getConnection 建立連線
	@Override
	public Connection getConnection() throws SQLException {
		connectionbean conn = new connectionbean();
		return conn.getConnection();
					
	}
	//用會員編號尋找
	@Override
	public Memberbean showAMember(int m_number) {
		return null;
	}
	//尋找所有會員
	@Override
	public List<Memberbean> showAllMember() {
		return null;
	}
	//新增會員
	@Override
	public void insertMember(Memberbean Memberbean) {
		
	}
	//更新會員
	@Override
	public boolean updateMember() {
		return false;
		
	}
	//刪除會員
	@Override
	public boolean deltetMember() {
		return false;		
	}
	//確認資料庫內是否有這組帳密
	@Override
	public boolean checkloginDB() {
		return false;		
	}
	//確認資料庫內是否有這組帳密
	@Override
	public boolean checkaccpwd() {
		return false;	
	}
}
