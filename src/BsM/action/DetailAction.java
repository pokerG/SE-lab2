package BsM.action;
import BsM.model.Author;
import BsM.model.Book;
import BsM.model.Global;
import BsM.util.DBPool;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DetailAction extends ActionSupport {

	private Book book;
	private Author author;
	private String ISBN;
	
	public String execute() {
		String ret = ERROR;
		if (!ISBN.trim().isEmpty()) {
			Connection conn = null;
			ResultSet result;
			try {
				conn = DBPool.getConnection();
				String sql = "SELECT * FROM Book WHERE ISBN = '"+ISBN+"'";
				Statement stmt = conn.createStatement();
				result = stmt.executeQuery(sql);
				while (result.next()) {
					book = new Book();
					book.setISBN(result.getString(1));
					book.setTitle(result.getString(2));
					book.setPublisher(result.getString(4));
					book.setPublishDate(result.getString(5));
					book.setPrice(result.getDouble(6));
					author = new Author(result.getInt(3));
					book.setAuthor(author.getName());
					ret = SUCCESS;
				}
				if (ret == ERROR) {
					addActionError("Book doesn't exist!");
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
		} else {
			addActionError("Book ISBN can't be null!");
		}
		return ret;
	}

	public Book getBook() {
		return this.book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	
	public Author getAuthor() {
		return this.author;
	}
	
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public String getISBN() {
		return this.ISBN;
	}
	
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
}
