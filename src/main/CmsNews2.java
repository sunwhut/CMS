package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CmsNews2{
	// 驱动程序名
	private String DBDRIVER = "com.mysql.jdbc.Driver";

	// URL指向要访问的数据库名
	private String DBURL = "jdbc:mysql://127.0.0.1:3306/score?useUnicode=true&characterEncoding=GBK";

	// MySQL配置时的用户名
	private String USERNAME = "root";

	// MySQL配置时的密码
	private String PASSWORD = "root";

	// 数据库连接对象
	private Connection conn = null;

	// 数据库操作对象
	private PreparedStatement stmt = null;

	/*
	 * //结果集 ResultSet rs = null;
	 */

	// 连接数据库
	public void connectDB() {
		// 1、加载驱动程序
		try {
			Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2、连接数据库
		// 通过连接管理器连接数据库
		try {
			// 在连接的时候直接输入用户名和密码才可以连接
			conn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 查询数据库
	public ResultSet selectDB(String id) {
		ResultSet rs = null;
		String sql = "select * from cmsnews where ID = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4、执行语句

		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;

	}

	// 查询栏目
	public ResultSet selectColumn(String column) {
		ResultSet rs = null;
		String sql = "select * from cmsnews where newsColumn = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, column);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 4、执行语句
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public void closeDB() {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertNews(String newsTitle, String content, String column,
			String newsTime) {
		String sql = "insert into cmsnews(newsColumn,newsTitle,newsTime,newsContent)"
				+ " values(?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, column);
			stmt.setString(2, newsTitle);
			stmt.setString(3, newsTime);
			stmt.setString(4, content);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public static void main(String[] args) { CmsNews2 cms2 = new CmsNews2();
	 * cms2.connectDB(); ResultSet rs = null; rs = cms2.selectDB(1); try {
	 * rs.next(); System.out.println(rs.getString("newsContent")); } catch
	 * (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } cms2.closeDB(); }
	 */

}
