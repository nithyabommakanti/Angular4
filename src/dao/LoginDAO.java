package dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;

import dao.Login;

public class LoginDAO extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public boolean addUser(User user) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        boolean status = false;
        try {
        	System.out.println(user.getEmail()+ user.getPassword() + user.getUser_name());
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookland", "root","root");
            System.out.println("Connection Created");
            String query = "select * from  user_details where user_name = ?, password = ?";
            PreparedStatement ps1=connection.prepareStatement(query);
            ps1.setString(1, user.getUser_name());
            ps1.setString(2, user.getPassword());
            ResultSet rs = ps1.executeQuery();
            System.out.println("Executed Query");
            status = rs.next();
            //int i = ps.executeUpdate();
            
            /*if (rs > 0){
             status = true;
            }else{
            	status = false;
            }*/
        } catch(Exception e) {
            e.printStackTrace();
        }
        return status;
    }
	
	public LoginDAO() {
        super();
        // TODO Auto-generated constructor stub
    }

}
