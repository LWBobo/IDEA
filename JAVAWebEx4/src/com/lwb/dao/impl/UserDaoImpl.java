package com.lwb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lwb.dao.UserDao;
import com.lwb.dao.util.JDBCutil;
import com.lwb.pojo.MsBoard;
import com.lwb.pojo.User;

public class UserDaoImpl implements UserDao{
	//根据用户名和密码查询用户信息
	@Override
	public User checkUserLoginDao(String uname, String pwd) {
		//声明jdbc对象
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//声明变量
		User u=null;
		try {
			//获取连接
			conn=JDBCutil.getMysqlConn();
			//创建sql命令
			String sql="select * from t_user where uname=? and pwd=?";
			//创建sql命令对象
			ps=conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, uname);
			ps.setString(2, pwd);
			//执行sql
			rs=ps.executeQuery();
			//遍历结果
			while(rs.next()){
				//给变量赋值
				u=new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
				u.setSex(rs.getString("sex"));
				u.setAge(rs.getInt("age"));
				u.setBirth(rs.getString("birth"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			try {
				if(null != rs) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		//返回结果
		return u;
	}
	//根据用户ID修改用户密码
	@Override
	public int userChangePwdDao(String newPwd, int uid) {
		//声明jdbc对象
		Connection conn=null;
		PreparedStatement ps=null;
		//创建变量
		int index=-1;
		try {
			//获取连接
			conn=JDBCutil.getMysqlConn();
			//创建SQL命令
			String sql="update t_user set pwd=? where uid=?";
			//创建SQL命令对象
			ps=conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, newPwd);
			ps.setInt(2, uid);
			//执行
			index=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{//关闭资源
			try {
				if(ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//返回结果
		return index;
	}
	//获取所有的用户信息
	@Override
	public List<User> userShowDao() {
		//声明jdbc对象
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//声明变量
		List<User> lu=null;
		try {
			//加载驱动
			conn=JDBCutil.getMysqlConn();
			//创建sql命令
			String sql="select * from t_user";
			//创建sql命令对象
			ps=conn.prepareStatement(sql);
			//执行sql
			rs=ps.executeQuery();
			//给集合赋值
			lu=new ArrayList<User>();
			//遍历结果
			while(rs.next()){
				//给变量赋值
				User u=new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
				u.setSex(rs.getString("sex"));
				u.setAge(rs.getInt("age"));
				u.setBirth(rs.getString("birth"));
				//将对象存储到集合中
				lu.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			try {
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		//返回结果
		return lu;
	}
	//用户注册
	@Override
	public int userRegDao(User u) {
		//声明jdbc对象
		Connection conn=null;
		PreparedStatement ps=null;
		//声明变量
		int index=-1;
		try {
			conn=JDBCutil.getMysqlConn();
			//创建SQL命令
			String sql="insert into t_user values(default,?,?,?,?,?)";
			//创建SQL命令对象
			ps=conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1,u.getUname());
			ps.setString(2, u.getPwd());
			ps.setString(3, u.getSex());
			ps.setInt(4, u.getAge());
			ps.setString(5, u.getBirth());
			//执行
			index=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{//关闭资源
			try {
				if(ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//返回结果
		return index;
	}

	@Override
	public int userMsBoard(MsBoard msboard) {
		//声明jdbc对象
		Connection conn=null;
		PreparedStatement ps=null;
		//声明变量
		int index=-1;
		try {
			conn=JDBCutil.getMysqlConn();
			//创建SQL命令
			String sql="insert into msboard values(default,?,?,?,?,?)";
			//创建SQL命令对象
			ps=conn.prepareStatement(sql);
			//给占位符赋值
			ps.setInt(1,msboard.getUid());
			ps.setString(2,msboard.getUname());
			ps.setString(3,msboard.getMstitle());
			ps.setString(4,msboard.getMskeyword());
			ps.setString(5,msboard.getMsinfo());
			//执行
			index=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{//关闭资源
			try {
				if(ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//返回结果
		return index;
	}

	/**
	 * 获取所有用户留言信息
	 * @return
	 */
	@Override
	public List<MsBoard> userMsShowDao() {

		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//声明变量
		List<MsBoard> lm=null;
		try {
			//加载驱动
			conn=JDBCutil.getMysqlConn();
			//创建sql命令
			String sql="select * from msboard";
			//创建sql命令对象
			ps=conn.prepareStatement(sql);
			//执行sql
			rs=ps.executeQuery();
			//给集合赋值
			lm=new ArrayList<MsBoard>();
			//遍历结果
			while(rs.next()){
				//给变量赋值
				MsBoard m = new MsBoard();
				m.setUid(rs.getInt("uid"));
				m.setUname(rs.getString("uname"));
				m.setMstitle(rs.getString("mstitle"));
				m.setMskeyword(rs.getString("mskeyword"));
				m.setMsinfo(rs.getString("msinfo"));
				//将对象存储到集合中
				lm.add(m);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			try {
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


		//返回结果
		return lm;

	}


}
