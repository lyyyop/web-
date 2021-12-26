package web.z;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 * 
 * 存放各类方法
 *
 */
public class UserService {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/db232?useUnicode=true&characterEncoding=utf8";
			String user = "root";
			String pass = "111111";

			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库驱动错误！");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库SQL错误！");
		}
		return conn;
	}
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	public static boolean userLogin(String username, String password) {
		// 注册驱动
		try {
			Connection conn = UserService.getConnection();
			QueryRunner qr = new QueryRunner();
			String sql = "select count(*) from t_user where name=? and password=?";
			Long r = qr.query(conn, sql, new ScalarHandler<Long>(), username, password);
			if (r > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库SQL错误！");
			return false;
		}
	}
	/**
	 * 用户注册
	 * @param username用户名
	 * @param password密码
	 * @param sex性别
	 * @param regTime 注册日期
	 * @param ip注册ip
	 * @param sign签名
	 * @param age年龄
	 */
	public static void addUser(String username, String password, String sex, String ip, Date regTime,String sign,String age) {
		try {
			Connection conn = UserService.getConnection();
			QueryRunner qr = new QueryRunner();
			String sql = "insert into t_user(name,password,sex,ip,date,sign,age) values(?,?,?,?,?,?,?)";
			qr.update(conn, sql, username, password, sex, ip, regTime, sign, age);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库SQL错误！");
		}
	}
	/**
	 * 添加人物卡
	 * @param name名字
	 * @param sex性别
	 * @param age年龄
	 * @param major职业
	 * @param sum总点数
	 * @param exp经历
	 * @param now现在状态
	 * @param user用户
	 */
	public static void addPc(String name, String sex, String age, String major, String sum,String exp,String now,String user) {
		try {
			Connection conn = UserService.getConnection();
			QueryRunner qr = new QueryRunner();
			String sql = "insert into t_pc(name, sex, age, major, sum, experience, now, user) values(?,?,?,?,?,?,?,?)";
			qr.update(conn, sql, name, sex, age, major, sum, exp, now, user);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库SQL错误！");
		}
	}
	/**
	 * 展示该用户名下信息
	 * @param username 用户名
	 * @return
	 */
	public static TUser getUserInfo(String username) {
		Connection conn = UserService.getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "select id,name as username,password,sex,date as regTime,ip,sign,age,kpl from t_user where name=?";
		TUser user = null;
		try {
			user = qr.query(conn, sql, new BeanHandler<TUser>(TUser.class), username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库SQL错误！");
		}
		return user;
	}
	
	/**
	 * 展示该用户名下所有人物卡集合
	 * @param username 用户名 
	 * @return
	 */
		public static List<TPc> getPc(String username) {
			Connection conn = UserService.getConnection();
			QueryRunner qr = new QueryRunner();
			String sql = "select id,name as pcname,sex,major,age,sum,experience as exp,now from t_pc where user=?";
			List<TPc> pcList = null;
			try {
				pcList = qr.query(conn, sql, new BeanListHandler<TPc>(TPc.class),username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("数据库SQL错误！");
			}

			return pcList;
		}
	/**
	 * 根据关键词模糊查询
	 * @param key
	 * @return
	 */
	public static List<TUser> queryUserByUsername(String key) {
		Connection conn = UserService.getConnection();
		QueryRunner qr = new QueryRunner();
		key = "%" + key + "%";
		String sql = "select id,name as username,password,sex,ip,date,sign,age,kpl from t_user where name like ?";
		List<TUser> userList = null;
		try {
			userList = qr.query(conn, sql, new BeanListHandler<TUser>(TUser.class), key);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库SQL错误！");
		}
		return userList;
	}

	/**
	 * 修改密码
	 * @param username用户名
	 * @param oldPwd原始密码
	 * @param newPwd新密码
	 * @return
	 */
	public static int updatePassword(String username, String oldPwd, String newPwd) {
		Connection conn = UserService.getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "update t_user set password=? where name=? and password=?";
		try {
			return qr.update(conn, sql, oldPwd, username, newPwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 用户状态改成pl
	 * @param id
	 * @return
	 */
	public static int invalidUser(int id) {
		Connection conn = UserService.getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "update t_user set kpl = 0 where id=?";
		try {
			return qr.update(conn, sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 用户状态改成kp
	 * @param id
	 * @return
	 */
	public static int restoreUser(int id) {
		Connection conn = UserService.getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "update t_user set kpl=1 where id=?";
		try {
			return qr.update(conn, sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	/**
	 * 分页展示所有论坛聊天内容
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static List<TChat> getChat(int pageNo,int pageSize) {
		Connection conn = UserService.getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "select id,user,content,time from t_chat limit ?,?";
		List<TChat> chatList = null;
		try {
			chatList = qr.query(conn, sql, new BeanListHandler<TChat>(TChat.class),(pageNo-1)*pageSize,pageSize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库SQL错误！");
		}

		return chatList;
	}
	/**
	 * 展示两用户之间私信内容
	 * @param user1 用户1
	 * @param user2 用户2
	 * @return
	 */
	public static List<TMessage> getMessage(String user1,String user2) {
		Connection conn = UserService.getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "select id,suser,tuser,content,time from t_message where suser=? and tuser=? or suser=? and tuser=?";
		List<TMessage> messageList = null;
		try {
			messageList = qr.query(conn, sql, new BeanListHandler<TMessage>(TMessage.class),user1,user2,user2,user1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库SQL错误！");
		}

		return messageList;
	}
	/**
	 * 发表回复
	 * @param content评论内容
	 * @param time时间
	 * @param user用户
	 */
	public static void reply(String content,Date time,String user) {
		try {
			Connection conn = UserService.getConnection();
			QueryRunner qr = new QueryRunner();
			String sql = "insert into t_chat(user,time,content) values(?,?,?)";
			qr.update(conn, sql, user,time,content);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库SQL错误！");
		}
	}
	/**
	 * 发送私信
	 * @param content内容
	 * @param time时间
	 * @param suser发送用户
	 * @param tuser接受用户
	 */
	public static void send(String content,Date time,String suser,String tuser) {
		try {
			Connection conn = UserService.getConnection();
			QueryRunner qr = new QueryRunner();
			String sql = "insert into t_message(time,content,tuser,suser) values(?,?,?,?)";
			qr.update(conn, sql, time,content,tuser,suser);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库SQL错误！");
		}
	}
	/**
	 * 展示该用户收到的私信列表
	 * @param user 用户名
	 * @return
	 */
	public static List<TMessage> getMessagelist(String user) {
		Connection conn = UserService.getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "select distinct suser from t_message where tuser=?";
		List<TMessage> messageList = null;
		try {
			messageList = qr.query(conn, sql, new BeanListHandler<TMessage>(TMessage.class),user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库SQL错误！");
		}

		return messageList;
	}
}
