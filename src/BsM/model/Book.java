package BsM.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Book {
	private String ISBN;
	private String Title;
	private String Author;
	private String Publisher;
	private String PublishDate;
	private Double Price;
	
	public Book() {
		
	}
	
	public Book(String ISBN, String Title, int AuthorID, String Publisher, String PublishDate, double Price) {
		this.ISBN = ISBN;
		this.Title = Title;
		this.Publisher = Publisher;
		this.PublishDate = PublishDate;
		this.Price = Price;
		
		Connection conn = null;
		ResultSet result;
		try {
			Class.forName(Global.DB_DRIVER);
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USERNAME, Global.DB_PASSWORD);
			String sql = "SELECT Name FROM Author WHERE AuthorID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ""+AuthorID);
			result = ps.executeQuery();
			while (result.next()) {
				if (!result.getString(1).equals("")) {
					this.Author = result.getString(1);
//					System.out.println(this.Author);
				}
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

	public String getISBN() {
		return this.ISBN;
	}
	
	public String getTitle() {
		return this.Title;
	}
	
	public String getAuthor() {
		return this.Author;
	}
	
	public String getPublisher() {
		return this.Publisher;
	}
	
	public String getPublishDate() {
		return this.PublishDate;
	}
	
	public Double getPrice() {
		return this.Price;
	}
	
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	
	public void setTitle(String Title) {
		this.Title = Title;
	}
	
	public void setAuthor(String Author) {
		this.Author = Author;
	}
	
	public void setPublisher(String Publisher) {
		this.Publisher = Publisher;
	}
	
	public void setPublishDate(String PublishDate) {
		this.PublishDate = PublishDate;
	}
	
	public void setPrice(Double Price) {
		this.Price = Price;
	}
}
