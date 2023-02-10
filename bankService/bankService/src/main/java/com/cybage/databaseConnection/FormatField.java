package com.cybage.databaseConnection;

public class FormatField {

	char type;//int I,alphanumeric A,float F,Date D.
	String valueString;
	public FormatField(char type, String valueString) {
		super();
		this.type = type;
		this.valueString = valueString;
	}
	
}
