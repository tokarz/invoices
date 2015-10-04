package database;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Properties;

public class DbfConfiguration {

	public static DbFileInfo getDbPath() throws IOException {
		Properties dbInfo = new Properties();

		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		dbInfo.load(cl.getResourceAsStream("/db.properties"));
		
		String folder = (String) dbInfo.get("dbfolder");
		String charset = (String) dbInfo.get("charset");
		
		DbFileInfo result = new DbFileInfo(folder + "/", Charset.forName(charset));
		
		
		return result;
	} 
	
}
