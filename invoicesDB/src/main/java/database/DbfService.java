package database;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.hexiong.jdbf.DBFReader;
import com.hexiong.jdbf.JDBField;

import entities.DbfColumnValue;
import entities.DbfData;

public class DbfService {

	public DbfData getDbfDataByNameCloseStream(String fileName,String columnName, String value) {
		DbfData result = new DbfData();

		InputStream file = null;
		try {
			DbFileInfo dbPath = DbfConfiguration.getDbPath();
			file = new FileInputStream(dbPath.folderPath + fileName);
			DBFReader dbfreader = new DBFReader(file);
			int i;

			List<String> headers = new ArrayList<String>();
			int indexOfColumn = -1;

			for (i = 0; i < dbfreader.getFieldCount(); i++) {
				JDBField currentField = dbfreader.getField(i);
				headers.add(currentField.getName());
				if (currentField.getName().equals(columnName)) {
					indexOfColumn = i;
				}

			}
			List<List<DbfColumnValue>> records = new ArrayList<List<DbfColumnValue>>();
			if (indexOfColumn != -1) {
				Charset charset = dbPath.charset;
				
				for (i = 0; dbfreader.hasNextRecord(); i++) {
					Object aobj[] = dbfreader.nextRecord(charset);
					if (aobj[indexOfColumn].equals(value)) {
						List<DbfColumnValue> row = new ArrayList<DbfColumnValue>();

						for (int j = 0; j < aobj.length; j++) {
							JDBField field = dbfreader.getField(j);
							Object currentValue = aobj[j];

							DbfColumnValue colVal = new DbfColumnValue(field, currentValue);

							row.add(colVal);
						}
						records.add(row);
					}
				}

			}

			result.setColumns(headers);
			result.setValues(records);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				file.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;

	}

}
