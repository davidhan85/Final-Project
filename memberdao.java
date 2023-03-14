package com.topic;

import java.sql.Connection;
import java.util.List;

import com.bean.Memberbean;

public interface memberdao {

	//getConnection 建立連線
	Connection getConnection();

	//用會員編號尋找
	Memberbean showAMember(int m_number);

	//尋找所有會員
	List<Memberbean> showAllMember();

	//新增會員
	void insertMember(Memberbean Memberbean);

	//更新會員
	boolean updateMember();

	//刪除會員
	boolean deltetMember();

	//確認資料庫內是否有這組帳密
	boolean checkloginDB();

	//確認資料庫內是否有這組帳密
	boolean checkaccpwd();

}