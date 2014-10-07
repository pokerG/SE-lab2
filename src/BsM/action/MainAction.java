package BsM.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import BsM.model.Book;
import BsM.model.Global;
import BsM.util.DBPool;

import com.opensymphony.xwork2.ActionSupport;

public class MainAction extends ActionSupport {
	
	private String keyword;

	private List<Book> result = new ArrayList<Book>();

	public String execute() {
		if (this.keyword.trim().isEmpty()) {
			addActionError("Keyword is invalid!");
			return ERROR;
		} else {
			String ret = ERROR;
			Connection conn = null;
			try {
				conn = DBPool.getConnection();
				String sql = "";
				sql += "SELECT * FROM Book WHERE AuthorID IN (SELECT AuthorID FROM Author WHERE name LIKE ?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+keyword+"%");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					//System.out.println(rs.getString(1));
					result.add(new Book(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getDouble(6)));
					ret = SUCCESS;
				}
				if (ret == ERROR) {
					addActionError("No result found!");
				}
			} catch (Exception e) {
				addActionError("Database connects failed!");
				System.out.println(e);
				ret = ERROR;
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (Exception e) {}
				}
			}
			return ret;
		}
	}

	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	

	public List<Book> getResult() {
		return this.result;
	}
	
//	public void setResult(List<Book> result) {
//		this.result = result;
//	}
	
}
