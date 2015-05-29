package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CmsNews2{
	// ����������
	private String DBDRIVER = "com.mysql.jdbc.Driver";

	// URLָ��Ҫ���ʵ����ݿ���
	private String DBURL = "jdbc:mysql://127.0.0.1:3306/score?useUnicode=true&characterEncoding=GBK";

	// MySQL����ʱ���û���
	private String USERNAME = "root";

	// MySQL����ʱ������
	private String PASSWORD = "root";

	// ���ݿ����Ӷ���
	private Connection conn = null;

	// ���ݿ��������
	private PreparedStatement stmt = null;

	/*
	 * //����� ResultSet rs = null;
	 */

	// �������ݿ�
	public void connectDB() {
		// 1��������������
		try {
			Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2���������ݿ�
		// ͨ�����ӹ������������ݿ�
		try {
			// �����ӵ�ʱ��ֱ�������û���������ſ�������
			conn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ��ѯ���ݿ�
	public ResultSet selectDB(String id) {
		ResultSet rs = null;
		String sql = "select * from cmsnews where ID = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4��ִ�����

		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;

	}

	// ��ѯ��Ŀ
	public ResultSet selectColumn(String column) {
		ResultSet rs = null;
		String sql = "select * from cmsnews where newsColumn = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, column);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 4��ִ�����
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
