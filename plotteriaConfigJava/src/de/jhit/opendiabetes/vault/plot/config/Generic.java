package de.jhit.opendiabetes.vault.plot.config;

public class Generic {
	public enum GenericType {CGM, BOLUSCALCULATION, BOLUS, BASAL, SYMBOL};
	private GenericType type;
	private String label;
	private String columnName;
	private String color;
	private String marker;
	
	public Generic(GenericType type, String label, String columnName, String color, String marker) {
		this.type = type;
		this.label = label;
		this.columnName = columnName;
		this.color = color;
		this.marker = marker;
	}
	
	@Override
	public String toString() {
		return "[\"" + label + "\",\"" + columnName + "\",\"" + color + "\",\"" + marker + "\"]";
	}
	
	public GenericType getType() {
		return type;
	}
	public void setType(GenericType type) {
		this.type = type;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMarker() {
		return marker;
	}
	public void setMarker(String marker) {
		this.marker = marker;
	}
}
