package com.ts.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import dao.UserDAO;
import dao.Books;
import dao.BooksDAO;
import dao.User;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/myresource")
public class MyResource {
    
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	/*@GET 
    @Path("/hi")
    @Produces("text/plain")7
    public String getIt() {
        return "Hi there! Angular REST SERVICES";
    }
    @GET 
    @Path("/hello")
    @Produces("text/plain")
    public String hello() {
        return "Hello there! WECCOME TO BVRIT";
    }
    @GET 
    @Path("/getData")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getDat() {
       List<Student> list = new ArrayList<Student>();
    	Student student1=new Student(100,"PASHA");
    	list.add(student1);
    	Student student2=new Student(101,"INDIRA");
    	list.add(student2);
     	return list;
    }*/
    
    
    @POST
    @Path("/register1")
   //@Produces("text/plane")
 @Consumes(MediaType.APPLICATION_JSON)
    public String addMember(User user) throws IOException {
    	UserDAO userdao = new UserDAO();
    	if(userdao.addUser(user)) {
    	  System.out.println("Inside Registration...");
    	  return "yes";
    	} else {
    		System.out.println("Not Inserted");
    		return "no";
    	}        
    }
    
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    	public String login(User user) throws IOException {
    	System.out.println("Hi!! save called....."+user.getPassword()+" "+user.getUser_name());
    	UserDAO userdao = new UserDAO();
    	String msg = userdao.checkUser(user); 
    		if(msg.equals("cp")) {
    			System.out.println("Successful login!!");
    			return "Successful";
    		}
    		else if(msg.equals("wp")) {
    			System.out.println("Wrong Password!");
    			return "Wrong pwd!!!";
    		} else {
    			System.out.println("User dont exist!!");
    			return "User not registered.....plz register!!!";
    		}
    	}
    
    @Path("/getdetails")
    @GET
    
    @Produces(MediaType.APPLICATION_JSON)
    public List<Books> findAll(){
    	BooksDAO b = new BooksDAO();
    	return b.getAll();
    }
    }
    


