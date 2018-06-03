package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class BooksDAO {

public List<Books> getAll() {
	
	Books b;
	List<Books> books = new ArrayList<>();
	String sql = "select * from books";
	try {
	 	DAOUtility du = new DAOUtility();
		Connection connection = du.DAOUtility();
		System.out.println("connection established");
		PreparedStatement pst = connection.prepareStatement(sql);
		System.out.println("stmt executed");
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			b = new Books();
			b.setBook_id(rs.getInt(1));
			b.setBook_name(rs.getString(2));
			System.out.println(b.getBook_name());
			b.setAuthor(rs.getString(3));
			b.setGenre(rs.getString(4));
			b.setYear(rs.getInt(5));
			b.setLanguage(rs.getString(6));
			b.setPrice(rs.getInt(7));
			b.setQuantity(rs.getInt(8));
			System.out.println(b);
			books.add(b);
			System.out.println(b.getBook_name());
		}
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	//System.out.println(books);
     return  books;
}
}
