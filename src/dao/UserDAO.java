package dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;

import dao.User;

public class UserDAO extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
       
    public boolean addUser(User user) {
    	Boolean status = null;
        String user_name = user.getUser_name();
        String password = user.getPassword();
        String email = user.getEmail();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        try {
        	
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookland", "root","root");
            String query = "insert into user_details values (?,?,?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getUser_name());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            if (ps.executeUpdate() > 0)
            	status = true;
            else 
            	status = false;
            System.out.println(status);
        } catch(Exception e) {
            e.printStackTrace();
        }
    return status;
}
    
    
    
    
    
    public String checkUser(User user){
		DAOUtility du = new DAOUtility();
		 Connection conn = du.DAOUtility();
		 String msg = "";
		 String sql = "select * from user_details where user_name = ?";
		 
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUser_name());
		    ResultSet rs = pst.executeQuery();
		    if (rs.next()){
		    	System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
		    	if (rs.getString(2).equals(user.getPassword())){
		    		msg = "cp";	
		    		System.out.println("cp");
		    	}else{
		    		msg = "wp";
		    	}
		    	
		    }else{
		    	msg = "de";
		    }	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
   

    public UserDAO() {
        super();
        // TODO Auto-generated constructor stub
    }
}