package entities;

import java.util.List;

public class DbfData {
	private List<String> columns;
	private List<List<DbfColumnValue>> values;

	public List<String> getColumns() {
		return columns;
	}

	public void setColumns(List<String> columns) {
		this.columns = columns;
	}

	public List<List<DbfColumnValue>> getValues() {
		return values;
	}

	public void setValues(List<List<DbfColumnValue>> values) {
		this.values = values;
	}
}
