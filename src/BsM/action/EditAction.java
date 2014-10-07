package BsM.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import BsM.model.Global;
import BsM.util.DBPool;

import com.opensymphony.xwork2.ActionSupport;

public class EditAction extends ActionSupport {
	
	private String ISBN;
	
	public String delete() {
		String ret = ERROR;
		if (!ISBN.trim().isEmpty()) {
			Connection conn = null;
			try {
				conn = DBPool.getConnection();
				String sql = "DELETE FROM Book WHERE ISBN = '" + ISBN + "'";
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				ret = SUCCESS;
			} catch (Exception e) {
				System.out.println("Database connects failed!");
				System.out.println(e.toString());
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (Exception e) {}
				}
			}
		} else {
			addActionError("Book ISBN can't be null!");
		}
		return ret;
	}
	
	public String update() {
		return "update";
	}
	
	public String getISBN() {
		return this.ISBN;
	}
	
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
}
