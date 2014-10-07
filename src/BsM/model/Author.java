package BsM.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Author {
	private String Name;
	private int Age;
	private String Country;
	
	public Author(int AuthorID) {
		Connection conn = null;
		ResultSet result;
		try {
			Class.forName(Global.DB_DRIVER);
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USERNAME, Global.DB_PASSWORD);
			String sql = "SELECT * FROM Author WHERE AuthorID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ""+AuthorID);
			result = ps.executeQuery();
			while (result.next()) {
				//System.out.println(this.Name);
				this.Name = result.getString(2);
				this.Age = result.getInt(3);
				this.Country = result.getString(4);
			}
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
	}
	
	public String getName() {
		return this.Name;
	}
	
	public int getAge() {
		return this.Age;
	}
	
	public String getCountry() {
		return this.Country;
	}
	
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public void setAge(int Age) {
		this.Age = Age;
	}
	
	public void setCountry(String Country) {
		this.Country = Country;
	}
}
