package entities;

import com.hexiong.jdbf.JDBField;

public class DbfColumnValue {
	public final JDBField field;
	public final Object value;
	
	public DbfColumnValue(JDBField field, Object value) {
		this.field = field;
		this.value = value;
	}
	
	
}
