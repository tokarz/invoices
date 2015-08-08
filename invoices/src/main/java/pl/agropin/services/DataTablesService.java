package pl.agropin.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/tableData")
public class DataTablesService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getTableData(String sessionId, String userName, String password) {

//		String jsonBig = "{ \"data\": [ [ \"Tiger Nixon\",\"System Architect\", \"Edinburgh\", \"5421\", \"2011/04/25\", \"$320,800\"],[ \"Garrett Winters\", \"Accountant\", \"Tokyo\", \"8422\", \"2011/07/25\", \"$170,750\"]]}";
		//dbConnect
		//dbSelect
		//dbParseToJSON
		
		String jsonBig = "{\"data\": ["
				  +       "{"
			  +         "\"name\": \"Tiger Nixon\","
			  +         "\"position\": \"System Architect\","
			  +         "\"salary\": \"$320,800\","
			  +         "\"start_date\": \"2011/04/25\","
			  +         "\"office\": \"Edinburgh\","
			  +         "\"extn\": \"5421\""
			  +       "},"                          
			  +       "{"
			  +         "\"name\": \"Garrett Winters\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2011/07/25\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "},"
			  +       "{"
			  +         "\"name\": \"Garrett Winters1\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2011/07/25\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "},"
			  +       "{"
			  +         "\"name\": \"Garrett Winters2\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2011/07/25\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "},"
			  +       "{"
			  +         "\"name\": \"Garrett Winters3\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2011/07/25\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "},"
			  +       "{"
			  +         "\"name\": \"Garrett Winters4\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2011/07/25\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "},"
			  +       "{"
			  +         "\"name\": \"Garrett Winters5\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2011/07/25\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "},"
			  +       "{"
			  +         "\"name\": \"Garrett Winters6\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2011/07/25\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "},"
			  +       "{"
			  +         "\"name\": \"Garrett Winters\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2011/07/25\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "},"
			  +       "{"
			  +         "\"name\": \"Garrett Winters\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2011/07/25\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "},"
			  +       "{"
			  +         "\"name\": \"Garrett Winters\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2011/07/26\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "},"
			  +       "{"
			  +         "\"name\": \"Garrett Winters\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2011/07/25\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "},"
			  +       "{"
			  +         "\"name\": \"Garrett Winters\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2012/07/25\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "}," +      
			  			"{"
			  +         "\"name\": \"Garrett Winters\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2011/07/25\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "},"
			  +       "{"
			  +         "\"name\": \"Garrett Winters\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2011/07/25\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "},"
			  +       "{"
			  +         "\"name\": \"Garrett Winters\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2011/07/25\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "},"
			  +       "{"
			  +         "\"name\": \"Garrett Winters\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2011/07/25\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "},"
			  +       "{"
			  +         "\"name\": \"Garrett Winters\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2011/07/25\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "},"
			  +       "{"
			  +         "\"name\": \"Garrett Winters\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2011/07/25\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "},"
			  +       "{"
			  +         "\"name\": \"Garrett Winters\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2011/07/25\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "},"
			  +       "{"
			  +         "\"name\": \"Garrett Winters\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2011/07/25\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "},"
			  +       "{"
			  +         "\"name\": \"Garrett Winters\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2011/07/25\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "},"
			  +       "{"
			  +         "\"name\": \"Garrett Winters\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2011/07/25\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "},"
			  +       "{"
			  +         "\"name\": \"Garrett Winters\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2011/07/25\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "},"
			  +       "{"
			  +         "\"name\": \"Garrett Winters\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2011/07/25\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "},"
			  +       "{"
			  +         "\"name\": \"Garrett Winters\","
			  +         "\"position\": \"Accountant\","
			  +         "\"salary\": \"$170,750\","
			  +         "\"start_date\": \"2011/07/25\","
			  +         "\"office\": \"Tokyo\","
			  +         "\"extn\": \"8422\""
			  +       "}"
			  +       "]}";

		return jsonBig;
	}

}


