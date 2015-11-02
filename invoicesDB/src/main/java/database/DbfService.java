package database;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hexiong.jdbf.DBFReader;
import com.hexiong.jdbf.JDBField;

import entities.DbfColumnValue;
import entities.DbfData;
import entities.Invoices;
import mappers.InvoicesMapper;

public class DbfService {

	public String convertDbfToMysql(String dbKey) {
		DbfData result = new DbfData();

		InputStream file = null;
		try {
			DbFileInfo dbPath = DbfConfiguration.getDbPath();
			String fileName = DbfConfiguration.getDbPropValue(dbKey);
			file = new FileInputStream(dbPath.folderPath + fileName);
			DBFReader dbfreader = new DBFReader(file);
			int i;

			List<String> headers = new ArrayList<String>();

			for (i = 0; i < dbfreader.getFieldCount(); i++) {
				JDBField currentField = dbfreader.getField(i);
				headers.add(currentField.getName());
			}

			List<List<DbfColumnValue>> records = new ArrayList<List<DbfColumnValue>>();
			Charset charset = dbPath.charset;

			for (i = 0; dbfreader.hasNextRecord(); i++) {
				Object aobj[] = dbfreader.nextRecord(charset);
				List<DbfColumnValue> row = new ArrayList<DbfColumnValue>();

				for (int j = 0; j < aobj.length; j++) {
					JDBField field = dbfreader.getField(j);
					Object currentValue = aobj[j];

					DbfColumnValue colVal = new DbfColumnValue(field, currentValue);

					row.add(colVal);
				}
				records.add(row);
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

		List<Invoices> invoicesToExport = new InvoicesMapper().mapDbfData(result);
		
		DatabaseService service = new DatabaseService();
		SessionFactory sessionFactory = service.createSessionFactory();
		if (sessionFactory != null) {

			Session session = sessionFactory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				long id=1;
				for(Invoices currentInvoice : invoicesToExport) 
				{
					currentInvoice.setId(id++);
					session.save(currentInvoice);
				}

				tx.commit();
			} catch (HibernateException e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.flush();
				session.close();
			}
		}

		return "?";
	}

	public DbfData getDbfDataByNameCloseStream(String dbKey, String columnName, String value) {
		DbfData result = new DbfData();

		InputStream file = null;
		try {
			DbFileInfo dbPath = DbfConfiguration.getDbPath();
			String fileName = DbfConfiguration.getDbPropValue(dbKey);
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
