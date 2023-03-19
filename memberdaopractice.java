package com.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.bean.Memberbean;
import com.bean.connectionbean;

public class memberdaopractice implements memberdao {
	private boolean deletecount; 
//	private boolean updatacount=false;
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
	public static final String SELECT_MEMBER_SQL="select [member_number],[member_account],[member_password],[member_name],[member_phone],[member_address]"
			+ ",[member_email],[member_birth] ,[member_creatdate] ,[member_points],[member_id],[member_verify]"
			+ "  FROM [dbo].[memderdata] where [member_number]=?";
	public static final String INSERT_MEMBER_SQL="INSERT INTO [dbo].[memderdata]"
			+"(member_account,member_password,member_name,member_phone,member_address,member_email,member_birth,member_creatdate,member_points,member_id)"
			+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
	public static final String SELECT_ALLMEMBER_SQL="SELECT * from dbo.memderdata";
	public static final String DELETE_MEMBER_SQL="DELETE FROM [dbo].[memderdata]"
	 		+"WHERE [member_number]=?";
	public static final String UPDATE_MEMBER_SQL="UPDATE [dbo].[memderdata]"
			+ "+ SET [member_account] =?,[member_password] =?,[member_name] =?,[member_phone] =?,[member_address]=?,[member_email]=?,[member_birth]=?,[member_points]=?,[member_id]=?"
			+ "+ WHERE [member_number]=?";
	
	//getConnection 建立連線
	@Override
	public Connection getConnection() throws SQLException{
		connectionbean conn;	
		conn = new connectionbean();
		return conn.getConnection();				
	}
	//用會員編號尋找
	@Override
	public Memberbean showAMember(int m_number) {
		Memberbean Memberbean=null;
		try {
				Class.forName(JDBC_DRIVER);
			Connection conn=getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_MEMBER_SQL);
			pstmt.setInt(1,m_number );
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String account=rs.getString("member_account");
				String password=rs.getString("member_password");
				String name=rs.getString("member_name");
				String phone=rs.getString("member_phone");
				String address=rs.getString("member_address");
				String email=rs.getString("member_email");
				Date birth=rs.getDate("member_birth");
				Date creatdate=rs.getDate("member_creatdate");
				int point=rs.getInt("member_points");
				String id=rs.getString("member_id");
				Memberbean=new Memberbean(account,password,name,phone,address,email,birth,creatdate,point,id);
			}
	
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return Memberbean;
	}
	//尋找所有會員
	@Override
	public List<Memberbean> showAllMember() {
		List<Memberbean> member = new ArrayList<>();
		try {
			Class.forName(JDBC_DRIVER);
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALLMEMBER_SQL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int no=rs.getInt("member_number");
				String account=rs.getString("member_account");
				String password=rs.getString("member_password");
				String name=rs.getString("member_name");
				String phone=rs.getString("member_phone");
				String address=rs.getString("member_address");
				String email=rs.getString("member_email");
				Date birth=null;
				if(rs.getDate("member_birth")!=null) {
					birth=rs.getDate("member_birth");
				}
				Date creatdate=null;
				if(rs.getDate("member_creatdate")!=null) {
					creatdate=rs.getDate("member_creatdate");
				}
				int point=rs.getInt("member_points");
				String id=rs.getString("member_id");
				member.add(new Memberbean(no,account,password,name,phone,address,email,birth,creatdate,point,id));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return member;
	}
	//新增會員
	@Override
	public void insertMember(Memberbean Memberbean) {
		try {
			Class.forName(JDBC_DRIVER);
			LocalDate createTime = LocalDate.now();
			//Connection conn=getConnection();
			Connection conn = null;
			try {
				InitialContext context = new InitialContext();
				DataSource ds=(DataSource)context.lookup("java:/comp/env/jdbc/servdb");
				conn = ds.getConnection();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PreparedStatement pstmt = conn.prepareStatement(INSERT_MEMBER_SQL);
			pstmt.setString(1,Memberbean.getM_account());
			pstmt.setString(2,Memberbean.getM_password());
			pstmt.setString(3,Memberbean.getM_name());
			pstmt.setString(4,Memberbean.getM_phone());
			pstmt.setString(5,Memberbean.getM_address());
			pstmt.setString(6, Memberbean.getM_email());
			pstmt.setDate(7,new Date(Memberbean.getM_birth().getTime()));
			pstmt.setDate(8, Date.valueOf(createTime));
			pstmt.setInt(9,Memberbean.getM_points());
			pstmt.setString(10,Memberbean.getM_id());
			pstmt.executeUpdate();
			conn.close();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	//更新會員
	@Override
	public boolean updateMember(Memberbean Memberbean) {
		try {
			Connection conn=getConnection();
			PreparedStatement pstmt = conn.prepareStatement(UPDATE_MEMBER_SQL);
			pstmt.setString(1,Memberbean.getM_account());
			pstmt.setString(2,Memberbean.getM_password());
			pstmt.setString(3,Memberbean.getM_name());
			pstmt.setString(4,Memberbean.getM_phone());
			pstmt.setString(5,Memberbean.getM_address());
			pstmt.setString(6, Memberbean.getM_email());
			pstmt.setDate(7,new Date( Memberbean.getM_birth().getTime()));
			pstmt.setInt(8,Memberbean.getM_points());
			pstmt.setString(9,Memberbean.getM_id());
		   int updatacount=pstmt.executeUpdate();
		   conn.close();
		   return updatacount>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;		
	}
	//刪除會員
	@Override
	public boolean deltetMember(int m_number) {
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(DELETE_MEMBER_SQL);
			pstmt.setInt(1,m_number);			
			  deletecount = pstmt.executeUpdate()>0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deletecount;		
		
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
