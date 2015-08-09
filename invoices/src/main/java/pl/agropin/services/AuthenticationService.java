package pl.agropin.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import daos.UserDAO;
import database.DatabaseService;
import entities.User;

@Path("/authenticate")
public class AuthenticationService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public boolean authenticate(String username, String password)
	{
		UserDAO user = new UserDAO(new DatabaseService());
		User userByNameAndPassword = user.getUserByNameAndPassword(username, password);
		
		return userByNameAndPassword != null;
	}
	
}
