package pl.agropin.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/dbVersion")
public class DatabaseVersionService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getDatabaseVersion()
	{
		
		return "{status: 'connected'}";
	}

//		
	
}
