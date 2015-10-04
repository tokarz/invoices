package daos;

import java.util.List;

import database.DbfService;
import entities.DbfColumnValue;
import entities.DbfData;
import entities.User;

public class UserDAO {
	private DbfService service;

	public UserDAO(DbfService service) {
		this.service = service;
	}
	
	public User getUserByNameAndPassword(String name, String password)
	{
		User result = null;
		DbfData dbfData = service.getDbfDataByNameCloseStream("paskicrypt.dbf", "NRPRAC", name);
		if (dbfData != null) {
			List<List<DbfColumnValue>> userData= dbfData.getValues();
			if(userData.size() > 0) 
			{
				List<DbfColumnValue> userDataRow = userData.get(0);
				for (DbfColumnValue dbfColumnValue : userDataRow) {
					if(dbfColumnValue.field.getName().equals("NAZWISKOPR")) 
					{
						if(dbfColumnValue.value.equals(password)) 
						{
							result = new User(name, "");
						}
					}
				}
			}
		}
		return result;
	}
	
}
