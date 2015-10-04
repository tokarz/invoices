package database;

import java.nio.charset.Charset;

public class DbFileInfo {
	public final String folderPath;
	public final Charset charset;

	public DbFileInfo(String folderPath, Charset charset) {
		this.folderPath = folderPath;
		this.charset = charset;
	}

}
