package pl.agropin.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import daos.DatabaseVersionDAO;
import database.DatabaseService;
import entities.DatabaseVersion;


@Path("/dbVersion")
public class DatabaseVersionService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getDatabaseVersion()
	{
		String result = null;
		DatabaseVersionDAO dbVersion = new DatabaseVersionDAO(new DatabaseService());
		DatabaseVersion databaseVersion = dbVersion.getDatabaseVersion();
		if(databaseVersion != null) {
			result = databaseVersion.getVersion();
		}
		return result;
	}

//		
	
}
